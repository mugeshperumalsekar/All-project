package com.ponsun.aml.amlTeam.AmlConfigBranch.services;
import com.ponsun.aml.amlTeam.AmlConfigBranch.domain.AmlConfigBranch;

import java.util.List;

public interface AmlConfigBranchReadService {
    AmlConfigBranch fetchConfigBranchById(Integer id);
    List<AmlConfigBranch> fetchAllConfigBranch();
}

