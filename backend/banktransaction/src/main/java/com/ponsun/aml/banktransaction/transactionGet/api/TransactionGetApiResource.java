package com.ponsun.aml.banktransaction.transactionGet.api;


import com.ponsun.aml.banktransaction.transactionGet.data.TransactionGetData;
import com.ponsun.aml.banktransaction.transactionGet.services.TransactionGetReadPlatformService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/TransactionGet")
public class TransactionGetApiResource {
    private final TransactionGetReadPlatformService transactionGetReadPlatformService;
    @GetMapping
    public List<TransactionGetData> fetchAll(@RequestParam String senderCustomer){
        return this.transactionGetReadPlatformService.getTransactionDetails(senderCustomer);}
}
