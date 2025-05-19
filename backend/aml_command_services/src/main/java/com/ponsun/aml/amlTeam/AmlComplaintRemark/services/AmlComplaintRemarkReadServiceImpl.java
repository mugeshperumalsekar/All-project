package com.ponsun.aml.amlTeam.AmlComplaintRemark.services;

import com.ponsun.aml.amlTeam.AmlComplaintRemark.domain.AmlComplaintRemark;
import com.ponsun.aml.amlTeam.AmlComplaintRemark.domain.AmlComplaintRemarkRepository;
import com.ponsun.aml.amlTeam.AmlComplaintRemark.domain.AmlComplaintRemarkWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AmlComplaintRemarkReadServiceImpl implements AmlComplaintRemarkReadService{
    private final AmlComplaintRemarkWrapper amlComplaintRemarkWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final AmlComplaintRemarkRepository amlComplaintRemarkRepository;

    @Override
    public AmlComplaintRemark fetchAmlComplaintRemarkById(Integer id){
        return this.amlComplaintRemarkRepository.findById(id).get();
    }
    @Override
    public List<AmlComplaintRemark> fetchAllAmlComplaintRemark(){
        return this.amlComplaintRemarkRepository.findAll();
    }

}
