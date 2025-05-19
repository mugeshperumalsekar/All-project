package com.ponsun.aml.scamTeam.ScamCommonAPI;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ponsun.aml.scamTeam.ScamCommonAPI.service.ScamCommonWriteService;
import com.ponsun.aml.infrastructure.utils.Response;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/v1/SaveScam")
@Tag(name = "SaveScamApiResources")
public class ScamCommonApiResources {
    private final ScamCommonWriteService scamCommonWriteService;

    @PostMapping("/CreateScam")
    public Response saveScam(@RequestParam("scamDTO")String scamDTO) throws JsonProcessingException{
     return this.scamCommonWriteService.saveScamDetails(scamDTO);
    }

    @GetMapping("/GetScam/{scamId}")
    public ScamReadDTO getScam(@PathVariable("scamId")Integer scamId){
      return this.scamCommonWriteService.getScam(scamId);
    }

    @PutMapping("/UpdateScam")
    public Response UpdateScam(@RequestParam ("ScamDTO") String scamDTO,Integer scamId,Integer euid){
      return this.scamCommonWriteService.updateScamDetails(scamDTO,scamId,euid);
    }
}
