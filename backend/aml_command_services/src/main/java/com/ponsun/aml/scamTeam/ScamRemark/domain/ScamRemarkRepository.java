package com.ponsun.aml.scamTeam.ScamRemark.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScamRemarkRepository extends JpaRepository<ScamRemark,Integer> {
   List<ScamRemark> findByScamId(Integer scamId);
}
