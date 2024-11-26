package com.sky.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SetmealDish implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Long setmealId;
    private Long dishId;
    private String name;
    private BigDecimal price;
    private Integer copies;
}
