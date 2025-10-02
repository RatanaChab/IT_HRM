package com.example.IT_HRM.ServiceImpl;

import com.example.IT_HRM.Entity.UserGroupId;
import com.example.IT_HRM.Repository.UserGroupRepository;
import com.example.IT_HRM.Service.UserGroupService;
import com.example.IT_HRM.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserGroupServiceImpl implements UserGroupService {

    @Autowired
    private UserGroupRepository userGroupRepository;

    @Override
    public List<UserGroupId> getAll() {
        return userGroupRepository.findAll();
    }
}
