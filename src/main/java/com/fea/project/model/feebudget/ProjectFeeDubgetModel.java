package com.fea.project.model.feebudget;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2019/12/10.
 */
@Data
@Builder
public class ProjectFeeDubgetModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /**
     * 父id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long parentId;

    /**
     * 组织id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long regId;

    /**
     * 
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long orgId;

    /**
     * 项目id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long projectId;

    /**
     * 预算名称
     */
    private String name;

    /**
     * 预算版本
     */
    private Long version;

    /**
     * 预算编号
     */
    private String num;

    /**
     * 预算金额
     */
    private BigDecimal amount;

    /**
     * 币种id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long currencyId;

    /**
     * 币种
     */
    private String currency;

    /**
     * 费用类型
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long type;
    private String typeString;

    /**
     * 预算关联项目阶段id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long stepId;

    /**
     * 预算关联项目阶段
     */
    private String stage;

    /**
     * 预算开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    /**
     * 预算完成时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    /**
     * 实际结束时间
     */
    private Date finishTime;

    /**
     * 预算说明
     */
    private String declares;

    /**
     * 审批状态
     */
    private Integer checkStatus;
    private String checkStatusString;

    /**
     * 审核标题
     */
    private String checkTitle;

    /**
     * 审核说明
     */
    private String checkExplain;

    /**
     * 创建人id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long createId;
    /**
     * 是否为草稿 0-不是 1-是 2-已变更
     */
    private Integer isDraft;

    /**
     * 创建人名称
     */
    private String createBy;

    /**
     * 创建人时间
     */
    private Date createTime;

    /**
     * 更新人id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long updateId;

    /**
     * 更新人名称
     */
    private String updateBy;

    /**
     * 更新人时间
     */
    private Date updateTime;

    /**
     * 删除标识
     */
    private Integer delStatus;



    public ProjectFeeDubgetModel () {
        
    }

    public ProjectFeeDubgetModel(Long id, Long parentId, Long regId, Long orgId, Long projectId, String name, Long version, String num, BigDecimal amount, Long currencyId, String currency, Long type, String typeString, Long stepId, String stage, Date startTime, Date endTime, Date finishTime, String declares, Integer checkStatus, String checkStatusString, String checkTitle, String checkExplain, Long createId, Integer isDraft, String createBy, Date createTime, Long updateId, String updateBy, Date updateTime, Integer delStatus) {
        this.id = id;
        this.parentId = parentId;
        this.regId = regId;
        this.orgId = orgId;
        this.projectId = projectId;
        this.name = name;
        this.version = version;
        this.num = num;
        this.amount = amount;
        this.currencyId = currencyId;
        this.currency = currency;
        this.type = type;
        this.typeString = typeString;
        this.stepId = stepId;
        this.stage = stage;
        this.startTime = startTime;
        this.endTime = endTime;
        this.finishTime = finishTime;
        this.declares = declares;
        this.checkStatus = checkStatus;
        this.checkStatusString = checkStatusString;
        this.checkTitle = checkTitle;
        this.checkExplain = checkExplain;
        this.createId = createId;
        this.isDraft = isDraft;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateId = updateId;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.delStatus = delStatus;
    }
}