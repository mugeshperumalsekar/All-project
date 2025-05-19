package com.ponsun.aml.scamTeam.ScamObservation.domain;

import com.ponsun.aml.scamTeam.ScamObservation.request.AbstractScamObservationRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScamObservationWrapper extends AbstractScamObservationRequest {
   private final ScamObservationRepository scamObservationRepository;

   @Transactional
    public ScamObservation findOneWithNotFoundDetection(final Integer id){
       return this.scamObservationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("ScamObservation Not found "+id));
   }

   @Transactional
   public List<ScamObservation> findScamIdNotFoundDetection(final Integer scamId){
      return this.scamObservationRepository.findByScamId(scamId);
   }
   @Override
    public String toString(){return super.toString();}
}
