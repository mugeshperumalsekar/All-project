package com.ponsun.aml.banktransaction.adminconfiguration.adminconfigmoduledet.services;


import com.ponsun.aml.banktransaction.accountDetails.data.AppicationException;
import com.ponsun.aml.banktransaction.adminconfiguration.adminconfigmoduledet.data.AdminConfigModuleDetDataValidator;
import com.ponsun.aml.banktransaction.adminconfiguration.adminconfigmoduledet.domain.AdminConfigModuleDet;
import com.ponsun.aml.banktransaction.adminconfiguration.adminconfigmoduledet.domain.AdminConfigModuleDetRepository;
import com.ponsun.aml.banktransaction.adminconfiguration.adminconfigmoduledet.domain.AdminConfigModuleDetRepositoryWrapper;
import com.ponsun.aml.banktransaction.adminconfiguration.adminconfigmoduledet.request.CreateAdminConfigModuleDetRequest;
import com.ponsun.aml.banktransaction.adminconfiguration.adminconfigmoduledet.request.UpdateAdminConfigModuleDetRequest;
import com.ponsun.aml.banktransaction.common.entity.Status;
import com.ponsun.aml.banktransaction.infrastructure.utils.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdminConfigModuleDetWritePlatformServiceImpl implements AdminConfigModuleDetWritePlatformService  {

    private final AdminConfigModuleDetRepository adminconfigmoduledetRepository;
    private final AdminConfigModuleDetRepositoryWrapper adminConfigModuleDetRepositoryWrapper;
    private final AdminConfigModuleDetDataValidator moduleDetDataValidator;
    @Override
    @Transactional
    public Response createAdminConfigModuleDet(CreateAdminConfigModuleDetRequest createAdminConfigModuleDetRequest) throws AppicationException {
        try {
            this.moduleDetDataValidator.validateSaveModuleDet(createAdminConfigModuleDetRequest);
            final AdminConfigModuleDet adminconfigmoduledet = AdminConfigModuleDet.create(createAdminConfigModuleDetRequest);//entity
            this.adminconfigmoduledetRepository.saveAndFlush(adminconfigmoduledet);
            return Response.of(Integer.valueOf(adminconfigmoduledet.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new AppicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response updateAdminConfigModuleDet(Integer id, UpdateAdminConfigModuleDetRequest updateAdminConfigModuleDetRequest) throws AppicationException {
        try {
            this.moduleDetDataValidator.validateUpdateModuleDet(updateAdminConfigModuleDetRequest);
            final AdminConfigModuleDet moduleDet = this.adminConfigModuleDetRepositoryWrapper.findOneWithNotFoundDetection(id);
            moduleDet.update(updateAdminConfigModuleDetRequest);
            this.adminconfigmoduledetRepository.saveAndFlush(moduleDet);
            return Response.of(Integer.valueOf(moduleDet.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new AppicationException(e.getMessage());
        }
    }

//    @Override
//    @Transactional
//    public Response deactive(Integer pepId, Integer euid){
//        try{
//            List<AdminConfigModuleDet> adminConfigModuleDetList = this.adminConfigModuleDetRepositoryWrapper.findOnePepIdWithNotFoundDetection(pepId);
//            Response response = null;
//            for (AdminConfigModuleDet adminConfigModuleDet : adminConfigModuleDetList) {
//                adminConfigModuleDet.setEuid(euid);
//                adminConfigModuleDet.setStatus(Status.ACTIVE);
//                adminConfigModuleDet.setUpdatedAt(LocalDateTime.now());
//                response = Response.of(adminConfigModuleDet.getId());
//            }
//            return response;
//        }catch (DataIntegrityViolationException e){
//            throw new EQAS_PEP_AppicationException(e.getMessage());
//        }
//    }

@Override
@Transactional
public Response blockAdminConfigModuleDet(Integer id) throws AppicationException {
    try {
        final AdminConfigModuleDet adminConfigModuleDet = this.adminConfigModuleDetRepositoryWrapper.findOneWithNotFoundDetection(id);
        adminConfigModuleDet.setValid(false); // Set 'valid' to 0
        adminConfigModuleDet.setStatus(Status.DELETE); // Or set the appropriate status
        adminConfigModuleDet.setUpdatedAt(LocalDateTime.now());
        this.adminconfigmoduledetRepository.saveAndFlush(adminConfigModuleDet);
        return Response.of(Integer.valueOf(id));
    } catch (DataIntegrityViolationException e) {
        throw new AppicationException(e.getMessage());
    }
}

    @Override
    @Transactional
    public Response unblockAdminConfigModuleDet(Integer id) throws AppicationException {
        try {
            final AdminConfigModuleDet adminConfigModuleDet = this.adminConfigModuleDetRepositoryWrapper.findOneWithNotFoundDetection(id);
            adminConfigModuleDet.setValid(true); // Set 'valid' to 1
            adminConfigModuleDet.setStatus(Status.ACTIVE); // Or set the appropriate status
            adminConfigModuleDet.setUpdatedAt(LocalDateTime.now());
            this.adminconfigmoduledetRepository.saveAndFlush(adminConfigModuleDet);
            return Response.of(Integer.valueOf(id));
        } catch (DataIntegrityViolationException e) {
            throw new AppicationException(e.getMessage());
        }
    }
}

