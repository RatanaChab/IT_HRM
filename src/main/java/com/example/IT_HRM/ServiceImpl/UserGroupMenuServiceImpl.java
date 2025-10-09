package com.example.IT_HRM.ServiceImpl;

import com.example.IT_HRM.Entity.User;
import com.example.IT_HRM.Entity.UserGroupMenuId;
import com.example.IT_HRM.Repository.UserGroupMenuRep;
import com.example.IT_HRM.Repository.UserGroupRepository;
import com.example.IT_HRM.Repository.UserRepository;
import com.example.IT_HRM.Service.UserGroupMenuService;
import com.example.IT_HRM.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserGroupMenuServiceImpl implements UserGroupMenuService {

    @Autowired
    private UserGroupMenuRep userGroupMenuRep;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserGroupMenuId> getAll() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        String groupCode = userRepository.findByName(username)
                .stream()
                .map(group -> group.getUserGroup().getGroupCode()).findFirst().orElse(null);

        List<UserGroupMenuId> gi10001 = userGroupMenuRep.findAll()
                .stream()
                .filter(group -> group.getUserGroup().getGroupCode().equals(groupCode))
                .toList();
        System.out.println(gi10001);
        return gi10001;
    }
}
