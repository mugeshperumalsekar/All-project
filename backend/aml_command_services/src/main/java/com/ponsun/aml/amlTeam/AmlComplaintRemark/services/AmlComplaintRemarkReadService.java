package com.ponsun.aml.amlTeam.AmlComplaintRemark.services;

import com.ponsun.aml.amlTeam.AmlComplaintRemark.domain.AmlComplaintRemark;

import java.util.List;

public interface AmlComplaintRemarkReadService {
    AmlComplaintRemark fetchAmlComplaintRemarkById(Integer id);
    List<AmlComplaintRemark> fetchAllAmlComplaintRemark();

}
