package com.example.IT_HRM.Mapper;

import com.example.IT_HRM.DTO.EmployeeDTO;
import com.example.IT_HRM.Entity.Employee;
import com.example.IT_HRM.Service.EmployeeService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring" , uses = {EmployeeService.class})
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    @Mapping(source = "id", target = "id", qualifiedByName = "formatId")
    EmployeeDTO employeeToDTO(Employee employee);

//    @Mapping(source = "entity.id", target = "id")
    @Mapping(source = "branch", target = "branch")
    void updateEmployeeFromDTO(@MappingTarget Employee employee ,EmployeeDTO employeeDTO);


    @Named("formatId")
    static String formatId(String id) {
        //System.out.println(String.format("%04d", id));
        return String.format("%04d", Long.parseLong(id));
    }
}
