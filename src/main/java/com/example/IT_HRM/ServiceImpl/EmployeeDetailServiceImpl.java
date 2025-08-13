package com.example.IT_HRM.ServiceImpl;

import com.example.IT_HRM.Entity.EmployeeDetail;
import com.example.IT_HRM.Repository.EmployeeDetailRep;
import com.example.IT_HRM.Service.EmployeeDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDetailServiceImpl implements EmployeeDetailService {
    @Autowired
    private EmployeeDetailRep employeeDetailRep;

    @Override
    public EmployeeDetail createDetail(EmployeeDetail employeeDetail) {

        return employeeDetailRep.save(employeeDetail);
    }
}
