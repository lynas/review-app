package com.lynas.controller;

import com.lynas.exception.EntityNotFoundException;
import com.lynas.service.ItemReviewRatingService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/rate")
public class ReviewAspectRatingController {

    private final ItemReviewRatingService itemReviewRatingService;

    public ReviewAspectRatingController(ItemReviewRatingService itemReviewRatingService) {
        this.itemReviewRatingService = itemReviewRatingService;
    }

    @PostMapping("/item/{itemId}/review_aspect/{review_aspect_id}")
    public boolean rateReviewAspectOfItem(@PathVariable Long itemId, @PathVariable Long review_aspect_id,
                                          @RequestBody int score) throws EntityNotFoundException {
        return itemReviewRatingService.rateItemReview(itemId, review_aspect_id, score);
    }

    @GetMapping("/{itemId}")
    public Map<String, Double> getItemReviewAspectRating(@PathVariable Long itemId) throws EntityNotFoundException {
        return itemReviewRatingService.getItemReview(itemId);
    }
}
