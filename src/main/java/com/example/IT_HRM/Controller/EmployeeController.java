package com.example.IT_HRM.Controller;

import com.example.IT_HRM.DTO.EmployeeDTO;
import com.example.IT_HRM.Entity.ApprovalGroup;
import com.example.IT_HRM.Entity.Employee;
import com.example.IT_HRM.Entity.EmployeeDetail;
import com.example.IT_HRM.Mapper.EmployeeMapper;
import com.example.IT_HRM.Service.ApprovalGroupService;
import com.example.IT_HRM.Service.EmployeeDetailService;
import com.example.IT_HRM.Service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/hrm")
@AllArgsConstructor
//@CrossOrigin(origins = "http://localhost:5173")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeDetailService employeeDetailService;
    private final ApprovalGroupService approvalGroupService;
    //@Autowired
    private final EmployeeMapper employeeMapper;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody EmployeeDTO employee){
        Employee emp = employeeService.createEmp(employee);
        return ResponseEntity.ok(emp);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        Employee employee = employeeService.findbyId(id);
        return ResponseEntity.ok(employee);
    }

//    @GetMapping("/employees")
//    public ResponseEntity<?> getEmployee(){
//        List<EmployeeDTO> list = employeeService.getAll().stream().map(employeeMapper::employeeToDTO).toList();
//        List<EmployeeDTO> collect = list.stream().sorted(Comparator.comparing(EmployeeDTO::getId)).collect(Collectors.toList());
//        return ResponseEntity.ok(collect);
//    }

    @GetMapping("/employeesFilter")
    public ResponseEntity<?> getFilterEmployee(@RequestParam Map<String,String> params){
        //List<EmployeeDTO> filter = employeeService.getFilter(params).stream().map(employeeMapper::employeeToDTO).toList();
        List<Employee> list = employeeService.getFilter(params).stream().toList();
        return ResponseEntity.ok(list);
    }

    @PutMapping("/employee/update/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        Employee employee1 = employeeService.updateEmp(id, employee);
        return ResponseEntity.ok(employee1);
    }


    @PostMapping("/api/approval_group/")
    public ResponseEntity<?> saveApprovalGroup(@RequestBody ApprovalGroup group){

        return ResponseEntity.ok(approvalGroupService.create(group));
    }

}
