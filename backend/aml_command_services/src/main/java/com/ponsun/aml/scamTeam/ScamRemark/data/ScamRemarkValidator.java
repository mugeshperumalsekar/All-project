package com.ponsun.aml.scamTeam.ScamRemark.data;

import com.ponsun.aml.scamTeam.ScamRemark.request.CreateScamRemarkRequest;
import com.ponsun.aml.scamTeam.ScamRemark.request.UpdateScamRemarkRequest;
import com.ponsun.aml.infrastructure.exceptions.EQAS_AML_AppicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ScamRemarkValidator {
    public void validateSaveRemark(final CreateScamRemarkRequest request){
        if(request.getId() == null || request.getId().equals("")){
            throw  new EQAS_AML_AppicationException("id parameter required");
        }
    }
    public void validateUpdateRemark(final UpdateScamRemarkRequest request){
        if(request.getId() == null || request.getId().equals("")){
            throw new EQAS_AML_AppicationException("id parameter required");
        }
    }
}
