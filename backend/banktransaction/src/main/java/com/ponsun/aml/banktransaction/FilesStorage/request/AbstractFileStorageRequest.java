package com.ponsun.aml.banktransaction.FilesStorage.request;

import lombok.Data;

@Data
public class AbstractFileStorageRequest {

    private Integer id;
    private String documentType;
    private Integer alertId;
    private String customerId;
    private String dt;
    private String url;
}
