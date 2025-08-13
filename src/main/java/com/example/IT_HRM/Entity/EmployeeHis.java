package com.example.IT_HRM.Entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "employee_history")
public class EmployeeHis extends DatetimeAuditor{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String fullName;
    private String job_his;
    private String level;
    private String dep_his;
    private String from_date;
    private String to_date;
    @ManyToOne
    @JoinColumn(name = "employeeHis")
    private Employee employeeId;
}
