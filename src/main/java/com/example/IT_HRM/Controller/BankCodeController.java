package com.example.IT_HRM.Controller;

import com.example.IT_HRM.DTO.BankCodeDTO;
import com.example.IT_HRM.Entity.BankCode;
import com.example.IT_HRM.Entity.Employee;
import com.example.IT_HRM.Mapper.BankCodeMapper;
import com.example.IT_HRM.Service.BankCodeService;
import com.example.IT_HRM.Utils.CommonUse;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/hrm/Banks")
@Data
public class BankCodeController {

    @Autowired
    private BankCodeService bankCodeService;

    private final BankCodeMapper bankCodeMapper;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody @Valid BankCode bankCode){
        BankCode bankCode1 = bankCodeService.create(bankCode);
        return ResponseEntity.ok(bankCode1);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllCode(){
        List<BankCodeDTO> list = bankCodeService.findAll().stream().map(bankCodeMapper::ToBankDTO).toList();
        //List<BankCodeDTO> list1 = list.stream().sorted(Comparator.comparing(BankCodeDTO::getId)).toList();
        List<BankCodeDTO> bankCodeDTOS = CommonUse.sortByField(list, item -> item.getId());
        return ResponseEntity.ok(bankCodeDTOS);
    }
}
