package com.ponsun.aml.amlTeam.AmlConfigStatus.api;

import com.ponsun.aml.amlTeam.AmlConfigStatus.domain.AmlConfigStatus;
import com.ponsun.aml.amlTeam.AmlConfigStatus.request.CreateAmlConfigStatusRequest;
import com.ponsun.aml.amlTeam.AmlConfigStatus.request.UpdateAmlConfigStatusRequest;
import com.ponsun.aml.amlTeam.AmlConfigStatus.services.AmlConfigStatusReadService;
import com.ponsun.aml.amlTeam.AmlConfigStatus.services.AmlConfigStatusWriteService;
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
@RequestMapping("/api/v1/AmlConfigStatus")
@Tag(name="AmlConfigStatusApiResources")
public class AmlConfigStatusApiResources {
    private final AmlConfigStatusWriteService amlConfigStatusWriteService;
    private final AmlConfigStatusReadService amlConfigStatusReadService;

    @PostMapping("/CreateAmlConfigStatusRequest")
    public Response createAmlConfigStatus(@RequestBody CreateAmlConfigStatusRequest createAmlConfigStatusRequest){
        Response response = this.amlConfigStatusWriteService.createAmlConfigStatus(createAmlConfigStatusRequest);
        return response;
    }
    @PutMapping("/{id}")
    public Response updateAmlConfigStatus(@PathVariable Integer id, @RequestBody UpdateAmlConfigStatusRequest updateAmlConfigStatusRequest){
        Response response = this.amlConfigStatusWriteService.updateAmlConfigStatus(id,updateAmlConfigStatusRequest);
        return response;
    }
    @GetMapping("/{id}")
    public AmlConfigStatus fetchAmlConfigStatusById(@PathVariable(name="id")Integer id){
        return this.amlConfigStatusReadService.fetchAmlConfigStatusById(id);
    }
    @GetMapping
    public List<AmlConfigStatus> fetchAll(){return this.amlConfigStatusReadService.fetchAllAmlConfigStatus();}
}
