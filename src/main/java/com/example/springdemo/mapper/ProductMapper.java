package com.example.springdemo.mapper;

import com.example.springdemo.entity.ProductEntity;
import com.example.springdemo.mapper.dto.Product;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class ProductMapper {
    private static ProducerMapper producerMapper = new ProducerMapper();

    public ProductEntity mapProductToEntity(Product product) {
        ProductEntity entity = new ProductEntity();
        entity
                .setProducer(producerMapper.mapProducerToEntity(product.getProducer()))
                .setName(product.getName())
                .setPrice(product.getPrice())
                .setUuid(product.getUuid())
                .setId(product.getId());
        return entity;
    }

    public Product mapEntityToProduct(ProductEntity productEntity) {
        Product product = new Product();
        product
                .setProducer(producerMapper.mapEntityToProducer(productEntity.getProducer()))
                .setName(productEntity.getName())
                .setPrice(productEntity.getPrice())
                .setUuid(productEntity.getUuid())
                .setId(productEntity.getId());
        return product;
    }

    public List<Product> mapEntitiesToProducts(List<ProductEntity> entities) {
        return entities.stream()
                .map(this::mapEntityToProduct)
                .collect(toList());
    }

    public List<ProductEntity> mapProductsToEntities(List<Product> products) {
        return products.stream()
                .map(this::mapProductToEntity)
                .collect(toList());
    }
}
