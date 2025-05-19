package com.ponsun.aml.fraudTeam.FraudTeam.api;

import com.ponsun.aml.fraudTeam.FraudTeam.domain.FraudTeam;
import com.ponsun.aml.fraudTeam.FraudTeam.request.CreateFraudTeamRequest;
import com.ponsun.aml.fraudTeam.FraudTeam.request.UpdateFraudTeamRequest;
import com.ponsun.aml.fraudTeam.FraudTeam.services.FraudTeamReadService;
import com.ponsun.aml.fraudTeam.FraudTeam.services.FraudTeamWriteService;
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
@RequestMapping("/api/v1/FraudTeam")
@Tag(name="FraudTeamApiResources")
public class FraudTeamApiResources {
    private final FraudTeamWriteService fraudTeamWriteService;
    private final FraudTeamReadService fraudTeamReadService;

    @PostMapping("/CreateFraudTeamRequest")
    public Response createFraudTeam(@RequestBody CreateFraudTeamRequest createFraudTeamRequest){
        Response response = this.fraudTeamWriteService.createFraudTeam(createFraudTeamRequest);
        return response;
    }
    @PutMapping("/{id}")
    public Response updateFraudTeam(@PathVariable Integer id,@RequestBody UpdateFraudTeamRequest updateFraudTeamRequest){
        Response response = this.fraudTeamWriteService.updateFraudTeam(id,updateFraudTeamRequest);
        return response;
    }
    @GetMapping("/{id}")
    public FraudTeam fetchFraudTeamById(@PathVariable(name="id")Integer id){
        return this.fraudTeamReadService.fetchFraudTeamById(id);
    }
    @GetMapping
    public List<FraudTeam> fetchAll(){return this.fraudTeamReadService.fetchAllFraudTeam();}
}
