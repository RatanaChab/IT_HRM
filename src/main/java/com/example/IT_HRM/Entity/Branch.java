package com.example.IT_HRM.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.boot.context.properties.bind.DefaultValue;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "Branches")
public class Branch extends DatetimeAuditor{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long Id;
    @Column(length = 9, nullable = false,unique = true)
    private String branchCode;
    @Column(length = 50, nullable = false,unique = true)
    private String branchName;
    @Column(length = 4, nullable = false,unique = true)
    private String other;
    private Boolean userYN;

}
