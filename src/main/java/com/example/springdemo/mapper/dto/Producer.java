package com.example.springdemo.mapper.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
public class Producer extends BaseDto {
    private String name;
    private List<Product> products;
}
