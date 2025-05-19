package com.ponsun.aml.scamTeam.ScamStatus.api;

import com.ponsun.aml.scamTeam.ScamStatus.domain.ScamStatus;
import com.ponsun.aml.scamTeam.ScamStatus.request.CreateScamStatusRequest;
import com.ponsun.aml.scamTeam.ScamStatus.request.UpdateScamStatusRequest;
import com.ponsun.aml.scamTeam.ScamStatus.services.ScamStatusWriteService;
import com.ponsun.aml.scamTeam.ScamStatus.services.ScamStatusReadService;
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
@RequestMapping("/api/v1/ScamStatus")
@Tag(name ="ScamStatusApiResources")
public class ScamStatusApiResources {
    private final ScamStatusWriteService scamStatusWriteService;
    private final ScamStatusReadService scamStatusReadService;

    @PostMapping("/CreateScamStatusRequest")
    public Response createScamStatus(@RequestBody CreateScamStatusRequest createScamStatusRequest){
        Response response = this.scamStatusWriteService.createScamStatus(createScamStatusRequest);
        return response;
    }
    @PutMapping("/{id}")
    public Response updateScamStatus(@PathVariable Integer id, @RequestBody UpdateScamStatusRequest updateScamStatusRequest){
        Response response = this.scamStatusWriteService.updateScamStatus(id,updateScamStatusRequest);
        return response;
    }

    @GetMapping("/{id}")
    public ScamStatus fetchScamStatusById(@PathVariable(name="id")Integer id){
        return  this.scamStatusReadService.fetchStatusById(id);
    }
    @GetMapping
    public List<ScamStatus> fetchAll(){return this.scamStatusReadService.fetchAllStatus();}

    @PutMapping("/{id}/deActivate")
    public Response deActivate(@RequestParam Integer scamId,@RequestParam Integer euid){
      Response response = this.scamStatusWriteService.deActive(scamId,euid);
      return response;
    }
}
