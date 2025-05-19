package com.ponsun.aml.banktransaction.AlertGeneration.api;

import com.ponsun.aml.banktransaction.AlertGeneration.services.AlertGenerationWriteService;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/alerts")
//@Api(tags = "Alert Generation")
public class AlertGenerationApi {

    private final AlertGenerationWriteService alertGenerationWriteService;

//    public AlertGenerationApi(AlertGenerationWriteService alertGenerationService) {
//        this.alertGenerationWriteService = alertGenerationService;
//    }

    @PostMapping("/generate")
    public String generateAlerts() {
        alertGenerationWriteService.generateAlerts();
        return "Alerts generated successfully!";
    }
}

