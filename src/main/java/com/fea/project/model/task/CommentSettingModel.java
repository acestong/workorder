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
@EqualsAndHashCode
@ToString
public class CommentSettingModel implements Serializable {
	/*
	 * 主键Id
	 */
    private Long id;

    /*
     * 业务来源Id
     */
    private Long resourceBusinessId;

    /*
     * 业务来源类型（0：项目任务；1：常规任务；2：协作组任务；3：销售机会任务；4：市场线索任务）
     */
    private Long resourceBusinessType;

    /*
     * 组织Id
     */
    private Long orgId;

    /*
     * 质量权重
     */
    private Double qualityEstimateWeight;

    /*
     * 时间权重
     */
    private Double timeEstimateWeight;

    /*
     * 创建人Id
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

    public CommentSettingModel(Long resourceBusinessId,Long resourceBusinessType) {
    	this.resourceBusinessId = resourceBusinessId;
    	this.resourceBusinessType = resourceBusinessType;
    }
    
    public CommentSettingModel(Double qualityEstimateWeight,Double timeEstimateWeight) {
    	this.qualityEstimateWeight = qualityEstimateWeight;
    	this.timeEstimateWeight = timeEstimateWeight;
    }
}