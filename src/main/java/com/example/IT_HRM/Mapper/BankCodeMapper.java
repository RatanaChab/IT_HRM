package com.example.IT_HRM.Mapper;

import com.example.IT_HRM.DTO.BankCodeDTO;
import com.example.IT_HRM.Entity.BankCode;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "Spring")
public interface BankCodeMapper {
    BankCodeMapper INSTANCE = Mappers.getMapper(BankCodeMapper.class);

    BankCodeDTO ToBankDTO(BankCode bankCode);
}
