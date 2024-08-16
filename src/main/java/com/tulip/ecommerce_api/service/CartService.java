package com.tulip.ecommerce_api.service;

//import com.tulip.ecommerce_api.dto.CartDTO;
import com.tulip.ecommerce_api.entity.CartItem;

import java.util.List;

public interface CartService {
    void addToCart(Long productId, int quantity, String username);
    List<CartItem> getCartItems(String username);
    void updateCartItem(Long cartItemId, int quantity);
    void removeCartItem(Long cartItemId);
}