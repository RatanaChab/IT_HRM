package com.example.IT_HRM.ServiceImpl;

import com.example.IT_HRM.Entity.ApprovalGroup;
import com.example.IT_HRM.GlobalException.ApiException;
import com.example.IT_HRM.Repository.ApprovalGroupRep;
import com.example.IT_HRM.Service.ApprovalGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ApprovalGroupServiceImpl implements ApprovalGroupService {

    @Autowired
    private ApprovalGroupRep approvalGroupRep;

    @Override
    public ApprovalGroup create(ApprovalGroup group) {
        return approvalGroupRep.save(group);
    }

    @Override
    public ApprovalGroup getById(Long aLong) {
        return approvalGroupRep.findById(aLong).orElseThrow(() -> new ApiException(HttpStatus.BAD_REQUEST,aLong.toString()));
    }
}
