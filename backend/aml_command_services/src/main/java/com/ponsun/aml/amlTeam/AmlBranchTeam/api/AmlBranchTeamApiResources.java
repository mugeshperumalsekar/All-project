package com.ponsun.aml.amlTeam.AmlBranchTeam.api;


import com.ponsun.aml.amlTeam.AmlBranchTeam.data.AmlBranchPendingResponseData;
import com.ponsun.aml.amlTeam.AmlBranchTeam.services.AmlBranchTeamReadService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/AmlBranchTeam")
@Tag(name = "AmlBranchTeamApiResources")
public class AmlBranchTeamApiResources {
 final private AmlBranchTeamReadService amlBranchTeamReadService;

    @GetMapping("/fetchAllAmlBranchPendingResponse")
    public List<AmlBranchPendingResponseData> fetchAllAmlBranchPendingResponse(Integer branchId) {
        return this.amlBranchTeamReadService.fetchAllAmlBranchPendingResponse(branchId);
    }
}
