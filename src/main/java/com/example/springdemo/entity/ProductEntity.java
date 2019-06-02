package com.example.springdemo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "products")
@Accessors(chain = true)
public class ProductEntity extends UuidEntity {
    private String name;
    private BigDecimal price;

    @ManyToOne
    @JsonBackReference
    private ProducerEntity producer;


}
