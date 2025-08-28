package com.example.IT_HRM.Repository;

import com.example.IT_HRM.Entity.BankCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankcodeRep extends JpaRepository<BankCode,Long> {

    boolean existsByBankCode(String BankCode);
    boolean existsByBankName(String BankName);
}
