package com.ponsun.aml.scamTeam.ScamCommonAPI.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ponsun.aml.scamTeam.ScamCommonAPI.ScamReadDTO;
import com.ponsun.aml.infrastructure.utils.Response;

public interface ScamCommonWriteService {
    Response saveScamDetails(String scamDTO) throws JsonProcessingException;
    ScamReadDTO getScam(Integer scamId);
    Response updateScamDetails(String scamDTO,Integer scamId ,Integer euid);

}
