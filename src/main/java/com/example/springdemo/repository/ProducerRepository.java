package com.example.springdemo.repository;

import com.example.springdemo.entity.ProducerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducerRepository extends JpaRepository<ProducerEntity, Long> {
}
