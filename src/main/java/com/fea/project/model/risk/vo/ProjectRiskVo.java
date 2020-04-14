package com.fea.project.model.risk.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.model.risk.ProjectRiskAssessPlanModel;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author: fangfan
 * @version: 1.0
 * @date: 2019/12/3 14:57
 **/
@Data
public class ProjectRiskVo{
    /**
     * 风险名称
     */
    private String name;


    /**
     * 风险指数
     */
    private BigDecimal rating;


    /**
     * 风险评估
     */
    private List<ProjectRiskAssessVo> projectRiskAssessVos;
}
