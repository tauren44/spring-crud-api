package com.example.springdemo.service;

import com.example.springdemo.exceptions.ProductNotFoundException;
import com.example.springdemo.mapper.ProductMapper;
import com.example.springdemo.mapper.dto.Product;
import com.example.springdemo.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;
    private final ProductMapper mapper;

    @Override
    public void createProduct(Product product) {
        repository.save(mapper.toEntity(product));
    }

    @Override
    public void updateProduct(Product product) {
        repository.save(mapper.toEntity(product));
    }

    @Override
    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Product findProductById(Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow(ProductNotFoundException::new)) ;
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(toList());
    }
}
