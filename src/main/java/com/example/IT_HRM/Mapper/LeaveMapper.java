package com.example.IT_HRM.Mapper;

import com.example.IT_HRM.DTO.LeaveDTO;
import com.example.IT_HRM.Entity.Employee;
import com.example.IT_HRM.Entity.Leave;
import com.example.IT_HRM.Service.LeaveService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring" , uses = {LeaveService.class})
public interface LeaveMapper {
    LeaveMapper INSTANCE = Mappers.getMapper(LeaveMapper.class);

    @Mapping(source = "employee",       target = "employee", qualifiedByName = "mapEmpId")
    @Mapping(source = "totalLeave",     target = "totalLeave")
    @Mapping(source = "forwardLeave",   target = "forwardLeave")
    @Mapping(source = "leaveTaken",     target = "leaveTaken")
    @Mapping(source = "leaveBalance",   target = "leaveBalance")
    @Mapping(target = "leaveApply",     constant = "0L")
    Leave DTOToLeave(LeaveDTO dto);

    @Mapping(source = "employee", target = "employee", qualifiedByName = "mapDTOEmpId")
    LeaveDTO mapToDTO( Leave leave);


    @Named("mapEmpId")
    default Employee mapEmpId(Long id){
        if (id == null) return null;
        Employee employee = new Employee();
        employee.setId(id);
        return employee;
    }



    @Named("mapDTOEmpId")
    default Long mapDTOEmpId(Employee id){
        if (id == null) return null;

        return id.getId();
    }


}
