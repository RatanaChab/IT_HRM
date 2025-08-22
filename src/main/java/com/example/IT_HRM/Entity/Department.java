package com.example.IT_HRM.Entity;

import com.example.IT_HRM.Enum.DepartmentEnum;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "Departments")
public class Department extends DatetimeAuditor{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "depart_code", nullable = false,unique = true)
    private String departmentCode ;
    @Column(name = "depart_name", nullable = false,unique = true)
    private String departmentName;
    @OneToMany
    @JoinColumn(name = "department_id")
    private List<Employee> employees;
}
