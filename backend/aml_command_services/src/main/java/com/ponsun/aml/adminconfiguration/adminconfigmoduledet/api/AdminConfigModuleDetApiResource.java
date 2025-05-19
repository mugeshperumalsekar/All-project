package com.ponsun.aml.adminconfiguration.adminconfigmoduledet.api;




import com.ponsun.aml.adminconfiguration.adminconfigmoduledet.domain.AdminConfigModuleDet;
import com.ponsun.aml.adminconfiguration.adminconfigmoduledet.request.CreateAdminConfigModuleDetRequest;
import com.ponsun.aml.adminconfiguration.adminconfigmoduledet.request.UpdateAdminConfigModuleDetRequest;
import com.ponsun.aml.adminconfiguration.adminconfigmoduledet.services.AdminConfigModuleDetReadPlatformService;
import com.ponsun.aml.adminconfiguration.adminconfigmoduledet.services.AdminConfigModuleDetWritePlatformService;
import com.ponsun.aml.infrastructure.utils.Response;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/adminconfigmoduledet")
@Tag(name = "AdminConfigModuleDetApiResource")
public class AdminConfigModuleDetApiResource {

    private final AdminConfigModuleDetWritePlatformService adminconfigmoduledetWritePlatformService;
    private final AdminConfigModuleDetReadPlatformService adminconfigmoduledetReadPlatformService;

    @PostMapping("/createAdminConfigModuleDet")
    public Response saveAdminConfigModuleDet(@RequestBody CreateAdminConfigModuleDetRequest createAdminConfigModuleDetRequest) {
        log.debug("START saveAdminConfigModuleDet request body {}",createAdminConfigModuleDetRequest);
        Response response = this.adminconfigmoduledetWritePlatformService.createAdminConfigModuleDet(createAdminConfigModuleDetRequest);
        log.debug("START saveAdminConfigModuleDet response",response);
        return response;
    }

    @GetMapping
    public List<AdminConfigModuleDet> fetchAll() {
        return this.adminconfigmoduledetReadPlatformService.fetchAllAdminConfigModuleDet();
    }

    @GetMapping("/{id}")
    public AdminConfigModuleDet fetchAdminConfigModuleDetById(@PathVariable (name = "id") Integer id) {
        return this.adminconfigmoduledetReadPlatformService.fetchAdminConfigModuleDetById(id);
    }
    @PutMapping("/{id}")
    public Response updateAdminConfigModuleDet(@PathVariable Integer id, @RequestBody UpdateAdminConfigModuleDetRequest updateAdminConfigModuleDetRequest) {
        log.debug("START updateAdminConfigModuleDet request body {}",updateAdminConfigModuleDetRequest);
        Response response = this.adminconfigmoduledetWritePlatformService.updateAdminConfigModuleDet(id, updateAdminConfigModuleDetRequest);
        log.debug("START updateAdminConfigModuleDet response",response);
        return response;
}

    @PutMapping("/block/{id}")
    public Response blockAdminConfigModuleDet(@PathVariable Integer id) {
    Response response = this.adminconfigmoduledetWritePlatformService.blockAdminConfigModuleDet(id);
    return response;
}

    @PutMapping("/{id}/unblock")
    public Response unblockAdminConfigModuleDet(@PathVariable Integer id) {
        Response response = this.adminconfigmoduledetWritePlatformService.unblockAdminConfigModuleDet(id);
        return response;
    }
}
