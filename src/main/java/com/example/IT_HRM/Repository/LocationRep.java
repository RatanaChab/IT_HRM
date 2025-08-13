package com.example.IT_HRM.Repository;

import com.example.IT_HRM.Entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRep extends JpaRepository<Location,Long> {
}
