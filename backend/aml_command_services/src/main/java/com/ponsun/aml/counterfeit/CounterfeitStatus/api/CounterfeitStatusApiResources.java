package com.ponsun.aml.counterfeit.CounterfeitStatus.api;


import com.ponsun.aml.infrastructure.utils.Response;
import com.ponsun.aml.counterfeit.CounterfeitStatus.domain.CounterfeitStatus;
import com.ponsun.aml.counterfeit.CounterfeitStatus.request.CreateCounterfeitStatusRequest;
import com.ponsun.aml.counterfeit.CounterfeitStatus.request.UpdateCounterfeitStatusRequest;
import com.ponsun.aml.counterfeit.CounterfeitStatus.services.CounterfeitStatusReadService;
import com.ponsun.aml.counterfeit.CounterfeitStatus.services.CounterfeitStatusWriteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/CounterfeitStatus")
@Tag(name = "CounterfeitStatusApiResources")
public class CounterfeitStatusApiResources {

    private final CounterfeitStatusWriteService counterfeitStatusWriteService;
    private final CounterfeitStatusReadService counterfeitStatusReadService;
    @PostMapping("/CreateCounterfeitStatusRequest")
    public Response createCounterfeitStatus(@RequestBody CreateCounterfeitStatusRequest createCounterfeitStatusRequest){
        Response response = this.counterfeitStatusWriteService.createCounterfeitStatus(createCounterfeitStatusRequest);
        return response;
    }
    @PutMapping("/{id}")
    public Response updateCounterfeitStatus(@PathVariable Integer id, @RequestBody UpdateCounterfeitStatusRequest updateCounterfeitStatusRequest){
        Response response = this.counterfeitStatusWriteService.updateCounterfeitStatus(id, updateCounterfeitStatusRequest);
        return response;
    }
    @GetMapping("/{id}")
    public CounterfeitStatus fetchCounterfeitStatusById(@PathVariable(name = "id")Integer id) {
        return this.counterfeitStatusReadService.fetchCounterfeitStatusById(id);
    }

    @GetMapping
    public List<CounterfeitStatus> fetchAll(){return this.counterfeitStatusReadService.fetchAllCounterfeitStatus();
    }
    @PutMapping("/{id}/deActivate")
    public Response deActivate(@RequestParam Integer counterfeitId, @RequestParam Integer euid){
        Response response = this.counterfeitStatusWriteService.deActive(counterfeitId,euid);
        return  response;
    }
}

