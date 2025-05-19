package com.ponsun.aml.counterfeit.CounterfeitNumber.data;


import com.ponsun.aml.infrastructure.exceptions.EQAS_AML_AppicationException;
import com.ponsun.aml.counterfeit.CounterfeitNumber.request.CreateCounterfeitNumberRequest;
import com.ponsun.aml.counterfeit.CounterfeitNumber.request.UpdateCounterfeitNumberRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CounterfeitNumberValidator {
    public void validateSaveCounterfeitNumber(final CreateCounterfeitNumberRequest request) {
        if (request.getId() == null || request.getId().equals("")) {
            throw new EQAS_AML_AppicationException("id parameter required");
        }
    }
    public void validateUpdateCounterfeitNumber(final UpdateCounterfeitNumberRequest request) {
        if (request.getId() == null || request.getId().equals("")) {
            throw new EQAS_AML_AppicationException("id parameter required");
        }
    }
}
