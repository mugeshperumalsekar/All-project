package com.ponsun.aml.amlTeam.AmlComplaintRemark.data;

import com.ponsun.aml.amlTeam.AmlComplaintRemark.request.CreateAmlComplaintRemarkRequest;
import com.ponsun.aml.amlTeam.AmlComplaintRemark.request.UpdateAmlComplaintRemarkRequest;
import com.ponsun.aml.infrastructure.exceptions.EQAS_AML_AppicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AmlComplaintRemarkValidator {
    public void validateSaveAmlComplaintRemarkList(final CreateAmlComplaintRemarkRequest request) {
        if (request.getComplaintId() == null || request.getComplaintId().equals("")) {
            throw new EQAS_AML_AppicationException("id parameter required");
        }
    }
    public void validateUpdateAmlComplaintRemarkList(final UpdateAmlComplaintRemarkRequest request) {
        if (request.getComplaintId() == null || request.getComplaintId().equals("")) {
            throw new EQAS_AML_AppicationException("id parameter required");
        }
    }

}

