package com.ponsun.aml.amlTeam.AmlComplaintStatus.services;
import com.ponsun.aml.amlTeam.AmlComplaintStatus.domain.AmlComplaintStatus;

import java.util.List;

public interface AmlComplaintStatusReadService {
    AmlComplaintStatus fetchAmlStatusById(Integer id);
    List<AmlComplaintStatus> fetchAllAmlStatus();

}
