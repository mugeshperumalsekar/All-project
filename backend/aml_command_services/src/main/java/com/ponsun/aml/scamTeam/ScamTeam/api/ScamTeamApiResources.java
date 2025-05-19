package com.ponsun.aml.scamTeam.ScamTeam.api;

import com.ponsun.aml.scamTeam.ScamTeam.domain.ScamTeam;
import com.ponsun.aml.scamTeam.ScamTeam.request.CreateScamTeamRequest;
import com.ponsun.aml.scamTeam.ScamTeam.request.UpdateScamTeamRequest;
import com.ponsun.aml.scamTeam.ScamTeam.services.ScamTeamReadService;
import com.ponsun.aml.scamTeam.ScamTeam.services.ScamTeamWriteService;
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
@RequestMapping("/api/v1/ScamTeam")
@Tag(name="ScamTeamApiResources")
public class ScamTeamApiResources {
    private final ScamTeamWriteService scamTeamWriteService;
    private final ScamTeamReadService scamTeamReadService;

    @PostMapping("/CreateScamTeamRequest")
    public Response createScamTeam(@RequestBody CreateScamTeamRequest createScamTeamRequest){
        Response response = this.scamTeamWriteService.createScamTeam(createScamTeamRequest);
        return response;
    }
    @PutMapping("/{id}")
    public Response updateScamTeam(@PathVariable Integer id,@RequestBody UpdateScamTeamRequest updateScamTeamRequest){
        Response response = this.scamTeamWriteService.updateScamTeam(id,updateScamTeamRequest);
        return response;
    }
    @GetMapping("/{id}")
    public ScamTeam fetchScamTeamById(@PathVariable(name="id")Integer id){
        return this.scamTeamReadService.fetchScamTeamById(id);
    }
    @GetMapping
    public List<ScamTeam> fetchAll(){return this.scamTeamReadService.fetchAllScamTeam();}
}
