package com.example.IT_HRM.Controller;

import com.example.IT_HRM.Entity.Employee;
import com.example.IT_HRM.Entity.EmployeeDetail;
import com.example.IT_HRM.Service.EmployeeDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hrm")
public class EmployeeDetailController {

    @Autowired
    private EmployeeDetailService employeeDetailService;

    @PostMapping("/employeeDetail/save")
    public ResponseEntity<?> save(@RequestBody EmployeeDetail employee){

        EmployeeDetail emp = employeeDetailService.createDetail(employee);
        return ResponseEntity.ok(emp);
    }
}
