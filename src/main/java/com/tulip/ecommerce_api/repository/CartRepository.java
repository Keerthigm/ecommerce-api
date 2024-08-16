package com.tulip.ecommerce_api.repository;

import com.tulip.ecommerce_api.dto.CartDTO;
import com.tulip.ecommerce_api.entity.CartItem;
import com.tulip.ecommerce_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CartRepository extends JpaRepository<CartItem, Long> , JpaSpecificationExecutor<CartItem> {
    List<CartDTO> findByUser(User user);
}
