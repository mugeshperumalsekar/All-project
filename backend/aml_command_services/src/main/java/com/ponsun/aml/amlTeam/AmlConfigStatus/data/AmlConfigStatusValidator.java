package com.ponsun.aml.amlTeam.AmlConfigStatus.data;

import com.ponsun.aml.amlTeam.AmlConfigStatus.request.CreateAmlConfigStatusRequest;
import com.ponsun.aml.amlTeam.AmlConfigStatus.request.UpdateAmlConfigStatusRequest;
import com.ponsun.aml.infrastructure.exceptions.EQAS_AML_AppicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AmlConfigStatusValidator {
    public void validateSaveConfigStatus(final CreateAmlConfigStatusRequest request){
        if(request.getId() == null || request.getId().equals("")){
            throw new EQAS_AML_AppicationException("id parameter required");
        }
    }
    public void validateUpdateConfigStatus(final UpdateAmlConfigStatusRequest request){
        if(request.getId() == null || request.getId().equals("")){
            throw new EQAS_AML_AppicationException("id parameter required");
        }
    }
}
