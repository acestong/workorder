package com.fea.project.model.milestone.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.model.base.AppendixModel;
import com.fea.project.model.plan.vo.AppendixIdAndNameInfoModelVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019/11/01.
 */
@AllArgsConstructor
@Builder
@Data
public class ProjectMilestoneDeliverableVo implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     * 里程碑交付物主键id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /**
     * 里程碑id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long milestoneId;

    /**
     * 交付物名称
     */
    private String deliverableName;

    /**
     * 交付物编号
     */
    private String deliverableNumber;

    /**
     * 关联交付要求id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long deliveryId;

    /**
     * 关联要求交付物名称
     */
    private String deliveryName;

    /**
     * 交付物说明
     */
    private String description;
    /**
     * 创建人id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long createId;

    /**
     * 创建人姓名
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新人id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long updateId;

    /**
     * 更新人姓名
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     *
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long orgId;

    /**
     * 组织id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long regId;
    /**
     * 附件数量
     */
    private Integer appendixCount;
    /**
     * 附件列表
     */
    private List<AppendixIdAndNameInfoModelVo> appendixList;
    /**
     * 审核人
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long verifyer;
    private String verifyerName;
    /**
     * 审核评分
     */
    private Double verifyerScore;

    /**
     * 审核状态
     */
    private Integer verifyerStatus;
    private String verifyerStatusString;

    /**
     * 审核时间
     */
    private Date verifyerTime;

    /**
     * 交付人
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long deliver;

    /**
     * 交付状态
     */
    private Integer deliverStatus;
    private String deliverStatusString;
    /**
     * 交付时间
     */
    private Date deliverTime;

    public ProjectMilestoneDeliverableVo() {

    }

    public ProjectMilestoneDeliverableVo(Long id, Long milestoneId, String deliverableName, String deliverableNumber, Long deliveryId, String deliveryName, String description, Long createId, String createBy, Date createTime, Long updateId, String updateBy, Date updateTime, Long orgId, Long regId, Integer appendixCount, Long verifyer, Double verifyerScore, Integer verifyerStatus, String verifyerStatusString, Date verifyerTime, Long deliver, Integer deliverStatus, String deliverStatusString, Date deliverTime) {
        this.id = id;
        this.milestoneId = milestoneId;
        this.deliverableName = deliverableName;
        this.deliverableNumber = deliverableNumber;
        this.deliveryId = deliveryId;
        this.deliveryName = deliveryName;
        this.description = description;
        this.createId = createId;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateId = updateId;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.orgId = orgId;
        this.regId = regId;
        this.appendixCount = appendixCount;
        this.verifyer = verifyer;
        this.verifyerScore = verifyerScore;
        this.verifyerStatus = verifyerStatus;
        this.verifyerStatusString = verifyerStatusString;
        this.verifyerTime = verifyerTime;
        this.deliver = deliver;
        this.deliverStatus = deliverStatus;
        this.deliverStatusString = deliverStatusString;
        this.deliverTime = deliverTime;
    }

    public ProjectMilestoneDeliverableVo(Long id, Long milestoneId, String deliverableName, String deliverableNumber, Long deliveryId, String deliveryName, String description, Long createId, String createBy, Date createTime, Long updateId, String updateBy, Date updateTime, Long orgId, Long regId, Integer appendixCount, Long verifyer, Double verifyerScore, Integer verifyerStatus, Date verifyerTime, Long deliver, Integer deliverStatus, Date deliverTime) {
        this.id = id;
        this.milestoneId = milestoneId;
        this.deliverableName = deliverableName;
        this.deliverableNumber = deliverableNumber;
        this.deliveryId = deliveryId;
        this.deliveryName = deliveryName;
        this.description = description;
        this.createId = createId;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateId = updateId;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.orgId = orgId;
        this.regId = regId;
        this.appendixCount = appendixCount;
        this.verifyer = verifyer;
        this.verifyerScore = verifyerScore;
        this.verifyerStatus = verifyerStatus;
        this.verifyerTime = verifyerTime;
        this.deliver = deliver;
        this.deliverStatus = deliverStatus;
        this.deliverTime = deliverTime;
    }
}