package com.ponsun.aml.banktransaction.FilesStorage.domain;

import com.ponsun.aml.banktransaction.FilesStorage.request.CreateFileStorageRequest;
import com.ponsun.aml.banktransaction.common.entity.Status;
import com.ponsun.aml.banktransaction.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "bank_document")

public class FileStorage extends BaseEntity {
    private static final Integer serialVersionUID = Math.toIntExact(1L);

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "documentType")
    private String documentType;

    @Column(name = "customerId")
    private String customerId;

    @Column(name = "alertId")
    private Integer alertId;

    @Column(name = "pathId")
    private Integer pathId;

    @Column(name = "url")
    private String url;


    public static FileStorage create(final CreateFileStorageRequest createFileStorageRequest){
        final FileStorage fileStorage = new FileStorage();
        fileStorage.setDocumentType(createFileStorageRequest.getDocumentType());
        fileStorage.setCustomerId(createFileStorageRequest.getCustomerId());
        fileStorage.setAlertId(createFileStorageRequest.getAlertId());
        fileStorage.setUrl(createFileStorageRequest.getUrl());
        fileStorage.setStatus(Status.ACTIVE);
        System.out.println("fileStorage"+fileStorage);
        return fileStorage;
    }
}
