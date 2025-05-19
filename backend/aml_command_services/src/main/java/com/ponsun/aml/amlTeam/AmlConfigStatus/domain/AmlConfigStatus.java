package com.ponsun.aml.amlTeam.AmlConfigStatus.domain;

import com.ponsun.aml.amlTeam.AmlConfigStatus.request.CreateAmlConfigStatusRequest;
import com.ponsun.aml.amlTeam.AmlConfigStatus.request.UpdateAmlConfigStatusRequest;
import com.ponsun.aml.common.entity.Status;
import com.ponsun.aml.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name="aml_config_status")
public class AmlConfigStatus extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="uid")
    private Integer uid;

    @Column(name="euid")
    private Integer euid;

    public static AmlConfigStatus create(CreateAmlConfigStatusRequest request){
        final AmlConfigStatus amlConfigStatus = new AmlConfigStatus();
        amlConfigStatus.setId(request.getId());
        amlConfigStatus.setName(request.getName());
        amlConfigStatus.setUid(request.getUid());
        amlConfigStatus.setEuid(request.getEuid());
        amlConfigStatus.onCreate();
        amlConfigStatus.setStatus(Status.ACTIVE);
        return amlConfigStatus;
    }
    public void update(final UpdateAmlConfigStatusRequest request){
        this.setId(request.getId());
        this.setName(request.getName());
        this.setUid(request.getUid());
        this.setEuid(request.getEuid());
        this.onUpdate();
        this.setStatus(Status.ACTIVE);
    }
}
