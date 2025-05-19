package com.ponsun.aml.counterfeit.CounterfeitStatus.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CounterfeitStatusRepository extends JpaRepository<CounterfeitStatus, Integer> {
    List<CounterfeitStatus> findByCounterfeitId(Integer counterfeitId);
}
