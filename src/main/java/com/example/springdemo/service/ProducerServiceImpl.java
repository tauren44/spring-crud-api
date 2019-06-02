package com.example.springdemo.service;

import com.example.springdemo.exceptions.ProducerNotFoundException;
import com.example.springdemo.mapper.ProducerMapper;
import com.example.springdemo.mapper.dto.Producer;
import com.example.springdemo.repository.ProducerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProducerServiceImpl implements ProducerService {
    private final ProducerRepository repository;
    private final ProducerMapper mapper = new ProducerMapper();

    @Override
    public void createProducer(Producer producer) {
        repository.save(mapper.mapProducerToEntity(producer));
    }

    @Override
    public void updateProducer(Producer producer) {
        repository.save(mapper.mapProducerToEntity(producer));
    }

    @Override
    public void deleteProducer(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Producer findProducerById(Long id) {
        return mapper.mapEntityToProducer(repository.findById(id).orElseThrow(ProducerNotFoundException::new));
    }

    @Override
    public List<Producer> findAll() {
        return mapper.mapEntitiesToProducers(repository.findAll());
    }
}