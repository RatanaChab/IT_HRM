package com.example.IT_HRM.DTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private String id;
    private String firstName;
    private String lastName;
    private String fullName;
    private String branch;
    private String localFirstName;
    private String localLastName;
    private String sex;
    private String phoneNum;

}
