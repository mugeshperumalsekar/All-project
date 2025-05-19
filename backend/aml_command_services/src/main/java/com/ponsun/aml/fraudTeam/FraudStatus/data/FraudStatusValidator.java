package com.ponsun.aml.fraudTeam.FraudStatus.data;

import com.ponsun.aml.fraudTeam.FraudStatus.request.CreateFraudStatusRequest;
import com.ponsun.aml.fraudTeam.FraudStatus.request.UpdateFraudStatusRequest;
import com.ponsun.aml.infrastructure.exceptions.EQAS_AML_AppicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FraudStatusValidator {
    public void validateSaveStatus(final CreateFraudStatusRequest request){
        if(request.getId() == null || request.getId().equals("")){
            throw new EQAS_AML_AppicationException("id parameter required");
        }
    }
    public void validateUpdateStatus(final UpdateFraudStatusRequest request){
        if(request.getId() == null || request.getId().equals("")){
            throw new EQAS_AML_AppicationException("id parameter required");
        }
    }
}
