package com.ponsun.aml.amlTeam.AmlComplaintRemark.services;
import com.ponsun.aml.amlTeam.AmlComplaintRemark.request.CreateAmlComplaintRemarkRequest;
import com.ponsun.aml.amlTeam.AmlComplaintRemark.request.UpdateAmlComplaintRemarkRequest;
import com.ponsun.aml.infrastructure.utils.Response;

public interface AmlComplaintRemarkWriteService {
    Response createAmlComplaintRemarkList(CreateAmlComplaintRemarkRequest createAmlComplaintRemarkRequest);
    Response updateAmlComplaintRemarkList(Integer id, UpdateAmlComplaintRemarkRequest updateAmlComplaintRemarkRequest);
//    List<AmlComplaintRemarkData> fetchAllComplaintRemarkData(Integer complaintId);

}
