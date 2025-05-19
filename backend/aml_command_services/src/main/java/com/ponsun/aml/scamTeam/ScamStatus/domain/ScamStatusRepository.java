package com.ponsun.aml.scamTeam.ScamStatus.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScamStatusRepository extends JpaRepository<ScamStatus,Integer> {
    List<ScamStatus> findByScamId(Integer scamId);
}
