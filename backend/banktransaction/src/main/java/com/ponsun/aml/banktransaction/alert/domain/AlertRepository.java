package com.ponsun.aml.banktransaction.alert.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlertRepository extends JpaRepository<Alert,Integer> {
    Optional<Alert> findById(Integer id);
}