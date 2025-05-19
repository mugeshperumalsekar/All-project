package com.ponsun.aml.counterfeit.CounterfeitNumber.services;

import com.ponsun.aml.counterfeit.CounterfeitNumber.domain.CounterfeitNumber;

import java.util.List;

public interface CounterfeitNumberReadService {
    CounterfeitNumber fetchCounterfeitNumberById(Integer id);

    List<CounterfeitNumber> fetchAllCounterfeitNumber();
}
