package com.ponsun.aml.fraudTeam.FraudObservation.data;

import com.ponsun.aml.fraudTeam.FraudObservation.request.CreateFraudObservationRequest;
import com.ponsun.aml.fraudTeam.FraudObservation.request.UpdateFraudObservationRequest;
import com.ponsun.aml.infrastructure.exceptions.EQAS_AML_AppicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FraudObservationValidator {
    public void validateSaveObservation(final CreateFraudObservationRequest request){
       if(request.getId() == null || request.getId().equals("")) {
          throw  new EQAS_AML_AppicationException("id parameter required");
       }
    }

    public void validateUpdateObservation(final UpdateFraudObservationRequest request){
        if(request.getId() == null || request.getId().equals("")){
           throw new EQAS_AML_AppicationException("id parameter required");
        }
    }

}
