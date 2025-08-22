package com.example.IT_HRM.Entity;

import com.example.IT_HRM.Enum.DepartmentEnum;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "Departments")
public class Department extends DatetimeAuditor{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "depart_code", nullable = false,length = 10)
    private String DepartmentCode ;
    @Column(name = "depart_name", nullable = false,length = 30)
    private String departmentName ;

}
