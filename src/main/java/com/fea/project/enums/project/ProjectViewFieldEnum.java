package com.fea.project.enums.project;

import com.fea.project.configure.SpringContextHelper;
import com.fea.project.enums.base.EnableStatusEnum;
import com.fea.project.enums.base.ProjectActionCodeEnum;
import com.fea.project.service.project.ProjectViewParamService;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/21 12:13
 * 项目视图字段枚举
 **/
public enum ProjectViewFieldEnum {

    TYPE_PROJECT_TYPE(1, "项目类型", "type", ProjectActionCodeEnum.TYPE_VARCHAR, EnableStatusEnum.DISABLE.getStatus()){
        @Override
        public Object selectParamByRegId(Long userRegId) {
            //TODO
            return null;
        }
    },
    TYPE_PROJECT_LEVEL(2, "项目级别", "level", ProjectActionCodeEnum.TYPE_VARCHAR, EnableStatusEnum.ENABLE.getStatus()){
        @Override
        public Object selectParamByRegId(Long userRegId) {
            return SpringContextHelper.getBean(ProjectViewParamService.class).selectProjectLevel(userRegId);
        }
    },
    TYPE_PROJECT_RESOURCE(3, "项目所属行业", "industry", ProjectActionCodeEnum.TYPE_VARCHAR, EnableStatusEnum.ENABLE.getStatus()){
        @Override
        public Object selectParamByRegId(Long userRegId) {
            return SpringContextHelper.getBean(ProjectViewParamService.class).selectIndustry(userRegId);
        }
    },
    TYPE_PROJECT_AREA(4, "项目所属区域", "area", ProjectActionCodeEnum.TYPE_VARCHAR, EnableStatusEnum.ENABLE.getStatus()){
        @Override
        public Object selectParamByRegId(Long userRegId) {
            return SpringContextHelper.getBean(ProjectViewParamService.class).selectRegion(userRegId);
        }
    },
    TYPE_PROJECT_BUDGE(5, "项目的预算金额", "budget", ProjectActionCodeEnum.TYPE_NUMBER, EnableStatusEnum.ENABLE.getStatus()){
        @Override
        public Object selectParamByRegId(Long userRegId) {
            return null;
        }
    },
    TYPE_PROJECT_CONTRACT_COST(6, "项目关联合同/订单金额", "project_contract_cost", ProjectActionCodeEnum.TYPE_NUMBER, EnableStatusEnum.DISABLE.getStatus()){
        @Override
        public Object selectParamByRegId(Long userRegId) {
            return null;
        }
    },
    TYPE_PROJECT_RISK_LEVEL(7, "项目风险等级", "risk_level", ProjectActionCodeEnum.TYPE_VARCHAR, EnableStatusEnum.ENABLE.getStatus()){
        @Override
        public Object selectParamByRegId(Long userRegId) {
            return  SpringContextHelper.getBean(ProjectViewParamService.class).selectRiskLevel(userRegId);
        }
    },
    TYPE_PROJECT_CONNECT_RPODUCT(8, "项目关联产品", "project_connect_product", ProjectActionCodeEnum.TYPE_VARCHAR, EnableStatusEnum.DISABLE.getStatus()){
        @Override
        public Object selectParamByRegId(Long userRegId) {
            return  null;
        }
    },
    TYPE_PROJECT_CREATER(9, "项目创建人", "create_id", ProjectActionCodeEnum.TYPE_VARCHAR, EnableStatusEnum.DISABLE.getStatus()){
        @Override
        public Object selectParamByRegId(Long userRegId) {
            return  null;
        }
    },
    TYPE_PROJECT_CREATE_TIME(10, "项目创建时间", "create_time", ProjectActionCodeEnum.TYPE_NUMBER, EnableStatusEnum.DISABLE.getStatus()){
        @Override
        public Object selectParamByRegId(Long userRegId) {
            return  null;
        }
    },
    TYPE_PROJECT_PLAN_START_TIME(11, "项目计划开始时间", "plan_startTime", ProjectActionCodeEnum.TYPE_NUMBER, EnableStatusEnum.DISABLE.getStatus()){
        @Override
        public Object selectParamByRegId(Long userRegId) {
            return  null;
        }
    },
    TYPE_PROJECT_PLAN_END_TIME(12, "项目计划结束时间", "plan_endTime", ProjectActionCodeEnum.TYPE_NUMBER, EnableStatusEnum.DISABLE.getStatus()){
        @Override
        public Object selectParamByRegId(Long userRegId) {
            return  null;
        }
    },
    TYPE_PROJECT_REAL_START_TIME(13, "项目真实开始时间", "real_startTime", ProjectActionCodeEnum.TYPE_NUMBER, EnableStatusEnum.DISABLE.getStatus()){
        @Override
        public Object selectParamByRegId(Long userRegId) {
            return  null;
        }
    },
    TYPE_PROJECT_REAL_END_TIME(14, "项目真实结束时间", "real_endTime", ProjectActionCodeEnum.TYPE_NUMBER, EnableStatusEnum.DISABLE.getStatus()){
        @Override
        public Object selectParamByRegId(Long userRegId) {
            return  null;
        }
    },
    TYPE_PROJECT_LEADER(15, "项目负责人", "leader", ProjectActionCodeEnum.TYPE_VARCHAR, EnableStatusEnum.ENABLE.getStatus()){
        @Override
        public Object selectParamByRegId(Long userRegId) {
            return  SpringContextHelper.getBean(ProjectViewParamService.class).selectLeaders(userRegId);
        }
    },
    TYPE_PROJECT_ORG(16, "所属部门", "orgs", ProjectActionCodeEnum.TYPE_VARCHAR, EnableStatusEnum.ENABLE.getStatus()){
        @Override
        public Object selectParamByRegId(Long userRegId) {
            return  SpringContextHelper.getBean(ProjectViewParamService.class).selectOrgs(userRegId);
        }
    };

