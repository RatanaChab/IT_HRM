package com.example.IT_HRM.Mapper;

import com.example.IT_HRM.DTO.UserDTO;
import com.example.IT_HRM.Entity.User;
import com.example.IT_HRM.Service.UserService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring" , uses = {UserService.class})
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "name", target = "username")
    UserDTO userToDTO(User user);
}
