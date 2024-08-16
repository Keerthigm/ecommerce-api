package com.tulip.ecommerce_api.service.implementation;

//import com.tulip.ecommerce_api.dto.CartDTO;
import com.tulip.ecommerce_api.entity.CartItem;
import com.tulip.ecommerce_api.entity.Product;
import com.tulip.ecommerce_api.entity.User;
import com.tulip.ecommerce_api.exception.ResourceNotFoundException;
import com.tulip.ecommerce_api.repository.CartRepository;
import com.tulip.ecommerce_api.service.CartService;
import com.tulip.ecommerce_api.service.ProductService;
import com.tulip.ecommerce_api.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
@AllArgsConstructor(onConstructor_ = @Autowired)
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;

    @Override
    public void addToCart(Long productId, int quantity, String username) {
        Product product = productService.getProductById(productId);
        Optional<User> user = userService.getByUsername(username);

        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);
        cartItem.setUser(user.orElseThrow(() -> new ResourceNotFoundException("User not found")));
        cartRepository.save(cartItem);
    }

    @Override
    public List<CartItem> getCartItems(String username) {
        Optional<User> user = userService.getByUsername(username);
        List<CartItem> cartItems = cartRepository.findByUser(user);
        return cartItems.stream()
                .map(cartItem -> {
                    cartItem.getProduct().setPrice(null);
                    return cartItem;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void updateCartItem(Long cartItemId, int quantity) {
        CartItem cartItem = cartRepository.findById(cartItemId)
                .orElseThrow(() -> new ResourceNotFoundException("Cart item not found"));
        cartItem.setQuantity(quantity);
        cartRepository.save(cartItem);
    }

    @Override
    public void removeCartItem(Long cartItemId) {
        cartRepository.deleteById(cartItemId);
    }

//    private CartDTO convertToDTO(CartItem cartItem) {
//        CartDTO cartDTO = new CartDTO();
//        cartDTO.setId(cartItem.getId());
//        cartDTO.setQuantity(cartItem.getQuantity());
//        cartDTO.setProduct(cartItem.getProduct());
//        cartDTO.setUser(cartItem.getUser());
//        return cartDTO;
//    }
}