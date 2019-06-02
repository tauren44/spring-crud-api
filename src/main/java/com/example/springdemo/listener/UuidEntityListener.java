package com.example.springdemo.listener;

import com.example.springdemo.entity.UuidEntity;

import javax.persistence.PrePersist;
import java.util.UUID;

public class UuidEntityListener {
    @PrePersist
    public void setRandomUuid(UuidEntity entity) {
        entity.setUuid(UUID.randomUUID());
    }
}
