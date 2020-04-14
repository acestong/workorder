package com.fea.project.workorder.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.workorder.enums.AttentionEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttentionModel implements Serializable {
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long attentionId;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long workorderId;

    private Long attentionStatus;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long createId;

    private String createBy;

    private Date createTime;

    private static final long serialVersionUID = 1L;


    public AttentionModel(WorkorderModel workorderModel) {
  		// TODO Auto-generated constructor stub
      	this.attentionStatus = workorderModel.getAttentionStatus()==null ? AttentionEnum.NOT_ATTENTION.getStatus().longValue() : workorderModel.getAttentionStatus();
      	this.workorderId = workorderModel.getWorkorderId();
  	}
}