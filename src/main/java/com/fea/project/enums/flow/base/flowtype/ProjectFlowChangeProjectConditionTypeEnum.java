package com.fea.project.enums.flow.base.flowtype;

import com.fea.project.api.other.model.base.SysDepartmentModel;
import com.fea.project.api.other.model.crm.CrmDictionaryIndustryModel;
import com.fea.project.api.other.model.crm.CrmDictionaryRegionModel;
import com.fea.project.api.other.model.crm.CrmSaleChanceTypeModel;
import com.fea.project.api.other.model.product.ProductStructureModel;
import com.fea.project.api.other.service.base.SysDepartmentService;
import com.fea.project.api.other.service.crm.CrmDictionaryIndustryService;
import com.fea.project.api.other.service.crm.CrmDictionaryRegionService;
import com.fea.project.api.other.service.crm.CrmSaleChanceTypeService;
import com.fea.project.api.other.service.product.ProductStructureService;
import com.fea.project.configure.SpringContextHelper;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.enums.base.DictionaryTypeEnum;
import com.fea.project.enums.base.ProjectActionCodeEnum;
import com.fea.project.enums.project.ProjectViewFieldEnum;
import com.fea.project.model.base.ProjectDictionaryItemModel;
import com.fea.project.model.base.ProjectDictionaryModel;
import com.fea.project.model.flow.ProjectFlowListConditionModel;
import com.fea.project.model.flow.flowtype.FlowTypeIdAndParamIdModel;
import com.fea.project.model.flow.flowtype.ProjectFlowChangeProjectConditionTypeModel;
import com.fea.project.model.flow.vo.ProjectFlowListConditionVo;
import com.fea.project.service.apply.ProjectApplyFlowConditionCheckService;
import com.fea.project.service.base.ProjectDictionaryItemService;
import com.fea.project.service.project.draft.DraftConnectBusinessService;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/11/11 10:29
 **/
public enum ProjectFlowChangeProjectConditionTypeEnum {

