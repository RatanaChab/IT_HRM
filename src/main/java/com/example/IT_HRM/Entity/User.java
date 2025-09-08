package com.example.IT_HRM.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.context.properties.bind.DefaultValue;

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
    private String password;
    @Column(name = "active_YN")
    private String activeYn ;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;
}
