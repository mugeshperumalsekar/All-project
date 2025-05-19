package com.ponsun.aml.amlTeam.BranchUserMapping.services;
import com.ponsun.aml.amlTeam.BranchUserMapping.domain.BranchUserMapping;

import java.util.List;

public interface BranchUserMappingReadService {
    BranchUserMapping fetchUserMappingById(Integer id);
    List<BranchUserMapping> fetchAllUserMapping();

}
