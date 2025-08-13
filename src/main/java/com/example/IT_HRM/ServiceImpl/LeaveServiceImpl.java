package com.example.IT_HRM.ServiceImpl;

import com.example.IT_HRM.DTO.LeaveDTO;
import com.example.IT_HRM.Entity.Leave;
import com.example.IT_HRM.GlobalException.ResourceNotFoundException;
import com.example.IT_HRM.Mapper.LeaveMapper;
import com.example.IT_HRM.Repository.EmployeeRep;
import com.example.IT_HRM.Repository.LeaveRep;
import com.example.IT_HRM.Service.EmployeeService;
import com.example.IT_HRM.Service.LeaveService;
import com.example.IT_HRM.Utils.CommonUse;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveServiceImpl implements LeaveService {

    @Autowired
    private LeaveRep leaveRep;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private LeaveMapper leaveMapper;

    @Override
    public LeaveDTO Create(LeaveDTO leaveDTO) {
        employeeService.findbyId(leaveDTO.getEmployee());
        Leave leave = leaveMapper.DTOToLeave(leaveDTO);
        leaveRep.save(leave);
        return leaveDTO;
    }

    @Override
    public List<LeaveDTO> ListLeave() {
        List<LeaveDTO> list = leaveRep.findAll().stream().map(leaveMapper::mapToDTO).toList();
        List<LeaveDTO> leaveDTOS = CommonUse.sortByField(list, item -> item.getId());
        return leaveDTOS;
    }


    @Override
    public Leave getById(Long Id) {
        return leaveRep.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Information",Id));
    }
}
