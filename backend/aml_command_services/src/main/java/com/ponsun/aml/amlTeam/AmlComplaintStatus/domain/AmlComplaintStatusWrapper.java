package com.ponsun.aml.amlTeam.AmlComplaintStatus.domain;
import com.ponsun.aml.amlTeam.AmlComplaintStatus.request.AbstractAmlComplaintStatusRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AmlComplaintStatusWrapper extends AbstractAmlComplaintStatusRequest {
    private final AmlComplaintStatusRepository amlComplaintStatusRepository;
    @Transactional
    public AmlComplaintStatus findOneWithNotFoundDetection(final Integer id){
        return this.amlComplaintStatusRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("AmlComplaintStatus Not found " + id) );
    }
    @Override
    public String toString(){
        return super.toString();
    }

}
