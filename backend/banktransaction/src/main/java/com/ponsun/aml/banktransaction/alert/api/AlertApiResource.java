package com.ponsun.aml.banktransaction.alert.api;

import com.ponsun.aml.banktransaction.accountDetails.data.AppicationException;
import com.ponsun.aml.banktransaction.alert.domain.Alert;
import com.ponsun.aml.banktransaction.alert.request.CreateAlertRequest;
import com.ponsun.aml.banktransaction.alert.request.UpdateAlertRequest;
import com.ponsun.aml.banktransaction.alert.services.AlertReadPlatformService;
import com.ponsun.aml.banktransaction.alert.services.AlertWritePlatformService;
import com.ponsun.aml.banktransaction.infrastructure.utils.Response;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/Alert")
@Tag(name = "AlertApiResource")
public class AlertApiResource {

    private final AlertWritePlatformService alertWritePlatformService;
    private final AlertReadPlatformService alertReadPlatformService;
    @PostMapping("/CreateAlertRequest")
    public Response saveAlert(@RequestBody CreateAlertRequest createAlertRequest) throws AppicationException {
        Response response = this.alertWritePlatformService.createAlert(createAlertRequest);
        return response;
    }
    @GetMapping
    public List<Alert> fetchAllAlert()
    { return this.alertReadPlatformService.fetchAllAlert();}

    @GetMapping("/{id}")
    public Alert fetchAlertById(@PathVariable(name = "id")Integer id){
        return this.alertReadPlatformService.fetchAlertById(id);
    }

    @PutMapping("/{id}")
    public Response updateAlert(@PathVariable Integer id, @RequestBody UpdateAlertRequest updateAlertRequest) throws AppicationException {
        Response response = this.alertWritePlatformService.updateAlert(id,updateAlertRequest);
        return  response;
    }
    @PutMapping("/{id}/block")
    public Response blockAlert(@PathVariable Integer id) throws AppicationException {
        Response response = this.alertWritePlatformService.blockAlert(id);
        return response;
    }
    @PutMapping("/{id}/unblock")
    public Response unblockAlert(@PathVariable Integer id) throws AppicationException {
        Response response = this.alertWritePlatformService.unblockAlert(id);
        return  response;
    }
}
