package com.example.IT_HRM.ServiceImpl;

import com.example.IT_HRM.Entity.EmployeeDetail;
import com.example.IT_HRM.GlobalException.ResourceNotFoundException;
import com.example.IT_HRM.Repository.EmployeeDetailRep;
import com.example.IT_HRM.Service.EmployeeDetailService;
import com.example.IT_HRM.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDetailServiceImpl implements EmployeeDetailService {
    @Autowired
    private EmployeeDetailRep employeeDetailRep;
    @Autowired
    private EmployeeService employeeService;

    @Override
    public EmployeeDetail createDetail(EmployeeDetail employeeDetail) {

        return employeeDetailRep.save(employeeDetail);
    }

    @Override
    public EmployeeDetail getEmpDetail(Long empId) {
        return employeeDetailRep.findById(empId).orElseThrow( () -> new ResourceNotFoundException("Employee Detail", empId));
    }

    @Override
    public EmployeeDetail updateDetail(EmployeeDetail empId) {
        getEmpDetail(empId.getEmployeeId().getId());
        employeeService.updateEmp(empId.getId(),empId.getEmployeeId());
        EmployeeDetail save = employeeDetailRep.save(empId);
        return save;
    }
}
