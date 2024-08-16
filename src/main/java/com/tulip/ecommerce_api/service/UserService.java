package com.tulip.ecommerce_api.service;

import com.tulip.ecommerce_api.entity.User;

import java.util.Optional;

public interface UserService {
    Optional<User> getByUsername(String username);

//    User getByUsername(String username);
}