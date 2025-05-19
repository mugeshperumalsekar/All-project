package com.ponsun.aml.amlTeam.AmlConfigBranch.api;

import com.ponsun.aml.amlTeam.AmlConfigBranch.domain.AmlConfigBranch;
import com.ponsun.aml.amlTeam.AmlConfigBranch.request.CreateAmlConfigBranchRequest;
import com.ponsun.aml.amlTeam.AmlConfigBranch.request.UpdateAmlConfigBranchRequest;
import com.ponsun.aml.amlTeam.AmlConfigBranch.services.AmlConfigBranchReadService;
import com.ponsun.aml.amlTeam.AmlConfigBranch.services.AmlConfigBranchWriteService;
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
@RequestMapping("/api/v1/AmlConfigBranch")
@Tag(name = "AmlConfigBranchApiResources")
public class AmlConfigBranchApiResources {
    private final AmlConfigBranchWriteService amlConfigBranchWriteService;
    private final AmlConfigBranchReadService amlConfigBranchReadService;

    @PostMapping("/CreateAmlConfigBranchRequest")
    public Response createConfigBranch(@RequestBody CreateAmlConfigBranchRequest createCurrencyReportBranchToAmlRequest){
        Response response = this.amlConfigBranchWriteService.createConfigBranch(createCurrencyReportBranchToAmlRequest);
        return response;
    }
    @PutMapping("/{id}")
    public Response updateConfigBranch(@PathVariable Integer id, @RequestBody UpdateAmlConfigBranchRequest updateCurrencyReportBranchToAmlRequest){
        Response response = this.amlConfigBranchWriteService.updateConfigBranch(id, updateCurrencyReportBranchToAmlRequest);
        return response;
    }
    @GetMapping("/{id}")
    public AmlConfigBranch fetchConfigBranchById(@PathVariable(name = "id")Integer id) {
        return this.amlConfigBranchReadService.fetchConfigBranchById(id);
    }

    @GetMapping
    public List<AmlConfigBranch> fetchAll(){return this.amlConfigBranchReadService.fetchAllConfigBranch();}

}
