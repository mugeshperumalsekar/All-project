package com.ponsun.aml.banktransaction.levelGet.services;

import com.ponsun.aml.banktransaction.levelGet.domain.LevelGet;

import java.util.List;

public interface LevelGetReadPlatformService {
    List<LevelGet> fetchAllLevelDet();

    LevelGet fetchLevelDetById(Integer id);
}
