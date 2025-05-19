package com.ponsun.aml.banktransaction.infrastructure.baseentity;

import com.ponsun.aml.banktransaction.common.converter.StatusEnumToCodeConverter;
import com.ponsun.aml.banktransaction.common.entity.Status;
import jakarta.persistence.*;
import lombok.Getter;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Where;


import java.time.LocalDateTime;

@RequiredArgsConstructor
@SuperBuilder
@MappedSuperclass
@Where(clause = "status = 'A'")
@Getter
@Setter
public class BaseEntity {

    @Column(name = "dt", columnDefinition = "DATETIME")
    protected LocalDateTime createdAt;

    @Column(name = "edt", columnDefinition = "DATETIME")
    protected LocalDateTime updatedAt;

//    @Version
//    private Long version;

    @PrePersist
    public void onCreate() {
        createdAt = LocalDateTime.now();
        //updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

//    @Column(name = "valid", nullable = false)
//    @Convert(converter = StatusEnumToCodeConverter.class)
    @Basic(optional = false)
    protected Status status;

}
