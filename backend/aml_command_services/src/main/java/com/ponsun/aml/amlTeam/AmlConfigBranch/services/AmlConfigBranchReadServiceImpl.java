package com.ponsun.aml.amlTeam.AmlConfigBranch.services;
import com.ponsun.aml.amlTeam.AmlConfigBranch.domain.AmlConfigBranch;
import com.ponsun.aml.amlTeam.AmlConfigBranch.domain.AmlConfigBranchRepository;
import com.ponsun.aml.amlTeam.AmlConfigBranch.domain.AmlConfigBranchWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AmlConfigBranchReadServiceImpl implements AmlConfigBranchReadService {
    private final AmlConfigBranchWrapper amlConfigBranchWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final AmlConfigBranchRepository amlConfigBranchRepository;

    @Override
    public AmlConfigBranch fetchConfigBranchById(Integer id){
        return this.amlConfigBranchRepository.findById(id).get();
    }
    @Override
    public List<AmlConfigBranch> fetchAllConfigBranch(){
        return this.amlConfigBranchRepository.findAll();
    }
}
