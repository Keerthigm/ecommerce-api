package com.tulip.ecommerce_api.service;

import com.tulip.ecommerce_api.dto.CartDTO;

import java.util.List;

public interface CartService {
    public void addToCart(Long productId, int quantity, String username);
    public List<CartDTO> getCartItems(String username);
    public void updateCartItem(Long cartItemId, int quqntity);
    public void removeCartItem(Long cartItemId);
}
