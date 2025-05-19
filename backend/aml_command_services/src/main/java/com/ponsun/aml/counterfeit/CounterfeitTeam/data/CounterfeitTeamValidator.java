package com.ponsun.aml.counterfeit.CounterfeitTeam.data;


import com.ponsun.aml.infrastructure.exceptions.EQAS_AML_AppicationException;
import com.ponsun.aml.counterfeit.CounterfeitTeam.request.CreateCounterfeitTeamRequest;
import com.ponsun.aml.counterfeit.CounterfeitTeam.request.UpdateCounterfeitTeamRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CounterfeitTeamValidator {
    public void validateSaveCounterfeitTeam(final CreateCounterfeitTeamRequest request) {
        if (request.getId() == null || request.getId().equals("")) {
            throw new EQAS_AML_AppicationException("id parameter required");
        }
    }
    public void validateUpdateCounterfeitTeam(final UpdateCounterfeitTeamRequest request) {
        if (request.getId() == null || request.getId().equals("")) {
            throw new EQAS_AML_AppicationException("id parameter required");
        }
    }
}
