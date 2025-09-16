package com.example.IT_HRM.Controller;

import com.example.IT_HRM.Entity.Employee;
import com.example.IT_HRM.Entity.EmployeeDetail;
import com.example.IT_HRM.Service.EmployeeDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/{empId}/employeeDetail")
    public ResponseEntity<?> getDetail(@RequestParam Long empId){
        EmployeeDetail empDetail = employeeDetailService.getEmpDetail(empId);
        return ResponseEntity.ok(empDetail);
    }

    @PutMapping("update/{empId}/employeeDetail")
    public ResponseEntity<?> updateEmpDetail(@RequestBody EmployeeDetail empId){
        EmployeeDetail employeeDetail = employeeDetailService.updateDetail(empId);
        return ResponseEntity.ok(employeeDetail);
    }
}
