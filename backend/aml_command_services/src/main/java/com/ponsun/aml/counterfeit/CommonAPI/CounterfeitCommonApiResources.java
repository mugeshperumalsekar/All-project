package com.ponsun.aml.counterfeit.CommonAPI;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ponsun.aml.counterfeit.CommonAPI.service.CommonWriteService;
import com.ponsun.aml.infrastructure.utils.Response;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/v1/SaveCounterfeit")
@Tag(name = "SaveCounterfeitApiResource")
public class CounterfeitCommonApiResources {

    private final CommonWriteService commonWriteService;
    @PostMapping("/CreateCounterfeit")
    public Response saveCounterfeit(@RequestParam("counterfeitDTO") String counterfeitDTO) throws JsonProcessingException {
        return this.commonWriteService.saveCounterfeitDetails(counterfeitDTO);
    }
    @GetMapping("/GetCounterfeit/{counterfeitId}")
    public CounterfeitReadDTO getCounterfeit(@PathVariable("counterfeitId") Integer counterfeitId) {
        return this.commonWriteService.getCounterfeit(counterfeitId);
    }

    @PutMapping("/UpdateCounterfeit")
    public Response UpdateCounterfeit(@RequestParam ("CounterfeitDTO") String counterfeitDTO, Integer counterfeitId, Integer euid) {
        return this.commonWriteService.updateCounterfeitDetails(counterfeitDTO,counterfeitId,euid);
    }
}
