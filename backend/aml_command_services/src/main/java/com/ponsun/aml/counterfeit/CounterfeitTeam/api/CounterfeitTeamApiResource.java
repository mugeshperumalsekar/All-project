package com.ponsun.aml.counterfeit.CounterfeitTeam.api;


import com.ponsun.aml.infrastructure.utils.Response;
import com.ponsun.aml.counterfeit.CounterfeitTeam.domain.CounterfeitTeam;
import com.ponsun.aml.counterfeit.CounterfeitTeam.request.CreateCounterfeitTeamRequest;
import com.ponsun.aml.counterfeit.CounterfeitTeam.request.UpdateCounterfeitTeamRequest;
import com.ponsun.aml.counterfeit.CounterfeitTeam.services.CounterfeitTeamReadService;
import com.ponsun.aml.counterfeit.CounterfeitTeam.services.CounterfeitTeamWriteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/CounterfeitTeam")
@Tag(name = "CounterfeitTeamApiResources")
public class CounterfeitTeamApiResource {
    private final CounterfeitTeamWriteService counterfeitTeamWriteService;
    private final CounterfeitTeamReadService counterfeitTeamReadService;

    @PostMapping("/CreateCounterfeitTeamRequest")
    public Response createCounterfeitTeam(@RequestBody CreateCounterfeitTeamRequest createCounterfeitTeamRequest){
        Response response = this.counterfeitTeamWriteService.createCounterfeitTeam(createCounterfeitTeamRequest);
        return response;
    }
    @PutMapping("/{id}")
    public Response updateCounterfeitTeam(@PathVariable Integer id, @RequestBody UpdateCounterfeitTeamRequest updateCounterfeitTeamRequest){
        Response response = this.counterfeitTeamWriteService.updateCounterfeitTeam(id, updateCounterfeitTeamRequest);
        return response;
    }

    @GetMapping("/{id}")
    public CounterfeitTeam fetchCounterfeitTeamById(@PathVariable(name = "id")Integer id) {
        return this.counterfeitTeamReadService.fetchCounterfeitTeamById(id);
    }

    @GetMapping
    public List<CounterfeitTeam> fetchAll(){return this.counterfeitTeamReadService.fetchAllCounterfeitTeam();
    }
}

