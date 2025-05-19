package com.ponsun.aml.amlTeam.BranchUserMapping.domain;
import com.ponsun.aml.amlTeam.BranchUserMapping.request.AbstractBranchUserMappingRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BranchUserMappingWrapper extends AbstractBranchUserMappingRequest {
    private final BranchUserMappingRepository branchUserMappingRepository;
    @Transactional
    public BranchUserMapping findOneWithNotFoundDetection(final Integer id){
        return this.branchUserMappingRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("BranchUserMapping Not found " + id) );
    }
    @Override
    public String toString(){
        return super.toString();
    }

}
