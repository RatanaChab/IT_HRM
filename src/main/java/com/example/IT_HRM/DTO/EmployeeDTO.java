package com.example.IT_HRM.DTO;
import com.example.IT_HRM.Enum.EmpActEnum;
import com.example.IT_HRM.Enum.RankEnum;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String fullName;
    private String branch;
    private String localFirstName;
    private String localLastName;
    private String sex;
    private String phoneNum;
    private String position;
    private String rank;
    private String empType ;
    private String joinDate;
    private String resignDate;
    private Long group;
    private Long department;
}
