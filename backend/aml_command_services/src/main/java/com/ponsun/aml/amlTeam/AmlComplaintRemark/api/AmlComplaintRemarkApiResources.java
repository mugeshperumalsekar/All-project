package com.ponsun.aml.amlTeam.AmlComplaintRemark.api;

import com.ponsun.aml.amlTeam.AmlComplaintRemark.domain.AmlComplaintRemark;
import com.ponsun.aml.amlTeam.AmlComplaintRemark.request.CreateAmlComplaintRemarkRequest;
import com.ponsun.aml.amlTeam.AmlComplaintRemark.request.UpdateAmlComplaintRemarkRequest;
import com.ponsun.aml.amlTeam.AmlComplaintRemark.services.AmlComplaintRemarkReadService;
import com.ponsun.aml.amlTeam.AmlComplaintRemark.services.AmlComplaintRemarkWriteService;
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
@RequestMapping("/api/v1/AmlComplaintRemark")
@Tag(name = "AmlComplaintRemarkApiResources")
public class AmlComplaintRemarkApiResources {
    private final AmlComplaintRemarkWriteService amlComplaintRemarkWriteService;
    private final AmlComplaintRemarkReadService amlComplaintRemarkReadService;

    @PostMapping("/CreateAmlComplaintRemarkRequest")
    public Response createAmlComplaintRemarkList(@RequestBody CreateAmlComplaintRemarkRequest createAmlComplaintRemarkRequest){
        Response response = this.amlComplaintRemarkWriteService.createAmlComplaintRemarkList(createAmlComplaintRemarkRequest);
        return response;
    }
    @PutMapping("/{id}")
    public Response updateAmlComplaintRemarkList(@PathVariable Integer id, @RequestBody UpdateAmlComplaintRemarkRequest updateAmlComplaintRemarkRequest){
        Response response = this.amlComplaintRemarkWriteService.updateAmlComplaintRemarkList(id, updateAmlComplaintRemarkRequest);
        return response;
    }
    @GetMapping("/{id}")
    public AmlComplaintRemark fetchAmlComplaintRemarkById(@PathVariable(name = "id")Integer id) {
        return this.amlComplaintRemarkReadService.fetchAmlComplaintRemarkById(id);
    }

    @GetMapping
    public List<AmlComplaintRemark> fetchAll(){return this.amlComplaintRemarkReadService.fetchAllAmlComplaintRemark();}


}
