package com.example.IT_HRM.ServiceImpl;

import com.example.IT_HRM.Entity.Department;
import com.example.IT_HRM.Repository.DepartmentRep;
import com.example.IT_HRM.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRep departmentRep;

    @Override
    public Department createDep(Department department) {
        //department.setDepEnumCode(department.getDepEnumCode());
        department.setEntryBy("HO_IT06");
        department.setEntryDate(LocalDateTime.now());
        return departmentRep.save(department);
    }
}
