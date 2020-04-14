package com.fea.project.model.feebudget;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2019/12/16.
 */
@Data
public class ProjectFeeCostModel implements Serializable {
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
     * 项目id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long projectId;

    /**
     * 项目预算id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long projectFeeBudgetId;

    /**
     * 成本类型  1--物料成本 2-其他成本
     */
    private Integer costType;

    /**
     * 物料名称/成本名称
     */
    private String name;

    /**
     * 费用类型
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long type;
    private String feeTypeString;

    /**
     * 数量
     */
    private BigDecimal count;

    /**
     * 单位
     */
    private String unit;

    /**
     * 单价
     */
    private BigDecimal price;

    /**
     * 单价币种
     */
    private String priceCurrency;

    /**
     * 成本
     */
    private BigDecimal cost;

    /**
     * 成本币种
     */
    private String costCurrency;

    /**
     * 使用方式
     */
    private String useType;

    /**
     * 使用开始时间
     */
    private Date startTime;

    /**
     * 使用结束时间
     */
    private Date endTime;

    /**
     * 创建人id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long createId;

    /**
     * 创建人
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
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除
     */
    private Integer delStatus;



}