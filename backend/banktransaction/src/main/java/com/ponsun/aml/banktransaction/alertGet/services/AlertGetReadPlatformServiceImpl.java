package com.ponsun.aml.banktransaction.alertGet.services;


import com.ponsun.aml.banktransaction.alertGet.domain.AlertGet;
import com.ponsun.aml.banktransaction.alertGet.domain.AlertGetRepository;
import com.ponsun.aml.banktransaction.alertGet.domain.AlertGetRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AlertGetReadPlatformServiceImpl implements AlertGetReadPlatformService {

private final AlertGetRepositoryWrapper alertGetRepositoryWrapper;

    private final JdbcTemplate jdbcTemplate;

    private final AlertGetRepository alertGetRepository;

    @Override
    public AlertGet fetchAlertGetById(Integer id) {
        return this.alertGetRepository.findById(id).get();
    }

    @Override
    public List<AlertGet> fetchAllAlertGet() {
    return this.alertGetRepository.findAll();
    }

}
