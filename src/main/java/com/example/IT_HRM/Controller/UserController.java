package com.example.IT_HRM.Controller;

import com.example.IT_HRM.DTO.LeaveDTO;
import com.example.IT_HRM.DTO.UserDTO;
import com.example.IT_HRM.Entity.User;
import com.example.IT_HRM.Service.LeaveService;
import com.example.IT_HRM.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hrm/users")
public class UserController {

    @Autowired
    private UserService userService;

    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody UserDTO user){
        return ResponseEntity.ok(userService.create(user));
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(userService.getUsers());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/user1")
    public ResponseEntity<?> getAllUser(){
        return ResponseEntity.ok(userService.allUser());
    }

    @PutMapping("/{userId}/user/update")
    public ResponseEntity<?> updateUser(@PathVariable String userId,  @RequestBody UserDTO user){
        userService.updateUser(userId,user);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }


}
