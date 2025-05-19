package com.ponsun.aml.fraudTeam.FraudRemark.services;

import com.ponsun.aml.fraudTeam.FraudRemark.data.FraudRemarkData;
import com.ponsun.aml.fraudTeam.FraudRemark.request.CreateFraudRemarkRequest;
import com.ponsun.aml.fraudTeam.FraudRemark.request.UpdateFraudRemarkRequest;
import com.ponsun.aml.infrastructure.utils.Response;

import java.util.List;

public interface FraudRemarkWriteService {
    Response createFraudRemark(CreateFraudRemarkRequest createFraudRemarkRequest);
    Response updateFraudRemark(Integer id, UpdateFraudRemarkRequest updateFraudRemarkRequest);
    List<FraudRemarkData> fetchAllFraudRemarkData(Integer fraudId);
    Response deActive(Integer fraudId,Integer euid);
}
