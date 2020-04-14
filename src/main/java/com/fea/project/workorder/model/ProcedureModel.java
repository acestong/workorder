package com.fea.project.workorder.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 工序model
 * @author st
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcedureModel implements Serializable {
	/*
	 * 工序id
	 */
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long procedureId;

    /*
     * 任务id，预留
     */
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long taskId;

    /*
     * 工序名称
     */
    private String procedureName;

    /*
     * 部门id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long deptId;

    /*
     * 部门名称
     */
    private String deptName;

    /*
     * 负责人id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long leaderId;

    /*
     * 负责人名称
     */
    private String leaderName;

    /*
     * 工序工时
     */
    private Double procedureWorkHour;

    /*
     * 工序排序
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long procedureOrderNum;

    /*
     * 前置工序
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long preProcedureId;

    /*
     * 工序内容
     */
    private String procedureContent;

    /*
     * 工单模板id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long workorderId;

    /*
     * 模板id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long mouldId;

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