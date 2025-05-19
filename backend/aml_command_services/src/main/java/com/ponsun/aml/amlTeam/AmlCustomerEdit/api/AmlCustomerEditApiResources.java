package com.ponsun.aml.amlTeam.AmlCustomerEdit.api;

import com.ponsun.aml.amlTeam.AmlCustomerEdit.data.AmlCustomerEditData;
import com.ponsun.aml.amlTeam.AmlCustomerEdit.services.AmlCustomerEditWriteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/AmlCustomerEditApiResources")
@Tag(name = "AmlCustomerEditApiResources")
public class AmlCustomerEditApiResources {
    private  final AmlCustomerEditWriteService customerEditWritePlatformService;

    @GetMapping
    public List<AmlCustomerEditData> fetchAll(@RequestParam String fromDate , @RequestParam String toDate ){
        return this.customerEditWritePlatformService.fetchAllCustomerEditData(fromDate , toDate);}


}
