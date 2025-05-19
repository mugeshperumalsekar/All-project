package com.ponsun.aml.fraudTeam.FraudRemark.services;

import com.ponsun.aml.fraudTeam.FraudRemark.domain.FraudRemark;

import java.util.List;

public interface FraudRemarkReadService {
    FraudRemark fetchRemarkById(Integer id);
    List<FraudRemark> fetchAllRemark();
}
