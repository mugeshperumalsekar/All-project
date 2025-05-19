package com.ponsun.aml.fraudTeam.FraudRemark.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FraudRemarkRepository extends JpaRepository<FraudRemark,Integer> {
   List<FraudRemark> findByFraudId(Integer fraudId);
}
