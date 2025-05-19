package com.ponsun.aml.fraudTeam.FraudObservation.api;

import com.ponsun.aml.fraudTeam.FraudObservation.domain.FraudObservation;
import com.ponsun.aml.fraudTeam.FraudObservation.request.CreateFraudObservationRequest;
import com.ponsun.aml.fraudTeam.FraudObservation.request.UpdateFraudObservationRequest;
import com.ponsun.aml.fraudTeam.FraudObservation.services.FraudObservationReadService;
import com.ponsun.aml.fraudTeam.FraudObservation.services.FraudObservationWriteService;
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
@RequestMapping("/api/v1/FraudObservation")
@Tag(name ="FraudObservationApiResources")
public class FraudObservationApiResources {
    private final FraudObservationWriteService fraudObservationWriteService;
    private final FraudObservationReadService fraudObservationReadService;

    @PostMapping("/CreateFraudObservationRequest")
    public Response createFraudObservation(@RequestBody CreateFraudObservationRequest createFraudObservationRequest){
        Response response = this.fraudObservationWriteService.createFraudObservation(createFraudObservationRequest);
        return response;
    }
    @PutMapping("/{id}")
    public Response updateFraudObservation(@PathVariable Integer id,@RequestBody UpdateFraudObservationRequest updateFraudObservationRequest){
       Response response = this.fraudObservationWriteService.updateFraudObservation(id,updateFraudObservationRequest);
       return  response;
    }

    @GetMapping("/{id}")
   public FraudObservation fetchFraudObservationById(@PathVariable(name = "id")Integer id){
        return this.fraudObservationReadService.fetchFraudObservationById(id);
    }
    @GetMapping
    public List<FraudObservation> fetchAll() {return this.fraudObservationReadService.fetchAllFraudObservation();}

    @PutMapping("/{id}/deActive")
    public Response deActive(@RequestParam Integer fraudId,@RequestParam Integer euid){
        Response response = this.fraudObservationWriteService.deActive(fraudId,euid);
        return response;
    }
}
