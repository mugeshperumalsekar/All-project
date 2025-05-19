package com.ponsun.aml.banktransaction.adminconfiguration.admingroup.domain;

import com.ponsun.aml.banktransaction.adminconfiguration.admingroup.request.CreateAdmingroupRequest;
import com.ponsun.aml.banktransaction.adminconfiguration.admingroup.request.UpdateAdmingroupRequest;
import com.ponsun.aml.banktransaction.common.entity.Status;
import com.ponsun.aml.banktransaction.infrastructure.baseentity.BaseEntity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Entity
@Accessors(chain = true)

@Table(name = "admin_config_admingroup")
public class Admingroup extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "module_url")
    private String moduleUrl;

    @Column(name = "name")
    private String name;

    @Column(name = "valid")
    private Boolean valid;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "euid")
    private Integer euid;

    public static Admingroup create(final CreateAdmingroupRequest createAdmingroupRequest) {
        final Admingroup admingroup = new Admingroup();
        admingroup.setModuleUrl(createAdmingroupRequest.getModuleUrl());
        admingroup.setName(createAdmingroupRequest.getName());
        admingroup.setValid(createAdmingroupRequest.getValid());
        admingroup.setUid(createAdmingroupRequest.getUid());
        admingroup.setStatus(Status.ACTIVE);
        admingroup.setCreatedAt(LocalDateTime.now());
        return admingroup;
    }
    public void update(final UpdateAdmingroupRequest updateAdmingroupRequest){
        this.setModuleUrl(updateAdmingroupRequest.getModuleUrl());
        this.setName(updateAdmingroupRequest.getName());
        this.setValid(updateAdmingroupRequest.getValid());
        this.setEuid(updateAdmingroupRequest.getEuid());
        this.setStatus(Status.ACTIVE);
        this.setUpdatedAt(LocalDateTime.now());
    }

    public void deactive(UpdateAdmingroupRequest updateAdmingroupRequest){
        this.setEuid(updateAdmingroupRequest.getEuid());
        this.onUpdate();
        this.setStatus(Status.DELETE);
    }

}

