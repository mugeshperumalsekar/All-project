package com.ponsun.aml.fraudTeam.FraudObservation.domain;

import com.ponsun.aml.fraudTeam.FraudObservation.request.AbstractFraudObservationRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FraudObservationWrapper extends AbstractFraudObservationRequest {
   private final FraudObservationRepository fraudObservationRepository;
   @Transactional
    public FraudObservation findOneWithNotFoundDetection(final Integer id){
       return this.fraudObservationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("FraudObservation Not found "+id));
   }

   @Transactional
   public List<FraudObservation> findFraudIdNotFoundDetection(final Integer fraudId){
      return this.fraudObservationRepository.findByFraudId(fraudId);
   }
   @Override
    public String toString(){return super.toString();}
}
