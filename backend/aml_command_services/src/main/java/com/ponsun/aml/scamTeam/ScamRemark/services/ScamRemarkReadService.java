package com.ponsun.aml.scamTeam.ScamRemark.services;

import com.ponsun.aml.scamTeam.ScamRemark.domain.ScamRemark;

import java.util.List;

public interface ScamRemarkReadService {
    ScamRemark fetchRemarkById(Integer id);
    List<ScamRemark> fetchAllRemark();
}
