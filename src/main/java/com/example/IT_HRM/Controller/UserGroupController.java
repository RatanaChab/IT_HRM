package com.example.IT_HRM.Controller;

import com.example.IT_HRM.DTO.UserDTO;
import com.example.IT_HRM.Entity.UserGroupId;
import com.example.IT_HRM.Service.UserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hrm/api/group")
public class UserGroupController {

    @Autowired
    private UserGroupService userGroupService;

    @GetMapping("/save")
    public ResponseEntity<?> save(){

        List<UserGroupId> all = userGroupService.getAll();
        return ResponseEntity.ok(all);
    }
}
