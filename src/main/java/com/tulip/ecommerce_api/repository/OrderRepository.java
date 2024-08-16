package com.tulip.ecommerce_api.repository;

import com.tulip.ecommerce_api.entity.Order;
import com.tulip.ecommerce_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>, JpaSpecificationExecutor<Order> {
    List<Order> findByUser(User user);

    List<Order> findByUser(Optional<User> user);
}
