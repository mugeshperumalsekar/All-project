package com.ponsun.aml.amlTeam.AmlComplaintStatus.api;

import com.ponsun.aml.amlTeam.AmlComplaintStatus.domain.AmlComplaintStatus;
import com.ponsun.aml.amlTeam.AmlComplaintStatus.request.CreaetAmlComplaintStatuRequest;
import com.ponsun.aml.amlTeam.AmlComplaintStatus.request.UpdateAmlComplaintStatusRequest;
import com.ponsun.aml.amlTeam.AmlComplaintStatus.services.AmlComplaintStatusReadService;
import com.ponsun.aml.amlTeam.AmlComplaintStatus.services.AmlComplaintStatusWriteService;
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
@RequestMapping("/api/v1/AmlComplaintStatus")
@Tag(name = "AmlComplaintStatusApiResources")
public class AmlComplaintStatusApiResources {
    private final AmlComplaintStatusWriteService amlComplaintStatusWriteService;
    private final AmlComplaintStatusReadService amlComplaintStatusReadService;

    @PostMapping("/CreateAmlStatusRequest")
    public Response createAmlStatusList(@RequestBody CreaetAmlComplaintStatuRequest creaetAmlConfigStatuRequest){
        Response response = this.amlComplaintStatusWriteService.createAmlStatusList(creaetAmlConfigStatuRequest);
        return response;
    }
    @PutMapping("/{id}")
    public Response updateAmlStatusList(@PathVariable Integer id, @RequestBody UpdateAmlComplaintStatusRequest updateAmlConfigStatusRequest){
        Response response = this.amlComplaintStatusWriteService.updateAmlStatusList(id, updateAmlConfigStatusRequest);
        return response;
    }
    @GetMapping("/{id}")
    public AmlComplaintStatus fetchAmlStatusById(@PathVariable(name = "id")Integer id) {
        return this.amlComplaintStatusReadService.fetchAmlStatusById(id);
    }

    @GetMapping
    public List<AmlComplaintStatus> fetchAll(){return this.amlComplaintStatusReadService.fetchAllAmlStatus();}

}
