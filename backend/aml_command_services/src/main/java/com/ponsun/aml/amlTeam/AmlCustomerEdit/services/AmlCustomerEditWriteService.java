package com.ponsun.aml.amlTeam.AmlCustomerEdit.services;

import com.ponsun.aml.amlTeam.AmlCustomerEdit.data.AmlCustomerEditData;

import java.util.List;

public interface AmlCustomerEditWriteService {
    List<AmlCustomerEditData> fetchAllCustomerEditData(String fromDate, String toDate);

}
