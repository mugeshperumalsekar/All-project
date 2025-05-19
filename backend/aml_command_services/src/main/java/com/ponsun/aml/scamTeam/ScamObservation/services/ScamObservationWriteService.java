package com.ponsun.aml.scamTeam.ScamObservation.services;

import com.ponsun.aml.scamTeam.ScamObservation.data.ScamObservationData;
import com.ponsun.aml.scamTeam.ScamObservation.request.CreateScamObservationRequest;
import com.ponsun.aml.scamTeam.ScamObservation.request.UpdateScamObservationRequest;
import com.ponsun.aml.infrastructure.utils.Response;

import java.util.List;

public interface ScamObservationWriteService {
    Response createScamObservation(CreateScamObservationRequest createScamObservationRequest);
    Response updateScamObservation(Integer id, UpdateScamObservationRequest updateScamObservationRequest);
    List<ScamObservationData> fetchAllScamObservationData(Integer scamId);
    Response deActive(Integer scamId,Integer euid);
}
