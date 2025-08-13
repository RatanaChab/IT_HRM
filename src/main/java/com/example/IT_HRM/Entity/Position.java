package com.example.IT_HRM.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Position extends DatetimeAuditor{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "position_code", nullable = false, length = 9)
    private String pst_code;
    @Column(name = "position_title", nullable = false, length = 50)
    private String pst_title;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department dep_id;
    private String group_code;
}
