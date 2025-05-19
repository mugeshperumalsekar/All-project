package com.ponsun.aml.adminconfiguration.adminconfigmoduledet.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminConfigModuleDetRepository extends JpaRepository<AdminConfigModuleDet, Integer>{
    Optional<AdminConfigModuleDet> findById(Integer id);

//    List<AdminConfigModuleDet> findBycmsId(Integer cmsId);
}