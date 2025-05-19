package com.ponsun.aml.scamTeam.ScamRemark.domain;

import com.ponsun.aml.scamTeam.ScamRemark.request.CreateScamRemarkRequest;
import com.ponsun.aml.scamTeam.ScamRemark.request.UpdateScamRemarkRequest;
import com.ponsun.aml.common.entity.Status;
import com.ponsun.aml.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name ="scam_remark")
public class ScamRemark extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="scamId")
    private Integer scamId;

    @Column(name="branchId")
    private Integer branchId;

    @Column(name="ticketId")
    private Integer ticketId;

    @Column(name="remark")
    private String remark;

    @Column(name="uid")
    private Integer uid;

    @Column(name="euid")
    private Integer euid;

    public static ScamRemark create(CreateScamRemarkRequest request){
        final ScamRemark scamRemark = new ScamRemark();
        scamRemark.setId(request.getId());
        scamRemark.setScamId(request.getScamId());
        scamRemark.setBranchId(request.getBranchId());
        scamRemark.setTicketId(request.getTicketId());
        scamRemark.setRemark(request.getRemark());
        scamRemark.setUid(request.getUid());
        scamRemark.setEuid(request.getEuid());
        scamRemark.onCreate();
        scamRemark.setStatus(Status.ACTIVE);
        return scamRemark;
    }
    public void update(final UpdateScamRemarkRequest request){
        this.setId(request.getId());
        this.setScamId(request.getScamId());
        this.setBranchId(request.getBranchId());
        this.setTicketId(request.getTicketId());
        this.setRemark(request.getRemark());
        this.setUid(request.getUid());
        this.setEuid(request.getEuid());
        this.onUpdate();
        this.setStatus(Status.ACTIVE);
    }

}
