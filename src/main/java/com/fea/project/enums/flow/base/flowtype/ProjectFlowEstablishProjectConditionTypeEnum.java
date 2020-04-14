package com.fea.project.enums.flow.base.flowtype;

import com.fea.project.api.other.model.base.SysDepartmentModel;
import com.fea.project.api.other.model.crm.CrmDictionaryIndustryModel;
import com.fea.project.api.other.model.crm.CrmDictionaryRegionModel;
import com.fea.project.api.other.service.base.SysDepartmentService;
import com.fea.project.api.other.service.crm.CrmDictionaryIndustryService;
import com.fea.project.api.other.service.crm.CrmDictionaryRegionService;
import com.fea.project.configure.SpringContextHelper;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.enums.base.DictionaryTypeEnum;
import com.fea.project.enums.base.ProjectActionCodeEnum;
import com.fea.project.enums.project.ProjectResourceEnum;
import com.fea.project.enums.project.ProjectViewFieldEnum;
import com.fea.project.model.base.ProjectDictionaryItemModel;
import com.fea.project.model.base.ProjectDictionaryModel;
import com.fea.project.model.establishproject.project.ProjectEstablishStepModel;
import com.fea.project.model.flow.ProjectFlowListConditionModel;
import com.fea.project.model.flow.flowtype.FlowTypeIdAndParamIdModel;
import com.fea.project.model.flow.flowtype.ProjectFlowEstablishProjectConditionTypeModel;
import com.fea.project.model.flow.vo.ProjectFlowListConditionVo;
import com.fea.project.service.apply.ProjectApplyFlowConditionCheckService;
import com.fea.project.service.base.ProjectDictionaryItemService;
import com.fea.project.service.establishproject.project.EstablishConnectBusinessService;
import com.fea.project.service.establishproject.project.ProjectEstablishStepService;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/11/11 10:29
 **/
public enum ProjectFlowEstablishProjectConditionTypeEnum {

