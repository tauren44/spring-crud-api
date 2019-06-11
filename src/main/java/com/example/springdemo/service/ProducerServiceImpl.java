package com.example.springdemo.service;

import com.example.springdemo.exceptions.ProducerNotFoundException;
import com.example.springdemo.mapper.ProducerMapper;
import com.example.springdemo.mapper.dto.Producer;
import com.example.springdemo.repository.ProducerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProducerServiceImpl implements ProducerService {
    private final ProducerRepository repository;
    private final ProducerMapper mapper;

    @Override
    public void createProducer(Producer producer) {
        repository.save(mapper.toEntity(producer));
    }

    @Override
    public void updateProducer(Producer producer) {
        repository.save(mapper.toEntity(producer));
    }

    @Override
    public void deleteProducer(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Producer findProducerById(Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow(ProducerNotFoundException::new));
    }

    @Override
    public List<Producer> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(toList());
    }
}
