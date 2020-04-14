package com.fea.project.model.plan;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.enums.plan.PlanHeadShowStatusEnum;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class PlanHeadStatusModel implements Serializable {
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long curUserId;

    private Long planHeadStatusId;
    private Long planId;
    private Long planName;
    private Long planVersion;
    private Long planApplyDesc;
    private Long planNum; 
    private Long parentPlanId;
    private Long projectId;

    private Long projectStep;

    private Long priority;

    private Long planStarttime;

    private Long planEndtime;

    private Long planDeadline;

    private Long planDuration;
	private Long planLeaderId;
    private Long planTeamId;
    private Long planMilestoneId;
    private Long planRemindHour;
    private Long planContent;
    private Long planAppendixId;
    private Long associationPlanId;
    private Long deliveryRequirementId;
    private Long reportRequirementId;
    private Long qualityRequirementId;
    private Long planRemark;
    private Long checkStatus;
    private Long createId;
    private Long createBy;
    private Long createTime;
    private Long updateId;
    private Long updateBy;
    private Long updateTime;
    private Long delStatus;
    private static final long serialVersionUID = 1L;

    
    public PlanHeadStatusModel(Long curUserId) {
    	this.curUserId = curUserId;
		this.planId = PlanHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.planName = PlanHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.planVersion = PlanHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.planApplyDesc = PlanHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.planNum = PlanHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.parentPlanId = PlanHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.projectId = PlanHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.projectStep = PlanHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.priority = PlanHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.planStarttime = PlanHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.planEndtime = PlanHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.planDeadline = PlanHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.planDuration = PlanHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.planLeaderId = PlanHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.planTeamId = PlanHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.planMilestoneId = PlanHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.planRemindHour = PlanHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.planContent = PlanHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.planAppendixId = PlanHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.associationPlanId = PlanHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.deliveryRequirementId = PlanHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.reportRequirementId = PlanHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.qualityRequirementId = PlanHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.planRemark = PlanHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.checkStatus = PlanHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.createId = PlanHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.createBy = PlanHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.createTime = PlanHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.updateId = PlanHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.updateBy = PlanHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.updateTime = PlanHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.delStatus = PlanHeadShowStatusEnum.SHOWN.getStatus().longValue();
    }


    
}