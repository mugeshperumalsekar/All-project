package com.ponsun.aml.amlTeam.AmlComplaintReply.domain;
import com.ponsun.aml.amlTeam.AmlComplaintReply.request.AbstarctAmlComplaintReplyRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AmlComplaintReplyWrapper extends AbstarctAmlComplaintReplyRequest {
    private final AmlComplaintReplyRepository amlComplaintReplyRepository;
    @Transactional
    public AmlComplaintReply findOneWithNotFoundDetection(final Integer id){
        return this.amlComplaintReplyRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("AmlComplaintReply Not found " + id) );
    }
    @Override
    public String toString(){
        return super.toString();
    }

}
