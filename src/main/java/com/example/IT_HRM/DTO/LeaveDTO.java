package com.example.IT_HRM.DTO;

import lombok.Data;

@Data
public class LeaveDTO {
    private Long Id;
    private Long employee;
    private Float forwardLeave;
    private Float totalLeave;
    private Float leaveTaken;
    private Float leaveBalance;
}
