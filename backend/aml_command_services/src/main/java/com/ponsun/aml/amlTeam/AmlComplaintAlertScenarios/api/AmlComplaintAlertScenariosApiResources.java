package com.ponsun.aml.amlTeam.AmlComplaintAlertScenarios.api;

import com.ponsun.aml.amlTeam.AmlComplaintAlertScenarios.domain.AmlComplaintAlertScenarios;
import com.ponsun.aml.amlTeam.AmlComplaintAlertScenarios.request.CreateAmlComplaintAlertScenariosRequest;
import com.ponsun.aml.amlTeam.AmlComplaintAlertScenarios.request.UpdateAmlComplaintAlertScenariosRequest;
import com.ponsun.aml.amlTeam.AmlComplaintAlertScenarios.services.AmlComplaintAlertScenariosReadServices;
import com.ponsun.aml.amlTeam.AmlComplaintAlertScenarios.services.AmlComplaintAlertScenariosWriteService;
import com.ponsun.aml.infrastructure.utils.Response;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/AmlComplaintAlertScenarios")
@Tag(name = "AmlComplaintAlertScenariosApiResources")
public class AmlComplaintAlertScenariosApiResources {
    private final AmlComplaintAlertScenariosWriteService amlComplaintAlertScenariosWriteService;
    private final AmlComplaintAlertScenariosReadServices amlComplaintAlertScenariosReadServices;

    @PostMapping("/CreateAmlComplaintRemarkRequest")
    public Response createAlertScenariosList(@RequestBody CreateAmlComplaintAlertScenariosRequest createAmlComplaintAlertScenariosRequest){
        Response response = this.amlComplaintAlertScenariosWriteService.createAlertScenariosList(createAmlComplaintAlertScenariosRequest);
        return response;
    }
    @PutMapping("/{id}")
    public Response updateAlertScenariosList(@PathVariable Integer id, @RequestBody UpdateAmlComplaintAlertScenariosRequest updateAmlComplaintAlertScenariosRequest){
        Response response = this.amlComplaintAlertScenariosWriteService.updateAlertScenariosList(id, updateAmlComplaintAlertScenariosRequest);
        return response;
    }
    @GetMapping("/{id}")
    public AmlComplaintAlertScenarios fetchAlertScenariosById(@PathVariable(name = "id")Integer id) {
        return this.amlComplaintAlertScenariosReadServices.fetchAlertScenariosById(id);
    }

    @GetMapping
    public List<AmlComplaintAlertScenarios> fetchAll(){return this.amlComplaintAlertScenariosReadServices.fetchAllAlertScenarios();}

}
