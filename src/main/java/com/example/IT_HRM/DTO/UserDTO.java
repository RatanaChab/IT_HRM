package com.example.IT_HRM.DTO;

import com.example.IT_HRM.Entity.Role;
import lombok.Data;

import java.util.Set;

@Data
public class UserDTO {
    private String username;
    private Long employee;
    private Long role;
    private String apprYN;
}
