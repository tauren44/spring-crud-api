package com.example.springdemo.mapper.dto;

import com.example.springdemo.entity.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Set;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class User extends BaseDto {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Set<Role> roles;

    public User(User user) {
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.roles = user.getRoles();
        this.setUuid(user.getUuid());
        this.setId(user.getId());
    }
}
