package com.ponsun.aml.amlTeam.AmlComplaintStatus.data;
import com.ponsun.aml.amlTeam.AmlComplaintStatus.request.CreaetAmlComplaintStatuRequest;
import com.ponsun.aml.amlTeam.AmlComplaintStatus.request.UpdateAmlComplaintStatusRequest;
import com.ponsun.aml.infrastructure.exceptions.EQAS_AML_AppicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AmlComplaintStatusValidator {
    public void validateSaveAmlConfigStatusList(final CreaetAmlComplaintStatuRequest request) {
        if (request.getId() == null || request.getId().equals("")) {
            throw new EQAS_AML_AppicationException("id parameter required");
        }
    }
    public void validateUpdateAmlConfigStatusList(final UpdateAmlComplaintStatusRequest request) {
        if (request.getId() == null || request.getId().equals("")) {
            throw new EQAS_AML_AppicationException("id parameter required");
        }
    }

}
