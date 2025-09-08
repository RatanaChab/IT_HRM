package com.example.IT_HRM.Entity;

import com.example.IT_HRM.Enum.DepartmentEnum;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@Entity
@Table(name = "Departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "depart_code", nullable = false,unique = true)
    private String departmentCode ;
    @Column(name = "depart_name", nullable = false,unique = true)
    private String departmentName;
}
