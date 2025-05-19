package com.ponsun.aml.amlTeam.AmlConfigAlertScenarios.domain;

import com.ponsun.aml.amlTeam.AmlConfigAlertScenarios.request.CreateAbstractAmlConfigAlertScenariosRequest;
import com.ponsun.aml.amlTeam.AmlConfigAlertScenarios.request.UpdateAbstractAmlConfigAlertScenariosRequest;
import com.ponsun.aml.common.entity.Status;
import com.ponsun.aml.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "aml_config_alert_scenarios")
public class AmlConfigAlertScenarios extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "alertScenarios")
    private String alertScenarios;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "euid")
    private Integer euid;

    public static AmlConfigAlertScenarios create(CreateAbstractAmlConfigAlertScenariosRequest request) {
        final AmlConfigAlertScenarios amlConfigAlertScenarios = new AmlConfigAlertScenarios();
        amlConfigAlertScenarios.setId(request.getId());
        amlConfigAlertScenarios.setAlertScenarios(request.getAlertScenarios());
        amlConfigAlertScenarios.setUid(request.getUid());
        amlConfigAlertScenarios.setEuid(request.getEuid());
        amlConfigAlertScenarios.onCreate();
        amlConfigAlertScenarios.setStatus(Status.ACTIVE);
        return amlConfigAlertScenarios;
    }

    public void update(final UpdateAbstractAmlConfigAlertScenariosRequest request) {
        this.setId(request.getId());
        this.setAlertScenarios(request.getAlertScenarios());
        this.setUid(request.getUid());
        this.setEuid(request.getEuid());
        this.onUpdate();
        this.setStatus(Status.ACTIVE);
    }

}
