package com.tulip.ecommerce_api.service.implementation;

import com.tulip.ecommerce_api.entity.User;
import com.tulip.ecommerce_api.repository.UserRepository;
import com.tulip.ecommerce_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> getByUsername(String username) {
        return Optional.ofNullable(userRepository.getByUsername(username));
    }
}

//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public Optional<User> getUserByUsername(String username) {
//        return Optional.ofNullable(userRepository.getByUsername(username));
//    }
//    @Override
//    public User getUserByname(String username) {
//        return userRepository.findByUsername(username);
//    }
//}