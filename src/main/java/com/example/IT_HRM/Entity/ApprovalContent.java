package com.example.IT_HRM.Entity;

import com.example.IT_HRM.Enum.ProcessEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class ApprovalContent {

    private Long Id;
    private Long employeeId;
    private Long seqNo;
    private Long approvalId;
    private String approvalName;
    private String approvalStatus;  //modify
    private String approvalCmt;
    private String approvalDate;
    private Long backupId;
    private String backupYN;
    private Long reviewId;
    private String reviewYN;
    private String confirmHr;
    private String commentHr;
    private Long specialApproval;
    @Enumerated(EnumType.STRING)
    private ProcessEnum status = ProcessEnum.PENDING;
    private String specialCmt;

}
