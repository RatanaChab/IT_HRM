package com.example.IT_HRM.Entity;

import com.example.IT_HRM.Enum.ReligionEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "employeeDetails",indexes = {
        @Index(columnList = "id"),
        @Index(columnList = "fullName")
})
@Data
public class EmployeeDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String fullName;
    private String nickName;
    private String work_exp;
    private String Ident_no;
    private String Ident_type; // modify later
    private String bank_code;
    private String acct_code;
    private String birth_date;
    private String ext_no;
    private String email;
    private String current_address;
    private String birth_address;
    private String marital_status;
    private Long children;
    private String hobby;
    private ReligionEnum religion;
    private Long age ;
    private String group_code ;
    @OneToOne
    @JoinColumn(name = "employee_id")
    @JsonIgnore
    private Employee emp_id;


}
