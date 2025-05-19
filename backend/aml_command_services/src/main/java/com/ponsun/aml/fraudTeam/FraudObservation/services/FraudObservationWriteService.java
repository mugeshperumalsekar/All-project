package com.ponsun.aml.fraudTeam.FraudObservation.services;

import com.ponsun.aml.fraudTeam.FraudObservation.data.FraudObservationData;
import com.ponsun.aml.fraudTeam.FraudObservation.request.CreateFraudObservationRequest;
import com.ponsun.aml.fraudTeam.FraudObservation.request.UpdateFraudObservationRequest;
import com.ponsun.aml.infrastructure.utils.Response;

import java.util.List;

public interface FraudObservationWriteService {
    Response createFraudObservation(CreateFraudObservationRequest createFraudObservationRequest);
    Response updateFraudObservation(Integer id, UpdateFraudObservationRequest updateFraudObservationRequest);
    List<FraudObservationData> fetchAllFraudObservationData(Integer fraudId);
    Response deActive(Integer fraudId,Integer euid);
}
