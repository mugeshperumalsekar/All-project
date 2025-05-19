package com.ponsun.aml.amlTeam.AmlConfigAlertScenarios.request;

import lombok.Data;

@Data
public class AbstractAmlConfigAlertScenariosRequest {
    private Integer id;
    private String alertScenarios;
    private String remark;
    private Integer uid;
    private Integer euid;

}
