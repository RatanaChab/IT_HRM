package com.example.IT_HRM.Entity;

import com.example.IT_HRM.Enum.BranchEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Null;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "leave_apply", indexes = {
        @Index(columnList = "id"),
        @Index(columnList = "seqNo")
})
@Data
public class LeaveApply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Long seqNo;
    @Column(nullable = false)
    private Long employeeId;
    @Column(nullable = false,length = 50)
    private String fullName;
    @Column(nullable = false)
    private String holidayType;
    private LocalDateTime applyDate;
    //@Column(length = 9,nullable = false)
    private LocalDate fromDate;
    //@Column(length = 9,nullable = false)
    private LocalDate toDate;
    @Enumerated(EnumType.STRING)
    //@Column(nullable = false)
    private BranchEnum branch;
    //@Column(nullable = false)
    private Long actualDay;
    //@Column(nullable = false)
    private Boolean forwardYN;
    //@Column(nullable = false)
    private Boolean halfYN;
    private Long applyLeave;
    //@Column(nullable = false)
    private String reasonDetail;


}
