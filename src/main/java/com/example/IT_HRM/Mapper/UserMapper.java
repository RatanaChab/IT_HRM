package com.example.IT_HRM.Mapper;

import com.example.IT_HRM.DTO.UserDTO;
import com.example.IT_HRM.Entity.Employee;
import com.example.IT_HRM.Entity.Role;
import com.example.IT_HRM.Entity.User;
import com.example.IT_HRM.Service.UserService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring" , uses = {UserService.class})
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "username", target = "name")
    @Mapping(source = "employee", target = "employee", qualifiedByName = "longToEmp")
    @Mapping(source = "role", target = "roles", qualifiedByName = "longsToRoles")
    User dtoToUser(UserDTO user);

    @Mapping(source = "name", target = "username")
    @Mapping(source = "employee", target = "employee", qualifiedByName = "empToLong")
    @Mapping(source = "roles", target = "role", qualifiedByName = "rolesToLongs")
    UserDTO userToDTO(User user);

    @Named("longToEmp")
    default Employee longToEmp(Long id) {
        if (id == null) return null;
        Employee emp = new Employee();
        emp.setId(id);
        return emp;
    }

    @Named("empToLong")
    default Long empToLong(Employee emp) {
        return emp == null ? null : emp.getId();
    }

    @Named("longsToRoles")
    default Set<Role> longsToRoles(Long id) {
        if (id == null) {
            return Collections.emptySet();
        }
        Role role = new Role();
        role.setId(id);
        return Set.of(role);
    }

    @Named("rolesToLongs")
    default Long rolesToLongs(Set<Role> roles) {
        if (roles == null || roles.isEmpty()) {
            return null;
        }
        return roles.iterator().next().getId();  // take first role
    }
}
