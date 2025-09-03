package com.example.IT_HRM.Service;

import com.example.IT_HRM.Entity.LeaveApply;

import java.util.List;

public interface LeaveApplyService {
    LeaveApply Create( LeaveApply leaveApply);
    List<LeaveApply> getAllList();
}
