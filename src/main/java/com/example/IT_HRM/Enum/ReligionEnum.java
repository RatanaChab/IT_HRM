package com.example.IT_HRM.Enum;

public enum ReligionEnum {
    ISL(1,"Islam"),
    PRO(2,"Protestanitism"),
    CAT(3,"Catholicism"),
    BUD(4,"Buddhism"),
    HIN(5,"Hinduism"),
    CON(6,"Confucianism"),
    OTHER(7,"Other");

    private final int id;
    private final String name;

    ReligionEnum( int id , String name){
        this.id = id;
        this.name = name;
    }
}
