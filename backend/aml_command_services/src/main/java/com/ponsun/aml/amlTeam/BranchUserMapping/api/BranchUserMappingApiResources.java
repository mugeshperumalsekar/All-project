package com.ponsun.aml.amlTeam.BranchUserMapping.api;
import com.ponsun.aml.amlTeam.BranchUserMapping.data.BranchUserMappingData;
import com.ponsun.aml.amlTeam.BranchUserMapping.domain.BranchUserMapping;
import com.ponsun.aml.amlTeam.BranchUserMapping.request.UpdateBranchUserMappingRequest;
import com.ponsun.aml.amlTeam.BranchUserMapping.services.BranchUserMappingReadService;
import com.ponsun.aml.amlTeam.BranchUserMapping.services.BranchUserMappingWriteService;
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
@RequestMapping("/api/v1/BranchUserMappingApiResources")
@Tag(name = "BranchUserMappingApiResources")
public class BranchUserMappingApiResources {
    private final BranchUserMappingWriteService branchUserMappingWriteService;
    private final BranchUserMappingReadService branchUserMappingReadService;

    @PostMapping("/CreateAmlConfigBranchRequest")
    public Response createUserMapping(@RequestBody List<BranchUserMappingData> branchUserMappingDataList){
        Response response = this.branchUserMappingWriteService.createUserMapping(branchUserMappingDataList);
        return response;
    }
    @PutMapping("/{id}")
    public Response updateUserMapping(@PathVariable Integer id, @RequestBody UpdateBranchUserMappingRequest updateBranchUserMappingRequest){
        Response response = this.branchUserMappingWriteService.updateUserMapping(id, updateBranchUserMappingRequest);
        return response;
    }
    @GetMapping("/{id}")
    public BranchUserMapping fetchUserMappingById(@PathVariable(name = "id")Integer id) {
        return this.branchUserMappingReadService.fetchUserMappingById(id);
    }

    @GetMapping
    public List<BranchUserMapping> fetchAll(){return this.branchUserMappingReadService.fetchAllUserMapping();}
}
