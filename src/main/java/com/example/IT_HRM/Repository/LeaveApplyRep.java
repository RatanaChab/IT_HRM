package com.example.IT_HRM.Repository;

import com.example.IT_HRM.Entity.LeaveApply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveApplyRep extends JpaRepository<LeaveApply,Long> {
}
