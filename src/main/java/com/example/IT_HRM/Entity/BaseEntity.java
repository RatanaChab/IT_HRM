package com.example.IT_HRM.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
@Data
public abstract class BaseEntity extends DatetimeAuditor{
    @Id
    private Long id;

    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
}
