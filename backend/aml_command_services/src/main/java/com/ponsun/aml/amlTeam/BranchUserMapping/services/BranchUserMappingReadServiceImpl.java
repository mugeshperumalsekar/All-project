package com.ponsun.aml.amlTeam.BranchUserMapping.services;

import com.ponsun.aml.amlTeam.BranchUserMapping.domain.BranchUserMapping;
import com.ponsun.aml.amlTeam.BranchUserMapping.domain.BranchUserMappingRepository;
import com.ponsun.aml.amlTeam.BranchUserMapping.domain.BranchUserMappingWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BranchUserMappingReadServiceImpl implements BranchUserMappingReadService{
    private final BranchUserMappingWrapper branchUserMappingWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final BranchUserMappingRepository branchUserMappingRepository;

    @Override
    public BranchUserMapping fetchUserMappingById(Integer id){
        return this.branchUserMappingRepository.findById(id).get();
    }
    @Override
    public List<BranchUserMapping> fetchAllUserMapping(){
        return this.branchUserMappingRepository.findAll();
    }

}
