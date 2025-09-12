package com.example.IT_HRM.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
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

    @Column(name = "group_code", nullable = false ,unique = true)
    private String groupCode;  //

    @Column(name = "group_name",  nullable = false,unique = true)
    private String groupName;  //

    @Column(name = "priority_level")
    private Integer priorityLevel;  // Determines approval sequence

    @Column(name = "description")
    private String description;

//    @OneToMany(mappedBy = "group")
//    private List<Employee> employees;
}


