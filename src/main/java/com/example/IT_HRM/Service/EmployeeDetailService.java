package com.example.IT_HRM.Service;

import com.example.IT_HRM.Entity.EmployeeDetail;

public interface EmployeeDetailService {
    EmployeeDetail createDetail( EmployeeDetail employeeDetail);
    EmployeeDetail getEmpDetail( Long empId );
    EmployeeDetail updateDetail( EmployeeDetail empId );
}
