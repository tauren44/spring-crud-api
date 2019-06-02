package com.example.springdemo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Getter
@Setter
@Accessors(chain = true)
@Table(name = "users")
public class UserEntity extends UuidEntity{
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Role> roles;
}
