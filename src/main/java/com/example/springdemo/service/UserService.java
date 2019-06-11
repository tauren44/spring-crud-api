package com.example.springdemo.service;

import com.example.springdemo.mapper.dto.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void createUser(User user);

    void updateUser(User user);

    void deleteUser(Long id);

    User findUserById(Long id);

    User findByEmail(String email);

    List<User> findAll();
}
