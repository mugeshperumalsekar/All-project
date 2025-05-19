package com.ponsun.aml.banktransaction.infrastructure.fileupload;

public enum FileType {
    XLS("xls"), CSV("csv");

    public String fileType;

    FileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileType() {
        return this.fileType;
    }
}
