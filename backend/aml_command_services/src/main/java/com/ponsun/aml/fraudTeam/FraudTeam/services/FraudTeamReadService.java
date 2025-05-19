package com.ponsun.aml.fraudTeam.FraudTeam.services;

import com.ponsun.aml.fraudTeam.FraudTeam.domain.FraudTeam;
import java.util.List;

public interface FraudTeamReadService {
    FraudTeam fetchFraudTeamById(Integer id);
    List<FraudTeam> fetchAllFraudTeam();
    Integer getmaxTicketId();
}
