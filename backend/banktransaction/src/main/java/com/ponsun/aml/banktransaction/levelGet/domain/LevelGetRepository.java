package com.ponsun.aml.banktransaction.levelGet.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LevelGetRepository extends JpaRepository<LevelGet, Integer> {
    Optional<LevelGet> findById(Integer id);
}
