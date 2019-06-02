package com.example.springdemo.mapper;

import com.example.springdemo.entity.UserEntity;
import com.example.springdemo.mapper.dto.User;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class UserMapper {

    public User mapEntityToUser(UserEntity entity) {
        User user = new User();
        user
                .setEmail(entity.getEmail())
                .setFirstName(entity.getFirstName())
                .setLastName(entity.getLastName())
                .setPassword(entity.getPassword())
                .setRoles(entity.getRoles())
                .setId(entity.getId())
                .setUuid(entity.getUuid());
        return user;
    }

    public UserEntity mapUserToEntity(User user) {
        UserEntity entity = new UserEntity();
        entity
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setRoles(user.getRoles())
                .setId(user.getId());
        entity.setUuid(user.getUuid());
        return entity;
    }

    public List<User> mapEntitiesToUsers(List<UserEntity> entities) {
        return entities.stream()
                .map(this::mapEntityToUser)
                .collect(toList());
    }

//    public List<UserEntity> mapUsersToEntities(List<User> users) {
//        return users.stream()
//                .map(this::mapUserToEntity)
//                .collect(toList());
//    }
}
