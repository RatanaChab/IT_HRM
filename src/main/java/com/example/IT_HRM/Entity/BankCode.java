package com.example.IT_HRM.Entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "BankCodes", indexes = {
        @Index(columnList = "Id"),
        @Index(columnList = "bank_code"),
        @Index(columnList = "bank_other"),
})
@Data
public class BankCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(nullable = false,length = 9,unique = true)
    private String bank_code;
    @Column(nullable = false,length = 100,unique = true)
    private String bank_name;
    @Column(nullable = false,length = 100,unique = true)
    private String bank_kh;
    @Column(nullable = false,length = 4)
    private String bank_other;
    @CreatedBy
    private String entryBy;
    @CreatedDate
    private LocalDateTime entryDate;
    @LastModifiedBy
    private String updateBy;
    @LastModifiedDate
    private LocalDateTime updateDate;
}
