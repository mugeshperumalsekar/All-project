package com.ponsun.aml.banktransaction.customerGet.api;

import com.ponsun.aml.banktransaction.customerGet.data.CustomerGetData;
import com.ponsun.aml.banktransaction.customerGet.services.CustomerGetReadPlatformService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/CustomerGet")

public class CustomerGetApiResource {
    private final CustomerGetReadPlatformService customerGetReadPlatformService;
    @GetMapping
    public List<CustomerGetData> fetchAll(){
        return this.customerGetReadPlatformService.fetchAllTransactionGetData();
    }
}