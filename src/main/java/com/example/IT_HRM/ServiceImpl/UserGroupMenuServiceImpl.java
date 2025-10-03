package com.example.IT_HRM.ServiceImpl;

import com.example.IT_HRM.Entity.UserGroupMenuId;
import com.example.IT_HRM.Repository.UserGroupMenuRep;
import com.example.IT_HRM.Repository.UserGroupRepository;
import com.example.IT_HRM.Service.UserGroupMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserGroupMenuServiceImpl implements UserGroupMenuService {

    @Autowired
    private UserGroupMenuRep userGroupMenuRep;

    @Override
    public List<UserGroupMenuId> getAll() {
        List<UserGroupMenuId> gi10001 = userGroupMenuRep.findAll()
                .stream().filter(group -> group.getUserGroup().getGroupCode().equals("GI10001")).toList();
        System.out.println(gi10001);
        return gi10001;
    }
}
