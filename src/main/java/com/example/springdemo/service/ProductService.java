package com.example.springdemo.service;

import com.example.springdemo.mapper.dto.Product;

import java.util.List;

public interface ProductService {
    void createProduct(Product entity);

    void updateProduct(Product entity);

    void deleteProduct(Long id);

    Product findProductById(Long id);

    List<Product> findAll();
}
