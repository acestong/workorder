package com.fea.project.model.project.vo;

import com.fea.project.api.other.io.project.IProjectBusinessModel;
import com.fea.project.model.establishproject.vo.ProjectEstablishVo;
import com.fea.project.model.project.ProjectModel;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/9/29 11:42
 **/
@Data
public class ProjectVo extends ProjectModel {

    //关联业务models
    protected List<IProjectBusinessModel> projectBusinessModels;


    protected BigDecimal schedule;

    protected Long alarmLevel;

    protected String applyerName;

    protected String leaderName;

    protected String parterNames;

    protected String DeptName;

    /**
     * 关联业务名称
     */
    protected String connectBusinessName;

    /**
     * 当前阶段
     */
    protected Integer currentStep;

    protected String currentStepName;

    /**
     * 审核状态
     */
    protected String verifyStatusName;

    /**
     * 是否立项
     */
    protected String establishmentName;

    /**
     * 项目状态
     */
    protected String projectStatusName;

    /**
     * 执行状态
     */
    protected String actionStatusName;

    protected String typeName;

    protected String priorityName;

    protected String levelName;

    protected String riskLevelName;

    protected String resourceName;

    protected String versionCode;

    protected Integer submitShow;

    protected String areaName;

    protected String industryName;

    public ProjectVo() {
    }

}
