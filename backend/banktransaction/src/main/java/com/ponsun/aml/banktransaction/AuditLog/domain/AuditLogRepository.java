package com.ponsun.aml.banktransaction.AuditLog.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface AuditLogRepository extends JpaRepository<AuditLog,Integer>, JpaSpecificationExecutor<AuditLog> {
    Optional<AuditLog> findById(Integer id);
}