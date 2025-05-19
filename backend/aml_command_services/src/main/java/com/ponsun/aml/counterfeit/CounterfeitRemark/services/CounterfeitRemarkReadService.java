package com.ponsun.aml.counterfeit.CounterfeitRemark.services;

import com.ponsun.aml.counterfeit.CounterfeitRemark.domain.CounterfeitRemark;

import java.util.List;

public interface CounterfeitRemarkReadService {
    CounterfeitRemark fetchCounterfeitRemarkById(Integer id);
    List<CounterfeitRemark> fetchAllCounterfeitRemark();
}
