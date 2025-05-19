package com.ponsun.aml.amlTeam.BranchUserMapping.request;

import lombok.Data;

@Data
public class AbstractBranchUserMappingRequest {
    private Integer id;
    private Integer branchId;
    private String userId;
    private String entryDate;
    private Integer uid;
    private Integer euid;
}
