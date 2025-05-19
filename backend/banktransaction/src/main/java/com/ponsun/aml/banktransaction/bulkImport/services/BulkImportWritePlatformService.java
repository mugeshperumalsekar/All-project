package com.ponsun.aml.banktransaction.bulkImport.services;

import com.ponsun.aml.banktransaction.bulkImport.request.CreateBulkImportRequest;
import com.ponsun.aml.banktransaction.infrastructure.utils.Response;

import java.util.List;
import java.util.Map;

public interface BulkImportWritePlatformService {
    Response saveBulkData(List<Map<String, Object>> data);
}
