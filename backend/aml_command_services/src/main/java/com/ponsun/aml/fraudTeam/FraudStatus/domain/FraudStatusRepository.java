package com.ponsun.aml.fraudTeam.FraudStatus.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FraudStatusRepository extends JpaRepository<FraudStatus,Integer> {
    List<FraudStatus> findByFraudId(Integer fraudId);
}
