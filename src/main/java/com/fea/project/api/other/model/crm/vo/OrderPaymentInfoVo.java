package com.fea.project.api.other.model.crm.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2019/09/29.
 */
@Data
public class OrderPaymentInfoVo implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;
    /**
     * 自增标识
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    /**
     * 注册id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long regId;
    /**
     * 组织id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long orgId;
    /**
     * 收款单号
     */
    private String code;
    /**
     * 计划名称
     */
    private String planName;
    /**
     * 收款类型
     */
    private Integer paymentType;
    /**
     * 收款日期
     */
    private Date gatherTime;
    /**
     * 收款期次
     */
    private Integer count;
    /**
     * 币种ID
     */
    private Long currencyId;
    /**
     * 币种
     */
    private String currency;
    /**
     * 款项说明
     */
    private String description;
    /**
     * 支付方式
     */
    private Integer paymentWay;

    /**
     * 核销状态
     */
    private Integer cancelStatus;
    /**
     * 核销金额
     */
    private Double cancelAmount;
    /**
     * 未核销金额
     */
    private Double noCancelAmount;
    /**
     * 认领状态
     */
    private String claimStatus;
    /**
     * 认领金额
     */
    private Double claimAmount;
    /**
     * 认领编号
     */
    private String claimCode;
    /**
     * 合同id
     */
    private Long contractId;
    private String contractName;
    /**
     * 订单id
     */
    private Long orderId;
    private String orderName;
    /**
     * 回款计划id
     */
    private Long paymentPlanListId;
    private String paymentPlanName;
    /**
     * 回款计划金额
     */
    private Double planAmount;
    /**
     * 回款金额
     */
    private Double gatherAmount;
    /**
     * 认领人
     */
    private Long claimUser;
    private String claimUserString;
    /**
     * 认领时间
     */
    private Date claimTime;

    /**
     * 创建人
     */
    private String createBy;
    private Date createTime;
    public OrderPaymentInfoVo() {
        
    }

}