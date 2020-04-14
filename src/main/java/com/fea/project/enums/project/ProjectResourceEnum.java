package com.fea.project.enums.project;

import com.fea.project.api.other.io.project.IProjectConnectBusiness;
import com.fea.project.api.other.model.crm.CrmMoneyTranslateModel;
import com.fea.project.configure.SpringContextHelper;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.util.ListUtil;

import java.util.*;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/9/24 10:00
 * 业务类型枚举
 **/
public enum ProjectResourceEnum {

    MARKETING_CONTRACT(1, "业务合同") {
        @Override
        public Object getConnectBusiness(Long regId) {
            IProjectConnectBusiness iProjectConnectBusiness = getConnectBusinessService();
            return iProjectConnectBusiness.getConnectBusiness(regId);
        }

        @Override
        public IProjectConnectBusiness getConnectBusinessService() {
            return SpringContextHelper.getBean("crmContractService");
        }

        @Override
        public List<Long> getCustomerIdsByBusinessIds(List<Long> businessIds) {
            IProjectConnectBusiness iProjectConnectBusiness = getConnectBusinessService();
            return iProjectConnectBusiness.getCustomerIdsByBusinessIds(businessIds);
        }

    },
    SALE_CHANCE(2, "销售机会") {
        @Override
        public Object getConnectBusiness(Long regId) {
            IProjectConnectBusiness iProjectConnectBusiness = getConnectBusinessService();
            return iProjectConnectBusiness.getConnectBusiness(regId);
        }

        @Override
        public IProjectConnectBusiness getConnectBusinessService() {
            return SpringContextHelper.getBean("crmSaleChanceService");
        }

        @Override
        public List<Long> getCustomerIdsByBusinessIds(List<Long> businessIds) {
            IProjectConnectBusiness iProjectConnectBusiness = getConnectBusinessService();
            return iProjectConnectBusiness.getCustomerIdsByBusinessIds(businessIds);
        }

    },
    ORDER(3, "订单") {
        @Override
        public Object getConnectBusiness(Long regId) {
            IProjectConnectBusiness iProjectConnectBusiness = getConnectBusinessService();
            return iProjectConnectBusiness.getConnectBusiness(regId);
        }

        @Override
        public IProjectConnectBusiness getConnectBusinessService() {
            return SpringContextHelper.getBean("crmOrderService");
        }

        @Override
        public List<Long> getCustomerIdsByBusinessIds(List<Long> businessIds) {
            IProjectConnectBusiness iProjectConnectBusiness = getConnectBusinessService();
            return iProjectConnectBusiness.getCustomerIdsByBusinessIds(businessIds);
        }

    },
    INNER_PROJECT(4, "内部项目") {
        @Override
        public Object getConnectBusiness(Long regId) {
            IProjectConnectBusiness iProjectConnectBusiness = getConnectBusinessService();
            return iProjectConnectBusiness.getConnectBusiness(regId);
        }

        @Override
        public IProjectConnectBusiness getConnectBusinessService() {
            return SpringContextHelper.getBean("projectEstablishConnectBusinessService");
        }

        @Override
        public List<Long> getCustomerIdsByBusinessIds(List<Long> businessIds) {
            IProjectConnectBusiness iProjectConnectBusiness = getConnectBusinessService();
            return iProjectConnectBusiness.getCustomerIdsByBusinessIds(businessIds);
        }

    };

    private Integer value;
    private String test;

    ProjectResourceEnum(Integer value, String test) {
        this.value = value;
        this.test = test;
    }

    public static List<Map<String, Object>> getProjectResource() {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = null;
        ProjectResourceEnum[] enums = ProjectResourceEnum.values();
        for (ProjectResourceEnum anEnum : enums) {
            if(Objects.equals(anEnum, INNER_PROJECT)){
                continue;
            }
            map = new HashMap<>();
            map.put("id", anEnum.getValue() + "");
            map.put("name", anEnum.getTest());
            list.add(map);
        }
        return list;
    }

    public static List<Map<String, Object>> getApplyProjectResource() {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = null;
        ProjectResourceEnum[] enums = ProjectResourceEnum.values();
        for (ProjectResourceEnum anEnum : enums) {
            map = new HashMap<>();
            map.put("id", anEnum.getValue() + "");
            map.put("name", anEnum.getTest());
            list.add(map);
        }
        return list;
    }

