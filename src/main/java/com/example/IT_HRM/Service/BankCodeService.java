package com.example.IT_HRM.Service;

import com.example.IT_HRM.DTO.BankCodeDTO;
import com.example.IT_HRM.Entity.BankCode;

import java.util.List;

public interface BankCodeService {
    BankCode create(BankCode bankCodeDTO);
    List<BankCode> findAll();
}
