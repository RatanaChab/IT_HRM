package com.example.IT_HRM.Entity;

import com.example.IT_HRM.Enum.BranchEnum;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "employees")
@Data
public class Employee extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(length = 9,nullable = false)
    private BranchEnum branch;
    @Column(length = 50)
    private String fullName;
    @Column(length = 25)
    private String localFirstName;
    @Column(length = 25)
    private String localLastName;
    @Column(length = 50)
    private String localFullName;
    @Column(length = 9)
    private String sex;
    @Column(length = 9)
    private String position;
    @Column(length = 9)
    private String rank;    // modify later
    @Column(length = 9)
    private String empType;
    @Column(length = 9,nullable = false)
    private String joinDate;
    @Column(length = 9)
    private String resignDate;
    @Column(length = 15)
    private String phoneNum;
    @Column(length = 9,nullable = false)
    private String dep_code;
    @OneToOne(mappedBy = "emp_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private EmployeeDetail employeeDetail;
    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private Leave leave;
    @OneToMany(mappedBy = "employeeId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EmployeeHis> employeeHis;

}

