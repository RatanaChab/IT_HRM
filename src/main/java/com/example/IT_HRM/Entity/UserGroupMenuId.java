package com.example.IT_HRM.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class UserGroupMenuId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @ManyToOne
    @JoinColumn(name = "groupCode",referencedColumnName = "groupCode")
    private UserGroupId userGroup;
    private String menuIDN;
    private String menuNam;
    private Long rgtUser;
    private Long rgtDate;
    private Long uptUser;
    private Long uptDate;

}
