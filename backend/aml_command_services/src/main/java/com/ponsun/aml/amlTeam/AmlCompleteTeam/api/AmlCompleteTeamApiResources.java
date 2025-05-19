package com.ponsun.aml.amlTeam.AmlCompleteTeam.api;

import com.ponsun.aml.amlTeam.AmlCompleteTeam.data.*;
import com.ponsun.aml.amlTeam.AmlCompleteTeam.services.AmlCompleteTeamReadService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/AmlCompleteTeamApiResources")
@Tag(name = "AmlCompleteTeamApiResources")
public class AmlCompleteTeamApiResources {
    private final AmlCompleteTeamReadService amlCompleteTeamReadService;
    @GetMapping("/ComplaintData")
    public List<ComplaintDto> fetchAllComplaintDto(@RequestParam Integer complaintId) {
        return this.amlCompleteTeamReadService.fetchAllComplaintDto(complaintId);
    }

    @GetMapping("/AlertScenarioData")
    public List<AlertScenarioDto> fetchAllAlertScenario(@RequestParam Integer complaintId) {
        return this.amlCompleteTeamReadService.fetchAllAlertScenario(complaintId);
    }

    @GetMapping("/RemarkData")
    public List<RemarkDto> fetchAllRemark(@RequestParam Integer complaintId) {
        return this.amlCompleteTeamReadService.fetchAllRemark(complaintId);
    }

    @GetMapping("/ReplyData")
    public List<ReplyDto> fetchAllReply(@RequestParam Integer complaintId) {
        return this.amlCompleteTeamReadService.fetchAllReply(complaintId);
    }

    @GetMapping("/CompleteTeamData")
    public CompleteTeamDto fetchAllCommonDto(@RequestParam Integer complaintId) {
        return this.amlCompleteTeamReadService.fetchAllCommonDto(complaintId);
    }

}
