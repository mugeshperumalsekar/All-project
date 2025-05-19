package com.ponsun.aml.amlTeam.AmlConfigStatus.request;

import lombok.Data;

@Data
public class AbstractAmlConfigStatusRequest {
    private Integer id;
    private String name;
    private Integer uid;
    private Integer euid;
}
