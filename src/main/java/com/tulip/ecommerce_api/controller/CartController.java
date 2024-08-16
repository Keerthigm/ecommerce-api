package com.tulip.ecommerce_api.controller;

//import com.tulip.ecommerce_api.dto.CartDTO;
import com.tulip.ecommerce_api.entity.CartItem;
import com.tulip.ecommerce_api.service.CartService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@Tag(name = "cart", description = "The product. Contains all the operations that can be performed for product.")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public void addToCart(@RequestParam Long productId, @RequestParam int quantity, @RequestParam String username) {
        cartService.addToCart(productId, quantity, username);
    }

    @GetMapping("/items")
    public List<CartItem> getCartItems(@RequestParam String username) {
        return cartService.getCartItems(username);
    }

    @PutMapping("/update")
    public void updateCartItem(@RequestParam Long cartItemId, @RequestParam int quantity) {
        cartService.updateCartItem(cartItemId, quantity);
    }

    @DeleteMapping("/remove")
    public void removeCartItem(@RequestParam Long cartItemId) {
        cartService.removeCartItem(cartItemId);
    }
}