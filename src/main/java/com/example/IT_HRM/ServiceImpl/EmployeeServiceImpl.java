package com.example.IT_HRM.ServiceImpl;

import com.example.IT_HRM.DTO.EmployeeDTO;
import com.example.IT_HRM.Entity.Employee;
import com.example.IT_HRM.Entity.EmployeeDetail;
import com.example.IT_HRM.GlobalException.ResourceAlreadyExistsException;
import com.example.IT_HRM.GlobalException.ResourceNotFoundException;
import com.example.IT_HRM.Mapper.EmployeeMapper;
import com.example.IT_HRM.Repository.EmployeeDetailRep;
import com.example.IT_HRM.Repository.EmployeeRep;
import com.example.IT_HRM.Service.EmployeeService;
import com.example.IT_HRM.Spec.EmployeeFilter;
import com.example.IT_HRM.Spec.EmployeeSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRep employeeRep;
    @Autowired
    private EmployeeDetailRep employeeDetailRep;

    @Override
    public Employee createEmp(Employee employee) {

        employee.setEntryDate(LocalDateTime.now());
        employee.setEntryBy("HO_IT");
        employee.setFullName(employee.getFirstName() + " " + employee.getLastName());

        EmployeeDetail employeeDetail = new EmployeeDetail();
        employeeDetail.setEmployeeId(employee);

        employeeRep.save(employee);
        employeeDetailRep.save(employeeDetail);
        return employee;
    }

    @Override
    public List<Employee> getAll() {
        return employeeRep.findAll();
    }

    @Override
    public Employee findbyId(Long id) {
        Employee employee = employeeRep.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee",id));
        return employee;
    }

    @Override
    public Employee updateEmp(Long id , Employee emp) {
        Employee employee = findbyId(id);
        //EmployeeMapper.INSTANCE.updateEmployeeFromDTO(employee, emp);
        emp.setPhoneNum(emp.getPhoneNum());
        emp.setUpdateBy("HO_IT06");
        emp.setUpdateDate(LocalDateTime.now());
        return employeeRep.save(emp);
    }


//    public Long findByEmpCode(Long id) {
//
//        if(employeeRep.findByEmpCode(id) == null){
//            return id;
//        }
//
//        Employee byEmpCode = employeeRep.findByEmpCode(id);
//        if (id.equals(byEmpCode.getEmpCode())){
//            throw new ResourceAlreadyExistsException("Employee Code",id.toString());
//        }
//        return byEmpCode.getEmpCode();
//    }

    @Override
    public List<Employee> getFilter(Map<String, String> params) {
        EmployeeFilter employeeFilter = new EmployeeFilter();

        if (params.containsKey("id")){
            String id = params.get("id");
            employeeFilter.setId(Long.parseLong(id));
        }

        if (params.containsKey("branch")){
            String branch = params.get("branch");
            employeeFilter.setBranch(branch);
        }

        if (params.containsKey("empCode")){
            String empCode = params.get("empCode");
            employeeFilter.setEmpCode(empCode);
        }

        EmployeeSpec employeeSpec = new EmployeeSpec(employeeFilter);
        List<Employee> all = employeeRep.findAll(employeeSpec);
        return all;
    }

}
