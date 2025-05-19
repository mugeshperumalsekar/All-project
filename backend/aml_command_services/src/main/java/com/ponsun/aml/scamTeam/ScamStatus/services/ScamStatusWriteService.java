package com.ponsun.aml.scamTeam.ScamStatus.services;

import com.ponsun.aml.scamTeam.ScamStatus.data.ScamStatusData;
import com.ponsun.aml.scamTeam.ScamStatus.request.CreateScamStatusRequest;
import com.ponsun.aml.scamTeam.ScamStatus.request.UpdateScamStatusRequest;
import com.ponsun.aml.infrastructure.utils.Response;

import java.util.List;

public interface ScamStatusWriteService {
    Response createScamStatus(CreateScamStatusRequest createScamStatusRequest);
    Response updateScamStatus(Integer id, UpdateScamStatusRequest updateScamStatusRequest);

    List<ScamStatusData> fetchAllScamStatusData(Integer scamId);
    Response deActive(Integer scamId,Integer euid);
}
