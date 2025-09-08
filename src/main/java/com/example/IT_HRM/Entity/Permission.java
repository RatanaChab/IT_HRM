package com.example.IT_HRM.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "permission_roles")
@Data
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;

}
