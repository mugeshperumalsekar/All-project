package com.ponsun.aml.banktransaction.AuditLog.api;

import com.ponsun.aml.banktransaction.AuditLog.domain.AuditLog;
import com.ponsun.aml.banktransaction.AuditLog.request.CreateAuditLogRequest;
import com.ponsun.aml.banktransaction.AuditLog.request.UpdateAuditLogRequest;
import com.ponsun.aml.banktransaction.AuditLog.services.AuditLogReadPlatformService;
import com.ponsun.aml.banktransaction.AuditLog.services.AuditLogWritePlatformService;
import com.ponsun.aml.banktransaction.infrastructure.utils.Response;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/AuditLog")
@Tag(name = "AuditLogApiResource")
public class AuditLogApiResource {

    private final AuditLogWritePlatformService auditLogWritePlatformService;
    private final AuditLogReadPlatformService auditLogReadPlatformService;
    @PostMapping("/CreateAuditLogRequest")
    public Response saveAuditLog(@RequestBody CreateAuditLogRequest createAuditLogRequest){
        Response response = this.auditLogWritePlatformService.createAuditLog(createAuditLogRequest);
        return response;
    }
    @GetMapping
    public List<AuditLog> fetchAll(){return this.auditLogReadPlatformService.fetchAllAuditLog();}
    @GetMapping("/{id}")
    public AuditLog fetchAuditLogById(@PathVariable(name = "id") Integer id){
        return this.auditLogReadPlatformService.fetchAuditLogById(id);
    }
    @PutMapping("/{id}")
    public Response updateAuditLog(@PathVariable Integer id, @RequestBody UpdateAuditLogRequest updateAuditLogRequest){
        Response response = this.auditLogWritePlatformService.updateAuditLogById(id,updateAuditLogRequest);
        return response;
    }
}
