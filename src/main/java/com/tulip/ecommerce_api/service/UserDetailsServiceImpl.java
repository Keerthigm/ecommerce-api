//package com.tulip.ecommerce_api.service;
//
//import com.tulip.ecommerce_api.dto.UserDTO;
//import com.tulip.ecommerce_api.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.security.core.userdetails.UserDetails;
////import org.springframework.security.core.userdetails.UsernameNotFoundException;
////import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public UserDTO loadUserByUsername(String username) throws UsernameNotFoundException {
//        UserDTO user = userRepository.findByUsername(username)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
//
//        return new UserDTO();
//    }
//}
