package com.example.IT_HRM.Entity;

import jakarta.persistence.*;

import java.util.Set;

public class ApprovalGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_name", unique = true, nullable = false)
    private String roleName;  // e.g., "DIRECT_MANAGER", "HR_MANAGER", "DEPARTMENT_HEAD"

    @Column(name = "priority_level")
    private Integer priorityLevel;  // Determines approval sequence

    // Many-to-many relationship with employees who can act in this role
    @ManyToMany
    @JoinTable(
            name = "role_approvers",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id")
    )
    @Column(name = "user_approval")
    private Set<User> users;

    @Column(name = "description")
    private String description;
}

