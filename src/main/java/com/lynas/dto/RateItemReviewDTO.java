package com.lynas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RateItemReviewDTO {
    @NotNull
    private Long itemId;
    @NotNull
    private Long reviewAspectId;
    @NotNull
    private int score;
}
