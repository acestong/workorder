package com.fea.project.model.milestone.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.model.project.ProjectStepModel;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Administrator
 */
@Data
public class ProjectStepShowVo extends ProjectStepModel {

    private String leadName;

    private String deptName;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long stepVerifyId;

    private Integer stepVerifyStatus;
    private String stepVerifyStatusName;
    /**
     * 实际开始时间
     */
    private Date stepStartTime;
    /**
     * 实际结束时间
     */
    private Date stepEndTime;
    /**
     * 实际工时
     */
    private BigDecimal stepWorkTime;
    /**
     * 确认人
     */
    private String notarize;
    /**
     * 预警状态
     */
    private String warnStatus;
    /**
     * 完成度
     */
    private String pmgressbar;
    /**
     * 项目名称
     */
    private String projectName;
    /**
     * 是否完成（0未完成，1执行中，2已完成）
     */
    private Integer isFinish;
    /**
     * 预警状态类型
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Integer isWarn;
}