    TYPE_PROJECT_TYPE(1, "项目类型", ProjectActionCodeEnum.TYPE_VARCHAR.getValue(), "project." + ProjectViewFieldEnum.TYPE_PROJECT_TYPE.getShortName()) {
        @Override
        public Map<? extends Long, ? extends String> getConditionNameMap(List<Object> ids) {
            List<Long> list = ids.stream().map(x -> (Long) x).collect(Collectors.toList());
            return SpringContextHelper.getBean(ProjectDictionaryItemService.class).selectByIds(list)
                    .stream().collect(Collectors.toMap(ProjectDictionaryItemModel::getId, ProjectDictionaryItemModel::getName));
        }

        @Override
        public Object getDeatailParam(FlowTypeIdAndParamIdModel model) {
            return SpringContextHelper.getBean(ProjectDictionaryItemService.class)
                    .listByShortNameAndRegIdWhenNullCreate(new ProjectDictionaryModel(DictionaryTypeEnum.PROJECT_TYPE.getValue(), model.getRegId()));
        }

        @Override
        public boolean isSatisfied(ProjectFlowListConditionVo projectFlowListConditionVo, Object businessInfo) {
            throw new SystemParamCheckException("项目类型无需单独进行流程判断");
        }

        @Override
        public Object getOtherConnectBusinessInfo(Long businessId) {
            throw new SystemParamCheckException("项目类型可以直接关联查出，无需单个查询");
        }
    },
    TYPE_PROJECT_FROM(2, "项目来源", ProjectActionCodeEnum.TYPE_VARCHAR.getValue(), "project.resource") {
        @Override
        public Map<? extends Long, ? extends String> getConditionNameMap(List<Object> ids) {
            List<Integer> list = ids.stream().map(x -> Integer.parseInt(x + "")).collect(Collectors.toList());
            return Stream.of(ProjectResourceEnum.values()).filter(x -> list.contains(x.getValue())).collect(Collectors.toMap(x -> Long.parseLong(x.getValue() + ""), ProjectResourceEnum::getTest));
        }

        @Override
        public Object getDeatailParam(FlowTypeIdAndParamIdModel model) {
            return ProjectResourceEnum.getApplyProjectResource();
        }

        @Override
        public boolean isSatisfied(ProjectFlowListConditionVo projectFlowListConditionVo, Object businessInfo) {
            throw new SystemParamCheckException("项目来源无需单独进行流程判断");
        }

        @Override
        public Object getOtherConnectBusinessInfo(Long businessId) {
            throw new SystemParamCheckException("项目来源可以直接关联查出，无需单个查询");
        }
    },
    TYPE_PROJECT_ESTABLISH(3, "立项阶段", ProjectActionCodeEnum.TYPE_VARCHAR.getValue(), "step.step_id") {
        @Override
        public Map<? extends Long, ? extends String> getConditionNameMap(List<Object> ids) {
            List<Long> list = ids.stream().map(x -> (Long) x).collect(Collectors.toList());
            return SpringContextHelper.getBean(ProjectEstablishStepService.class).selectByIds(list)
                    .stream().collect(Collectors.toMap(ProjectEstablishStepModel::getId, ProjectEstablishStepModel::getName));
        }

        @Override
        public Object getDeatailParam(FlowTypeIdAndParamIdModel model) {
            return SpringContextHelper.getBean(ProjectEstablishStepService.class).selectByProjectId(model.getBusinessId())
                    .stream().collect(Collectors.toMap(ProjectEstablishStepModel::getId, ProjectEstablishStepModel::getName));
        }

        @Override
        public boolean isSatisfied(ProjectFlowListConditionVo projectFlowListConditionVo, Object businessInfo) {
            throw new SystemParamCheckException("项目类型无需单独进行流程判断");
        }

        @Override
        public Object getOtherConnectBusinessInfo(Long businessId) {
            throw new SystemParamCheckException("项目类型可以直接关联查出，无需单个查询");
        }
    },
    TYPE_PROJECT_APPLY_DEPARTMENT(4, "项目申请部门", ProjectActionCodeEnum.TYPE_VARCHAR.getValue(), "project.apply_depart") {
        @Override
        public Map<? extends Long, ? extends String> getConditionNameMap(List<Object> ids) {
            List<Long> list = ids.stream().map(x -> (Long) x).collect(Collectors.toList());
            return SpringContextHelper.getBean(SysDepartmentService.class).selectByIds(list)
                    .stream().collect(Collectors.toMap(SysDepartmentModel::getDEPID, SysDepartmentModel::getDEPNAME));
        }

        @Override
        public Object getDeatailParam(FlowTypeIdAndParamIdModel model) {
            return SpringContextHelper.getBean(SysDepartmentService.class).selectDeptTreeByRegId(model.getRegId());
        }

        @Override
        public boolean isSatisfied(ProjectFlowListConditionVo projectFlowListConditionVo, Object businessInfo) {
            throw new SystemParamCheckException("项目申请部门无需单独进行流程判断");
        }

        @Override
        public Object getOtherConnectBusinessInfo(Long businessId) {
            throw new SystemParamCheckException("申请部门可以直接关联查出，无需单个查询");
        }
    },
    TYPE_PROJECT_LEVEL(5, "项目级别", ProjectActionCodeEnum.TYPE_VARCHAR.getValue(), "project." + ProjectViewFieldEnum.TYPE_PROJECT_LEVEL.getShortName()) {
        @Override
        public Map<? extends Long, ? extends String> getConditionNameMap(List<Object> ids) {
            List<Long> list = ids.stream().map(x -> (Long) x).collect(Collectors.toList());
            return SpringContextHelper.getBean(ProjectDictionaryItemService.class).selectByIds(list)
                    .stream().collect(Collectors.toMap(ProjectDictionaryItemModel::getId, ProjectDictionaryItemModel::getName));
        }

        @Override
        public Object getDeatailParam(FlowTypeIdAndParamIdModel model) {
            return SpringContextHelper.getBean(ProjectDictionaryItemService.class).listByShortNameAndRegIdWhenNullCreate(
                    new ProjectDictionaryModel(DictionaryTypeEnum.PROJECT_LEVEL.getValue(), model.getRegId()));
        }

        @Override
        public boolean isSatisfied(ProjectFlowListConditionVo projectFlowListConditionVo, Object businessInfo) {
            throw new SystemParamCheckException("项目级别无需单独进行流程判断");
        }

        @Override
        public Object getOtherConnectBusinessInfo(Long businessId) {
            throw new SystemParamCheckException("项目级别可以直接关联查出，无需单个查询");
        }
    },
    TYPE_PROJECT_AREA(6, "项目所属区域", ProjectActionCodeEnum.TYPE_VARCHAR.getValue(), ProjectViewFieldEnum.TYPE_PROJECT_AREA.getShortName()) {
        @Override
        public Map<? extends Long, ? extends String> getConditionNameMap(List<Object> ids) {
            List<Long> list = ids.stream().map(x -> (Long) x).collect(Collectors.toList());
            return SpringContextHelper.getBean(CrmDictionaryRegionService.class).selectByIds(list)
                    .stream().collect(Collectors.toMap(CrmDictionaryRegionModel::getID, CrmDictionaryRegionModel::getNAME));
        }

        @Override
        public Object getDeatailParam(FlowTypeIdAndParamIdModel model) {
            return SpringContextHelper.getBean(CrmDictionaryRegionService.class).selectRegionByLevel(null, model.getRegId());
        }

        @Override
        public boolean isSatisfied(ProjectFlowListConditionVo projectFlowListConditionVo, Object businessInfo) {
            return SpringContextHelper.getBean(ProjectApplyFlowConditionCheckService.class).isSatisfied(projectFlowListConditionVo, businessInfo);
        }

        @Override
        public Object getOtherConnectBusinessInfo(Long businessId) {
            return SpringContextHelper.getBean(EstablishConnectBusinessService.class).selectProjectAreaByProjectId(businessId);
        }
    },
    TYPE_PROJECT_RESOURCE(7, "项目所属行业", ProjectActionCodeEnum.TYPE_VARCHAR.getValue(), ProjectViewFieldEnum.TYPE_PROJECT_RESOURCE.getShortName()) {
        @Override
        public Map<? extends Long, ? extends String> getConditionNameMap(List<Object> ids) {
            List<Long> list = ids.stream().map(x -> (Long) x).collect(Collectors.toList());
            return SpringContextHelper.getBean(CrmDictionaryIndustryService.class).selectByIds(list)
                    .stream().collect(Collectors.toMap(CrmDictionaryIndustryModel::getID, CrmDictionaryIndustryModel::getNAME));
        }

        @Override
        public Object getDeatailParam(FlowTypeIdAndParamIdModel model) {
            return SpringContextHelper.getBean(CrmDictionaryIndustryService.class).selectIndustryByLevel(null, model.getRegId());
        }

        @Override
        public boolean isSatisfied(ProjectFlowListConditionVo projectFlowListConditionVo, Object businessInfo) {
            return SpringContextHelper.getBean(ProjectApplyFlowConditionCheckService.class).isSatisfied(projectFlowListConditionVo, businessInfo);
        }

        @Override
        public Object getOtherConnectBusinessInfo(Long businessId) {
            return SpringContextHelper.getBean(EstablishConnectBusinessService.class).selectResourceByProjectId(businessId);
        }
    },
    TYPE_PROJECT_RISK_LEVEL(8, "项目风险级别", ProjectActionCodeEnum.TYPE_VARCHAR.getValue(), "project." + ProjectViewFieldEnum.TYPE_PROJECT_RISK_LEVEL.getShortName()) {
        @Override
        public Map<? extends Long, ? extends String> getConditionNameMap(List<Object> ids) {
            List<Long> list = ids.stream().map(x -> (Long) x).collect(Collectors.toList());
            return SpringContextHelper.getBean(ProjectDictionaryItemService.class).selectByIds(list)
                    .stream().collect(Collectors.toMap(ProjectDictionaryItemModel::getId, ProjectDictionaryItemModel::getName));
        }

        @Override
        public Object getDeatailParam(FlowTypeIdAndParamIdModel model) {
            return SpringContextHelper.getBean(ProjectDictionaryItemService.class).listByShortNameAndRegIdWhenNullCreate(new ProjectDictionaryModel(DictionaryTypeEnum.PROJECT_RISK_LEVEL.getValue(), model.getRegId()));
        }

        @Override
        public boolean isSatisfied(ProjectFlowListConditionVo projectFlowListConditionVo, Object businessInfo) {
            throw new SystemParamCheckException("项目风险级别无需单独进行流程判断");
        }

        @Override
        public Object getOtherConnectBusinessInfo(Long businessId) {
            throw new SystemParamCheckException("项目级别可以直接关联查出，无需单个查询");
        }
    },
    TYPE_PROJECT_BUDGET(9 , "项目预算金额", ProjectActionCodeEnum.TYPE_NUMBER.getValue(), ProjectViewFieldEnum.TYPE_PROJECT_BUDGE.getShortName()) {
        @Override
        public Map<? extends Long, ? extends String> getConditionNameMap(List<Object> ids) {
            return new HashMap<>();
        }

        @Override
        public Object getDeatailParam(FlowTypeIdAndParamIdModel model) {
            throw new SystemParamCheckException("该类型下无法进行查询");
        }

        @Override
        public boolean isSatisfied(ProjectFlowListConditionVo projectFlowListConditionVo, Object businessInfo) {
            return SpringContextHelper.getBean(ProjectApplyFlowConditionCheckService.class).isSatisfied(projectFlowListConditionVo, businessInfo);
        }

        @Override
        public Object getOtherConnectBusinessInfo(Long businessId) {
            return SpringContextHelper.getBean(EstablishConnectBusinessService.class).selectBudgetByProjectId(businessId);
        }
    };

