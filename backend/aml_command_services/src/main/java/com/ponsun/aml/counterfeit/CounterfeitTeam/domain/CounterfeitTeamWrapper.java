package com.ponsun.aml.counterfeit.CounterfeitTeam.domain;


import com.ponsun.aml.counterfeit.CounterfeitTeam.request.AbstractCounterfeitTeamRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CounterfeitTeamWrapper extends AbstractCounterfeitTeamRequest {
    private final CounterfeitTeamRepository counterfeitTeamRepository;
    @Transactional
    public CounterfeitTeam findOneWithNotFoundDetection(final Integer id){
        return this.counterfeitTeamRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("CounterfeitTeam Not found " + id) );
    }
    @Override
    public String toString(){
        return super.toString();
    }


}
