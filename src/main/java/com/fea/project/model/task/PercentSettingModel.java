package com.fea.project.model.task;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class PercentSettingModel implements Serializable {
	/*
	 * 主键id
	 */
    private Long id;

    /*
     * 业务来源id
     */
    private Long resourceBusinessId;

    /*
     * 业务来源类型（0：项目任务；1：常规任务；2：协作组任务；3：销售机会任务；4：市场线索任务）
     */
    private Long resourceBusinessType;

    /*
     * 条件枚举键
     */
    private Long actionId;

    /*
     * 条件枚举值 < > = 等等
     */
    private String actionName;

    /*
     * 业务id
     */
    private Long businessId;

    /*
     * 业务类型
     */
    private Long businessType;

    /*
     * 级别枚举键 
     */
    private Long estimateId;

    /*
     * 级别枚举值 优异 优秀 合格 差 极差
     */
    private String estimateName;

    /*
     * 级别取值（判定值）
     */
    private Double value;

    /*
     * 类型id 预留字段 暂无用
     */
    private Long typeId;

    /*
     * 创建人id
     */
    private Long createId;

    /*
     * 创建人
     */
    private String createBy;

    /*
     * 创建时间
     */
    private Date createTime;

    /*
     * 更新人id
     */
    private Long updateId;

    /*
     * 更新人
     */
    private String updateBy;

    /*
     * 更新时间
     */
    private Date updateTime;

    /*
     * 删除状态
     */
    private Long delStatus;

    private static final long serialVersionUID = 1L;

    public PercentSettingModel(Long actionId,String actionName,Long estimateId,String estimateName,Double value) {
    	this.estimateId = estimateId;
    	this.estimateName = estimateName;
    	this.actionId = actionId;
    	this.actionName = actionName;
    	this.value = value;
    }
}