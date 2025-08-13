package com.example.IT_HRM.ServiceImpl;

import com.example.IT_HRM.DTO.BankCodeDTO;
import com.example.IT_HRM.Entity.BankCode;
import com.example.IT_HRM.GlobalException.DataIntegrityException;
import com.example.IT_HRM.Repository.BankcodeRep;
import com.example.IT_HRM.Service.BankCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankCodeServiceImpl implements BankCodeService {
    @Autowired
    private BankcodeRep bankcodeRep;

    @Override
    public BankCode create(BankCode bankCode) {
//        List<String> list = bankcodeRep.findAll().stream().map(code -> code.getBank_code()).toList();
//        for ( String code : list){
//            if ( code.equals(bankCode.getBank_code())){
//                throw new ResourceAlreadyExistsException("Code",bankCode.getBank_code());
//            }
//
        BankCode save = new BankCode();
        try{
            save = bankcodeRep.save(bankCode);
        } catch (Exception e) {
            throw new DataIntegrityException("Fields",e.getMessage());
        }
        return save;
    }

    @Override
    public List<BankCode> findAll() {

        return bankcodeRep.findAll();
    }
}
