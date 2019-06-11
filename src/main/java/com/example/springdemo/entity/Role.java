package com.example.springdemo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "roles")
@EqualsAndHashCode(callSuper = false)
public class Role extends BaseEntity {
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    private UserEntity entity;
}
