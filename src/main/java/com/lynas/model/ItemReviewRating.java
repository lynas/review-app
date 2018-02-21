package com.lynas.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ItemReviewRating {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private Item item;
    @Column(nullable = false)
    private Review review;
    @Min(0)
    @Max(10)
    @Column(nullable = false)
    private int score;
}
