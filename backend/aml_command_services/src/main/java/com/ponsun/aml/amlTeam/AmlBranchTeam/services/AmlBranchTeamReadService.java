package com.ponsun.aml.amlTeam.AmlBranchTeam.services;

import com.ponsun.aml.amlTeam.AmlBranchTeam.data.AmlBranchPendingResponseData;

import java.util.List;

public interface AmlBranchTeamReadService {
    List<AmlBranchPendingResponseData> fetchAllAmlBranchPendingResponse(Integer branchId);

}
