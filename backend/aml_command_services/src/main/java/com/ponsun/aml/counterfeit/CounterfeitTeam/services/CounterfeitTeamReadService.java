package com.ponsun.aml.counterfeit.CounterfeitTeam.services;

import com.ponsun.aml.counterfeit.CounterfeitTeam.domain.CounterfeitTeam;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CounterfeitTeamReadService {
    CounterfeitTeam fetchCounterfeitTeamById(Integer id);
    List<CounterfeitTeam> fetchAllCounterfeitTeam();
    Integer getmaxTicketId();
}
