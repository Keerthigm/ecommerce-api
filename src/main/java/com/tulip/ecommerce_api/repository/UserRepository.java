package com.tulip.ecommerce_api.repository;

import com.tulip.ecommerce_api.entity.User;
//import org.springframework.security.core.userdetails.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> , JpaSpecificationExecutor<User> {
//    Optional<User> findByUsername(String username);

    User getByUsername(String username);

    User findByUsername(String username);
}