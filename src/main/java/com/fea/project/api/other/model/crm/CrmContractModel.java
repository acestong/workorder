package com.fea.project.api.other.model.crm;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.api.other.io.project.IProjectBusinessModel;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2019/09/26.
 * 合同 实体类
 */
@Data
public class CrmContractModel implements Serializable, IProjectBusinessModel {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long id;

    /**
     * 合同编号
     */
    protected String code;

    /**
     * 合同名称
     */
    protected String name;

    /**
     * 版本号
     */
    protected String version;

    /**
     * 合同类型
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long assortment;

    /**
     * 合同签约状态  0待签合同，1已签合同
     */
    protected Integer type;

    /**
     *
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long parentId;


    /**
     * 负责人/业务员
     */
    protected String owner;

    /**
     * 负责人ID
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long ownerId;


    /**
     * 业务类型
     */
    protected Integer businessType;


    /**
     * 客户名称
     */
    protected String customerName;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long createUserId;
    protected Date createTime;
    protected String createUserName;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long updateUserId;
    protected Date updateTime;
    protected String updateUserName;


    /**
     *
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long regId;

    /**
     * 申请状态
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long applyState;


    /**
     * 客户标识
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long customerId;

    /**
     * 所属部门
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long orgId;

    /**
     * 父合同名称
     */
    protected String parentName;


    /**
     * 签约时间
     */
    protected Date signTime;

    protected Integer isRemove;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long businessId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long currencyId;

    protected BigDecimal amount;


    @Override
    public String getShowName() {
        return name;
    }
    /**
     * 合同额（原始金额）单位为（美元，欧元，人民币）等
     */
    //private Double amount;
}