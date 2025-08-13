package com.example.IT_HRM.Enum;

import lombok.AllArgsConstructor;

public enum BranchEnum {
    HQ(1,"Head"),
    SVN(2,"Sovanna"),
    CCV(3,"Chraoy Chongvar"),
    CHC(4,"Chaom Chau"),
    KDS(5,"Kandal Stueng"),
    ASN(6,"Angk Snuol");


    private final Integer id;
    private final String name;

    BranchEnum(Integer id, String name){
        this.id = id;
        this.name = name;
    }
}
