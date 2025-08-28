package com.example.IT_HRM.ServiceImpl;

import com.example.IT_HRM.Entity.BankCode;
import com.example.IT_HRM.GlobalException.ResourceAlreadyExistsException;
import com.example.IT_HRM.Repository.BankcodeRep;
import com.example.IT_HRM.Service.BankCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BankCodeServiceImpl implements BankCodeService {
    @Autowired
    private BankcodeRep bankcodeRep;

    @Override
    public BankCode create(BankCode bankCode) {
        if (bankcodeRep.existsByBankCode(bankCode.getBankCode())){
            throw new ResourceAlreadyExistsException("Bank Code", bankCode.getBankCode());
        }

        if (bankcodeRep.existsByBankName(bankCode.getBankName())){
            throw new ResourceAlreadyExistsException("Bank Name", bankCode.getBankName());
        }

        bankCode.setEntryBy("HO_IT");
        bankCode.setEntryDate(LocalDateTime.now());
        return bankcodeRep.save(bankCode);
    }

    @Override
    public List<BankCode> findAll() {

        return bankcodeRep.findAll();
    }
}
