package com.example.springdemo.mapper.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.UUID;

@Getter
@Setter
@Accessors(chain = true)
public class BaseDto {
    private Long id;
    private UUID uuid;
}
