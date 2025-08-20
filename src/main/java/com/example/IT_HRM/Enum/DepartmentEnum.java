package com.example.IT_HRM.Enum;

import lombok.Data;

public enum DepartmentEnum {
    BRANCHES("DE100001")        ,
    LOAN_MARKETING("DE100002")  ,
    CREDIT_COMMITEE("DE100003") ,
    LOAN_RECOVERY("DE100004")   ,
    AUDIT("DE100005")           ,
    HR("DE100006")              ,
    FINANCE("DE100007")         ,
    IT("DE100008");

    private String value;
    DepartmentEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
