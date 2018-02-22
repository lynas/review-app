package com.lynas.controller;

import com.lynas.exception.EntityNotFoundException;
import com.lynas.service.ItemReviewRatingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity rateReviewAspectOfItem(@PathVariable Long itemId, @PathVariable Long review_aspect_id,
                                                 @RequestBody int score) throws EntityNotFoundException {
        return new ResponseEntity(
                itemReviewRatingService.rateItemReview(itemId, review_aspect_id, score),
                HttpStatus.CREATED);
    }

    @GetMapping("/{itemId}")
    public Map<String, Double> getItemReviewAspectRating(@PathVariable Long itemId) throws EntityNotFoundException {
        return itemReviewRatingService.getItemReview(itemId);
    }
}
