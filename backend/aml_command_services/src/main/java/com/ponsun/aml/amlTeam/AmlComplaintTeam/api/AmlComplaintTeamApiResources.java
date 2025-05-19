package com.ponsun.aml.amlTeam.AmlComplaintTeam.api;

import com.ponsun.aml.amlTeam.AmlComplaintTeam.data.AmlComplaintDto;
import com.ponsun.aml.amlTeam.AmlComplaintTeam.domain.AmlComplaintTeam;
import com.ponsun.aml.amlTeam.AmlComplaintTeam.request.CreateAmlComplaintTeamRequest;
import com.ponsun.aml.amlTeam.AmlComplaintTeam.request.UpdateAmlComplaintTeamRequest;
import com.ponsun.aml.amlTeam.AmlComplaintTeam.services.AmlComplaintTeamReadService;
import com.ponsun.aml.amlTeam.AmlComplaintTeam.services.AmlComplaintTeamWriteService;
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
@RequestMapping("/api/v1/AmlComplaintTeam")
@Tag(name = "AmlComplaintTeamApiResources")
public class AmlComplaintTeamApiResources {
    private final AmlComplaintTeamWriteService amlComplaintTeamWriteService;
    private final AmlComplaintTeamReadService amlBranchReadService;

    @PostMapping("/CreateAmlComplaintTeamRequest")
    public Response createAmlBranchList(@RequestBody CreateAmlComplaintTeamRequest createAmlComplaintTeamRequest){
        Response response = this.amlComplaintTeamWriteService.createAmlBranchList(createAmlComplaintTeamRequest);
        return response;
    }
    @PutMapping("/{id}")
    public Response updateAmlBranchList(@PathVariable Integer id, @RequestBody UpdateAmlComplaintTeamRequest updateAmlComplaintTeamRequest){
        Response response = this.amlComplaintTeamWriteService.updateAmlBranchList(id, updateAmlComplaintTeamRequest);
        return response;
    }

    @GetMapping("/{id}")
    public AmlComplaintTeam fetchAmlBranchById(@PathVariable(name = "id")Integer id) {
        return this.amlBranchReadService.fetchAmlBranchById(id);
    }

    @GetMapping
    public List<AmlComplaintTeam> fetchAll(){return this.amlBranchReadService.fetchAllAmlBranch();
    }

    @PostMapping("/createAmlComplaint")
    public Response createAmlComplaint(@RequestBody AmlComplaintDto amlComplaintDto){
        Response response = this.amlComplaintTeamWriteService.createAmlComplaint(amlComplaintDto);
        return response;
    }

    @PutMapping("/updateAmlTeamComplaint")
    public Response updateAmlComplaint(@RequestParam Integer compId,@RequestParam Integer euid , //@RequestParam("AmlComplaintDto") String amlDto,
                                       @RequestBody AmlComplaintDto amlComplaintDto){
        Response response = this.amlComplaintTeamWriteService.updateAmlComplaint(compId, euid,amlComplaintDto);
        return response;
    }

    @PutMapping("/deActivate/{id}")
    public Response DeActiveFunction(@RequestParam Integer compId, @RequestParam Integer euid){
        Response response = this.amlComplaintTeamWriteService.DeActiveFunction(compId, euid);
        return response;
    }
}
