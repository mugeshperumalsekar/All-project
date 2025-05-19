package com.ponsun.aml.scamTeam.ScamObservation.api;

import com.ponsun.aml.scamTeam.ScamObservation.domain.ScamObservation;
import com.ponsun.aml.scamTeam.ScamObservation.request.CreateScamObservationRequest;
import com.ponsun.aml.scamTeam.ScamObservation.request.UpdateScamObservationRequest;
import com.ponsun.aml.scamTeam.ScamObservation.services.ScamObservationReadService;
import com.ponsun.aml.scamTeam.ScamObservation.services.ScamObservationWriteService;
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
@RequestMapping("/api/v1/ScamObservation")
@Tag(name ="ScamObservationApiResources")
public class ScamObservationApiResources {
    private final ScamObservationWriteService scamObservationWriteService;
    private final ScamObservationReadService scamObservationReadService;

    @PostMapping("/CreateScamObservationRequest")
    public Response createScamObservation(@RequestBody CreateScamObservationRequest createScamObservationRequest){
        Response response = this.scamObservationWriteService.createScamObservation(createScamObservationRequest);
        return response;
    }
    @PutMapping("/{id}")
    public Response updateScamObservation(@PathVariable Integer id,@RequestBody UpdateScamObservationRequest updateScamObservationRequest){
       Response response = this.scamObservationWriteService.updateScamObservation(id,updateScamObservationRequest);
       return  response;
    }

    @GetMapping("/{id}")
   public ScamObservation fetchScamObservationById(@PathVariable(name = "id")Integer id){
        return this.scamObservationReadService.fetchScamObservationById(id);
    }
    @GetMapping
    public List<ScamObservation> fetchAll() {return this.scamObservationReadService.fetchAllScamObservation();}

    @PutMapping("/{id}/deActive")
    public Response deActive(@RequestParam Integer scamId,@RequestParam Integer euid){
        Response response = this.scamObservationWriteService.deActive(scamId,euid);
        return response;
    }
}
