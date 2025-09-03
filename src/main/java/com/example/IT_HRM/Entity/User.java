package com.example.IT_HRM.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table( name = "Users", indexes = {
        @Index(columnList = "Id"),
        @Index(columnList = "name")
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    @ManyToOne
    private ApprovalGroup approvalApproval;
}
