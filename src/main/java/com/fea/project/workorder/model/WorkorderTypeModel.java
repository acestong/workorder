package com.fea.project.workorder.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.workorder.enums.DeleteStatusEnum;
import com.fea.project.workorder.enums.InsertOrUpdateEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 工单类型Model
 * @author st
 *
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@ToString
public class WorkorderTypeModel implements Serializable {
	
	/*
	 * 工单类型id
	 */
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long workorderTypeId;

    /*
     * 父工单类型id
     */
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long parentTypeId;

    /*
     * 工单类型名称
     */
    private String workorderTypeName;

    /*
     * 组织id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long orgId;
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