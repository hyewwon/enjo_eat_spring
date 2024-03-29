package com.enjo_eat_spring.enjo_eat_spring.data.repository;

import com.enjo_eat_spring.enjo_eat_spring.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUserid(String userid);
    boolean existsByUsername(String username);
    Optional<User> findByUserid(String userid);
    Optional<User> findByUsername(String username);
}
