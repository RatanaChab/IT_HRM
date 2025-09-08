package com.example.IT_HRM.Service;

import com.example.IT_HRM.DTO.EmployeeDTO;
import com.example.IT_HRM.Entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface EmployeeService {

    Employee createEmp( EmployeeDTO employee);
    List<Employee> getAll();
    //Page<Employee> getFilter(Map<String,String> params);
    List<Employee> getFilter(Map<String,String> params);
    Employee findbyId( Long id);
    Employee updateEmp( Long id,  Employee employee);
}
