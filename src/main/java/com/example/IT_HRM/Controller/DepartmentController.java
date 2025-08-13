package com.example.IT_HRM.Controller;

import com.example.IT_HRM.Entity.Department;
import com.example.IT_HRM.Entity.EmployeeDetail;
import com.example.IT_HRM.Service.DepartmentService;
import com.example.IT_HRM.Service.EmployeeDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hrm/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/create")
    public ResponseEntity<?> save(@RequestBody Department department){
        Department dep = departmentService.createDep(department);
        return ResponseEntity.ok(dep);
    }
}
