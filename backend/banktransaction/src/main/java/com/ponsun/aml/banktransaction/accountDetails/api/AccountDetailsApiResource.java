package com.ponsun.aml.banktransaction.accountDetails.api;

import com.ponsun.aml.banktransaction.accountDetails.data.AppicationException;
import com.ponsun.aml.banktransaction.accountDetails.domain.AccountDetails;
import com.ponsun.aml.banktransaction.accountDetails.request.CreateAccountDetailsRequest;
import com.ponsun.aml.banktransaction.accountDetails.request.UpdateAccountDetailsRequest;
import com.ponsun.aml.banktransaction.accountDetails.services.AccountDetailsReadPlatformService;
import com.ponsun.aml.banktransaction.accountDetails.services.AccountDetailsWritePlatformService;
import com.ponsun.aml.banktransaction.infrastructure.utils.Response;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/AccountDetails")
@Tag(name = "AccountDetailsApiResource")
public class AccountDetailsApiResource {

    private final AccountDetailsWritePlatformService accountDetailsWritePlatformService;
    private final AccountDetailsReadPlatformService accountDetailsReadPlatformService;
    @PostMapping("/CreateAccountDetailsRequest")
    public Response saveAccountDetails(@RequestBody CreateAccountDetailsRequest createAccountDetailsRequest) throws AppicationException {
        Response response = this.accountDetailsWritePlatformService.createAccountDetails(createAccountDetailsRequest);
        return response;
    }
//    @PostMapping("/CreateAccountAlertGeneration")
//    public Response AlertGeneration(){
//        Response response = this.accountDetailsWritePlatformService.AlertGeneration();
//        return response;
//    }

    @GetMapping
    public List<AccountDetails> fetchAllAccountDetails()
    { return this.accountDetailsReadPlatformService.fetchAllAccountDetails();}

    @GetMapping("/{id}")
    public AccountDetails fetchAccountDetailsById(@PathVariable(name = "id")Integer id){
        return this.accountDetailsReadPlatformService.fetchAccountDetailsById(id);
    }

    @PutMapping("/{id}")
    public Response updateAccountDetails(@PathVariable Integer id, @RequestBody UpdateAccountDetailsRequest updateAccountDetailsRequest) throws AppicationException {
        Response response = this.accountDetailsWritePlatformService.updateAccountDetails(id,updateAccountDetailsRequest);
        return  response;
    }
    @PutMapping("/{id}/block")
    public Response blockAccountDetails(@PathVariable Integer id) throws AppicationException {
        Response response = this.accountDetailsWritePlatformService.blockAccountDetails(id);
        return response;
    }
    @PutMapping("/{id}/unblock")
    public Response unblockAccountDetails(@PathVariable Integer id) throws AppicationException {
        Response response = this.accountDetailsWritePlatformService.unblockAccountDetails(id);
        return  response;
    }
}
