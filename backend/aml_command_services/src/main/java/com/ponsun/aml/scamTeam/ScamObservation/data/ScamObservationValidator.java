package com.ponsun.aml.scamTeam.ScamObservation.data;

import com.ponsun.aml.scamTeam.ScamObservation.request.CreateScamObservationRequest;
import com.ponsun.aml.scamTeam.ScamObservation.request.UpdateScamObservationRequest;
import com.ponsun.aml.infrastructure.exceptions.EQAS_AML_AppicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ScamObservationValidator {
    public void validateSaveObservation(final CreateScamObservationRequest request){
       if(request.getId() == null || request.getId().equals("")) {
          throw  new EQAS_AML_AppicationException("id parameter required");
       }
    }

    public void validateUpdateObservation(final UpdateScamObservationRequest request){
        if(request.getId() == null || request.getId().equals("")){
           throw new EQAS_AML_AppicationException("id parameter required");
        }
    }

}
