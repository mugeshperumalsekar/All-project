package com.ponsun.aml.amlTeam.AmlComplaintReply.domain;

import com.ponsun.aml.amlTeam.AmlComplaintReply.request.CreateAmlComplaintReplyRequest;
import com.ponsun.aml.amlTeam.AmlComplaintReply.request.UpdateAmlComplaintReplyrequest;
import com.ponsun.aml.common.entity.Status;
import com.ponsun.aml.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "aml_complaint_reply")
public class AmlComplaintReply extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "complaintAlertId")
    private Integer complaintAlertId;

    @Column(name = "reply")
    private String reply;

    @Column(name = "complaintId")
    private Integer complaintId;

    @Column(name = "euid")
    private Integer euid;

    public static AmlComplaintReply create(CreateAmlComplaintReplyRequest request) {
        final AmlComplaintReply amlComplaintReply = new AmlComplaintReply();
        amlComplaintReply.setId(request.getId());
        amlComplaintReply.setUid(request.getUid());
        amlComplaintReply.setComplaintAlertId(request.getComplaintAlertId());
        amlComplaintReply.setReply(request.getReply());
        amlComplaintReply.setComplaintId(request.getComplaintId());
        amlComplaintReply.setEuid(request.getEuid());
        amlComplaintReply.onCreate();
        amlComplaintReply.setStatus(Status.ACTIVE);
        return amlComplaintReply;
    }
    public void update(final UpdateAmlComplaintReplyrequest request) {
        this.setId(request.getId());
        this.setUid(request.getUid());
        this.setComplaintAlertId(request.getComplaintAlertId());
        this.setReply(request.getReply());
        this.setComplaintId(request.getComplaintId());
        this.setEuid(request.getEuid());
        this.onUpdate();
        this.setStatus(Status.ACTIVE);
    }

}
