package com.example.IT_HRM.Service;

import com.example.IT_HRM.Entity.Department;

import java.util.List;

public interface DepartmentService {
    Department createDep( Department department);
    List<Department> findAllDep();
    Department getById( Long Id);
}
