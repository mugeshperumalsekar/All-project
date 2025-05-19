package com.ponsun.aml.scamTeam.ScamTeam.domain;

import com.ponsun.aml.scamTeam.ScamTeam.request.AbstractScamTeamRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ScamTeamWrapper extends AbstractScamTeamRequest {
    private final ScamTeamRepository scamTeamRepository;

    @Transactional
    public ScamTeam findOneWithNotFoundDetection(final Integer id){
        return this.scamTeamRepository.findById(id).orElseThrow(() ->new EntityNotFoundException("ScamTeam Not found "+id));
    }
    @Override
    public String toString(){return super.toString();}
}
