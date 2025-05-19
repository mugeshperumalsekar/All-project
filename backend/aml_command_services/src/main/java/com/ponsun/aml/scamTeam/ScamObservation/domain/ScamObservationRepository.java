package com.ponsun.aml.scamTeam.ScamObservation.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScamObservationRepository extends JpaRepository<ScamObservation, Integer> {
   List<ScamObservation> findByScamId(Integer scamId);
}