    private Integer value;
    private String text;
    private Integer typeStr;
    private String shortName;

    ProjectFlowEstablishProjectConditionTypeEnum(Integer value, String text, Integer typeStr, String shortName) {
        this.value = value;
        this.text = text;
        this.typeStr = typeStr;
        this.shortName = shortName;
    }

    public static String getSqlStrByConditionTypeAndConditionStr(ProjectFlowListConditionModel model) {
        ProjectFlowEstablishProjectConditionTypeEnum targetEnum = getMapEnum().get(model.getFieldType());
        ProjectActionCodeEnum projectActionCodeEnum = ProjectActionCodeEnum.getEnumMap().get(model.getActionCode());
        return projectActionCodeEnum.getTargetActionEnumExplain(model.getFilterType(), targetEnum.getShortName(), model.getFilterValue());
    }


    public static Map<Integer, ProjectFlowEstablishProjectConditionTypeEnum> getMapEnum() {
        return Stream.of(ProjectFlowEstablishProjectConditionTypeEnum.values()).collect(Collectors.toMap(ProjectFlowEstablishProjectConditionTypeEnum::getValue, x -> x));
    }

    public static Object getDetailParamMap(FlowTypeIdAndParamIdModel model) {
        ProjectFlowEstablishProjectConditionTypeEnum targetEnum = getMapEnum().get(model.getParamId());
        if (targetEnum == null) {
            throw new SystemParamCheckException("参数类型未定义，无法获取对应类型下的参数");
        }
        return targetEnum.getDeatailParam(model);
    }

