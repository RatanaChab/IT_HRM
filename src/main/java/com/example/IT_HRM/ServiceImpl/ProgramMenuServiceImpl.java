package com.example.IT_HRM.ServiceImpl;

import com.example.IT_HRM.Entity.ProgramMenu;
import com.example.IT_HRM.Entity.UserGroupId;
import com.example.IT_HRM.Entity.UserGroupMenuId;
import com.example.IT_HRM.Repository.ProgramMenuRepository;
import com.example.IT_HRM.Repository.UserGroupMenuRep;
import com.example.IT_HRM.Service.ProgramMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProgramMenuServiceImpl implements ProgramMenuService {

    @Autowired
    private ProgramMenuRepository programMenuRepository;
    @Autowired
    private UserGroupMenuRep userGroupMenuRep;

    @Override
    public ProgramMenu create(ProgramMenu programMenu) {
        programMenuRepository.save(programMenu);
        return null;
    }

    @Override
    public List<ProgramMenu> getAllProgram() {
        return programMenuRepository.findAll();
    }

    @Override
    public List<ProgramMenu> getBymenuIDN(String menu) {
        List<String> list1 = userGroupMenuRep.findAll().stream().filter(group -> group.getUserGroup()
                .getGroupCode().equals(menu)).map(menuId -> menuId.getMenuIDN()).toList();
        System.out.println(list1);


        List<ProgramMenu> filtered = programMenuRepository.findAll().stream()
                .filter(men -> list1.contains(men.getMenuIDN()))
                .toList();

        System.out.println(filtered);
        return filtered;
    }
}
