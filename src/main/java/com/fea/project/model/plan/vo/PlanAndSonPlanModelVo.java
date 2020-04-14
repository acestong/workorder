package com.fea.project.model.plan.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.model.plan.PlanModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PlanAndSonPlanModelVo extends PlanModel implements Serializable{
	
    /*
     * 父项目名称
     */
    private String parentPlanName;
    /*
     * 项目名称
     */
    private String projectName;
    
    private String projectStepStr;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    /*
     * 页面中按照枚举类型数字返回信息
     */
    private String priorityStr;

    private String checkStatusStr;
    @JsonFormat(shape = JsonFormat.Shape.STRING)

    private List<ProjectUserIdAndNameInfoModelVO> planParticipantInfos;
    
    /*
     * 里程碑名称
     */
    private String milestoneName;
    
    
    private List<PlanAndSonPlanModelVo> children;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private List<Long> projectStepList;
    
    private static final long serialVersionUID = 1L;
    
    public PlanAndSonPlanModelVo(PlanModel planModel) {
    	super();
    	super.setPlanId(planModel.getPlanId());
    	super.setPlanName(planModel.getPlanName());
		super.setPlanVersion(planModel.getPlanVersion());
		super.setPlanApplyDesc(planModel.getPlanApplyDesc());
		super.setPlanNum(planModel.getPlanNum());
		super.setParentPlanId(planModel.getParentPlanId());
		super.setProjectId(planModel.getProjectId());
		super.setProjectStep(planModel.getProjectStep());
		super.setPriority(planModel.getPriority());
		super.setPlanStarttime(planModel.getPlanStarttime());
		super.setPlanEndtime(planModel.getPlanEndtime());
		super.setPlanDeadline(planModel.getPlanDeadline());
		super.setPlanDuration(planModel.getPlanDuration());
		super.setPlanLeaderId(planModel.getPlanLeaderId());
		super.setPlanTeamId(planModel.getPlanTeamId());
		super.setPlanParticipantId(planModel.getPlanParticipantId());
		super.setPlanMilestoneId(planModel.getPlanMilestoneId());
		super.setPlanRemindHour(planModel.getPlanRemindHour());
		super.setPlanContent(planModel.getPlanContent());
		super.setPlanRemark(planModel.getPlanRemark());
		super.setCheckStatus(planModel.getCheckStatus());
		super.setPlanType(planModel.getPlanType());
		super.setCreateId(planModel.getCreateId());
		super.setCreateBy(planModel.getCreateBy());
		super.setCreateTime(planModel.getCreateTime());
		super.setUpdateId(planModel.getUpdateId());
		super.setUpdateBy(planModel.getUpdateBy());
		super.setUpdateTime(planModel.getUpdateTime());
		super.setDelStatus(planModel.getDelStatus());
    }

   
    

}