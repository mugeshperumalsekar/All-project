package com.ponsun.aml.amlTeam.AmlComplaintStatus.services;
import com.ponsun.aml.amlTeam.AmlComplaintStatus.request.CreaetAmlComplaintStatuRequest;
import com.ponsun.aml.amlTeam.AmlComplaintStatus.request.UpdateAmlComplaintStatusRequest;
import com.ponsun.aml.infrastructure.utils.Response;

public interface AmlComplaintStatusWriteService {
    Response createAmlStatusList(CreaetAmlComplaintStatuRequest creaetAmlConfigStatuRequest);
    Response updateAmlStatusList(Integer id, UpdateAmlComplaintStatusRequest updateAmlConfigStatusRequest);

}