    public static Map<Integer, ProjectResourceEnum> getFullEnumsMap() {
        Map<Integer, ProjectResourceEnum> map = new HashMap<>();
        ProjectResourceEnum[] enums = ProjectResourceEnum.values();
        for (ProjectResourceEnum anEnum : enums) {
            map.put(anEnum.getValue(), anEnum);
        }
        return map;
    }

    public static Object getConnectBusinessByBussinessType(Integer type, Long regId) {
        if (type == null || regId == null) {
            return null;
        }
        ProjectResourceEnum targetEnum = getFullEnumsMap().get(type);
        if (targetEnum == null) {
            return null;
        }
        return targetEnum.getConnectBusiness(regId);
    }

    public static List<Long> getCustomersByBussinessType(Integer type, List<Long> businessIds) {
        if (type == null || ListUtil.isNullOrEmpty(businessIds)) {
            return new ArrayList<>();
        }
        ProjectResourceEnum targetEnum = getFullEnumsMap().get(type);
        if (targetEnum == null) {
            return null;
        }
        return targetEnum.getCustomerIdsByBusinessIds(businessIds);
    }

    public static List<Long> getProductsByBusinessIds(Integer resource, List<Long> list) {
        ProjectResourceEnum projectResourceEnum = getFullEnumsMap().get(resource);
        if (Objects.isNull(projectResourceEnum)) {
            throw new SystemParamCheckException("传入的业务类型未定义");
        }
        return projectResourceEnum.getConnectBusinessService().getProductsByIds(list);
    }

    public static List<Long> getCustomersAreaByBusinessIds(Integer resource, List<Long> list) {
        ProjectResourceEnum projectResourceEnum = getFullEnumsMap().get(resource);
        if (Objects.isNull(projectResourceEnum)) {
            throw new SystemParamCheckException("传入的业务类型未定义");
        }
        return projectResourceEnum.getConnectBusinessService().getCustomersAreaByBusinessIds(list);
    }

    public static List<Long> getCustomersResourceByBusinessIds(Integer resource, List<Long> list) {
        ProjectResourceEnum projectResourceEnum = getFullEnumsMap().get(resource);
        if (Objects.isNull(projectResourceEnum)) {
            throw new SystemParamCheckException("传入的业务类型未定义");
        }
        return projectResourceEnum.getConnectBusinessService().getCustomersResourceByBusinessIds(list);

    }

    public static List<Long> getConnectSaleChanceTypeByBusinessIds(Integer resource, List<Long> list) {
        ProjectResourceEnum projectResourceEnum = getFullEnumsMap().get(resource);
        if (Objects.isNull(projectResourceEnum)) {
            throw new SystemParamCheckException("传入的业务类型未定义");
        }
        return projectResourceEnum.getConnectBusinessService().getConnectSaleChanceTypeByBusinessIds(list);
    }

    public static CrmMoneyTranslateModel getContractCostByBusinessIds(Integer resource, List<Long> list) {
        ProjectResourceEnum projectResourceEnum = getFullEnumsMap().get(resource);
        if (Objects.isNull(projectResourceEnum)) {
            throw new SystemParamCheckException("传入的业务类型未定义");
        }
        return projectResourceEnum.getConnectBusinessService().getContractCostByBusinessIds(list);
    }

    public static CrmMoneyTranslateModel getConnectSaleChanceEstimatedContractAmountByBusinessIds(Integer resource, List<Long> list) {
        ProjectResourceEnum projectResourceEnum = getFullEnumsMap().get(resource);
        if (Objects.isNull(projectResourceEnum)) {
            throw new SystemParamCheckException("传入的业务类型未定义");
        }
        return projectResourceEnum.getConnectBusinessService().getConnectSaleChanceEstimatedContractAmountByBusinessIds(list);
    }

    public Integer getValue() {
        return value;
    }

    public String getTest() {
        return test;
    }

    public abstract Object getConnectBusiness(Long regId);

    public abstract IProjectConnectBusiness getConnectBusinessService();

    public abstract List<Long> getCustomerIdsByBusinessIds(List<Long> businessIds);

}