    TYPE_PROJECT_TYPE(1, "项目类型", ProjectActionCodeEnum.TYPE_VARCHAR.getValue(), ProjectViewFieldEnum.TYPE_PROJECT_TYPE.getShortName()) {
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
    TYPE_PROJECT_PRODUCT(2, "项目关联产品", ProjectActionCodeEnum.TYPE_VARCHAR.getValue(), ProjectViewFieldEnum.TYPE_PROJECT_CONNECT_RPODUCT.getShortName()) {
        @Override
        public Map<? extends Long, ? extends String> getConditionNameMap(List<Object> ids) {
            List<Long> list = ids.stream().map(x -> (Long) x).collect(Collectors.toList());
            return SpringContextHelper.getBean(ProductStructureService.class).selectProductsByIds(list)
                    .stream().collect(Collectors.toMap(ProductStructureModel::getID, ProductStructureModel::getGROUPNAME));
        }

        @Override
        public Object getDeatailParam(FlowTypeIdAndParamIdModel model) {
            return SpringContextHelper.getBean(ProductStructureService.class).selectProductsByLevel(null, model.getRegId());
        }

        @Override
        public boolean isSatisfied(ProjectFlowListConditionVo projectFlowListConditionVo, Object businessInfo) {
            return SpringContextHelper.getBean(ProjectApplyFlowConditionCheckService.class).isSatisfied(projectFlowListConditionVo, businessInfo);
        }

        @Override
        public Object getOtherConnectBusinessInfo(Long businessId) {
            return SpringContextHelper.getBean(DraftConnectBusinessService.class).selectProductsByDraftId(businessId);
        }
    },
    TYPE_PROJECT_APPLY_DEPARTMENT(3, "项目申请部门", ProjectActionCodeEnum.TYPE_VARCHAR.getValue(), "apply_depart") {
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
    TYPE_PROJECT_LEVEL(4, "项目级别", ProjectActionCodeEnum.TYPE_VARCHAR.getValue(), ProjectViewFieldEnum.TYPE_PROJECT_LEVEL.getShortName()) {
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
    TYPE_PROJECT_AREA(5, "项目所属区域", ProjectActionCodeEnum.TYPE_VARCHAR.getValue(), ProjectViewFieldEnum.TYPE_PROJECT_AREA.getShortName()) {
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
            return SpringContextHelper.getBean(DraftConnectBusinessService.class).selectProjectAreaByDraftId(businessId);
        }
    },
    TYPE_PROJECT_RESOURCE(6, "项目所属行业", ProjectActionCodeEnum.TYPE_VARCHAR.getValue(), ProjectViewFieldEnum.TYPE_PROJECT_RESOURCE.getShortName()) {
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
            return SpringContextHelper.getBean(DraftConnectBusinessService.class).selectResourceByDraftId(businessId);
        }
    },
    TYPE_PROJECT_RISK_LEVEL(7, "项目风险级别", ProjectActionCodeEnum.TYPE_VARCHAR.getValue(), ProjectViewFieldEnum.TYPE_PROJECT_RISK_LEVEL.getShortName()) {
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
    TYPE_PROJECT_BUDGET(8, "项目预算金额", ProjectActionCodeEnum.TYPE_NUMBER.getValue(), ProjectViewFieldEnum.TYPE_PROJECT_BUDGE.getShortName()) {
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
            return SpringContextHelper.getBean(DraftConnectBusinessService.class).selectBudgetByProjectId(businessId);
        }
    },
    TYPE_PROJECT_CONNECT_CONTRACT_COST(9, "项目关联合同金额", ProjectActionCodeEnum.TYPE_NUMBER.getValue(), ProjectViewFieldEnum.TYPE_PROJECT_CONTRACT_COST.getShortName()) {
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
            return SpringContextHelper.getBean(DraftConnectBusinessService.class).selectContractCostByDraftId(businessId);
        }
    },
    TYPE_PROJECT_CONNECT_SALE_CHANCE_TYPE(10, "项目关联销售机会类型", ProjectActionCodeEnum.TYPE_VARCHAR.getValue(), "TYPE_PROJECT_CONNECT_SALE_CHANCE_TYPE") {
        @Override
        public Map<? extends Long, ? extends String> getConditionNameMap(List<Object> ids) {
            List<Long> list = ids.stream().map(x -> (Long) x).collect(Collectors.toList());
            return SpringContextHelper.getBean(CrmSaleChanceTypeService.class).selectByIds(list)
                    .stream().collect(Collectors.toMap(CrmSaleChanceTypeModel::getID, CrmSaleChanceTypeModel::getTYPE));
        }

        @Override
        public Object getDeatailParam(FlowTypeIdAndParamIdModel model) {
            return SpringContextHelper.getBean(CrmSaleChanceTypeService.class).selectCrmChanceTypeByRegId(model.getRegId());
        }

        @Override
        public boolean isSatisfied(ProjectFlowListConditionVo projectFlowListConditionVo, Object businessInfo) {
            return SpringContextHelper.getBean(ProjectApplyFlowConditionCheckService.class).isSatisfied(projectFlowListConditionVo, businessInfo);
        }

        @Override
        public Object getOtherConnectBusinessInfo(Long businessId) {
            return SpringContextHelper.getBean(DraftConnectBusinessService.class).selectConnectSaleChanceType(businessId);
        }
    },
    TYPE_PROJECT_CONNECT_SALE_CHANCE_ESTIMATED_CONTRACT_AMOUNT(11, "项目关联销售机会预计签约金额", ProjectActionCodeEnum.TYPE_NUMBER.getValue(), "TYPE_PROJECT_CONNECT_SALE_CHANCE_ESTIMATED_CONTRACT_AMOUNT") {
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
            return SpringContextHelper.getBean(DraftConnectBusinessService.class).selectConnectSaleChanceEstimatedContractAmount(businessId);
        }
    };

    private Integer value;
    private String text;
    private Integer typeStr;
    private String shortName;

    ProjectFlowChangeProjectConditionTypeEnum(Integer value, String text, Integer typeStr, String shortName) {
        this.value = value;
        this.text = text;
        this.typeStr = typeStr;
        this.shortName = shortName;
    }

    public static String getSqlStrByConditionTypeAndConditionStr(ProjectFlowListConditionModel model) {
        ProjectFlowChangeProjectConditionTypeEnum targetEnum = getMapEnum().get(model.getFieldType());
        ProjectActionCodeEnum projectActionCodeEnum = ProjectActionCodeEnum.getEnumMap().get(model.getActionCode());
        return projectActionCodeEnum.getTargetActionEnumExplain(model.getFilterType(), targetEnum.getShortName(), model.getFilterValue());
    }


    public static Map<Integer, ProjectFlowChangeProjectConditionTypeEnum> getMapEnum() {
        return Stream.of(ProjectFlowChangeProjectConditionTypeEnum.values()).collect(Collectors.toMap(ProjectFlowChangeProjectConditionTypeEnum::getValue, x -> x));
    }

    public static List<ProjectFlowChangeProjectConditionTypeModel> getMapInfo() {
        return Stream.of(ProjectFlowChangeProjectConditionTypeEnum.values()).map(x -> new ProjectFlowChangeProjectConditionTypeModel(x)).collect(Collectors.toList());
    }

    public static Object getDetailParamMap(FlowTypeIdAndParamIdModel model) {
        ProjectFlowChangeProjectConditionTypeEnum targetEnum = getMapEnum().get(model.getParamId());
        if (targetEnum == null) {
            throw new SystemParamCheckException("参数类型未定义，无法获取对应类型下的参数");
        }
        return targetEnum.getDeatailParam(model);
    }

    public static Map<Integer, String> getMap() {
        return Stream.of(ProjectFlowChangeProjectConditionTypeEnum.values())
                .collect(Collectors.toMap(ProjectFlowChangeProjectConditionTypeEnum::getValue, ProjectFlowChangeProjectConditionTypeEnum::getText));
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
        List<Integer> list = new ArrayList<>();
        list.add(TYPE_PROJECT_PRODUCT.value);
        list.add(TYPE_PROJECT_CONNECT_CONTRACT_COST.value);
        list.add(TYPE_PROJECT_CONNECT_SALE_CHANCE_TYPE.value);
        list.add(TYPE_PROJECT_CONNECT_SALE_CHANCE_ESTIMATED_CONTRACT_AMOUNT.value);
        return list;
    }

    public static Object getConnectInfoByBusinessId(Integer typeId, Long businessId) {
        ProjectFlowChangeProjectConditionTypeEnum tagetEnum = getMapEnum().get(typeId);
        if (tagetEnum == null) {
            throw new SystemParamCheckException("传入的参数类型，项目创建申请未定义");
        }
        return tagetEnum.getOtherConnectBusinessInfo(businessId);
    }

    public static boolean isSatisfied(Integer typeId, ProjectFlowListConditionVo projectFlowListConditionVo, Object businessInfo) {
        ProjectFlowChangeProjectConditionTypeEnum tagetEnum = getMapEnum().get(typeId);
        if (tagetEnum == null) {
            throw new SystemParamCheckException("传入的参数类型，项目创建申请未定义");
        }
        return tagetEnum.isSatisfied(projectFlowListConditionVo, businessInfo);
    }

    public abstract boolean isSatisfied(ProjectFlowListConditionVo projectFlowListConditionVo, Object businessInfo);

    protected abstract Object getOtherConnectBusinessInfo(Long businessId);

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

    public abstract Map<? extends Long, ? extends String> getConditionNameMap(List<Object> ids);

    public String getShortName() {
        return shortName;
    }
}
