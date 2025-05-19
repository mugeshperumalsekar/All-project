package com.ponsun.aml.amlTeam.AmlComplaintTeam.services;

import com.ponsun.aml.amlTeam.AmlComplaintTeam.data.AmlComplaintDto;
import com.ponsun.aml.amlTeam.AmlComplaintTeam.request.CreateAmlComplaintTeamRequest;
import com.ponsun.aml.amlTeam.AmlComplaintTeam.request.UpdateAmlComplaintTeamRequest;
import com.ponsun.aml.infrastructure.utils.Response;

public interface AmlComplaintTeamWriteService {
    Response createAmlBranchList(CreateAmlComplaintTeamRequest createAmlComplaintTeamRequest);
    Response updateAmlBranchList(Integer id, UpdateAmlComplaintTeamRequest updateAmlComplaintTeamRequest);
    Response createAmlComplaint(AmlComplaintDto amlComplaintDto);

    Response updateAmlComplaint(Integer euid,Integer compId,AmlComplaintDto amlComplaintDto );
    Response  DeActiveFunction(Integer compId, Integer euid);

}
//    Response updateAmlComplaint(String AmlDto,Integer compId,Integer uid );