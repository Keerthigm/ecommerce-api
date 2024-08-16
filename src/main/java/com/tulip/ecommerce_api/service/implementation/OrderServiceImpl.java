package com.tulip.ecommerce_api.service.implementation;

import com.tulip.ecommerce_api.entity.CartItem;
import com.tulip.ecommerce_api.entity.Order;
import com.tulip.ecommerce_api.entity.User;
import com.tulip.ecommerce_api.exception.ResourceNotFoundException;
import com.tulip.ecommerce_api.repository.CartRepository;
import com.tulip.ecommerce_api.repository.OrderRepository;
import com.tulip.ecommerce_api.service.OrderService;
import com.tulip.ecommerce_api.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
@AllArgsConstructor(onConstructor_ = @Autowired)
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserService userService;
    @Override
    public void placeOrder(String username) {
        Optional<User> user = userService.getByUsername(username);
        List<CartItem> cartDTOList = cartRepository.findByUser(user);

        if (cartDTOList.isEmpty()) {
            throw new ResourceNotFoundException("Cart is empty");
        }

        Order order = new Order();
        order.setUser(user);
        order.setOrderDate(LocalDateTime.now());
        order.setTotalAmount(cartDTOList.stream().mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity()).sum());
        order.setCartItems(cartDTOList);

        orderRepository.save(order);
        cartRepository.deleteAll(cartDTOList);
    }
    @Override
    public List<Order> getOrderHistory(String username) {
        Optional<User> user = userService.getByUsername(username);
        return orderRepository.findByUser(user);
    }
    @Override
    public Order getOrderById(Long orderId) {
        return (Order) orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));
    }
}
