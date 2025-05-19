package com.ponsun.aml.counterfeit.CounterfeitRemark.data;


import com.ponsun.aml.infrastructure.exceptions.EQAS_AML_AppicationException;
import com.ponsun.aml.counterfeit.CounterfeitRemark.request.CreateCounterfeitRemarkRequest;
import com.ponsun.aml.counterfeit.CounterfeitRemark.request.UpdateCounterfeitRemarkRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CounterfeitRemarkValidator {
    public void validateSaveCounterfeitRemark(final CreateCounterfeitRemarkRequest request) {
        if (request.getId() == null || request.getId().equals("")) {
            throw new EQAS_AML_AppicationException("id parameter required");
        }
    }
    public void validateUpdateCounterfeitRemark(final UpdateCounterfeitRemarkRequest request) {
        if (request.getId() == null || request.getId().equals("")) {
            throw new EQAS_AML_AppicationException("id parameter required");
        }
    }
}
