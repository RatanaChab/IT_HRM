package com.example.IT_HRM.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.type.YesNoConverter;

@Entity
@Data
public class ProgramMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(nullable = false,unique = true)
    private String menuIDN;
    @Column(nullable = false,unique = true)
    private String menuNam;
    @Column(nullable = false,unique = true)
    private String menuUrl;
    private Integer menuLv1;
    private Integer menuLv2;
    private Integer menuLv3;
    private Integer menuLv4;
    private Integer menuLvl;
    @Convert(converter = YesNoConverter.class)
    private Boolean userYN;
}

