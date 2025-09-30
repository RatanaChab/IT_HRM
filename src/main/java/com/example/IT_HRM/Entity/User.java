package com.example.IT_HRM.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.type.YesNoConverter;
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
    @Convert(converter = YesNoConverter.class)
    private String activeYn ;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;
    @Column(name = "apprv_YN", length = 1)
    @Convert(converter = YesNoConverter.class)
    private Boolean appYN;
    @OneToOne
    @JoinColumn(name = "employee_id",referencedColumnName = "id")
    private Employee employee;
    @Column(name = "user_group")
    private String userGroup;
}
