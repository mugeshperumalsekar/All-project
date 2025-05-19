package com.ponsun.aml.counterfeit.CounterfeitRemark.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CounterfeitRemarkRepository extends JpaRepository<CounterfeitRemark, Integer> {
    List<CounterfeitRemark> findByCounterfeitId(Integer CounterfeitId);
}
