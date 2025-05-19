package com.ponsun.aml.amlTeam.AmlConfigBranch.domain;
import com.ponsun.aml.amlTeam.AmlComplaintTeam.request.AbstarctAmlComplaintTeamRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AmlConfigBranchWrapper extends AbstarctAmlComplaintTeamRequest {
    private final AmlConfigBranchRepository amlConfigBranchRepository;
    @Transactional
    public AmlConfigBranch findOneWithNotFoundDetection(final Integer id){
        return this.amlConfigBranchRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("AmlConfigBranch Not found " + id) );
    }
    @Override
    public String toString(){
        return super.toString();
    }



}
