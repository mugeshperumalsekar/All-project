package com.ponsun.aml.amlTeam.BranchUserMapping.domain;
import com.ponsun.aml.amlTeam.BranchUserMapping.request.CreateBranchUserMappingRequest;
import com.ponsun.aml.amlTeam.BranchUserMapping.request.UpdateBranchUserMappingRequest;
import com.ponsun.aml.common.entity.Status;
import com.ponsun.aml.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "branch_user_mapping")
public class BranchUserMapping extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "branchId")
    private Integer branchId;

    @Column(name = "userId")
    private String userId;

    @Column(name = "entryDate")
    private String entryDate;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "euid")
    private Integer euid;


    public static BranchUserMapping create(CreateBranchUserMappingRequest request) {
        final BranchUserMapping branchUserMapping = new BranchUserMapping();
        branchUserMapping.setId(request.getId());
        branchUserMapping.setBranchId(request.getBranchId());
        branchUserMapping.setUserId(request.getUserId());
        branchUserMapping.setEntryDate(request.getEntryDate());
        branchUserMapping.setUid(request.getUid());
        branchUserMapping.setEuid(request.getEuid());
        branchUserMapping.onCreate();
        branchUserMapping.setStatus(Status.ACTIVE);
        return branchUserMapping;

    }

    public void update(final UpdateBranchUserMappingRequest request) {
        this.setId(request.getId());
        this.setBranchId(request.getBranchId());
        this.setUserId(request.getUserId());
        this.setEntryDate(request.getEntryDate());
        this.setUid(request.getUid());
        this.setEuid(request.getEuid());
        this.onUpdate();
        this.setStatus(Status.ACTIVE);

    }
}