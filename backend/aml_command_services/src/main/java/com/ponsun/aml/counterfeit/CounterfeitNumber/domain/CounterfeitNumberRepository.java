package com.ponsun.aml.counterfeit.CounterfeitNumber.domain;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CounterfeitNumberRepository extends JpaRepository<CounterfeitNumber, Integer> {

    List<CounterfeitNumber> findByCounterfeitId(Integer counterfeitId);
}
