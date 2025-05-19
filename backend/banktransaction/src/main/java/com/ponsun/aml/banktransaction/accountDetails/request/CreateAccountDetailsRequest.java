package com.ponsun.aml.banktransaction.accountDetails.request;

import lombok.Data;

@Data
public class CreateAccountDetailsRequest extends AbstractAccountDetailsRequest {
    @Override
    public String toString(){ return super.toString();}
}