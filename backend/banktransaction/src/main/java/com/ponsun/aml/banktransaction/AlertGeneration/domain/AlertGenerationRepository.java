package com.ponsun.aml.banktransaction.AlertGeneration.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;


public interface AlertGenerationRepository extends JpaRepository<AlertGeneration , Integer> {

    @Query(value = "{call SP_AlertGeneration()}", nativeQuery = true)
    @Procedure
    Void SP_AlertGeneration();
}
