package com.example.IT_HRM.Entity;

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
    @Column(name = "department_code",length = 9, nullable = false)
    private String dep_code;
    @Column(name = "department_name",length = 30, nullable = false)
    private String dep_name;

}
