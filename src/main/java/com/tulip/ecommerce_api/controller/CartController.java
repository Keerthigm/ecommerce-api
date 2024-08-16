package com.tulip.ecommerce_api.controller;

import com.tulip.ecommerce_api.dto.CartDTO;
import com.tulip.ecommerce_api.dto.UserDTO;
import com.tulip.ecommerce_api.service.CartService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cart")
@Log4j2
@Tag(name = "Cart", description = "The Cart. Contains all the operations that can be performed for Cart.")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping
    public ResponseEntity<String> addToCart(@RequestBody CartDTO cartDto, @RequestBody UserDTO userDetails) {
        cartService.addToCart(cartDto.getId(), cartDto.getQuantity(), userDetails.getUsername());
        return ResponseEntity.status(HttpStatus.CREATED).body("Product added to cart");
    }

    @GetMapping
    public ResponseEntity<List<CartDTO>> getCartItems( UserDTO userDetails) {
        return ResponseEntity.ok(cartService.getCartItems(userDetails.getUsername()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCartItem(@PathVariable Long id, @RequestBody CartDTO cartDto) {
        cartService.updateCartItem(id, cartDto.getQuantity());
        return ResponseEntity.ok("Cart item updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeCartItem(@PathVariable Long id) {
        cartService.removeCartItem(id);
        return ResponseEntity.ok("Cart item removed");
    }
}
