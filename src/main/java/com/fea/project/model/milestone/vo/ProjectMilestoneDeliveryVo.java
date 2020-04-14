package com.fea.project.model.milestone.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.model.plan.vo.AppendixIdAndNameInfoModelVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Administrator
 * @date 2019/10/21
 * 项目里程碑交付物 实体类
 */
@AllArgsConstructor
@Builder
@Data
public class ProjectMilestoneDeliveryVo implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /**
     * 里程碑id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long milestoneId;

    /**
     * 要求交付物名称
     */
    private String name;

    /**
     * 要求交付时间
     */
    private Date deliveryTime;

    /**
     * 负责人id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long ownerId;

    /**
     * 负责人
     */
    private String owner;

    /**
     * 负责团队id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long teamId;

    /**
     * 负责团队
     */
    private String teamName;

    /**
     * 交付要求说明
     */
    private String requirement;

    /**
     * 排序
     */
    private Integer sort;

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
     * 附件数量
     */
    private Integer appendixCount;
    /**
     * 附件列表
     */
    private List<AppendixIdAndNameInfoModelVo> appendixList;
    /**
     * 交付状态
     */
    private Integer deliveryStatus;
    private String deliveryStatusString;
    /**
     * 实际交付时间
     */
    private Date deliverableTime;

    /**
     * 审核人
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long verifyer;
    private String verifyerName;
    /**
     * 审核状态
     */
    private Integer verifyerStatus;
    private String verifyerStatusString;
    /**
     * 审核时间
     */
    private Date verifyerTime;

    public ProjectMilestoneDeliveryVo() {
        
    }
}