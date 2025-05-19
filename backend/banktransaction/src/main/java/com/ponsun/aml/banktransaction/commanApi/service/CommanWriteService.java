package com.ponsun.aml.banktransaction.commanApi.service;

import com.ponsun.aml.banktransaction.AuditLog.request.CreateAuditLogRequest;
import com.ponsun.aml.banktransaction.commanApi.CommonReadDTO;
import com.ponsun.aml.banktransaction.infrastructure.utils.Response;
import org.springframework.web.multipart.MultipartFile;

public interface CommanWriteService {
    Response saveCustomer(String CommanDTO, MultipartFile[] files,Integer alertId,
                          String customerId,
                          String imgName);

    CommonReadDTO getCommonDetails();
}
