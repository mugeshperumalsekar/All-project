package com.ponsun.aml.banktransaction.bulkImport.domain;

import com.ponsun.aml.banktransaction.bulkImport.request.AbstractBulkImportBaseRequest;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class BulkImportRepositoryWrapper {
    private final BulkImportRepository bulkImportRepository;

    @Transactional
    public BulkImport saveDataFromExcel(Map<String, Object> excelData) {
        // Here, you can convert the map to a BulkImport entity and save it to the repository
        BulkImport bulkImport = new BulkImport();
        bulkImport.setSenderAccount(excelData.get("Name").toString());
        // Set other fields as needed
        return bulkImportRepository.save(bulkImport);
    }
}