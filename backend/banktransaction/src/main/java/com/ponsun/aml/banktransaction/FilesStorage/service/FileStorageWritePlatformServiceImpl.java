package com.ponsun.aml.banktransaction.FilesStorage.service;


import com.ponsun.aml.banktransaction.AuditLog.services.AuditLogWritePlatformService;
import com.ponsun.aml.banktransaction.FilesStorage.domain.FileStorage;
import com.ponsun.aml.banktransaction.FilesStorage.domain.FileStorageRepository;
import com.ponsun.aml.banktransaction.FilesStorage.request.CreateFileStorageRequest;
import com.ponsun.aml.banktransaction.infrastructure.utils.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
@Slf4j
public class FileStorageWritePlatformServiceImpl implements FileStorageWritePlatformService {
    private final JdbcTemplate jdbcTemplate;
    private final FileStorageRepository fileStorageRepository;
    private final AuditLogWritePlatformService auditLogWritePlatformService;

    private final String baseRoot = "D:\\uploadImages";

    @Override
    @Transactional
    public Response createFileStorage(CreateFileStorageRequest createFileStorageRequest) {
        try {
            final FileStorage fileStorage = FileStorage.create(createFileStorageRequest);
            this.fileStorageRepository.saveAndFlush(fileStorage);
            log.info("File storage created successfully with ID: {}", fileStorage.getId());

            return Response.of(fileStorage.getId());
        } catch (Exception e) {
            log.error("Error creating file storage:", e);
            throw new RuntimeException("Error creating file storage", e);
        }
    }


    @Override
    @Transactional
    public void documentsave(MultipartFile documentfiles,Integer alertId, String customerId, String imgName) {
        String resolvedRootDirectory = "";
        resolvedRootDirectory = "bankDocument\\Bank";

        Path root = Paths.get(baseRoot, resolvedRootDirectory);
        updatecompanyDocument(imgName);
        try {

            String fileExtensions = "";
            fileExtensions = documentfiles.getOriginalFilename().substring(documentfiles.getOriginalFilename().lastIndexOf(".") + 1);
            System.out.println("fileExtensions :" + fileExtensions);

            String folderName = customerId.toString();
            Path folderPath = root.resolve(folderName);
            Files.createDirectories(folderPath);
            System.out.println("File saved: " + folderPath);


            CreateFileStorageRequest createFileStorageRequest = new CreateFileStorageRequest();
            createFileStorageRequest.setDocumentType(fileExtensions);
            createFileStorageRequest.setAlertId(alertId);
            createFileStorageRequest.setCustomerId(customerId);
            createFileStorageRequest.setUrl(folderPath.toString());

            Response response = createFileStorage(createFileStorageRequest);
            Integer imageId = (Integer) response.getId();
            System.out.println("imageId"+imageId);

            String filename = imageId + "." + fileExtensions;
            Files.copy(documentfiles.getInputStream(), folderPath.resolve(filename));

        } catch (NullPointerException e) {
            throw new RuntimeException("File storage service is currently unavailable. Please try again later.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updatecompanyDocument(String id) {
        try {
            String sql = "UPDATE `bank_document` SET STATUS = '1', updated_at = NOW() WHERE id = ? AND status ='0'";
            jdbcTemplate.update(sql, id);
        } catch (DataAccessException e) {
            System.err.println("Error updating the document: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

