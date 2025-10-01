package com.example.IT_HRM.Repository;

import com.example.IT_HRM.Entity.UserGroupId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserGroupRepository extends JpaRepository<UserGroupId,Long> {
}
