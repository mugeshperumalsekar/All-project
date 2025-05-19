package com.ponsun.aml.amlTeam.AmlComplaintStatus.services;
import com.ponsun.aml.amlTeam.AmlComplaintStatus.domain.AmlComplaintStatus;
import com.ponsun.aml.amlTeam.AmlComplaintStatus.domain.AmlComplaintStatusRepository;
import com.ponsun.aml.amlTeam.AmlComplaintStatus.domain.AmlComplaintStatusWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AmlComplaintStatusReadServiceImpl implements AmlComplaintStatusReadService {
    private final AmlComplaintStatusWrapper amlComplaintStatusWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final AmlComplaintStatusRepository amlComplaintStatusRepository;

    @Override
    public AmlComplaintStatus fetchAmlStatusById(Integer id){
        return this.amlComplaintStatusRepository.findById(id).get();
    }
    @Override
    public List<AmlComplaintStatus> fetchAllAmlStatus(){
        return this.amlComplaintStatusRepository.findAll();
    }


}
