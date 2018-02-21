package com.lynas;

import com.lynas.model.Item;
import com.lynas.model.ItemReviewRating;
import com.lynas.model.ReviewAspect;
import com.lynas.repository.ItemRepository;
import com.lynas.repository.ItemReviewRatingRepository;
import com.lynas.repository.ReviewAspectRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemReviewRatingService {
    private final ItemReviewRatingRepository itemReviewRatingRepository;
    private final ItemRepository itemRepository;
    private final ReviewAspectRepository reviewAspectRepository;

    public ItemReviewRatingService(ItemReviewRatingRepository itemReviewRatingRepository, ItemRepository itemRepository,
                                   ReviewAspectRepository reviewAspectRepository) {
        this.itemReviewRatingRepository = itemReviewRatingRepository;
        this.itemRepository = itemRepository;
        this.reviewAspectRepository = reviewAspectRepository;
    }

    public boolean rateItemReview(Long itemId, Long reviewAspectId, int ratingScore) {
        Item item = itemRepository.findOne(itemId);
        ReviewAspect reviewAspect = reviewAspectRepository.findOne(reviewAspectId);
        itemReviewRatingRepository.save(new ItemReviewRating(item,reviewAspect,ratingScore));
        return true;
    }
}
