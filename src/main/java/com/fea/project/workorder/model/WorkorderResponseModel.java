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
 * 工单响应Model
 * @author st
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class WorkorderResponseModel implements Serializable {
	/*
	 * 响应id
	 */
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long responseId;

    /*
     * 响应状态 来源枚举 com.fea.project.workorder.enums.IsConfirmEnum
     */
    private Long isConfirm;

    /*
     * 确认工单时，为工单确认说明，驳回时为工单驳回说明
     */
    private String isConfirmDesc;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long createId;

    private String createBy;

    private Date createTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long workorderId;

    private static final long serialVersionUID = 1L;
    
}