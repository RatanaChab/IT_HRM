package com.example.IT_HRM.ServiceImpl;

import com.example.IT_HRM.DTO.EmployeeDTO;
import com.example.IT_HRM.Entity.*;
import com.example.IT_HRM.GlobalException.ResourceAlreadyExistsException;
import com.example.IT_HRM.GlobalException.ResourceNotFoundException;
import com.example.IT_HRM.Mapper.EmployeeMapper;
import com.example.IT_HRM.Repository.EmployeeDetailRep;
import com.example.IT_HRM.Repository.EmployeeRep;
import com.example.IT_HRM.Repository.LeaveRep;
import com.example.IT_HRM.Service.ApprovalGroupService;
import com.example.IT_HRM.Service.DepartmentService;
import com.example.IT_HRM.Service.EmployeeService;
import com.example.IT_HRM.Spec.EmployeeFilter;
import com.example.IT_HRM.Spec.EmployeeSpec;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRep employeeRep;
    private final EmployeeDetailRep employeeDetailRep;
    private final DepartmentService departmentService;
    private final LeaveRep leaveRep;
    private final ApprovalGroupService approvalGroupService;
    private final EmployeeMapper employeeMapper;

    @Override
    public Employee createEmp(EmployeeDTO employee) {
        if ( employeeRep.existsById(employee.getId())){
            throw new ResourceAlreadyExistsException("Employee Code",employee.getId().toString());
        }

        Department byId = departmentService.getById(employee.getDepartment());
        ApprovalGroup byId1 = approvalGroupService.getById(employee.getGroup());

        Employee employee1 = employeeMapper.DTOtoEmployee(employee);
        employee1.setDepartment(byId);
        employee1.setGroup(byId1);


        EmployeeDetail employeeDetail = new EmployeeDetail();
        employeeDetail.setEmployeeId(employee1);

        Leave leave = new Leave();
        leave.setEmployee(employee1);
        leave.setLeaveApply(1l);
        leave.setLeaveBalance(1f);
        leave.setForwardLeave(1f);
        leave.setTotalLeave(1f);
        leave.setLeaveTaken(1f);

        employeeRep.save(employee1);
        employeeDetailRep.save(employeeDetail);
        leaveRep.save(leave);
        return employee1;

    }

    //    @Override
//    public Employee createEmp(Employee employee) {
//
//        if ( employeeRep.existsById(employee.getId())){
//            throw new ResourceAlreadyExistsException("Employee Code",employee.getId().toString());
//        }
//
//        employee.setEntryDate(LocalDateTime.now());
//        employee.setEntryBy("HO_IT");
//        employee.setFullName(employee.getFirstName() + " " + employee.getLastName());
//
//        EmployeeDetail employeeDetail = new EmployeeDetail();
//        employeeDetail.setEmployeeId(employee);
//
//        Leave leave = new Leave();
//        leave.setEmployee(employee);
//        leave.setLeaveApply(1l);
//        leave.setLeaveBalance(1f);
//        leave.setForwardLeave(1f);
//        leave.setTotalLeave(1f);
//        leave.setLeaveTaken(1f);
//
//        employeeRep.save(employee);
//        employeeDetailRep.save(employeeDetail);
//        leaveRep.save(leave);
//        return employee;
//    }

    @Override
    public List<Employee> getAll() {
        return employeeRep.findAll();
    }

    @Override
    public Employee findbyId(Long id) {
        Employee employee = employeeRep.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", id));
        return employee;
    }

    @Override
    public Employee updateEmp(Long id, Employee emp) {
        Employee employee = findbyId(id);
        //EmployeeMapper.INSTANCE.updateEmployeeFromDTO(employee, emp);
        emp.setPhoneNum(emp.getPhoneNum());
        emp.setUpdateBy("HO_IT06");
        emp.setUpdateDate(LocalDateTime.now());
        return employeeRep.save(emp);
    }


    @Override
    public List<Employee> getFilter(Map<String, String> params) {
        EmployeeFilter employeeFilter = new EmployeeFilter();

        if (params.containsKey("id")) {
            String id = params.get("id");
            employeeFilter.setId(Long.parseLong(id));
        }

        if (params.containsKey("branch")) {
            String branch = params.get("branch");
            employeeFilter.setBranch(branch);
        }

        if (params.containsKey("empCode")) {
            String empCode = params.get("empCode");
            employeeFilter.setEmpCode(empCode);
        }

        EmployeeSpec employeeSpec = new EmployeeSpec(employeeFilter);
        List<Employee> all = employeeRep.findAll(employeeSpec);
//        Map<String, String> toMapDepartment = departmentRep.findAll().
//                                stream().collect(Collectors.toMap(Department::getDepartmentCode, Department::getDepartmentName));
//        List<Employee> employees = employeeRep.findAll(employeeSpec).stream().map( e -> {
//            e.setDepartment(toMapDepartment.getOrDefault(e.getDepartment().getDepartmentCode(),new Department()));
//           return e;
//        }).toList();
        //System.out.println(employees);

        return all;
    }
}

