package com.ponsun.aml.amlTeam.AmlComplaintAlertScenarios.domain;

import com.ponsun.aml.amlTeam.AmlComplaintAlertScenarios.request.CreateAmlComplaintAlertScenariosRequest;
import com.ponsun.aml.amlTeam.AmlComplaintAlertScenarios.request.UpdateAmlComplaintAlertScenariosRequest;
import com.ponsun.aml.common.entity.Status;
import com.ponsun.aml.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "aml_complaint_alert_scenarios")
public class AmlComplaintAlertScenarios extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "complaintId")
    private Integer complaintId;

    @Column(name = "scenarioId")
    private Integer scenarioId;

    @Column(name = "replyQry")
    private String replyQry;

    @Column(name = "euid")
    private Integer euid;

    @Column(name = "uid")
    private Integer uid;

    public static AmlComplaintAlertScenarios create(CreateAmlComplaintAlertScenariosRequest request) {
        final AmlComplaintAlertScenarios amlComplaintAlertScenarios = new AmlComplaintAlertScenarios();
        amlComplaintAlertScenarios.setId(request.getId());
        amlComplaintAlertScenarios.setComplaintId(request.getComplaintId());
        amlComplaintAlertScenarios.setScenarioId(request.getScenarioId());
        amlComplaintAlertScenarios.setReplyQry(request.getReplyQry());
        amlComplaintAlertScenarios.setUid(request.getUid());
        amlComplaintAlertScenarios.setEuid(request.getEuid());
        amlComplaintAlertScenarios.onCreate();
        amlComplaintAlertScenarios.setStatus(Status.ACTIVE);
        return amlComplaintAlertScenarios;
    }

    public void update(final UpdateAmlComplaintAlertScenariosRequest request) {
        this.setId(request.getId());
        this.setComplaintId(request.getComplaintId());
        this.setScenarioId(request.getScenarioId());
        this.setReplyQry(request.getReplyQry());
        this.setUid(request.getUid());
        this.setEuid(request.getEuid());
        this.onUpdate();
        this.setStatus(Status.ACTIVE);
    }

}
