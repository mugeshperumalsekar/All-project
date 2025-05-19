package com.ponsun.aml.fraudTeam.FraudTeam.data;

import com.ponsun.aml.fraudTeam.FraudTeam.request.CreateFraudTeamRequest;
import com.ponsun.aml.fraudTeam.FraudTeam.request.UpdateFraudTeamRequest;
import com.ponsun.aml.infrastructure.exceptions.EQAS_AML_AppicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FraudTeamValidator {
    public void validateSaveTeam(final CreateFraudTeamRequest request){
        if(request.getId() == null || request.getId().equals("")){
            throw new EQAS_AML_AppicationException("id parameter required");
        }
    }
    public void validateUpdateTeam(final UpdateFraudTeamRequest request){
        if(request.getId() == null || request.getId().equals("")){
            throw new EQAS_AML_AppicationException("id parameter required");
        }
    }
}
