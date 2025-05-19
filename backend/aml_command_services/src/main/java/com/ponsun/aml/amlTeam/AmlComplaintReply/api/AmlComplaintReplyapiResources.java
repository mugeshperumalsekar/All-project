package com.ponsun.aml.amlTeam.AmlComplaintReply.api;

import com.ponsun.aml.amlTeam.AmlComplaintReply.data.AmlComplaintAlertReplayData;
import com.ponsun.aml.amlTeam.AmlBranchTeam.data.AmlBranchPendingResponseData;
import com.ponsun.aml.amlTeam.AmlComplaintReply.data.AmlPendingResponseData;
import com.ponsun.aml.amlTeam.AmlComplaintReply.data.ReplayWriteDTO;
import com.ponsun.aml.amlTeam.AmlComplaintReply.domain.AmlComplaintReply;
import com.ponsun.aml.amlTeam.AmlComplaintReply.request.CreateAmlComplaintReplyRequest;
import com.ponsun.aml.amlTeam.AmlComplaintReply.request.UpdateAmlComplaintReplyrequest;
import com.ponsun.aml.amlTeam.AmlComplaintReply.services.AmlComplaintReplyReadService;
import com.ponsun.aml.amlTeam.AmlComplaintReply.services.AmlComplaintReplyWriteService;
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
@RequestMapping("/api/v1/AmlComplaintReply")
@Tag(name = "AmlComplaintReplyApiResources")
public class AmlComplaintReplyapiResources {
    private final AmlComplaintReplyWriteService amlComplaintReplyWriteService;
    private final AmlComplaintReplyReadService amlComplaintReplyReadService;

    @PostMapping("/CreateAmlComplaintReplyRequest")
    public Response createAmlComplaintReplyList(@RequestBody List<CreateAmlComplaintReplyRequest> createAmlComplaintReplyRequest) {
        Response response = this.amlComplaintReplyWriteService.createAmlComplaintReplyList(createAmlComplaintReplyRequest);
        return response;
    }

    @PutMapping("/{id}")
    public Response updateAmlComplaintReplyList(@PathVariable Integer id, @RequestBody UpdateAmlComplaintReplyrequest updateAmlComplaintReplyrequest) {
        Response response = this.amlComplaintReplyWriteService.updateAmlComplaintReplyList(id, updateAmlComplaintReplyrequest);
        return response;
    }

    @GetMapping("/{id}")
    public AmlComplaintReply fetchAmlComplaintReplyById(@PathVariable(name = "id") Integer id) {
        return this.amlComplaintReplyReadService.fetchAmlComplaintReplyById(id);
    }

    @GetMapping
    public List<AmlComplaintReply> fetchAll() {
        return this.amlComplaintReplyReadService.fetchAllAmlComplaintReply();
    }

    @PostMapping("/createReplaySave")
    public Response createReplaySave(@RequestBody ReplayWriteDTO replayWriteDTO){
        return this.amlComplaintReplyWriteService.createReplaySave(replayWriteDTO);
}
    @PutMapping("/updateReplaySave")
    public Response updateReplaySave(@RequestParam Integer complaintId,@RequestParam Integer euid ,
                                       @RequestBody ReplayWriteDTO replayWriteDTO){
        Response response = this.amlComplaintReplyWriteService.updateReplaySave(complaintId, euid,replayWriteDTO);
        return response;
    }

    @GetMapping("/fetchAllAmlPendingResponse")
    public List<AmlPendingResponseData> fetchAllAmlPendingResponse(){
        return this.amlComplaintReplyReadService.fetchAllAmlPendingResponse();}

    @GetMapping("/fetchAllAmlAlertReplay")
    public List<AmlComplaintAlertReplayData> fetchAllAmlAlertReplay(Integer complaintId) {
        return this.amlComplaintReplyReadService.fetchAllAmlAlertReplay(complaintId);
    }
}