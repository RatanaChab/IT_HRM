package com.example.IT_HRM.Entity;

import jakarta.persistence.*;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = "groupCode")})
public class UserGroupId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String groupCode;
    private String groupName;
}
