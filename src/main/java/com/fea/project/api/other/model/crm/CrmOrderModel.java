package com.fea.project.api.other.model.crm;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.api.other.io.project.IProjectBusinessModel;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2019/09/30.
 */
@Data
public class CrmOrderModel implements Serializable, IProjectBusinessModel {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     * 订单id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /**
     * 订单编号(自动生成)
     */
    private String num;

    /**
     * 订单名称/订单标题
     */
    private String title;

    /**
     * 订单来源
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long sources;

    /**
     * 订单金额=含税总额
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal money;

    /**
     * 订单类型
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long orderType;

    /**
     * 订单状态(0-未开始 1-执行中 2-已完成)
     */
    private Integer status;

    /**
     * 客户id，从客户列表选择
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long customId;

    /**
     * 下单时间
     */
    private Date orderTime;

    /**
     * 合同id（客户下的合同)
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long contractId;

    /**
     * 预计交货期
     */
    private Date planDelivery;

    /**
     * 收货人姓名
     */
    private String consignee;

    /**
     * 收货人电话
     */
    private String consigneePhone;

    /**
     * 收货人地址
     */
    private String consigneePlace;

    /**
     * 邮箱
     */
    private String consigneeEmail;

    /**
     * 负责销售
     */
    private String chargeSale;

    /**
     * 审核状态(0-未审核1--审核中 2-审核通过 3-驳回)
     */
    private Integer checkStatus;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long createId;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long updateId;

    /**
     * 修改人
     */
    private String updatedBy;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 是否删除（0-未删除 1-已删除）
     */
    private Integer delStatus;

    /**
     * 订单产品金额合计
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal totalAmount;

    /**
     * 是否折扣(0-否 1-是)，默认0
     */
    private Integer isDiscount;

    /**
     * 折扣方式
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long discountMethod;

    /**
     * 折扣率
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal discountRate;

    /**
     * 折后金额
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal discountedMoney;

    /**
     * 订单产品备注
     */
    private String productRemark;

    /**
     * 项目id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long projectId;
    /**
     * 客户名称
     */
    private String customName;
    /**
     * 合同名称
     */
    private String contractName;
    /**
     * 主要联系人
     */
    private String linkman;
    private String phone;
    private String place;
    /**
     * 币种
     */
    private String currency;
    /**
     * 组织id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long regId;


    public CrmOrderModel(Long regId) {
        this.regId = regId;
    }

    @Override
    public String getShowName() {
        return title;
    }
    /**
     * 负责人id
     */
    private Long chargeSaleId;
    /**
     * 申请标题
     */
    private String applyTitle;

    /**
     * 申请人ID
     */
    private Long applyUserId;

    /**
     * 申请人名称
     */
    private String applyUserName;

    /**
     * 申请时间
     */
    private Date applyTime;

    /**
     * 申请备注
     */
    private String applyRemark;
    /**
     * 审核状态(0-未审核1--审核中 2-审核通过 3-驳回)
     */
    private Integer verifyStatus;
}