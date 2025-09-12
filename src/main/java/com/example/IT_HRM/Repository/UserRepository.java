package com.example.IT_HRM.Repository;

import com.example.IT_HRM.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsById(Long code );
    boolean existsByName( String name);
}
