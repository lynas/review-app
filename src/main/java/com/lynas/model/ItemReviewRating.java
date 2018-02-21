package com.lynas.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ItemReviewRating {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Item item;
    @ManyToOne
    private ReviewAspect reviewAspect;
    @Min(0)
    @Max(10)
    @Column(nullable = false)
    private int score;

    public ItemReviewRating(Item item, ReviewAspect reviewAspect, int score) {
        this.item = item;
        this.reviewAspect = reviewAspect;
        this.score = score;
    }
}
