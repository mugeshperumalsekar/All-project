package com.ponsun.aml.banktransaction.commanApi.service;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ponsun.aml.banktransaction.AuditLog.domain.AuditLog;
import com.ponsun.aml.banktransaction.AuditLog.request.CreateAuditLogRequest;
import com.ponsun.aml.banktransaction.AuditLog.services.AuditLogReadPlatformService;
import com.ponsun.aml.banktransaction.AuditLog.services.AuditLogWritePlatformService;
import com.ponsun.aml.banktransaction.FilesStorage.service.FileStorageWritePlatformService;
import com.ponsun.aml.banktransaction.commanApi.CommanWriteDTO;
import com.ponsun.aml.banktransaction.commanApi.CommonReadDTO;
import com.ponsun.aml.banktransaction.infrastructure.utils.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CommanWriteServiceImpl implements CommanWriteService {

    private final AuditLogWritePlatformService auditLogWritePlatformService;
    private final AuditLogReadPlatformService auditLogReadPlatformService;
    private final FileStorageWritePlatformService fileStorageWritePlatformService;
    @Override
    @Transactional
    public Response saveCustomer(String CommanDTO, MultipartFile[] files,Integer alertId,String customerId, String imgName){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);

        System.out.println("CommanDTO"+CommanDTO);
        System.out.println("alertId"+alertId);
        System.out.println("customerId"+customerId);
        try {
            CommanWriteDTO commanWriteDTO = objectMapper.readValue(CommanDTO, CommanWriteDTO.class);
            CreateAuditLogRequest createAuditLogRequest = commanWriteDTO.getCreateAuditLogRequest();
            System.out.println("createAuditLogRequest: "+createAuditLogRequest);
            Response auditLog = this.auditLogWritePlatformService.createAuditLog(createAuditLogRequest);
            Integer auditId = (Integer) auditLog.getId();
            List<String> messages = new ArrayList<>();

            try {

                for (int j = 0; j < files.length; j++) {
                    if (files[j] != null) {
                        System.out.println("filesa: " + files[j].getOriginalFilename());

                        fileStorageWritePlatformService.documentsave(files[j], alertId, customerId,imgName);
                        messages.add(files[j].getOriginalFilename() + " [Successful]");
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new Response();
    }
    @Override
    public CommonReadDTO getCommonDetails() {
        CommonReadDTO commonReadDTO = new CommonReadDTO();
        List<AuditLog> auditLog = this.auditLogReadPlatformService.fetchAllAuditLog();
        commonReadDTO.setAuditLogs(auditLog);
        return commonReadDTO;

    }
};