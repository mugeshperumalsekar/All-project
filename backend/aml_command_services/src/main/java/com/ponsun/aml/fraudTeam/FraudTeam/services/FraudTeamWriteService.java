package com.ponsun.aml.fraudTeam.FraudTeam.services;

import com.ponsun.aml.fraudTeam.FraudTeam.data.FraudTeamData;
import com.ponsun.aml.fraudTeam.FraudTeam.request.CreateFraudTeamRequest;
import com.ponsun.aml.fraudTeam.FraudTeam.request.UpdateFraudTeamRequest;
import com.ponsun.aml.infrastructure.utils.Response;

import java.util.List;
public interface FraudTeamWriteService {
    Response createFraudTeam(CreateFraudTeamRequest createFraudTeamRequest);
    Response updateFraudTeam(Integer id, UpdateFraudTeamRequest updateFraudTeamRequest);

    List<FraudTeamData> fetchAllFraudTeamData(Integer id);
}
