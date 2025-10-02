package com.example.IT_HRM.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = "groupCode")})
@Data
public class UserGroupId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String groupCode;
    private String groupName;
}
