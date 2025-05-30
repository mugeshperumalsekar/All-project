package com.ponsun.aml.banktransaction.FilesStorage.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileStorageRepository extends JpaRepository<FileStorage, Integer> {
    Optional<FileStorage> findById(Integer id);
}
