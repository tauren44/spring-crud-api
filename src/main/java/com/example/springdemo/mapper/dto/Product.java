package com.example.springdemo.mapper.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Getter
@Setter
@Accessors(chain = true)
public class Product extends BaseDto {
    private String name;
    private BigDecimal price;
    private Producer producer;
}