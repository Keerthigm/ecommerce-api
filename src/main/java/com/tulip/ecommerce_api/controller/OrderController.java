package com.tulip.ecommerce_api.controller;

import com.tulip.ecommerce_api.entity.Order;
import com.tulip.ecommerce_api.entity.User;
import com.tulip.ecommerce_api.service.OrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
@Log4j2
@Tag(name = "order", description = "The order. Contains all the operations that can be performed for order.")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<String> placeOrder(User userDetails) {
        orderService.placeOrder(userDetails.getUsername());
        return ResponseEntity.status(HttpStatus.CREATED).body("Order placed successfully");
    }

    @GetMapping
    public ResponseEntity<List<Order>> getOrderHistory(User userDetails) {
        return ResponseEntity.ok(orderService.getOrderHistory(userDetails.getUsername()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }
}
