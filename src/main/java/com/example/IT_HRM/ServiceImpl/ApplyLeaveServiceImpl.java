package com.example.IT_HRM.ServiceImpl;

import com.example.IT_HRM.Entity.Leave;
import com.example.IT_HRM.Entity.LeaveApply;
import com.example.IT_HRM.Repository.LeaveApplyRep;
import com.example.IT_HRM.Service.ApplyLeaveService;
import com.example.IT_HRM.Service.LeaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplyLeaveServiceImpl implements ApplyLeaveService {

    private final LeaveApplyRep leaveApplyRep;

    private final LeaveService leaveService;

    @Override
    public LeaveApply applySave(LeaveApply apply) {
        Leave byId = leaveService.getById(apply.getId());



        return leaveApplyRep.save(apply);
    }
}
