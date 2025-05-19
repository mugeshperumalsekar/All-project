package com.ponsun.aml.fraudTeam.FraudStatus.services;

import com.ponsun.aml.fraudTeam.FraudStatus.domain.FraudStatus;
import com.ponsun.aml.fraudTeam.FraudStatus.domain.FraudStatusRepository;
import com.ponsun.aml.fraudTeam.FraudStatus.domain.FraudStatusWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class FraudStatusReadServiceImpl implements FraudStatusReadService {
    private final FraudStatusWrapper fraudStatusWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final FraudStatusRepository fraudStatusRepository;

    @Override
    public FraudStatus fetchStatusById(Integer id){

        return this.fraudStatusRepository.findById(id).get();
    }
    @Override
    public List<FraudStatus> fetchAllStatus(){return this.fraudStatusRepository.findAll();
    }
}

