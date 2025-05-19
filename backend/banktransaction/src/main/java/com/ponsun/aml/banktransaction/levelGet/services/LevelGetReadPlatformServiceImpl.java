package com.ponsun.aml.banktransaction.levelGet.services;


import com.ponsun.aml.banktransaction.levelGet.domain.LevelGet;
import com.ponsun.aml.banktransaction.levelGet.domain.LevelGetRepository;
import com.ponsun.aml.banktransaction.levelGet.domain.LevelGetRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class LevelGetReadPlatformServiceImpl implements LevelGetReadPlatformService {

    private final LevelGetRepositoryWrapper levelGetRepositoryWrapper;

    private final JdbcTemplate jdbcTemplate;

    private final LevelGetRepository levelGetRepository;

    @Override
    public LevelGet fetchLevelDetById(Integer id) {
        return this.levelGetRepository.findById(id).get();
    }

    @Override
    public List<LevelGet> fetchAllLevelDet() {
        return this.levelGetRepository.findAll();
    }

}
