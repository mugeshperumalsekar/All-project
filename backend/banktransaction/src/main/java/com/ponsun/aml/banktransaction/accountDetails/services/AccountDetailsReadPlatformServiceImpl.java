package com.ponsun.aml.banktransaction.accountDetails.services;

import com.ponsun.aml.banktransaction.accountDetails.domain.AccountDetails;
import com.ponsun.aml.banktransaction.accountDetails.domain.AccountDetailsRepository;
import com.ponsun.aml.banktransaction.accountDetails.domain.AccountDetailsRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountDetailsReadPlatformServiceImpl implements AccountDetailsReadPlatformService{

    private final AccountDetailsRepositoryWrapper accountDetailsRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final AccountDetailsRepository accountDetailsRepository;
    @Override
    public AccountDetails fetchAccountDetailsById(Integer id){
        return this.accountDetailsRepository.findById(id).get();
    }
    @Override
    public List<AccountDetails> fetchAllAccountDetails(){ return this.accountDetailsRepository.findAll();}
}
