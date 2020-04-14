package com.fea.project.model.feebudget.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: fangfan
 * @version: 1.0
 * @date: 2020/3/5 10:47
 **/
@Data
public class DubgetChangeGraphVo {
    //日期
    private Date date;
    //预算金额
    private BigDecimal money;
}
