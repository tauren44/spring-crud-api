package com.example.springdemo.service;

import com.example.springdemo.mapper.dto.Producer;

import java.util.List;

public interface ProducerService {
    void createProducer(Producer producer);

    void updateProducer(Producer producer);

    void deleteProducer(Long id);

    Producer findProducerById(Long id);

    List<Producer> findAll();
}
