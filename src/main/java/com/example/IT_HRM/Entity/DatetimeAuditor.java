package com.example.IT_HRM.Entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Data
public abstract class DatetimeAuditor implements Serializable {

    @CreatedBy
    private String entryBy;

    @CreatedDate
    private LocalDateTime entryDate;

    @LastModifiedBy
    private String updateBy;

    @LastModifiedDate
    private LocalDateTime updateDate;
}
