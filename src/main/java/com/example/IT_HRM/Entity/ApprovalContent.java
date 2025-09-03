package com.example.IT_HRM.Entity;

import com.example.IT_HRM.Enum.ProcessEnum;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "approval_content", indexes = {
        @Index(columnList = "Id"),
        @Index(columnList = "approvalId")
})
@Data
public class ApprovalContent {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seqNo_app")
    @SequenceGenerator(name = "seqNo_app", sequenceName = "seqNo_app", initialValue = 1, allocationSize = 1 )
    private Long Id;
    private String approvalId;
    private String approvalName;
    private String approvalCmt;
    private String approvalDate;
    private String backupId;
    private String backupYN;
    private String reviewId;
    private String reviewYN;
    private String confirmHr;
    private String commentHr;
    private String specialApproval;
    @Enumerated(EnumType.STRING)
    private ProcessEnum status = ProcessEnum.PENDING;
    private String specialCmt;
}
