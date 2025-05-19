package com.ponsun.aml.fraudTeam.FraudObservation.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FraudObservationRepository extends JpaRepository<FraudObservation, Integer> {
   List<FraudObservation> findByFraudId(Integer fraudId);
}
