package com.ponsun.aml.scamTeam.ScamRemark.api;

import com.ponsun.aml.scamTeam.ScamRemark.domain.ScamRemark;
import com.ponsun.aml.scamTeam.ScamRemark.request.CreateScamRemarkRequest;
import com.ponsun.aml.scamTeam.ScamRemark.request.UpdateScamRemarkRequest;
import com.ponsun.aml.scamTeam.ScamRemark.services.ScamRemarkReadService;
import com.ponsun.aml.scamTeam.ScamRemark.services.ScamRemarkWriteService;
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
@RequestMapping("/api/v1/ScamRemark")
@Tag(name ="ScamRemarkApiResource")
public class ScamRemarkApiResources {
    private final ScamRemarkWriteService scamRemarkWriteService;
    private final ScamRemarkReadService scamRemarkReadService;

    @PostMapping("/CreateScamRemarkRequest")
    public Response createScamRemark(@RequestBody CreateScamRemarkRequest createScamRemarkRequest){
        Response response = this.scamRemarkWriteService.createScamRemark(createScamRemarkRequest);
        return response;
    }

    @PutMapping("/{id}")
    public Response updateScamRemark(@PathVariable Integer id, @RequestBody UpdateScamRemarkRequest updateScamRemarkRequest){
        Response response = this.scamRemarkWriteService.updateScamRemark(id,updateScamRemarkRequest);
        return response;
    }
    @GetMapping("/{id}")
    public ScamRemark fetchScamRemarkById(@PathVariable(name="id")Integer id){
        return this.scamRemarkReadService.fetchRemarkById(id);
    }
    @GetMapping
    public List<ScamRemark> fetchAll() {return this.scamRemarkReadService.fetchAllRemark();}

    @PutMapping("/{id}/deActivate")
    public Response deActivate(@RequestParam Integer scamId,@RequestParam Integer euid){
        Response response = this.scamRemarkWriteService.deActive(scamId,euid);
        return response;
    }
}