    public static Map<Integer, String> getMap() {
        return Stream.of(ProjectFlowEstablishProjectConditionTypeEnum.values())
                .collect(Collectors.toMap(ProjectFlowEstablishProjectConditionTypeEnum::getValue, ProjectFlowEstablishProjectConditionTypeEnum::getText));
    }

    public static Map<Integer, Map<Long, String>> getTargetTypeConditionNameMap(Map<Integer, Set<Object>> conditionMap) {
        if (conditionMap == null) {
            throw new SystemParamCheckException("参数传入异常，无法进行查询");
        }
        if (conditionMap.isEmpty()) {
            return new HashMap<>();
        }
        Map<Integer, Map<Long, String>> map = new HashMap<>();
        conditionMap.forEach((x, y) -> map.computeIfAbsent(x, value -> new HashMap<>())
                .putAll(getMapEnum().get(x).getConditionNameMap(new ArrayList<>(y))));
        return map;
    }

    public static List<Integer> getOtherDBCheckTypeList() {
        return Collections.emptyList();
    }

    public static Object getConnectInfoByBusinessId(Integer typeId, Long businessId) {
        ProjectFlowEstablishProjectConditionTypeEnum tagetEnum = getMapEnum().get(typeId);
        if (tagetEnum == null) {
            throw new SystemParamCheckException("传入的参数类型，项目创建申请未定义");
        }
        return tagetEnum.getOtherConnectBusinessInfo(businessId);
    }

    public static boolean isSatisfied(Integer typeId, ProjectFlowListConditionVo projectFlowListConditionVo, Object businessInfo) {
        ProjectFlowEstablishProjectConditionTypeEnum tagetEnum = getMapEnum().get(typeId);
        if (tagetEnum == null) {
            throw new SystemParamCheckException("传入的参数类型，项目创建申请未定义");
        }
        return tagetEnum.isSatisfied(projectFlowListConditionVo, businessInfo);
    }

    public abstract boolean isSatisfied(ProjectFlowListConditionVo projectFlowListConditionVo, Object businessInfo);

    /**
     * 非直接判定业务
     *
     * @param businessId
     * @return
     */
    public abstract Object getOtherConnectBusinessInfo(Long businessId);

    public abstract Map<? extends Long, ? extends String> getConditionNameMap(List<Object> ids);

    public Integer getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

    public Integer getTypeStr() {
        return typeStr;
    }

    public abstract Object getDeatailParam(FlowTypeIdAndParamIdModel model);

    public String getShortName() {
        return shortName;
    }

    public static List<ProjectFlowEstablishProjectConditionTypeModel> getMapInfo() {
        return Stream.of(ProjectFlowEstablishProjectConditionTypeEnum.values()).map(ProjectFlowEstablishProjectConditionTypeModel::new).collect(Collectors.toList());
    }
}
