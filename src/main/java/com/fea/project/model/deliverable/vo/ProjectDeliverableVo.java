package com.fea.project.model.deliverable.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Administrator
 * @date 2019/12/06
 */
@AllArgsConstructor
@Data
public class ProjectDeliverableVo implements Serializable , Comparable<ProjectDeliverableVo> {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     * 项目交付物主键id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /**
     * 业务id（项目id等）
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long businessId;

    /**
     * 业务名称
     */
    private String businessName;

    /**
     * 项目阶段id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long projectStep;
    /**
     * 项目阶段名称
     */
    private String projectStepName;
    /**
     * 交付物名称
     */
    private String deliverableName;

    /**
     * 交付物编号
     */
    private String deliverableNum;
    /**
     * 交付物类型
     */
    private Integer deliverableType;
    private String deliverableTypeString;
    /**
     * 关联交付要求id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long deliveryId;

    /**
     * 关联交付要求名称
     */
    private String deliveryName;
    /**
     * 要求交付时间
     */
    private Date deliveryTime;
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
     * 删除状态(0正常，1删除)
     */
    @JsonIgnore
    private Integer delState;

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
    private String deliverName;
    /**
     * 交付人所属团队
     */
    private String team;
    /**
     * 交付状态
     */
    private Integer deliverStatus;
    private String deliverStatusString;
    /**
     * 交付时间
     */
    private Date deliverTime;

    /**
     * 项目id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long projectId;
    private String projectName;
    /**
     * 附件数量
     */
    private Integer appendixCount;

    public ProjectDeliverableVo() {

    }

    /**
     * 比较器排序
     */
    @Override
    public int compareTo(ProjectDeliverableVo o) {

        return o.createTime.compareTo(this.createTime);
    }


}