package com.example.IT_HRM.ServiceImpl;

import com.example.IT_HRM.Entity.Leave;
import com.example.IT_HRM.Entity.LeaveApply;
import com.example.IT_HRM.GlobalException.ApiException;
import com.example.IT_HRM.GlobalException.ResourceNotFoundException;
import com.example.IT_HRM.Repository.ApprovalContentRep;
import com.example.IT_HRM.Repository.LeaveApplyRep;
import com.example.IT_HRM.Repository.LeaveRep;
import com.example.IT_HRM.Service.LeaveApplyService;
import com.example.IT_HRM.Service.LeaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LeaveApplyServiceImpl implements LeaveApplyService {

    @Autowired
    private LeaveApplyRep leaveApplyRep;
    @Autowired
    private LeaveService leaveService;
    private final ApprovalContentRep approvalContentRep;

    @Override
    public LeaveApply Create(LeaveApply leaveApply) {
        Leave leaveId = leaveService.getByEmployee(leaveApply.getEmployeeId());

        if ( leaveId.getTotalLeave() < leaveApply.getActualDay() ) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Total Balance Leave Remain %s".formatted(leaveId.getTotalLeave()));
        }

        if ( isEndDatevalid(leaveApply.getFromDate(),leaveApply.getToDate()) ){
            throw new ApiException(HttpStatus.BAD_REQUEST,"Date Apply Must before 7 days");
        }

        Optional<LeaveApply> max = leaveApplyRep.findAll().stream().filter(l -> leaveApply.getEmployeeId().equals(l.getEmployeeId())).max(Comparator.comparing(LeaveApply::getSeqNo));
        max.stream().map(LeaveApply::getSeqNo).forEach(System.out::println);
        leaveApply.setApplyDate(LocalDateTime.now());
        leaveApply.setEmployeeId(leaveApply.getEmployeeId());
        //return null;

        approvalContentRep.save(leaveApply.getApprovalContent());
        leaveApplyRep.save(leaveApply);

        return leaveApply;
    }

    @Override
    public List<LeaveApply> getAllList() {
        return leaveApplyRep.findAll();
    }

    public static boolean isEndDatevalid( LocalDate startDate, LocalDate endDate ){
        LocalDate endlocalDate = startDate.plusDays(7);
        return  endDate.isBefore(endlocalDate);
    }
}

