package com.ponsun.aml.banktransaction.FilesStorage.api;

import com.ponsun.aml.banktransaction.FilesStorage.service.FileDownloadUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.ponsun.aml.banktransaction.FilesStorage.service.FileStorageWritePlatformService;
import org.springframework.jdbc.core.JdbcTemplate;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/v1/Document")
@Tag(name = "DocumentApiResource")
public class FileStorageApiResource {
    private final JdbcTemplate jdbcTemplate;
    private final FileStorageWritePlatformService fileStorageWritePlatformService;

    @PostMapping("/files/upload")
    public ResponseEntity<String> uploadFiles(
            @RequestParam("files") MultipartFile[] files,
            Integer alertId,
            String customerId,String imgName
    ) {
        List<String> messages = new ArrayList<>();


        try {
            for (int j = 0; j < files.length; j++) {
                fileStorageWritePlatformService.documentsave(files[j],alertId, customerId,imgName);
                messages.add(files[j].getOriginalFilename() + " [Successful]");
            }
            return ResponseEntity.ok(messages.toString());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred: " + e.getMessage());
        }
    }

    @GetMapping("/downloadDocument/{customerId}")
    public ResponseEntity<?> downloadDocument(@PathVariable("customerId") String customerId,Integer alertId) {
        FileDownloadUtil downloadUtil = new FileDownloadUtil();

        System.out.println("customerId: "+ customerId);
        System.out.println("alertId: "+ alertId);
        Resource resource = null;
        String documentName =getDocument(alertId,customerId);
        try {
            resource = (Resource) downloadUtil.getDocument(customerId,documentName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (resource == null) {
            return new ResponseEntity<>("Document not found", HttpStatus.NOT_FOUND);
        }

        String contentType = "application/octet-stream";
        String headerValue = "attachment; filename=\"" + resource.getFilename() + "\"";

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, headerValue)
                .body(resource);
    }

    public String getDocument(Integer alertId,String customerId) {
        try {
            String sql = "SELECT id FROM bank_document WHERE alertId=? AND customerId=? AND STATUS='0'";
            String documentType = jdbcTemplate.queryForObject(sql, String.class,alertId, customerId);
            return documentType;

        } catch (DataAccessException e) {
            System.err.println("Error updating the document: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

}
