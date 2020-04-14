package com.fea.project.model.feebudget.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: fangfan
 * @version: 1.0
 * @date: 2019/12/20 16:21
 **/
@Data
public class DubgetVsCostVo {
    //日期
    private Date date;
    //累计成本金额
    private BigDecimal accumulativeAmount;
    //当天成本金额
    private BigDecimal todayAmount;
    //人工
    private BigDecimal humanCost;
    //物料
    private BigDecimal materialCost;
    //出差
    private BigDecimal businessCost;
    //日常
    private BigDecimal dailyCost;
    //其他
    private BigDecimal otherCost;
}
