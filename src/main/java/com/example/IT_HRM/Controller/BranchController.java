package com.example.IT_HRM.Controller;

import com.example.IT_HRM.Entity.Branch;
import com.example.IT_HRM.Entity.Department;
import com.example.IT_HRM.Service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/hrm/branch")
public class BranchController {

    @Autowired
    private BranchService branchService;

    @PostMapping("/create")
    public ResponseEntity<?> save(@RequestBody Branch branch){
        Branch branch1 = branchService.create(branch);
        return ResponseEntity.ok(branch1);
    }
}
