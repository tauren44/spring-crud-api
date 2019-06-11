package com.example.springdemo.util;

import com.example.springdemo.mapper.dto.Producer;
import com.example.springdemo.mapper.dto.Product;
import com.example.springdemo.service.ProducerService;
import com.example.springdemo.service.ProductService;

public class DependencyCheckUtil {
    public static boolean isProductOfThisProducer(Long producerId, ProducerService producerService,
                                                  Long productId, ProductService productService) {
        Producer producer= producerService.findProducerById(producerId);
        Product product = productService.findProductById(productId);
        return producer.getProducts().contains(product) || product.getProducerId().equals(producerId);
    }
}
