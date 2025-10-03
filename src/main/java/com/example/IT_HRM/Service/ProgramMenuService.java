package com.example.IT_HRM.Service;

import com.example.IT_HRM.Entity.ProgramMenu;

import java.util.List;

public interface ProgramMenuService {
    ProgramMenu create( ProgramMenu programMenu);
    List<ProgramMenu> getAllProgram();
    ProgramMenu getBymenuIDN( String menu);
}
