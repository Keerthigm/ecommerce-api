package com.tulip.ecommerce_api.service.implementation;

import com.tulip.ecommerce_api.dto.CartDTO;
import com.tulip.ecommerce_api.dto.OrderDTO;
import com.tulip.ecommerce_api.dto.UserDTO;
import com.tulip.ecommerce_api.entity.CartItem;
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
        User user = userService.getUserByname(username);
        List<CartDTO> cartDTOList = cartRepository.findByUser(user);

        if (cartDTOList.isEmpty()) {
            throw new ResourceNotFoundException("Cart is empty");
        }

        OrderDTO order = new OrderDTO();
        order.setUser(user);
        order.setOrderDate(LocalDateTime.now());
        order.setTotalAmount(cartDTOList.stream().mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity()).sum());
        order.setCartDTOList(cartDTOList);

        orderRepository.save(order);
        cartRepository.deleteAll(cartDTOList);
    }
    @Override
    public List<OrderDTO> getOrderHistory(String username) {
        User user = userService.getUserByname(username);
        return orderRepository.findByUser((UserDTO) user);
    }
    @Override
    public OrderDTO getOrderById(Long orderId) {
        return (OrderDTO) orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));
    }
}
