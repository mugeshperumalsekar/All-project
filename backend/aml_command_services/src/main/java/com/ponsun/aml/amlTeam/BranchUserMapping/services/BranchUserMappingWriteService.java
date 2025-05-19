package com.ponsun.aml.amlTeam.BranchUserMapping.services;
import com.ponsun.aml.amlTeam.BranchUserMapping.data.BranchUserMappingData;
import com.ponsun.aml.amlTeam.BranchUserMapping.request.UpdateBranchUserMappingRequest;
import com.ponsun.aml.infrastructure.utils.Response;

import java.util.List;

public interface BranchUserMappingWriteService {
    Response createUserMapping(List<BranchUserMappingData> branchUserMappingDataList);
    Response updateUserMapping(Integer id, UpdateBranchUserMappingRequest updateBranchUserMappingRequest);


}
