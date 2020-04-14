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
public class DeliverableSettingModel implements Serializable {
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
     * 交付物id
     */
    private Long deliverableId;

    /*
     * 质量权重
     */
    private Double qualityEstimateWeight;

    /*
     * 时间权重
     */
    private Double timeEstimateWeight;

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

    public DeliverableSettingModel(Double qualityEstimateWeight,Double timeEstimateWeight) {
    	this.timeEstimateWeight = timeEstimateWeight;
    	this.qualityEstimateWeight = qualityEstimateWeight;
    }
}