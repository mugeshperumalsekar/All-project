package com.ponsun.aml.banktransaction.FilesStorage.data;

import lombok.Data;

@Data
public class FileStorageData {

    private Integer id;
    private String documentType;
    private String customerId;
    private Integer alertId;

    private String dt;
    private String url;

    public FileStorageData(final Integer id,final String documentType,  final String customerId, final Integer alertId, final String dt, final String url ) {
        this.id=id;
        this.documentType=documentType;
        this.customerId=customerId;
        this.alertId=alertId;
        this.dt=dt;
        this.url=url;
    }
    public static FileStorageData newInstance(final Integer id,final String documentType,  final String customerId,final Integer alertId, final String dt, final String url ) {
        return new FileStorageData(id,documentType,customerId,alertId,dt,url);
    }
}

