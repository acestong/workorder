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
 * 工单池Model
 * @author st
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class PoolModel implements Serializable {
	/*
	 * 工单池id
	 */
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long workorderPoolId;

    /*
     * 工单池名称
     */
    private String poolName;

    /*
     * 工单池说明
     */
    private String poolDesc;

    /*
     * 工单池管理员
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long poolManagerId;
    /*
     * 工单池管理员
     */
    private String poolManagerName;

    /*
     * 是否自动分配 来源 com.fea.project.workorder.enums.IsAutoDispatchEnum
     */
    private Long isAutoDispatch;

    /*
     * 工单选择 按照业务需要创建枚举
     */
    private Long workorderSelectionType;
    
    /*
     * 下单自动分配规则
     */
    private Long autoDispatchRule;
    
    /*
     * 是否提醒  来源 com.fea.project.workorder.enums.IsRemindEnum 
     */
    private Long isRemind;

    /*
     * 提醒的时间数
     */
    private Double remindCount;

    /*
     * 提醒单位  天、小时
     */
    private String remindUnit;

    /*
     * 提醒id，预留 
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long remindId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long createId;

    private String createBy;

    private Date createTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long orgId;

    private static final long serialVersionUID = 1L;
}