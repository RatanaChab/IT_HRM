package com.example.IT_HRM.Entity;

import com.example.IT_HRM.Enum.BranchEnum;
import com.example.IT_HRM.Enum.EmpActEnum;
import com.example.IT_HRM.Enum.RankEnum;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "employees",indexes = {@Index(columnList = "empCode")})
@Data
public class Employee extends BaseEntity {

    @Column(unique = true,nullable = false)
    private Long empCode;
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
    @Enumerated(EnumType.STRING)
    private RankEnum rank;
    @Enumerated(EnumType.STRING)
    private EmpActEnum empActive = EmpActEnum.PROBATION;
    @Column(length = 15)
    private String empType ;
    @Column(length = 9,nullable = false)
    private String joinDate;
    @Column(length = 9)
    private String resignDate;
    @Column(length = 15)
    private String phoneNum;
    @Column(length = 9,nullable = false)
    private String department;

}

