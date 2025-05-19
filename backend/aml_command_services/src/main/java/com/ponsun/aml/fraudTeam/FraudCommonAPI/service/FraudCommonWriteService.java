package com.ponsun.aml.fraudTeam.FraudCommonAPI.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ponsun.aml.fraudTeam.FraudCommonAPI.FraudReadDTO;
import com.ponsun.aml.infrastructure.utils.Response;

public interface FraudCommonWriteService {
    Response saveFraudDetails(String fraudDTO) throws JsonProcessingException;
    FraudReadDTO getFraud(Integer fraudId);
    Response updateFraudDetails(String fraudDTO,Integer fraudId ,Integer euid);

}
