package com.fea.project.api.other.model.crm.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Administrator
 * @date 2019/09/27
 */
@AllArgsConstructor
@Data
public class OrderPaymentPlanVo implements Serializable {
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
     * 组织id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long orgId;

    /**
     * 组织注册id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long regId;
    /**
     * 创建人id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long createUserId;
    /**
     * 创建人
     */
    private String createUser;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新人id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long updateUserId;
    /**
     * 更新人
     */
    private String updateUser;
    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 回款计划id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long paymentPlanId;

    /**
     * 回款条件
     */
    private String collectionTerms;

    /**
     * 预计回款时间
     */
    private Date estimatedDate;

    /**
     * 回款比例
     */
    private String paymentRate;

    /**
     * 回款金额
     */
    private Double amount;

    /**
     * 回款计划状态(0未回款，1已回款)
     */
    private Integer state;
    private String stateString;

    /**
     * 回款时间
     */
    private Date paymentDate;

    /**
     * 支付项目名称
     */
    private String paymentProjectName;
    /**
     * 备注
     */
    private String remarks;

    /**
     * 业务id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long businessId;
    /**
     * 收款计划类型
     */
    private Integer planType;
    /**
     * 业务负责人id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long businessOwnerId;
    /**
     * 实际收款日期
     */
    private Date lastGatherDate;
    /**
     * 实际收款金额
     */
    private Double gatherAmount;
    /**
     * 待收款金额
     */
    private Double needAmount;
    /**
     *计划名称
     */
    private String name;
    /**
     *开发票数额
     */
    private Double invoiceAmount;

    private Double ninvoiceAmount;
    /**
     * 0表示未变更，1表示变更后
     */
    private String beforeChange;
    /**
     * 订单ID
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long orderId;
    //@JsonIgnore
    private String orderNum;
    //@JsonIgnore
    private String orderName;
    /**
     * 合同
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long contractId;
    private String contractName;
    /**
     * 审核状态
     */
    private Integer auditState;
    private String auditStatus;
    /**
     * 币种
     */
    private String currency;
    private String isInvoice;
    /**
     * 计划状态
     *
     */
    private Integer planStatus;
    private String planStatusString;
    public OrderPaymentPlanVo() {
        
    }

}