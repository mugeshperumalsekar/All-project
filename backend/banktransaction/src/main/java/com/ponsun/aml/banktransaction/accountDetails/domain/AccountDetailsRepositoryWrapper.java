package com.ponsun.aml.banktransaction.accountDetails.domain;

import com.ponsun.aml.banktransaction.accountDetails.request.AbstractAccountDetailsRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AccountDetailsRepositoryWrapper extends AbstractAccountDetailsRequest {
    private final AccountDetailsRepository accountDetailsRepository;
    @Transactional
    public AccountDetails findOneWithNotFoundDetection(final Integer id){
        return this.accountDetailsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("AccountDetails Not found" + id));
    }

    @Override
    public String toString(){ return super.toString();}
}
