package com.example.IT_HRM.Service;

import com.example.IT_HRM.DTO.UserDTO;
import com.example.IT_HRM.Entity.User;

import java.util.List;

public interface UserService {
    User create( User user );
    List<UserDTO> getUsers();
}
