package com.ponsun.aml.banktransaction.levelGet.api;


import com.ponsun.aml.banktransaction.levelGet.domain.LevelGet;
import com.ponsun.aml.banktransaction.levelGet.services.LevelGetReadPlatformService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/LevelGet")
@Tag(name = "LevelGetApiResource")
public class LevelGetApiResource {

    private final LevelGetReadPlatformService levelGetReadPlatformService;

    @GetMapping
    public List<LevelGet> fetchAll() {
        return this.levelGetReadPlatformService.fetchAllLevelDet();
    }

    @GetMapping("/{id}")
    public LevelGet fetchLevelGetById(@PathVariable(name = "id") Integer id) {
        return this.levelGetReadPlatformService.fetchLevelDetById(id);
    }
}
