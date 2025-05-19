package com.ponsun.aml.fraudTeam.FraudRemark.data;

import com.ponsun.aml.fraudTeam.FraudRemark.request.CreateFraudRemarkRequest;
import com.ponsun.aml.fraudTeam.FraudRemark.request.UpdateFraudRemarkRequest;
import com.ponsun.aml.infrastructure.exceptions.EQAS_AML_AppicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FraudRemarkValidator {
    public void validateSaveRemark(final CreateFraudRemarkRequest request){
        if(request.getId() == null || request.getId().equals("")){
            throw  new EQAS_AML_AppicationException("id parameter required");
        }
    }
    public void validateUpdateRemark(final UpdateFraudRemarkRequest request){
        if(request.getId() == null || request.getId().equals("")){
            throw new EQAS_AML_AppicationException("id parameter required");
        }
    }
}
