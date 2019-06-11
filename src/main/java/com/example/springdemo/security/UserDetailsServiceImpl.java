package com.example.springdemo.security;
//
//import com.example.springdemo.service.UserService;
//import lombok.AllArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//@AllArgsConstructor(onConstructor = @__(@Autowired))
//public class UserDetailsServiceImpl implements UserDetailsService {
//    private final UserService userService;
//
//    @Override
//    public UserDetailsImpl loadUserByUsername(String email) throws UsernameNotFoundException {
//        return new UserDetailsImpl(userService.findByEmail(email));
//    }
//}
