package com.ponsun.aml.fraudTeam.FraudCommonAPI;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ponsun.aml.fraudTeam.FraudCommonAPI.service.FraudCommonWriteService;
import com.ponsun.aml.infrastructure.utils.Response;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/v1/SaveFraud")
@Tag(name = "SaveFraudApiResources")
public class FraudCommonApiResources {
    private final FraudCommonWriteService fraudCommonWriteService;

    @PostMapping("/CreateFraud")
    public Response saveFraud(@RequestParam("fraudDTO")String fraudDTO) throws JsonProcessingException{
     return this.fraudCommonWriteService.saveFraudDetails(fraudDTO);
    }

    @GetMapping("/GetFraud/{fraudId}")
    public FraudReadDTO getFraud(@PathVariable("fraudId")Integer fraudId){
      return this.fraudCommonWriteService.getFraud(fraudId);
    }

    @PutMapping("/UpdateFraud")
    public Response UpdateFraud(@RequestParam ("FraudDTO") String fraudDTO,Integer fraudId,Integer euid){
      return this.fraudCommonWriteService.updateFraudDetails(fraudDTO,fraudId,euid);
    }
}
