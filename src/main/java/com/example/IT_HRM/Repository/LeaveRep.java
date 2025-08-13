package com.example.IT_HRM.Repository;

import com.example.IT_HRM.Entity.Leave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveRep extends JpaRepository<Leave,Long> {
}
