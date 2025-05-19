package com.ponsun.aml.banktransaction.alertGet.api;


import com.ponsun.aml.banktransaction.alertGet.domain.AlertGet;
import com.ponsun.aml.banktransaction.alertGet.services.AlertGetReadPlatformService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/AlertGet")
@Tag(name = "AlertGetApiResource")
public class AlertGetApiResource {

    private final AlertGetReadPlatformService alertGetReadPlatformService;

    @GetMapping
    public List<AlertGet> fetchAll() {
        return this.alertGetReadPlatformService.fetchAllAlertGet();
    }

    @GetMapping("/{id}")
    public AlertGet fetchAlertGetById(@PathVariable(name = "id") Integer id) {
        return this.alertGetReadPlatformService.fetchAlertGetById(id);
    }
}
