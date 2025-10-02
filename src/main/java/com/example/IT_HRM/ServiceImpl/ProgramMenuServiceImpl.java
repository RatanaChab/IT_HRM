package com.example.IT_HRM.ServiceImpl;

import com.example.IT_HRM.Entity.ProgramMenu;
import com.example.IT_HRM.Repository.ProgramMenuRepository;
import com.example.IT_HRM.Service.ProgramMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramMenuServiceImpl implements ProgramMenuService {

    @Autowired
    private ProgramMenuRepository programMenuRepository;

    @Override
    public ProgramMenu create(ProgramMenu programMenu) {
        programMenuRepository.save(programMenu);
        return null;
    }


    @Override
    public List<ProgramMenu> getAllProgram() {

        return programMenuRepository.findAll();
    }
}
