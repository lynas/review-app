package com.lynas.service;

import com.lynas.exception.EntityNotFoundException;
import com.lynas.model.Item;
import com.lynas.model.ItemReviewRating;
import com.lynas.model.ReviewAspect;
import com.lynas.repository.ItemReviewRatingRepository;
import com.lynas.util.Util;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ItemReviewRatingService {
    private final ItemReviewRatingRepository itemReviewRatingRepository;
    private final ItemService itemService;
    private final ReviewAspectService reviewAspectService;

    public ItemReviewRatingService(ItemReviewRatingRepository itemReviewRatingRepository, ItemService itemService, ReviewAspectService reviewAspectService) {
        this.itemReviewRatingRepository = itemReviewRatingRepository;
        this.itemService = itemService;
        this.reviewAspectService = reviewAspectService;
    }


    public boolean rateItemReview(Long itemId, Long reviewAspectId, int ratingScore) throws EntityNotFoundException {
        final Item item = itemService.findById(itemId);
        final ReviewAspect reviewAspect = reviewAspectService.findById(reviewAspectId);
        itemReviewRatingRepository.save(new ItemReviewRating(item,reviewAspect,ratingScore));
        return true;
    }

    public Map<String, Double> getItemReview(Long itemId) throws EntityNotFoundException {
        final Item item = itemService.findById(itemId);
        Map<String, Double> itemScore = new HashMap<>();
        for (ReviewAspect reviewAspect : item.getReviewAspects()) {
            final List<ItemReviewRating> list = itemReviewRatingRepository.findByItemAndReviewAspect(item, reviewAspect);
            if (list.isEmpty()) {
                itemScore.put(reviewAspect.getAspect(), 0d);
                continue;
            }
            final double sum = list.stream().mapToDouble(ItemReviewRating::getScore).sum();
            itemScore.put(reviewAspect.getAspect(), new Util().formateRatingAvg(sum / list.size()));
        }
        return itemScore;
    }
}
