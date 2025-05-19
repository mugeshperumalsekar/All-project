package com.ponsun.aml.scamTeam.ScamRemark.services;

import com.ponsun.aml.scamTeam.ScamRemark.data.ScamRemarkData;
import com.ponsun.aml.scamTeam.ScamRemark.request.CreateScamRemarkRequest;
import com.ponsun.aml.scamTeam.ScamRemark.request.UpdateScamRemarkRequest;
import com.ponsun.aml.infrastructure.utils.Response;

import java.util.List;

public interface ScamRemarkWriteService {
    Response createScamRemark(CreateScamRemarkRequest createScamRemarkRequest);
    Response updateScamRemark(Integer id, UpdateScamRemarkRequest updateScamRemarkRequest);
    List<ScamRemarkData> fetchAllScamRemarkData(Integer scamId);
    Response deActive(Integer scamId,Integer euid);
}
