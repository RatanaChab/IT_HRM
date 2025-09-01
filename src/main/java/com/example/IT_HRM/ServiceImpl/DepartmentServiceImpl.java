package com.example.IT_HRM.ServiceImpl;

import com.example.IT_HRM.Entity.Department;
import com.example.IT_HRM.GlobalException.ResourceAlreadyExistsException;
import com.example.IT_HRM.Repository.DepartmentRep;
import com.example.IT_HRM.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRep departmentRep;

    @Override
    public Department createDep(Department department) {

        if ( departmentRep.existsByDepartmentCode(department.getDepartmentCode()) ){
                throw new ResourceAlreadyExistsException("Department Code", department.getDepartmentCode());
        }

        if ( departmentRep.existsByDepartmentName(department.getDepartmentName()) ){
                throw new ResourceAlreadyExistsException("Department Name", department.getDepartmentName());
        }

        department.setEntryBy("HO_IT06");
        department.setEntryDate(LocalDateTime.now());
        return departmentRep.save(department);
    }

    @Override
    public List<Department> findAllDep() {
        return departmentRep.findAll();
    }


}
