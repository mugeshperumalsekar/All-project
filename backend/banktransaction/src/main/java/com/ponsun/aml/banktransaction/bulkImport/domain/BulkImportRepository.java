package com.ponsun.aml.banktransaction.bulkImport.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface BulkImportRepository extends JpaRepository<BulkImport, List>{

    //BulkImport findAll(String name);
}