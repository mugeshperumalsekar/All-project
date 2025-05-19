package com.ponsun.aml.fraudTeam.FraudRemark.api;

import com.ponsun.aml.fraudTeam.FraudRemark.domain.FraudRemark;
import com.ponsun.aml.fraudTeam.FraudRemark.request.CreateFraudRemarkRequest;
import com.ponsun.aml.fraudTeam.FraudRemark.request.UpdateFraudRemarkRequest;
import com.ponsun.aml.fraudTeam.FraudRemark.services.FraudRemarkReadService;
import com.ponsun.aml.fraudTeam.FraudRemark.services.FraudRemarkWriteService;
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
@RequestMapping("/api/v1/FraudRemark")
@Tag(name ="FraudRemarkApiResource")
public class FraudRemarkApiResources {
    private final FraudRemarkWriteService fraudRemarkWriteService;
    private final FraudRemarkReadService fraudRemarkReadService;

    @PostMapping("/CreateFraudRemarkRequest")
    public Response createFraudRemark(@RequestBody CreateFraudRemarkRequest createFraudRemarkRequest){
        Response response = this.fraudRemarkWriteService.createFraudRemark(createFraudRemarkRequest);
        return response;
    }

    @PutMapping("/{id}")
    public Response updateFraudRemark(@PathVariable Integer id, @RequestBody UpdateFraudRemarkRequest updateFraudRemarkRequest){
        Response response = this.fraudRemarkWriteService.updateFraudRemark(id,updateFraudRemarkRequest);
        return response;
    }
    @GetMapping("/{id}")
    public FraudRemark fetchFraudRemarkById(@PathVariable(name="id")Integer id){
        return this.fraudRemarkReadService.fetchRemarkById(id);
    }
    @GetMapping
    public List<FraudRemark> fetchAll() {return this.fraudRemarkReadService.fetchAllRemark();}

    @PutMapping("/{id}/deActivate")
    public Response deActivate(@RequestParam Integer fraudId,@RequestParam Integer euid){
        Response response = this.fraudRemarkWriteService.deActive(fraudId,euid);
        return response;
    }
}
