package com.example.IT_HRM.ServiceImpl;

import com.example.IT_HRM.Entity.User;
import com.example.IT_HRM.Repository.UserRepository;
import com.example.IT_HRM.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }
}
