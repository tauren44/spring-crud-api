package com.example.springdemo.mapper.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Getter
@Setter
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class Product extends BaseDto {
    private String name;
    private BigDecimal price;
    private Long producerId;
}
