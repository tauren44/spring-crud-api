package com.example.springdemo.mapper;

import com.example.springdemo.entity.ProducerEntity;
import com.example.springdemo.mapper.dto.Producer;
import org.springframework.stereotype.Component;

@Component
public class ProducerMapper extends AbstractMapper<ProducerEntity, Producer> {

    public ProducerMapper() {
        super(ProducerEntity.class, Producer.class);
    }
}
