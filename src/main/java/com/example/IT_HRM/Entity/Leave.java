package com.example.IT_HRM.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Leave_Management", indexes = {
        @Index(columnList = "Id")
})
@Data
public class Leave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @OneToOne
    @JoinColumn(name = "empCode")
    private Employee employee;
    @Column(nullable = false, scale = 3)
    private Float forwardLeave;
    @Column(nullable = false, scale = 3)
    private Float totalLeave;
    @Column(nullable = false, scale = 3)
    private Float leaveTaken;
    @Column(nullable = false, scale = 3)
    private Float leaveBalance;
    @Column(nullable = false, scale = 3)
    private Long leaveApply;
}
