package com.example.IT_HRM.Controller;

import com.example.IT_HRM.Entity.Department;
import com.example.IT_HRM.Entity.EmployeeDetail;
import com.example.IT_HRM.Service.DepartmentService;
import com.example.IT_HRM.Service.EmployeeDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        List<Department> allDep = departmentService.findAllDep();
        return ResponseEntity.ok(allDep);
    }
}
