package com.ponsun.aml.amlTeam.AmlCustomerAllData.api;

import com.ponsun.aml.amlTeam.AmlCustomerAllData.data.AmlCustomerAllDataData;
import com.ponsun.aml.amlTeam.AmlCustomerAllData.services.AmlCustomerAllDataWriteService;
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
@RequestMapping("/api/v1/AmlCustomerAllDataApiResources")
@Tag(name = "AmlCustomerAllDataApiResources")
public class AmlCustomerAllDataApiResources {
    private  final AmlCustomerAllDataWriteService customerAllDataWritePlatformService;

    @GetMapping
    public List<AmlCustomerAllDataData> fetchAll(){
        return this.customerAllDataWritePlatformService.fetchAllCustomerData();
    }

}
