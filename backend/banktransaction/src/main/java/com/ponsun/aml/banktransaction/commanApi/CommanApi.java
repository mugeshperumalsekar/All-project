package com.ponsun.aml.banktransaction.commanApi;


import com.ponsun.aml.banktransaction.AuditLog.request.CreateAuditLogRequest;
import com.ponsun.aml.banktransaction.commanApi.service.CommanWriteService;
import com.ponsun.aml.banktransaction.infrastructure.utils.Response;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/v1/CustomerApi")
@Tag(name = "BankApiResource")
public class CommanApi {

    private final CommanWriteService commanWriteService;
    @PostMapping("/CreateCustomerDetails")
    public Response saveCustomer(@RequestParam("CommanWriteDTO") String CommanDTO,
                                 @RequestParam(value = "files", required = false) MultipartFile[] files,
                                 @RequestParam(value = "alertId", required = false) Integer alertId,
                                 @RequestParam(value = "customerId", required = false) String customerId,
                                 @RequestParam(value = "imgName", required = false) String imgName
    )
    {
        return this.commanWriteService.saveCustomer(CommanDTO,files,alertId,customerId,imgName);
    }

    @GetMapping("/GetAuditLog")
    public CommonReadDTO getCommonDetails()
    {
        return this.commanWriteService.getCommonDetails();
    }
}
