package com.tulip.ecommerce_api.dto;

import com.tulip.ecommerce_api.entity.Order;
import com.tulip.ecommerce_api.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO extends Order {
    private Long id;
    private LocalDateTime orderDate;
    private Double totalAmount;
    private User user;
    private List<CartDTO> cartDTOList;
}
