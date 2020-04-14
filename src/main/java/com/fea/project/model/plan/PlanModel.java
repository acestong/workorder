package com.fea.project.model.plan;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class PlanModel implements Serializable {
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long planId;

    private String planName;

    private Long planVersion;

    private String planApplyDesc;
 
    private String planNum;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long parentPlanId;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long projectId;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long projectStep;

    private Long priority;

    private Date planStarttime;

    private Date planEndtime;

    private Date planDeadline;

    private Long planDuration;
    //负责人或者团队（0代表负责人方式，1代表团队方式）
    private Long leaderIdOrTeamId;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long planLeaderId;
    
    private String planLeaderName;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long planTeamId;
    
    private String planTeamName;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long planParticipantId;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long planMilestoneId;

    private Long planRemindHour;

    private String planContent;

    private String planRemark;

    private Long checkStatus;

    private Long planType;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long createId;

    private String createBy;

    private Date createTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long updateId;

    private String updateBy;

    private Date updateTime;

    private Long delStatus;

    private static final long serialVersionUID = 1L;

}