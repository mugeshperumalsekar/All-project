package com.ponsun.aml.amlTeam.AmlComplaintStatus.domain;
import com.ponsun.aml.amlTeam.AmlComplaintStatus.request.CreaetAmlComplaintStatuRequest;
import com.ponsun.aml.amlTeam.AmlComplaintStatus.request.UpdateAmlComplaintStatusRequest;
import com.ponsun.aml.common.entity.Status;
import com.ponsun.aml.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "aml_complaint_status")
public class AmlComplaintStatus extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "ticketId")
    private Integer ticketId;

    @Column(name = "complaintId")
    private Integer complaintId;

    @Column(name = "branchId")
    private Integer branchId;

    @Column(name = "ticketStatusId")
    private Integer ticketStatusId;

    @Column(name = "remark")
    private String remark;

    public static AmlComplaintStatus create(CreaetAmlComplaintStatuRequest request) {
        final AmlComplaintStatus amlComplaintStatus = new AmlComplaintStatus();
        amlComplaintStatus.setId(request.getId());
        amlComplaintStatus.setUid(request.getUid());
        amlComplaintStatus.setTicketId(request.getTicketId());
        amlComplaintStatus.setComplaintId(request.getComplaintId());
        amlComplaintStatus.setBranchId(request.getBranchId());
        amlComplaintStatus.setTicketStatusId(request.getTicketStatusId());
        amlComplaintStatus.setRemark(request.getRemark());
        amlComplaintStatus.onCreate();
        amlComplaintStatus.setStatus(Status.ACTIVE);
        return amlComplaintStatus;
    }

    public void update(final UpdateAmlComplaintStatusRequest request) {
        this.setId(request.getId());
        this.setUid(request.getUid());
        this.setTicketId(request.getTicketId());
        this.setComplaintId(request.getComplaintId());
        this.setBranchId(request.getBranchId());
        this.setTicketStatusId(request.getTicketStatusId());
        this.setRemark(request.getRemark());
        this.onUpdate();
        this.setStatus(Status.ACTIVE);
    }
}
