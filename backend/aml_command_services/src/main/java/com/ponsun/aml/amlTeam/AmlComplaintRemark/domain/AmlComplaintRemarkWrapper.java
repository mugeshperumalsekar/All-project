package com.ponsun.aml.amlTeam.AmlComplaintRemark.domain;

import com.ponsun.aml.amlTeam.AmlComplaintRemark.request.AbstractAmlComplaintRemarkRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AmlComplaintRemarkWrapper extends AbstractAmlComplaintRemarkRequest {
    private final AmlComplaintRemarkRepository amlComplaintRemarkRepository;
    @Transactional
    public AmlComplaintRemark findOneWithNotFoundDetection(final Integer id){
        return this.amlComplaintRemarkRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("AmlComplaintRemark Not found " + id) );
    }
    @Override
    public String toString(){
        return super.toString();
    }

}
