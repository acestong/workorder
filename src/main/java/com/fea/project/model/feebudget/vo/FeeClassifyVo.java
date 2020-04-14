package com.fea.project.model.feebudget.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: fangfan
 * @version: 1.0
 * @date: 2019/12/20 9:50
 **/
@Data
public class FeeClassifyVo {
    private String feeType;
    private BigDecimal amount;

    public FeeClassifyVo() {
    }

    public FeeClassifyVo(String feeType, BigDecimal amount) {
        this.feeType = feeType;
        this.amount = amount;
    }
}
