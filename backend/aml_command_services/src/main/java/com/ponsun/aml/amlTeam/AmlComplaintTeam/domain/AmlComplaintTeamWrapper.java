package com.ponsun.aml.amlTeam.AmlComplaintTeam.domain;

import com.ponsun.aml.amlTeam.AmlComplaintTeam.request.AbstarctAmlComplaintTeamRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AmlComplaintTeamWrapper extends AbstarctAmlComplaintTeamRequest {
    private final AmlComplaintTeamRepository amlComplaintTeamRepository;
    @Transactional
    public AmlComplaintTeam findOneWithNotFoundDetection(final Integer id){
        return this.amlComplaintTeamRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("AmlComplaintTeam Not found " + id) );
    }
    @Override
    public String toString(){
        return super.toString();
    }


}
