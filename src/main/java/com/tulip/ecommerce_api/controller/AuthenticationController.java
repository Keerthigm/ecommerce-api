//package com.tulip.ecommerce_api.controller;
//
//import com.tulip.ecommerce_api.dto.AuthRequestDTO;
//import com.tulip.ecommerce_api.dto.AuthResponseDTO;
//import com.tulip.ecommerce_api.entity.User;
////import com.tulip.ecommerce_api.security.JwtUtil;
//import com.tulip.ecommerce_api.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.web.bind.annotation.*;
//import io.swagger.v3.oas.annotations.tags.Tag;
//
//@RestController
//@RequestMapping("/auth")
//@Tag(name = "Authentication", description = "This API contains all the operations that can be performed on a registration and login process.")
//public class AuthenticationController {
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private UserDetailsService userDetailsService;
//
////    @Autowired
////    private JwtUtil jwtUtil;
//
//    @Autowired
//    private UserService userService;
//
//    @PostMapping("/register")
//    public String registerUser(@RequestBody User user) {
//        userService.saveUser(user);
//        return "User registered successfully!";
//    }
//
////    @PostMapping("/login")
////    public AuthResponseDTO createAuthenticationToken(@RequestBody AuthRequestDTO authRequest) throws Exception {
////        try {
////            authenticationManager.authenticate(
////                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
////            );
////        } catch (Exception ex) {
////            throw new Exception("Invalid username or password");
////        }
////
////        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
////
//////        final String jwt = jwtUtil.generateToken(userDetails);
////
//////        return new AuthResponseDTO(jwt);
////    }
//}
