package com.ponsun.aml.counterfeit.CounterfeitRemark.domain;


import com.ponsun.aml.common.entity.Status;
import com.ponsun.aml.infrastructure.baseentity.BaseEntity;
import com.ponsun.aml.counterfeit.CounterfeitRemark.request.CreateCounterfeitRemarkRequest;
import com.ponsun.aml.counterfeit.CounterfeitRemark.request.UpdateCounterfeitRemarkRequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "counterfeit_remark")
public class CounterfeitRemark extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "counterfeitId")
    private Integer counterfeitId;

    @Column(name = "branchId")
    private Integer branchId;

    @Column(name = "ticketId")
    private Integer ticketId;

    @Column(name = "remark")
    private String remark;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "euid")
    private Integer euid;


    public static CounterfeitRemark create(CreateCounterfeitRemarkRequest request) {
        final CounterfeitRemark counterfeitRemark = new CounterfeitRemark();
        counterfeitRemark.setCounterfeitId(request.getCounterfeitId());
        counterfeitRemark.setBranchId(request.getBranchId());
        counterfeitRemark.setTicketId(request.getTicketId());
        counterfeitRemark.setRemark(request.getRemark());
        counterfeitRemark.setUid(request.getUid());
        counterfeitRemark.setEuid(request.getEuid());
        counterfeitRemark.onCreate();
        counterfeitRemark.setStatus(Status.ACTIVE);
        return counterfeitRemark;
    }

    public void update(final UpdateCounterfeitRemarkRequest request) {
        this.setCounterfeitId(request.getCounterfeitId());
        this.setBranchId(request.getBranchId());
        this.setTicketId(request.getTicketId());
        this.setRemark(request.getRemark());
        this.setUid(request.getUid());
        this.setEuid(request.getEuid());
        this.onUpdate();
        this.setStatus(Status.ACTIVE);
    }
}
