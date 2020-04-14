package com.fea.project.api.other.model.crm;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.api.other.io.project.IProjectBusinessModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2019/09/26.
 */
@Data
public class CrmSaleChanceModel implements Serializable, IProjectBusinessModel {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     * 自增标识
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long id;

    /**
     * 客户ID
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long customerId;

    /**
     * 客户名称
     */
    protected String customer;


    /**
     *
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long trailId;

    /**
     * 线索名称
     */
    protected String trail;

    /**
     * 优先级ID
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long priorityId;

    /**
     * 优先级名称
     */
    protected String priority;

    /**
     * 机会名称
     */
    protected String name;

    /**
     * 机会编码
     */
    protected String code;

    /**
     * 当前阶段ID
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long stageId;

    /**
     * 当前阶段名称
     */
    protected String stage;

    /**
     * 签约可能性ID
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long signingId;

    /**
     * 签约可能性
     */
    protected String signing;

    /**
     * 预计签约金额
     */
    protected Double money;

    /**
     * 预计签约时间
     */
    protected Date signTime;

    /**
     * 业绩权重
     */
    protected Double saleWeight;

    /**
     * 创建人ID
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long createUserId;

    /**
     * 创建人
     */
    protected String createUser;

    /**
     * 创建时间
     */
    protected Date createTime;

    /**
     * 修改人ID
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long updateUserId;

    /**
     * 修改人
     */
    protected String updateUser;

    /**
     * 修改时间
     */
    protected Date updateTime;

    /**
     * 备注
     */
    protected String description;

    /**
     * 负责人编号
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long ownerId;

    /**
     * 负责人
     */
    protected String owner;

    /**
     * 状态
     */
    protected String status;


    /**
     * 状态	1:审核中 2:跟进中 5:已完成 6:已失败 7:暂挂 8:中止
     */
    protected Integer approveStatus;


    /**
     * 是否删除
     */
    protected Integer delState;


    /**
     * 组织注册编号
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long regId;

    /**
     *
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long orgId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long saleChanceTypeId;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long currencyId;


    @Override
    public String getShowName() {
        return name;
    }
}