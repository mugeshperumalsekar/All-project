package com.ponsun.aml.fraudTeam.FraudObservation.services;

import com.ponsun.aml.fraudTeam.FraudObservation.domain.FraudObservation;

import java.util.List;

public interface FraudObservationReadService {
    FraudObservation fetchFraudObservationById(Integer id);
    List<FraudObservation> fetchAllFraudObservation();
}
