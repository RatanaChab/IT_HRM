package com.example.IT_HRM.ServiceImpl;

import com.example.IT_HRM.DTO.UserDTO;
import com.example.IT_HRM.Entity.User;
import com.example.IT_HRM.Mapper.UserMapper;
import com.example.IT_HRM.Repository.UserRepository;
import com.example.IT_HRM.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<UserDTO> getUsers() {
        List<UserDTO> list = userRepository.findAll().stream().map(user -> userMapper.userToDTO(user)).toList();

        return list;
    }
}
