package com.tulip.ecommerce_api.service;

//import com.tulip.ecommerce_api.dto.OrderDTO;
import com.tulip.ecommerce_api.entity.Order;

import java.util.List;

public interface OrderService {
    public void placeOrder(String username);
    public List<Order> getOrderHistory(String username);
    public Order getOrderById(Long orderId);
}
