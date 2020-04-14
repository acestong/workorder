package com.fea.project.model.risk.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: fangfan
 * @version: 1.0
 * @date: 2020/3/25 11:45
 **/
@Data
public class ProjectRiskAssessVo {
    /**
     * 当前风险指数
     */
    private BigDecimal rating;

    /**
     * 评估时间
     */
    private Date time;
}
