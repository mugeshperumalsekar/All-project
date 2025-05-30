package com.ponsun.aml.adminconfiguration.adminuserrights.services;


import com.ponsun.aml.adminconfiguration.adminuserrights.data.AdminUserRightsDTO;
import com.ponsun.aml.adminconfiguration.adminuserrights.data.AdminUserRightsDataValidator;
import com.ponsun.aml.adminconfiguration.adminuserrights.domain.AdminUserRights;
import com.ponsun.aml.adminconfiguration.adminuserrights.domain.AdminUserRightsRepository;
import com.ponsun.aml.adminconfiguration.adminuserrights.domain.AdminUserRightsRepositoryWrapper;
import com.ponsun.aml.adminconfiguration.adminuserrights.request.UpdateAdminUserRightsRequest;
import com.ponsun.aml.common.entity.Status;
import com.ponsun.aml.infrastructure.exceptions.EQAS_AML_AppicationException;
import com.ponsun.aml.infrastructure.utils.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class AdminUserRightsWritePlatformServiceImpl implements AdminUserRightsWritePlatformService{

    private final AdminUserRightsRepository adminUserRightsRepository;
    private final AdminUserRightsRepositoryWrapper adminUserRightsRepositoryWrapper;
    private final AdminUserRightsDataValidator adminUserRightsDataValidator;

    @Override
    @Transactional
    public List<String> createAdminUserRights(List<AdminUserRightsDTO> payload) {
        log.debug("Request payload received: {}", payload);

        List<String> createdUserRightsIds = new ArrayList<>();

        for (AdminUserRightsDTO jsonRequest : payload) {
            try {
                // Work with jsonRequest directly as AdminUserRightsDTO
//                this.adminUserRightsDataValidator.validateSaveAdminUserRights(jsonRequest);

                final AdminUserRights adminUserRights = AdminUserRights.Bulkcreate(jsonRequest);
                this.adminUserRightsRepository.saveAndFlush(adminUserRights);

                createdUserRightsIds.add(String.valueOf(adminUserRights.getUid()));


            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
            return createdUserRightsIds;
    }


    @Override
    @Transactional
    public Response updateAdminUserRights(Integer id, UpdateAdminUserRightsRequest updateAdminUserRightsRequest) {
        try {
//            this.adminUserRightsDataValidator.validateUpdateAdminUserRights(updateAdminUserRightsRequest);
            final AdminUserRights adminUserRights = this.adminUserRightsRepositoryWrapper.findOneWithNotFoundDetection(id);
            adminUserRights.update(updateAdminUserRightsRequest);
            this.adminUserRightsRepository.saveAndFlush(adminUserRights);
            return Response.of(Long.valueOf(adminUserRights.getId()));

        } catch (DataIntegrityViolationException e) {
            throw new EQAS_AML_AppicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response blockAdminUserRights(Integer id) {
        try {
            final AdminUserRights adminUserRights = this.adminUserRightsRepositoryWrapper.findOneWithNotFoundDetection(id);
            adminUserRights.setValid(false);
            adminUserRights.setStatus(Status.DELETE.DELETE);
            adminUserRights.setUpdatedAt(LocalDateTime.now());
            this.adminUserRightsRepository.saveAndFlush(adminUserRights);
                return Response.of(Long.valueOf(id));


        } catch (DataIntegrityViolationException e) {
            throw new EQAS_AML_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response unblockAdminUserRights(Integer id) {
        try {
            final AdminUserRights adminUserRights = this.adminUserRightsRepositoryWrapper.findOneWithNotFoundDetection(id);
            adminUserRights.setValid(true);
            adminUserRights.setStatus(Status.ACTIVE);
            adminUserRights.setUpdatedAt(LocalDateTime.now());
            this.adminUserRightsRepository.saveAndFlush(adminUserRights);
            return Response.of(Long.valueOf(id));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_AML_AppicationException(e.getMessage());
        }
    }
}
