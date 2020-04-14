package com.fea.project.workorder.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 工序汇报Model
 * @author st
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ProcedureReportModel implements Serializable {
	/*
	 * 主键id
	 */
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /*
     * 工序id
     */
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long procedureId;

    /*
     * 汇报标题
     */
    private String title;

    /*
     *实际开始时间 
     */
    private Date actualStartTime;
    
    /*
     * 实际结束时间
     */
    private Date actualEndTime;
    /*
     * 工序进度
     */
    private Double progrossRate;

    /*
     * 工序汇报内容
     */
    private String content;

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