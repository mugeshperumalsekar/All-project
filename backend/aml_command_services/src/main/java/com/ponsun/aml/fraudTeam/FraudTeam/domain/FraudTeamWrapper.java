package com.ponsun.aml.fraudTeam.FraudTeam.domain;

import com.ponsun.aml.fraudTeam.FraudTeam.request.AbstractFraudTeamRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FraudTeamWrapper extends AbstractFraudTeamRequest {
    private final FraudTeamRepository fraudTeamRepository;

    @Transactional
    public FraudTeam findOneWithNotFoundDetection(final Integer id){
        return this.fraudTeamRepository.findById(id).orElseThrow(() ->new EntityNotFoundException("FraudTeam Not found "+id));
    }
    @Override
    public String toString(){return super.toString();}
}
