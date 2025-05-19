package com.ponsun.aml.fraudTeam.FraudStatus.services;

import com.ponsun.aml.fraudTeam.FraudStatus.data.FraudStatusData;
import com.ponsun.aml.fraudTeam.FraudStatus.request.CreateFraudStatusRequest;
import com.ponsun.aml.fraudTeam.FraudStatus.request.UpdateFraudStatusRequest;
import com.ponsun.aml.infrastructure.utils.Response;

import java.util.List;

public interface FraudStatusWriteService {
    Response createFraudStatus(CreateFraudStatusRequest createFraudStatusRequest);
    Response updateFraudStatus(Integer id, UpdateFraudStatusRequest updateFraudStatusRequest);

    List<FraudStatusData> fetchAllFraudStatusData(Integer fraudId);
    Response deActive(Integer fraudId,Integer euid);
}
