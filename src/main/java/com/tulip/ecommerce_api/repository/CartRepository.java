package com.tulip.ecommerce_api.repository;

//import com.tulip.ecommerce_api.dto.CartDTO;
import com.tulip.ecommerce_api.entity.CartItem;
import com.tulip.ecommerce_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<CartItem, Long> , JpaSpecificationExecutor<CartItem> {
    List<CartItem> findByUser(User user);

    List<CartItem> findByUser(Optional<User> user);
}
