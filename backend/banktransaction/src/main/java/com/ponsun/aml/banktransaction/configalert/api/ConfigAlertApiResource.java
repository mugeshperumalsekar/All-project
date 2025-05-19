package com.ponsun.aml.banktransaction.configalert.api;

import com.ponsun.aml.banktransaction.accountDetails.data.AppicationException;
import com.ponsun.aml.banktransaction.configalert.domain.ConfigAlert;
import com.ponsun.aml.banktransaction.configalert.request.CreateConfigAlertRequest;
import com.ponsun.aml.banktransaction.configalert.services.ConfigAlertReadPlatformService;
import com.ponsun.aml.banktransaction.infrastructure.utils.Response;
import com.ponsun.aml.banktransaction.configalert.request.UpdateConfigAlertRequest;
import com.ponsun.aml.banktransaction.configalert.services.ConfigAlertWritePlatformService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/ConfigAlert")
@Tag(name = "ConfigAlertApiResource")
public class ConfigAlertApiResource {

    private final ConfigAlertWritePlatformService configAlertWritePlatformService;
    private final ConfigAlertReadPlatformService configAlertReadPlatformService;
    @PostMapping("/CreateAlertRequest")
    public Response saveAlert(@RequestBody CreateConfigAlertRequest createConfigAlertRequest) {
        Response response = this.configAlertWritePlatformService.createAlert(createConfigAlertRequest);
        return response;
    }
    @GetMapping
    public List<ConfigAlert> fetchAllAlert()
    { return this.configAlertReadPlatformService.fetchAllAlert();}

    @GetMapping("/{id}")
    public ConfigAlert fetchAlertById(@PathVariable(name = "id")Integer id){
        return this.configAlertReadPlatformService.fetchAlertById(id);
    }

}
