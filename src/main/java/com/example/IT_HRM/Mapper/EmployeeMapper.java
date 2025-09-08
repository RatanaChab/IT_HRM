package com.example.IT_HRM.Mapper;

import com.example.IT_HRM.DTO.EmployeeDTO;
import com.example.IT_HRM.Entity.ApprovalGroup;
import com.example.IT_HRM.Entity.Department;
import com.example.IT_HRM.Entity.Employee;
import com.example.IT_HRM.Repository.ApprovalGroupRep;
import com.example.IT_HRM.Service.ApprovalGroupService;
import com.example.IT_HRM.Service.EmployeeService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring" , uses = {EmployeeService.class,ApprovalGroupService.class})
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);


    //@Mapping(source = "id", target = "id", qualifiedByName = "formatId")
    //@Mapping(source = "id", target = "id")
    @Mapping(source = "group", target = "group",qualifiedByName = "stringToGroup")
    @Mapping(source = "department", target = "department",qualifiedByName = "stringToDep")
    Employee DTOtoEmployee(EmployeeDTO employee);

//    @Mapping(source = "entity.id", target = "id")
//    @Mapping(source = "branch", target = "branch")
//    void updateEmployeeFromDTO(@MappingTarget Employee employee ,EmployeeDTO employeeDTO);


//    @Named("stringToDep")
//    default String depToString(Department department) {
//        return department != null ? department.getDepartmentCode() : null;
//    }

//    @Named("stringToGroup")
//    default String groupToString(ApprovalGroup group) {
//        return group != null ? group.getGroupCode() : null;
//    }

    @Named("stringToDep")
    default Department stringToDep(String depName) {
        if (depName == null) return null;
        // You might need to fetch from repository
        return new Department() ;
    }

    @Named("stringToGroup")
    default ApprovalGroup stringToGroup(String groupName) {
        if (groupName == null) return null;
        // You might need to fetch from repository
        return new ApprovalGroup() ;
    }
//    @Named("formatId")
//    static String formatId(String id) {
//        //System.out.println(String.format("%04d", id));
//        return String.format("%04d", Long.parseLong(id));
//    }


}
