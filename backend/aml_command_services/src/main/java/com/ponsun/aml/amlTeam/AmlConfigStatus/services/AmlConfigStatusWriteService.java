package com.ponsun.aml.amlTeam.AmlConfigStatus.services;

import com.ponsun.aml.amlTeam.AmlConfigStatus.request.CreateAmlConfigStatusRequest;
import com.ponsun.aml.amlTeam.AmlConfigStatus.request.UpdateAmlConfigStatusRequest;
import com.ponsun.aml.infrastructure.utils.Response;
public interface AmlConfigStatusWriteService {
    Response createAmlConfigStatus(CreateAmlConfigStatusRequest createAmlConfigStatusRequest);
    Response updateAmlConfigStatus(Integer id, UpdateAmlConfigStatusRequest updateAmlConfigStatusRequest);
}
