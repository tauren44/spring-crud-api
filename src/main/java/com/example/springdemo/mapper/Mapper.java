package com.example.springdemo.mapper;

import com.example.springdemo.entity.BaseEntity;
import com.example.springdemo.mapper.dto.BaseDto;

public interface Mapper<E extends BaseEntity, D extends BaseDto> {

    E toEntity(D dto);

    D toDto(E entity);
}
