package com.lynas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewAspectDTO {
    @NotNull
    private Long reviewAspectId;
    @NotNull
    private String  reviewAspectName;
    @NotNull
    private Double avgScore;
}
