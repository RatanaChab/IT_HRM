package com.example.IT_HRM.ServiceImpl;

import com.example.IT_HRM.Entity.Leave;
import com.example.IT_HRM.Entity.LeaveApply;
import com.example.IT_HRM.Repository.LeaveApplyRep;
import com.example.IT_HRM.Repository.LeaveRep;
import com.example.IT_HRM.Service.LeaveApplyService;
import com.example.IT_HRM.Service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class LeaveApplyServiceImpl implements LeaveApplyService {

    @Autowired
    private LeaveApplyRep leaveApplyRep;

    @Autowired
    private LeaveService leaveService;

    @Override
    public LeaveApply Create(LeaveApply leaveApply) {
        Leave leaveId = leaveService.getById(leaveApply.getEmployeeId());

        //leaveId.getTotalLeave().compareTo();

       // System.out.println(i);
        leaveApply.setFromDate(LocalDate.now());
        leaveApply.setToDate(LocalDate.now());


        return null;
        //return leaveApplyRep.save(leaveApply);
    }
}

