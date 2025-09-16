package com.example.IT_HRM.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DepartmentDTO {
    private String departmentCode;
    private String departmentName;
}
