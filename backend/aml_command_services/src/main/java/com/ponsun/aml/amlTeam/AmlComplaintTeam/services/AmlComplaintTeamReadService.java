package com.ponsun.aml.amlTeam.AmlComplaintTeam.services;

import com.ponsun.aml.amlTeam.AmlComplaintTeam.domain.AmlComplaintTeam;

import java.util.List;

public interface AmlComplaintTeamReadService {
    AmlComplaintTeam fetchAmlBranchById(Integer id);
    List<AmlComplaintTeam> fetchAllAmlBranch();
    public Integer getmaxTicketId() ;


}
