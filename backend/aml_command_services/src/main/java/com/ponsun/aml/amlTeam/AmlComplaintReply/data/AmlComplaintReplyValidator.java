package com.ponsun.aml.amlTeam.AmlComplaintReply.data;

import com.ponsun.aml.amlTeam.AmlComplaintReply.request.CreateAmlComplaintReplyRequest;
import com.ponsun.aml.amlTeam.AmlComplaintReply.request.UpdateAmlComplaintReplyrequest;
import com.ponsun.aml.infrastructure.exceptions.EQAS_AML_AppicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AmlComplaintReplyValidator {

    public void validateSaveAmlComplaintReplyList(final CreateAmlComplaintReplyRequest request) {
        if (request.getId() == null || request.getId().equals("")) {
            throw new EQAS_AML_AppicationException("id parameter required");
        }
    }
    public void validateUpdateAmlComplaintReplyList(final UpdateAmlComplaintReplyrequest request) {
        if (request.getId() == null || request.getId().equals("")) {
            throw new EQAS_AML_AppicationException("id parameter required");
        }
    }

}
