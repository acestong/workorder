package com.fea.project.model.feebudget.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: fangfan
 * @version: 1.0
 * @date: 2019/12/16 18:18
 **/
@Data
public class HumanCostVo {
    private Long userId;
    //人员名称
    private String name;
    //人员角色
    private String role;
    //人天成本
    private BigDecimal cost;
    //实际工时
    private Long hour;
    //实际成本
    private BigDecimal totalCost;
}
