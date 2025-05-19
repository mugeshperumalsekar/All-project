package com.ponsun.aml.amlTeam.BranchUserMapping.services;
import com.ponsun.aml.amlTeam.BranchUserMapping.data.BranchUserMappingData;
import com.ponsun.aml.amlTeam.BranchUserMapping.data.BranchUserMappingValidator;
import com.ponsun.aml.amlTeam.BranchUserMapping.domain.BranchUserMapping;
import com.ponsun.aml.amlTeam.BranchUserMapping.domain.BranchUserMappingRepository;
import com.ponsun.aml.amlTeam.BranchUserMapping.domain.BranchUserMappingWrapper;
import com.ponsun.aml.amlTeam.BranchUserMapping.request.CreateBranchUserMappingRequest;
import com.ponsun.aml.amlTeam.BranchUserMapping.request.UpdateBranchUserMappingRequest;
import com.ponsun.aml.infrastructure.exceptions.EQAS_AML_AppicationException;
import com.ponsun.aml.infrastructure.utils.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BranchUserMappingWriteServiceImpl implements  BranchUserMappingWriteService{
    private final BranchUserMappingRepository branchUserMappingRepository;
    private final BranchUserMappingWrapper branchUserMappingWrapper;
    private final BranchUserMappingValidator branchUserMappingValidator;

    @Override
    @Transactional
    public Response createUserMapping(List<BranchUserMappingData> branchUserMappingDataList) {
        ModelMapper modelMapper = new ModelMapper();

        try {

            for (BranchUserMappingData request : branchUserMappingDataList) {
                CreateBranchUserMappingRequest createBranchUserMappingRequest = modelMapper.map(request, CreateBranchUserMappingRequest.class);
                BranchUserMapping branchUserMapping = BranchUserMapping.create(createBranchUserMappingRequest);
                branchUserMapping = this.branchUserMappingRepository.saveAndFlush(branchUserMapping);
                return Response.of(Long.valueOf(branchUserMapping.getId()));
            }
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_AML_AppicationException(e.getMessage());
        }
        return new Response();
    }
        @Override
        @Transactional
        public Response updateUserMapping (Integer id, UpdateBranchUserMappingRequest updateBranchUserMappingRequest) {
            try {
                this.branchUserMappingValidator.validateUpdateBranchUserMapping(updateBranchUserMappingRequest);
                final BranchUserMapping branchUserMapping = this.branchUserMappingWrapper.findOneWithNotFoundDetection(id);
                branchUserMapping.update(updateBranchUserMappingRequest);
                this.branchUserMappingRepository.saveAndFlush(branchUserMapping);
                return Response.of(Long.valueOf(branchUserMapping.getId()));

            } catch (DataIntegrityViolationException e) {
                throw new EQAS_AML_AppicationException(e.getMessage());
            }
        }
    }

