package com.ponsun.aml.fraudTeam.FraudStatus.api;

import com.ponsun.aml.fraudTeam.FraudStatus.domain.FraudStatus;
import com.ponsun.aml.fraudTeam.FraudStatus.request.CreateFraudStatusRequest;
import com.ponsun.aml.fraudTeam.FraudStatus.request.UpdateFraudStatusRequest;
import com.ponsun.aml.fraudTeam.FraudStatus.services.FraudStatusWriteService;
import com.ponsun.aml.fraudTeam.FraudStatus.services.FraudStatusReadService;
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
@RequestMapping("/api/v1/FraudStatus")
@Tag(name ="FraudStatusApiResources")
public class FraudStatusApiResources {
    private final FraudStatusWriteService fraudStatusWriteService;
    private final FraudStatusReadService fraudStatusReadService;

    @PostMapping("/CreateFraudStatusRequest")
    public Response createFraudStatus(@RequestBody CreateFraudStatusRequest createFraudStatusRequest){
        Response response = this.fraudStatusWriteService.createFraudStatus(createFraudStatusRequest);
        return response;
    }
    @PutMapping("/{id}")
    public Response updateFraudStatus(@PathVariable Integer id, @RequestBody UpdateFraudStatusRequest updateFraudStatusRequest){
        Response response = this.fraudStatusWriteService.updateFraudStatus(id,updateFraudStatusRequest);
        return response;
    }

    @GetMapping("/{id}")
    public FraudStatus fetchFraudStatusById(@PathVariable(name="id")Integer id){
        return  this.fraudStatusReadService.fetchStatusById(id);
    }
    @GetMapping
    public List<FraudStatus> fetchAll(){return this.fraudStatusReadService.fetchAllStatus();}

    @PutMapping("/{id}/deActivate")
    public Response deActivate(@RequestParam Integer fraudId,@RequestParam Integer euid){
      Response response = this.fraudStatusWriteService.deActive(fraudId,euid);
      return response;
    }

}
