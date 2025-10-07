package com.example.IT_HRM.Service;

import com.example.IT_HRM.DTO.UserDTO;
import com.example.IT_HRM.Entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User create( UserDTO user );
    Optional<User> getByUsername(String username );
    List<UserDTO> getUsers();
    List<User> allUser();
    User updateUser( User user);
    User getUserId( Long Id );
}

