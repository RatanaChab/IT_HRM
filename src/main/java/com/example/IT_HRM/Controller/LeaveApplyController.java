package com.example.IT_HRM.Controller;

import com.example.IT_HRM.DTO.LeaveDTO;
import com.example.IT_HRM.Entity.LeaveApply;
import com.example.IT_HRM.Service.LeaveApplyService;
import com.example.IT_HRM.Service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/apply")
public class LeaveApplyController {

    @Autowired
    private LeaveApplyService leaveApplyService;

    @PostMapping("/leave/save")
    public ResponseEntity<?> save(@RequestBody LeaveApply leave){

        return ResponseEntity.ok(leaveApplyService.Create(leave));
    }
}
