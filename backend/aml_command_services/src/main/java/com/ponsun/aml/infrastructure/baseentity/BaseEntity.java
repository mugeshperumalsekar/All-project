package com.ponsun.aml.infrastructure.baseentity;

import com.ponsun.aml.common.converter.StatusEnumToCodeConverter;
import com.ponsun.aml.common.entity.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@MappedSuperclass
@Where(clause = "status = 'A'")
@Getter
@Setter
public class BaseEntity {

//    @Column(name = "dt", columnDefinition = "DATETIME")
//    protected LocalDateTime createdAt;
//
//    @Column(name = "edt", columnDefinition = "DATETIME")
//    protected LocalDateTime updatedAt;

    @Column(name = "created_at")
    protected LocalDateTime createdAt;

    @Column(name = "updated_at")
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

    @Column(name = "status", nullable = false)
    @Convert(converter = StatusEnumToCodeConverter.class)
    @Basic(optional = false)
    protected Status status;

}
