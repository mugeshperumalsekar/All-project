package com.ponsun.aml.amlTeam.AmlConfigStatus.services;

import com.ponsun.aml.amlTeam.AmlConfigStatus.domain.AmlConfigStatus;

import java.util.List;

public interface AmlConfigStatusReadService {
    AmlConfigStatus fetchAmlConfigStatusById(Integer id);
    List<AmlConfigStatus>fetchAllAmlConfigStatus();
}
