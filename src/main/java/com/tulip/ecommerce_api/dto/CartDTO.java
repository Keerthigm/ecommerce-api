package com.tulip.ecommerce_api.dto;

import com.tulip.ecommerce_api.entity.CartItem;
import com.tulip.ecommerce_api.entity.Product;
import com.tulip.ecommerce_api.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO extends CartItem {
    private Long id;
    private Integer quantity;
    private Product product;
    private User user;
}
