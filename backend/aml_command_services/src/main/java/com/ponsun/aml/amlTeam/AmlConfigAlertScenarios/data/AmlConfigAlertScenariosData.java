package com.ponsun.aml.amlTeam.AmlConfigAlertScenarios.data;

import lombok.Data;
@Data
public class AmlConfigAlertScenariosData {
    private Integer id;
    private String alertScenarios;
    private Integer uid;
    private Integer euid;

    public AmlConfigAlertScenariosData(Integer id, String alertScenarios, Integer uid, Integer euid) {
        this.id = id;
        this.alertScenarios = alertScenarios;
        this.uid = uid;
        this.euid = euid;
    }
    public static AmlConfigAlertScenariosData newInsatcne(Integer id, String alertScenarios, Integer uid, Integer euid){
        return new AmlConfigAlertScenariosData(id,alertScenarios,uid,euid);
    }
}
