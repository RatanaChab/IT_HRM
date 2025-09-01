package com.example.IT_HRM.Repository;

import com.example.IT_HRM.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRep extends JpaRepository<Employee,Long>, JpaSpecificationExecutor<Employee> {

    //Employee findByEmpCode( Long code );
    boolean existsById(Long code );
}
