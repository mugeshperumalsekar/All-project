package com.ponsun.aml.scamTeam.ScamTeam.services;

import com.ponsun.aml.scamTeam.ScamTeam.domain.ScamTeam;
import java.util.List;

public interface ScamTeamReadService {
    ScamTeam fetchScamTeamById(Integer id);
    List<ScamTeam> fetchAllScamTeam();
    Integer getmaxTicketId();
}
