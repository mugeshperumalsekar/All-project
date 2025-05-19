package com.ponsun.aml.banktransaction.configalert.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConfigAlertRepository extends JpaRepository<ConfigAlert,Integer> {
    Optional<ConfigAlert> findById(Integer id);
}