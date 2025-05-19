package com.ponsun.aml.fraudTeam.FraudStatus.services;

import com.ponsun.aml.fraudTeam.FraudStatus.domain.FraudStatus;
import java.util.List;

public interface FraudStatusReadService {
    FraudStatus fetchStatusById(Integer id);
    List<FraudStatus> fetchAllStatus();
}
