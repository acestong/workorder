package com.fea.project.model.feebudget.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: fangfan
 * @version: 1.0
 * @date: 2019/12/19 17:24
 **/
@Data
public class DubgetVsFeeVo {
    private BigDecimal budgetAmount;
    private BigDecimal feeAmount;
    private BigDecimal surplusAmount;
    private String proportion;
}
