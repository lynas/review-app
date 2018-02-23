package com.lynas.controller;

import com.lynas.dto.RateItemReviewDTO;
import com.lynas.dto.ReviewAspectDTO;
import com.lynas.dto.SuccessResponseDTO;
import com.lynas.exception.EntityNotFoundException;
import com.lynas.service.ItemReviewRatingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("unchecked")
@RestController
@RequestMapping("/rate")
public class ReviewAspectRatingController {

    private final ItemReviewRatingService itemReviewRatingService;

    public ReviewAspectRatingController(ItemReviewRatingService itemReviewRatingService) {
        this.itemReviewRatingService = itemReviewRatingService;
    }

    @PostMapping
    public ResponseEntity rateReviewAspectOfItem(@RequestBody RateItemReviewDTO rateItemReviewDTO) throws EntityNotFoundException {
        boolean result = itemReviewRatingService.rateItemReview(rateItemReviewDTO.getItemId(),
                rateItemReviewDTO.getReviewAspectId(), rateItemReviewDTO.getScore());
        return new ResponseEntity(new SuccessResponseDTO(result), HttpStatus.CREATED);
    }

    @GetMapping("/item/{itemId}")
    public List<ReviewAspectDTO> getItemReviewAspectRating(@PathVariable Long itemId) throws EntityNotFoundException {
        return itemReviewRatingService.getItemReview(itemId);
    }
}
