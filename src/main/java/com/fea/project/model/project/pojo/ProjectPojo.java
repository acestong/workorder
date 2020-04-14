package com.fea.project.model.project.pojo;

import com.fea.project.model.project.ProjectModel;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/26 10:11
 **/
@Data
public class ProjectPojo extends ProjectModel {

    protected Integer personOrTeamType;

    /**
     * 人员查询人员
     */
    protected List<Long> userIds;
    /**
     * 人员查询类型
     */
    protected Integer queryType;

    /**
     * 基于视图查询，视图id
     */
    protected Long viewId;

    protected List<Long> typeList;

    protected Long selectId;

    protected Integer selectType;

    protected List<Long> leaderIds;

    protected List<Long> ids;


    /**
     * 视图查询用到的参数
     */
    protected List<Long> projectLevels;
    protected List<Long> projectIndustries;
    protected List<Long> projectRegions;
    protected List<Long> riskLevels;
    protected List<Long> orgs;
    protected BigDecimal minBudget;
    protected BigDecimal maxBudget;

    /**
     * 自定义视图使用参数
     */
    protected List<String> conditionStrs;

    public ProjectPojo() {
    }

    public ProjectPojo(Long selectId, Integer selectType) {
        this.selectId = selectId;
        this.selectType = selectType;
    }
}
