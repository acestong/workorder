package com.fea.project.model.task;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class TaskDeliverProductModel implements Serializable {
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long deliverProductId;

    private String deliverProductName;
    
    private String deliverProductNum;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long taskId;
    
    private TaskModel taskModel;

    private Date taskDeliverTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long taskDelivererId; 

    private String taskDelivererName;

    private Long taskDeliverStatus;

    private Long deliverCheckScore;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long deliverCheckerId;

    private String deliverProduceDesc;

    private Date deliveryCheckTime;

    private Long createId;

    private String createBy;

    private Date createTime;

    private Long updateId;

    private String updateBy;

    private Date updateTime;

    private Long delStatus;

    private static final long serialVersionUID = 1L;
}