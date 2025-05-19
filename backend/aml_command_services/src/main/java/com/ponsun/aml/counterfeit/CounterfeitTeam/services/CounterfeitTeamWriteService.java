package com.ponsun.aml.counterfeit.CounterfeitTeam.services;

import com.ponsun.aml.counterfeit.CounterfeitTeam.data.CounterfeitTeamData;
import com.ponsun.aml.infrastructure.utils.Response;
import com.ponsun.aml.counterfeit.CounterfeitTeam.request.CreateCounterfeitTeamRequest;
import com.ponsun.aml.counterfeit.CounterfeitTeam.request.UpdateCounterfeitTeamRequest;

import java.util.List;

public interface CounterfeitTeamWriteService {
    Response createCounterfeitTeam(CreateCounterfeitTeamRequest createCounterfeitTeamRequest);
    Response updateCounterfeitTeam(Integer id, UpdateCounterfeitTeamRequest updateCounterfeitTeamRequest);
    List<CounterfeitTeamData> fetchAllCounterfeitTeamData(Integer id);
}
