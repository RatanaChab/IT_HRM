package com.example.IT_HRM.Service;

import com.example.IT_HRM.DTO.UserDTO;
import com.example.IT_HRM.Entity.User;

import java.util.List;

public interface UserService {
    User create( UserDTO user );
    //User getByUsername( Long emp );
    List<UserDTO> getUsers();
    List<User> allUser();
}

