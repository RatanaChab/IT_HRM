package com.example.IT_HRM.Repository;

import com.example.IT_HRM.Entity.UserGroupMenuId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserGroupMenuRep extends JpaRepository<UserGroupMenuId,Long> {
}
