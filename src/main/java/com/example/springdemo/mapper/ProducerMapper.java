package com.example.springdemo.mapper;

import com.example.springdemo.entity.ProducerEntity;
import com.example.springdemo.mapper.dto.Producer;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class ProducerMapper {

    private static ProductMapper productMapper = new ProductMapper();

    public Producer mapEntityToProducer(ProducerEntity entity) {
        Producer producer = new Producer();
        producer
                .setName(entity.getName())
                .setProducts(productMapper.mapEntitiesToProducts(entity.getProducts()))
                .setId(entity.getId())
                .setUuid(entity.getUuid());

        return producer;
    }

    public ProducerEntity mapProducerToEntity(Producer producer) {
        ProducerEntity entity = new ProducerEntity();
        entity
                .setName(producer.getName())
                .setProducts(productMapper.mapProductsToEntities(producer.getProducts()))
                .setUuid(producer.getUuid())
                .setId(producer.getId());

        return entity;
    }

    public List<Producer> mapEntitiesToProducers(List<ProducerEntity> entityList) {
        return entityList.stream()
                .map(this::mapEntityToProducer)
                .collect(toList());
    }
}
