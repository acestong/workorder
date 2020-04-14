package com.fea.project.model.feebudget.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: fangfan
 * @version: 1.0
 * @date: 2019/12/18 11:00
 **/
@Data
public class DubgetClassifyVo {
    private String feeType;
    private BigDecimal amount;
}
