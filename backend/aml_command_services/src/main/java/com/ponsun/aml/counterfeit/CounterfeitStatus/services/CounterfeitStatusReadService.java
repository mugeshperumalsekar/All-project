package com.ponsun.aml.counterfeit.CounterfeitStatus.services;

import com.ponsun.aml.counterfeit.CounterfeitStatus.domain.CounterfeitStatus;

import java.util.List;

public interface CounterfeitStatusReadService {
    CounterfeitStatus fetchCounterfeitStatusById(Integer id);
    List<CounterfeitStatus> fetchAllCounterfeitStatus();
}
