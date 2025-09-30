package com.example.IT_HRM.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Id;
import org.hibernate.type.YesNoConverter;

public class ProgramMenu {
    @Id
    private Long Id;
    @Column(nullable = false,unique = true)
    private String menuIDN;
    private String menuNam;
    private String menuUrl;
    private String menuGroup;
    private Integer menuLv1;
    private Integer menuLv2;
    private Integer menuLv3;
    private Integer menuLv4;
    private Integer menuLvl;
    @Convert(converter = YesNoConverter.class)
    private Boolean userYN;
}

