package com.ponsun.aml.banktransaction.alertGet.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlertGetRepository extends JpaRepository<AlertGet, Integer> {
    Optional<AlertGet> findById(Integer id);
}
