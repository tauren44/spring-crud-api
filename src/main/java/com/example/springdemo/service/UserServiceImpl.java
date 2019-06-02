package com.example.springdemo.service;

import com.example.springdemo.exceptions.UserNotFoundException;
import com.example.springdemo.mapper.UserMapper;
import com.example.springdemo.mapper.dto.User;
import com.example.springdemo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {
    private final UserMapper mapper;
    private final UserRepository repository;


    @Override
    public void createUser(User user) {
        repository.save(mapper.mapUserToEntity(user));
    }

    @Override
    public void updateUser(User user) {
        repository.save(mapper.mapUserToEntity(user));
    }

    @Override
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    @Override
    public User findUserById(Long id) {
        return mapper.mapEntityToUser(repository.findById(id).orElseThrow(UserNotFoundException::new));
    }

    @Override
    public User findByEmail(String email) {
        return mapper.mapEntityToUser(repository.findByEmail(email).orElseThrow(UserNotFoundException::new));
    }

    @Override
    public List<User> findAll() {
        return mapper.mapEntitiesToUsers(repository.findAll());
    }
}
