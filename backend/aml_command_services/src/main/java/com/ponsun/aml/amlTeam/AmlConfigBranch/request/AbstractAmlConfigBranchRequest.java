package com.ponsun.aml.amlTeam.AmlConfigBranch.request;

import lombok.Data;

@Data
public class AbstractAmlConfigBranchRequest {
    private Integer id;
    private String name;
    private String branchCode;
    private Integer uid;
    private Integer euid;

}
