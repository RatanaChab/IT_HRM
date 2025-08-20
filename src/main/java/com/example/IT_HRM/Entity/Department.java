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
    @Column(name = "depart_code", nullable = false)
    private String DepEnumCode ;
    @Enumerated(EnumType.STRING)
    @Column(name = "depart_name", nullable = false)
    private DepartmentEnum anEnum ;

}
