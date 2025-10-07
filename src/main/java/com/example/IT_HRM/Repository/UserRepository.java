package com.example.IT_HRM.Repository;

import com.example.IT_HRM.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsById(Long code );
    boolean existsByName( String name);
    Optional<User> findByName(String username);
}
