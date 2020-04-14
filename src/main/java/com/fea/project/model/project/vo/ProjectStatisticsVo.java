package com.fea.project.model.project.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author wuqi
 * @version 1.0
 * @since 2020/1/17 14:18
 **/
@Data
public class ProjectStatisticsVo {

    private BigDecimal totalProject;
    private BigDecimal normalProject;
    private BigDecimal delayProject;

    public ProjectStatisticsVo() {
    }

    public static ProjectStatisticsVo initModel() {
        ProjectStatisticsVo model = new ProjectStatisticsVo();
        model.setTotalProject(BigDecimal.ZERO);
        model.setNormalProject(BigDecimal.ZERO);
        model.setDelayProject(BigDecimal.ZERO);
        return model;
    }
}
