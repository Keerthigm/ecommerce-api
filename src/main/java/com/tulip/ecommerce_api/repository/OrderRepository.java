package com.tulip.ecommerce_api.repository;

import com.tulip.ecommerce_api.dto.OrderDTO;
import com.tulip.ecommerce_api.dto.UserDTO;
import com.tulip.ecommerce_api.entity.Category;
import com.tulip.ecommerce_api.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderRepository extends JpaRepository<Order, Long>, JpaSpecificationExecutor<Order> {
    List<OrderDTO> findByUser(UserDTO user);
}
