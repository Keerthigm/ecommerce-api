package com.tulip.ecommerce_api.service;

import com.tulip.ecommerce_api.dto.UserDTO;
import com.tulip.ecommerce_api.entity.User;
import com.tulip.ecommerce_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public abstract class UserService {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

//    public User saveUser(User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        return userRepository.save(user);
//
//    }

    public Optional<UserDTO> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User getUserByname(String username) {
        return userRepository.findByname(username);
    }

}
