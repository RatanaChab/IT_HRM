package com.example.IT_HRM.Entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "locations", indexes = {
        @Index(columnList = "Id"),
        @Index(columnList = "province_code"),
        @Index(columnList = "district_code"),
        @Index(columnList = "commune_code"),
        @Index(columnList = "village_code"),
})
@Data
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(nullable = false,length = 2)
    private String province_code;
    @Column(nullable = false,length = 50)
    private String province_name;
    private String province_kh;
    @Column(nullable = false,length = 4)
    private String district_code;
    @Column(nullable = false,length = 50)
    private String district_name;
    private String district_kh;
    @Column(nullable = false,length = 6)
    private String commune_code;
    @Column(nullable = false,length = 50)
    private String commune_name;
    private String commune_kh;
    @Column(nullable = false,length = 8)
    private String village_code;
    @Column(nullable = false,length = 50)
    private String village_name;
    private String village_kh;

}
