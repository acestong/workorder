package com.fea.project.model.milestone.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 *
 * @author Administrator
 * @date 2019/10/19
 * 项目里程碑
 */
@AllArgsConstructor
@Data
public class ProjectMilestoneVo {

    /**
     * id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /**
     * 里程碑名称
     */
    private String name;

    /**
     * 里程碑编号
     */
    private String number;

    /**
     * 里程碑类型（进度，回款，验收等里程碑）
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long type;
    private String typeString;
    /**
     * 排序序号
     */
    private Integer sort;

    /**
     * 项目id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long projectId;
    /**
     * 项目名称
     */
    private String projectName;
    /**
     * 项目编号
     */
    private String code;

    /**
     * 关联项目阶段id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long projectStageId;

    /**
     * 关联项目阶段
     */
    private String projectStage;

    /**
     * 开始时间（上一里程碑完成时间）
     */
    private Date startTime;

    /**
     * 结束时间（里程碑时间）
     */
    private Date endTime;

    /**
     * 负责人id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long ownerId;

    /**
     * 负责人
     */
    private String owner;

    /**
     * 负责团队id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long teamId;

    /**
     * 负责团队
     */
    private String team;

    /**
     * 里程碑目标
     */
    private String target;

    /**
     * 里程碑说明
     */
    private String remark;

    /**
     * 审核状态(1未提交，2已提交)
     */
    private Integer status;
    private String statusString;
    /**
     *
     */
    private Long createId;

    /**
     *
     */
    private String createBy;

    /**
     *
     */
    private Date createTime;

    /**
     *
     */
    private Long updateId;

    /**
     *
     */
    private String updateBy;

    /**
     *
     */
    private Date updateTime;
    /**
     * 版本
     */
    private Integer version;
    /**
     * 组织id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long orgId;

    /**
     * 注册id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long regId;
    /**
     * 是否完成（0未完成，1执行中，2已完成）
     */
    private Integer isFinish;
    private String isFinishStr;
    /**
     * 确认完成时间
     */
    private Date finishTime;
    /**
     * 确认人
     */
    private String notarize;

    /**
     * 说明
     */
    private String description;
    /**
     * 预警状态
     */
    private String warnStatus;
    /**
     * 完成度
     */
    private String pmgressbar;

    /**
     * 预警状态类型
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Integer isWarn;


    public ProjectMilestoneVo() {
        
    }

}