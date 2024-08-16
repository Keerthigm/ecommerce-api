package com.tulip.ecommerce_api.service;

import com.tulip.ecommerce_api.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    public void placeOrder(String username);
    public List<OrderDTO> getOrderHistory(String username);
    public OrderDTO getOrderById(Long orderId);
}
