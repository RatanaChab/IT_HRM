package com.example.IT_HRM.Enum;

public enum RankEnum {
    CEO(1,"CEO"),
    DIRECTOR(2,"Director"),
    MANAGER(3,"Manager"),
    ASSISTANT(4,"Assistant"),
    SENOIR(5,"Senoir"),
    OFFICER(6,"Officer"),
    JUNOIR(7,"Junior"),
    CLERK(8,"Clerk"),
    Driver(9,"Driver");

    private final Integer id;
    private final String name;

    RankEnum(Integer id, String name){
        this.id = id;
        this.name = name;
    }
}
