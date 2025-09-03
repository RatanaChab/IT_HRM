package com.example.IT_HRM.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table( name = "approval_group", indexes = {
        @Index(columnList = "Id"),
        @Index(columnList = "priority_level")
})
public class ApprovalGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "role_name", unique = true, nullable = false)
    private String roleName;  // e.g., "DIRECT_MANAGER", "HR_MANAGER", "DEPARTMENT_HEAD"

    @Column(name = "priority_level")
    private Integer priorityLevel;  // Determines approval sequence

    // Many-to-many relationship with employees who can act in this role
//    @OneToMany
//    @Column(name = "user_approval")
//    private Set<User> users;

    @Column(name = "description")
    private String description;
}

