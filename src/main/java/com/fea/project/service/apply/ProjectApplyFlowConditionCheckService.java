package com.fea.project.service.apply;

import com.fea.project.api.other.model.crm.CrmMoneyTranslateModel;
import com.fea.project.enums.base.ProjectActionCodeEnum;
import com.fea.project.enums.base.ProjectListActionEnum;
import com.fea.project.enums.base.ProjectNumberActionEnum;
import com.fea.project.model.flow.vo.ProjectFlowListConditionVo;
import com.fea.project.util.ListUtil;
import com.github.pagehelper.util.StringUtil;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/12/5 17:45
 **/
@Service
public class ProjectApplyFlowConditionCheckService {

    public boolean isSatisfied(ProjectFlowListConditionVo projectFlowListConditionVo, Object businessInfo) {
        ProjectActionCodeEnum projectActionCodeEnum = ProjectActionCodeEnum.getEnumMap().get(projectFlowListConditionVo.getActionCode());
        if (Objects.equals(projectActionCodeEnum, ProjectActionCodeEnum.TYPE_VARCHAR)) {
            List<Long> business = (List<Long>) businessInfo;
            return this.isSatisfiedList(projectFlowListConditionVo, business);
        } else if (Objects.equals(projectActionCodeEnum, ProjectActionCodeEnum.TYPE_NUMBER)) {
            CrmMoneyTranslateModel cost = (CrmMoneyTranslateModel) businessInfo;
            return this.isSatisfiedDecimal(projectFlowListConditionVo, cost);
        }
        return Boolean.FALSE;
    }

    /**
     * 项目流程条件校验， 列表型
     *
     * @param projectFlowListConditionVo
     * @param businessInfo
     * @return
     */
    private boolean isSatisfiedList(ProjectFlowListConditionVo projectFlowListConditionVo, List<Long> businessInfo) {
        if (ListUtil.isNullOrEmpty(businessInfo)) {
            return Boolean.FALSE;
        }
        ProjectListActionEnum projectListActionEnum = ProjectListActionEnum.getEnumMap().get(projectFlowListConditionVo.getFieldType());
        if (projectListActionEnum == null) {
            return Boolean.FALSE;
        }
        List<Long> conditionIds = Stream.of(projectFlowListConditionVo.getFilterValue().split(",")).map(Long::parseLong).distinct().collect(Collectors.toList());
        return projectListActionEnum.isSatisfied(conditionIds, businessInfo);
    }

    /**
     * 项目流程条件校验， 数值型
     *
     * @param projectFlowListConditionVo
     * @param businessInfo
     * @return
     */
    private boolean isSatisfiedDecimal(ProjectFlowListConditionVo projectFlowListConditionVo, CrmMoneyTranslateModel businessInfo) {
        if (businessInfo == null || !Objects.equals(projectFlowListConditionVo.getFilterValueUnit(), businessInfo.getCurrencyId())) {
            return Boolean.FALSE;
        }
        ProjectNumberActionEnum projectNumberActionEnum = ProjectNumberActionEnum.getEnumMap().get(projectFlowListConditionVo.getFieldType());
        if (projectNumberActionEnum == null) {
            return Boolean.FALSE;
        }
        List<BigDecimal> costs = Stream.of(projectFlowListConditionVo.getFilterValue().split(",")).filter(StringUtil::isNotEmpty).map(BigDecimal::new).collect(Collectors.toList());
        return projectNumberActionEnum.isSatisfied(costs, businessInfo.getAmount());
    }
}
