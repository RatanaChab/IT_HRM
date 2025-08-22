package com.example.IT_HRM.Repository;

import com.example.IT_HRM.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRep extends JpaRepository<Department,Long> {

    Optional<Department> findByDepartmentCodeOrDepartmentCode(String code , String name);
//    Optional<Department> findByDepartmentCode(String departmentCode);
//    Optional<Department> findByDepartmentName(String departmentName);
    boolean existsByDepartmentCode(String departmentCode);
    boolean existsByDepartmentName(String departmentName);
}
