package com.ponsun.aml.scamTeam.ScamStatus.services;

import com.ponsun.aml.scamTeam.ScamStatus.domain.ScamStatus;
import java.util.List;

public interface ScamStatusReadService {
    ScamStatus fetchStatusById(Integer id);
    List<ScamStatus> fetchAllStatus();
}
