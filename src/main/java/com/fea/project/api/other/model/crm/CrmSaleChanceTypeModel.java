package com.fea.project.api.other.model.crm;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2019/11/11.
 */
@Data
public class CrmSaleChanceTypeModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     * 销售机会类型配置表-用于URM-销售分析预测-目标看板-缺口优化算法---20161102
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long ID;

    /**
     * 组织ID
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long REGID;

    /**
     * 机会类型
     */
    private String TYPE;

    /**
     * 平均签约金额（元）
     */
    private Double AVERAGECONTRACTAMOUNT;

    /**
     * 平均签约周期（工作日天）
     */
    private Double AVERAGECONTRACTPERIOD;

    /**
     * 平均毛利率
     */
    private Double AVERAGEGROSSRATE;

    /**
     * 机会类型描述
     */
    private String TYPEDESCRIPTION;

    /**
     * 类型配置时间
     */
    private Date CREATETIME;

    /**
     * 币种id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long CURRENCYID;

    /**
     * 币种
     */
    private String CURRENCY;

    /**
     *
     */
    private Date UPDATETIME;

    /**
     *
     */
    private Integer DELSTATE;

    /**
     *
     */
    @JsonIgnore
    private Long orgId;

    /**
     * 创建人id
     */
    @JsonIgnore
    private Long createUserId;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 更新人id
     */
    private Long updateUserId;

    /**
     * 更新人
     */
    private String updateUser;

    /**
     * 状态  0-冻结  1启用
     */
    private Integer STATUS;


    public CrmSaleChanceTypeModel() {

    }

    public CrmSaleChanceTypeModel(Long regId) {
        this.REGID = regId;
    }

}