package com.ponsun.aml.banktransaction.adminconfiguration.adminconfigmodule.request;

import lombok.Data;

@Data
public class AbstractAdminConfigModuleBaseRequest {
//  private Integer id;
    private String name;
    private Boolean valid;
    private Integer orderno;
    private Integer uid;
    private Integer euid;

}
