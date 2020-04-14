package com.fea.project.model.feebudget.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: fangfan
 * @version: 1.0
 * @date: 2019/12/19 17:59
 **/
@Data
public class DubgetVsFeeClassifyVo {
    //费用类型
    private String feeType;
    //预算金额
    private BigDecimal dubgetAmount;
    //实际支出金额
    private BigDecimal reimburAmount;
    //预算剩余金额
    private BigDecimal surplusAmount;
    //支出比例
    private String proportion;
}
