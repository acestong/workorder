package com.fea.project.model.feebudget.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author: fangfan
 * @version: 1.0
 * @date: 2019/12/17 10:33
 **/
@Data
public class ReimburseVo {
    //报销单号
    private String num;
    //报销事由
    private String reason;
    //报销类型
    private String type;
    //费用类型
    private String feeType;
    //报销申请日期
    private Date applyTime;
    //报销金额
    private Double amount;
    //币种
    private String currency;
    //报销人
    private String person;
    //报销时间
    private Date time;
}
