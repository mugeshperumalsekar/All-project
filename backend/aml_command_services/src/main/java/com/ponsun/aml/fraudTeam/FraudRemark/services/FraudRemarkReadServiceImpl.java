package com.ponsun.aml.fraudTeam.FraudRemark.services;

import com.ponsun.aml.fraudTeam.FraudRemark.domain.FraudRemark;
import com.ponsun.aml.fraudTeam.FraudRemark.domain.FraudRemarkRepository;
import com.ponsun.aml.fraudTeam.FraudRemark.domain.FraudRemarkWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FraudRemarkReadServiceImpl implements FraudRemarkReadService {
    private final FraudRemarkWrapper fraudRemarkWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final FraudRemarkRepository fraudRemarkRepository;

    @Override
    public FraudRemark fetchRemarkById(Integer id){

        return this.fraudRemarkRepository.findById(id).get();
    }
    @Override
    public List<FraudRemark> fetchAllRemark(){return this.fraudRemarkRepository.findAll();}
}
