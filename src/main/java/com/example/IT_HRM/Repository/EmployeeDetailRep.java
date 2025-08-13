package com.example.IT_HRM.Repository;

import com.example.IT_HRM.Entity.EmployeeDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDetailRep extends JpaRepository<EmployeeDetail,Long> {
}
