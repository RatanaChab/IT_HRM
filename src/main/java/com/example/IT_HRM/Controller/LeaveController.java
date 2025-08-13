package com.example.IT_HRM.Controller;

import com.example.IT_HRM.DTO.LeaveDTO;
import com.example.IT_HRM.Entity.EmployeeDetail;
import com.example.IT_HRM.Entity.Leave;
import com.example.IT_HRM.Service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hrm")
public class LeaveController {
    @Autowired
    private LeaveService leaveService;

    @PostMapping("/Leave/save")
    public ResponseEntity<?> save(@RequestBody LeaveDTO leaveDTO){
        return ResponseEntity.ok(leaveService.Create(leaveDTO));
    }

    @GetMapping("/Leave")
    public ResponseEntity<?> getAll(){
        List<LeaveDTO> leaveDTOS = leaveService.ListLeave();
        return ResponseEntity.ok(leaveDTOS);
    }
}
