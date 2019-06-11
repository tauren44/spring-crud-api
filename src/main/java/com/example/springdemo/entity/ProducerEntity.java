package com.example.springdemo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@Accessors(chain = true)
@Table(name = "producer")
public class ProducerEntity extends UuidEntity {
    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "producer")
    private List<ProductEntity> products = new ArrayList<>();
}