    private Integer value;
    private String text;
    private String shortName;
    private ProjectActionCodeEnum projectViewActionCodeEnum;
    private Integer isShow;

    ProjectViewFieldEnum(Integer value, String text, String shortName, ProjectActionCodeEnum projectViewActionCodeEnum, Integer isShow) {
        this.value = value;
        this.text = text;
        this.shortName = shortName;
        this.projectViewActionCodeEnum = projectViewActionCodeEnum;
        this.isShow = isShow;
    }

    public static Map<Integer, ProjectActionCodeEnum> getActionCodeMap() {
        return Stream.of(ProjectViewFieldEnum.values()).collect(Collectors.toMap(ProjectViewFieldEnum::getValue, ProjectViewFieldEnum::getProjectViewActionCodeEnum));
    }

    public static Map<Integer, String> getFieldNameMap() {
        return Stream.of(ProjectViewFieldEnum.values()).collect(Collectors.toMap(ProjectViewFieldEnum::getValue, ProjectViewFieldEnum::getShortName));
    }

    public static Map<Integer, String> getFieldTextMap() {
        return Stream.of(ProjectViewFieldEnum.values()).collect(Collectors.toMap(ProjectViewFieldEnum::getValue, ProjectViewFieldEnum::getText));
    }

    public static ProjectViewFieldEnum getTargetType(Integer typeId) {
        Map<Integer, ProjectViewFieldEnum> map = Stream.of(ProjectViewFieldEnum.values()).collect(Collectors.toMap(x -> x.getValue(), x->x));
        return map.get(typeId);
    }

    public static ProjectViewFieldEnum[] getCanUsedViewTypes() {
        List<ProjectViewFieldEnum> projectViewFieldEnums = Stream.of(ProjectViewFieldEnum.values()).filter(x -> Objects.equals(EnableStatusEnum.ENABLE.getStatus(), x.getIsShow())).collect(Collectors.toList());
        ProjectViewFieldEnum[] result = new ProjectViewFieldEnum[projectViewFieldEnums.size()];
        for (int i = 0; i < projectViewFieldEnums.size(); i++) {
            result[i] = projectViewFieldEnums.get(i);
        }
        return result;
    }

    public Integer getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

    public String getShortName() {
        return shortName;
    }

    public ProjectActionCodeEnum getProjectViewActionCodeEnum() {
        return projectViewActionCodeEnum;
    }

    public Integer getIsShow() {
        return isShow;
    }

    public abstract Object selectParamByRegId(Long userRegId);
}
