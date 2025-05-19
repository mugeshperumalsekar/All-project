package com.ponsun.aml.amlTeam.AmlConfigAlertScenarios.api;

import com.ponsun.aml.amlTeam.AmlConfigAlertScenarios.domain.AmlConfigAlertScenarios;
import com.ponsun.aml.amlTeam.AmlConfigAlertScenarios.request.CreateAbstractAmlConfigAlertScenariosRequest;
import com.ponsun.aml.amlTeam.AmlConfigAlertScenarios.request.UpdateAbstractAmlConfigAlertScenariosRequest;
import com.ponsun.aml.amlTeam.AmlConfigAlertScenarios.services.AmlConfigAlertScenariosReadService;
import com.ponsun.aml.amlTeam.AmlConfigAlertScenarios.services.AmlConfigAlertScenariosWriteService;
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
@RequestMapping("/api/v1/AmlConfigAlertScenarios")
@Tag(name = "AmlConfigAlertScenariosApiResources")
public class AmlConfigAlertScenariosApiResources {
    private final AmlConfigAlertScenariosWriteService amlConfigAlertScenariosWriteService;
    private final AmlConfigAlertScenariosReadService amlConfigAlertScenariosReadService;

    @PostMapping("/CreateAlertConfigScenariosRequest")
    public Response createAlertScenariosList(@RequestBody CreateAbstractAmlConfigAlertScenariosRequest createAlertScenariosRequest){
        Response response = this.amlConfigAlertScenariosWriteService.createAlertScenariosList(createAlertScenariosRequest);
        return response;
    }
    @PutMapping("/{id}")
    public Response updateAlertScenariosList(@PathVariable Integer id, @RequestBody UpdateAbstractAmlConfigAlertScenariosRequest updateAlertScenariosRequest){
        Response response = this.amlConfigAlertScenariosWriteService.updateAlertScenariosList(id, updateAlertScenariosRequest);
        return response;
    }
    @GetMapping("/{id}")
    public AmlConfigAlertScenarios fetchAlertScenariosById(@PathVariable(name = "id")Integer id) {
        return this.amlConfigAlertScenariosReadService.fetchAlertScenariosById(id);
    }

    @GetMapping
    public List<AmlConfigAlertScenarios> fetchAll(){return this.amlConfigAlertScenariosReadService.fetchAllAlertScenarios();}

}
