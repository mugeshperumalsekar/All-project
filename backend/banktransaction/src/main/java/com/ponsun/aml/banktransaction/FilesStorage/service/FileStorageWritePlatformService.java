package com.ponsun.aml.banktransaction.FilesStorage.service;


import com.ponsun.aml.banktransaction.FilesStorage.request.CreateFileStorageRequest;
import com.ponsun.aml.banktransaction.infrastructure.utils.Response;
import org.springframework.web.multipart.MultipartFile;

public interface FileStorageWritePlatformService {
    Response createFileStorage(CreateFileStorageRequest createFileStorageRequest);

    void documentsave(MultipartFile documentfiles,Integer alertId, String customerId, String imgName);

    void updatecompanyDocument(String id);
}
