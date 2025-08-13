package com.example.IT_HRM.Repository;

import com.example.IT_HRM.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRep extends JpaRepository<Department,Long> {
}
