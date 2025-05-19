package com.ponsun.aml.amlTeam.AmlComplaintRemark.domain;

import com.ponsun.aml.amlTeam.AmlComplaintRemark.request.CreateAmlComplaintRemarkRequest;
import com.ponsun.aml.amlTeam.AmlComplaintRemark.request.UpdateAmlComplaintRemarkRequest;
import com.ponsun.aml.common.entity.Status;
import com.ponsun.aml.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "aml_complaint_remark")
public class AmlComplaintRemark extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "remark")
    private String remark;

    @Column(name = "complaintId")
    private Integer complaintId;

    @Column(name = "branchId")
    private Integer branchId;

    @Column(name = "euid")
    private Integer euid;


    public static AmlComplaintRemark create(CreateAmlComplaintRemarkRequest request) {
        final AmlComplaintRemark amlComplaintRemark = new AmlComplaintRemark();
//        amlComplaintRemark.setId(request.getId());
        amlComplaintRemark.setUid(request.getUid());
        amlComplaintRemark.setRemark(request.getRemark());
        amlComplaintRemark.setComplaintId(request.getComplaintId());
        amlComplaintRemark.setBranchId(request.getBranchId());
        amlComplaintRemark.setEuid(request.getEuid());
        amlComplaintRemark.onCreate();
        amlComplaintRemark.setStatus(Status.ACTIVE);
        return amlComplaintRemark;
    }

    public void update(final UpdateAmlComplaintRemarkRequest request) {
//        this.setId(request.getId());
        this.setUid(request.getUid());
        this.setRemark(request.getRemark());
        this.setComplaintId(request.getComplaintId());
        this.setBranchId(request.getBranchId());
        this.setEuid(request.getEuid());
        this.onUpdate();
        this.setStatus(Status.ACTIVE);
    }
}