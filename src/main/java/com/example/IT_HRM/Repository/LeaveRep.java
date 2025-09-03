package com.example.IT_HRM.Repository;

import com.example.IT_HRM.Entity.Employee;
import com.example.IT_HRM.Entity.Leave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LeaveRep extends JpaRepository<Leave,Long> {
    Optional<Leave> findByEmployee(Employee emp );
}
