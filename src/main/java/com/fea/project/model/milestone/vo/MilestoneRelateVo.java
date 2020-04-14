package com.fea.project.model.milestone.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.model.plan.vo.PlanAndSonPlanModelVo;
import com.fea.project.model.task.vo.TaskAndSonTaskModelVo;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @author Administrator
 * 里程碑关联计划，任务通用vo
 */
@AllArgsConstructor
@Data
public class MilestoneRelateVo {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    private String name;

    private String num;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long projectId;
    /**
     * 项目名称
     */
    private String projectName;

    private Long projectStep;

    private String projectStepStr;
    /**
     * 状态
     */
    private Long status;
    private String statusStr;
    /**
     * 负责人及所属团队*/
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long leaderId;
    private String leaderName;
    private Long leaderTeamId;
    private String leaderTeamName;
    /**
     * 负责团队及团队负责人*/
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long teamId;
    private String teamName;
    private Long teamLeaderId;
    private String teamLeaderName;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long createId;

    private String createBy;

    private Date createTime;

    public MilestoneRelateVo() {
    }

    public MilestoneRelateVo(PlanAndSonPlanModelVo modelVo) {
        this.id = modelVo.getPlanId();
        this.name = modelVo.getPlanName();
        this.num = modelVo.getPlanNum();
        this.projectId = modelVo.getProjectId();
        this.projectName = modelVo.getProjectName();
        this.projectStep = modelVo.getProjectStep();
        this.projectStepStr = modelVo.getProjectStepStr();
        this.status = modelVo.getCheckStatus();

        this.createId = modelVo.getCreateId();
        this.createBy = modelVo.getCreateBy();
        this.createTime = modelVo.getCreateTime();
    }

    public MilestoneRelateVo(TaskAndSonTaskModelVo modelVo) {
        this.id = modelVo.getTaskId();
        this.name = modelVo.getTaskName();
        this.num = modelVo.getTaskNum();
        this.projectId = modelVo.getProjectId();

        this.projectStep = modelVo.getProjectStep();
        this.projectStepStr = modelVo.getProjectStepStr();


        this.createId = modelVo.getCreateId();
        this.createBy = modelVo.getCreateBy();
        this.createTime = modelVo.getCreateTime();
    }
}
