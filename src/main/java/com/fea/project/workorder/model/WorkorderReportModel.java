package com.fea.project.workorder.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.configure.exception.SystemParamCheckException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkorderReportModel implements Serializable {
	
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long reportId;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long workorderId;

    private String reportTitle;

    private Date actualStartTime;

    private Date actualEndTime;

    private Double actualWorkHour;

    private Double workorderProgrossRate;

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