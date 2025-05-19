package com.ponsun.aml.scamTeam.ScamTeam.data;

import com.ponsun.aml.scamTeam.ScamTeam.request.CreateScamTeamRequest;
import com.ponsun.aml.scamTeam.ScamTeam.request.UpdateScamTeamRequest;
import com.ponsun.aml.infrastructure.exceptions.EQAS_AML_AppicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ScamTeamValidator {
    public void validateSaveTeam(final CreateScamTeamRequest request){
        if(request.getId() == null || request.getId().equals("")){
            throw new EQAS_AML_AppicationException("id parameter required");
        }
    }
    public void validateUpdateTeam(final UpdateScamTeamRequest request){
        if(request.getId() == null || request.getId().equals("")){
            throw new EQAS_AML_AppicationException("id parameter required");
        }
    }
}
