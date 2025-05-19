package com.ponsun.aml.scamTeam.ScamTeam.services;

import com.ponsun.aml.scamTeam.ScamTeam.data.ScamTeamData;
import com.ponsun.aml.scamTeam.ScamTeam.request.CreateScamTeamRequest;
import com.ponsun.aml.scamTeam.ScamTeam.request.UpdateScamTeamRequest;
import com.ponsun.aml.infrastructure.utils.Response;

import java.util.List;
public interface ScamTeamWriteService {
    Response createScamTeam(CreateScamTeamRequest createScamTeamRequest);
    Response updateScamTeam(Integer id, UpdateScamTeamRequest updateScamTeamRequest);

    List<ScamTeamData> fetchAllScamTeamData(Integer id);
}
