package com.lynas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ReviewAspect {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true, nullable = false)
    private String aspect;

}
