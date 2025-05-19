package com.ponsun.aml.amlTeam.AmlConfigBranch.services;
import com.ponsun.aml.amlTeam.AmlConfigBranch.request.CreateAmlConfigBranchRequest;
import com.ponsun.aml.amlTeam.AmlConfigBranch.request.UpdateAmlConfigBranchRequest;
import com.ponsun.aml.infrastructure.utils.Response;

public interface AmlConfigBranchWriteService {
    Response createConfigBranch(CreateAmlConfigBranchRequest createCurrencyReportBranchToAmlRequest);
    Response updateConfigBranch(Integer id, UpdateAmlConfigBranchRequest updateCurrencyReportBranchToAmlRequest);

}

