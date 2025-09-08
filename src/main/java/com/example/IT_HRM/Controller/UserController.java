package com.example.IT_HRM.Controller;

import com.example.IT_HRM.DTO.LeaveDTO;
import com.example.IT_HRM.Entity.User;
import com.example.IT_HRM.Service.LeaveService;
import com.example.IT_HRM.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hrm/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody User user){
        return ResponseEntity.ok(userService.create(user));
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(userService.getUsers());
    }
}
