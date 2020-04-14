package com.fea.project.api.other.io.project;

import com.fea.project.api.other.model.crm.CrmMoneyTranslateModel;

import java.util.List;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/9/26 11:52
 **/
public interface IProjectConnectBusiness<T> {

    /**
     * 获取项目关联的业务
     *
     * @param regId
     * @return
     */
    List<T> getConnectBusiness(Long regId);

    List<Long> getCustomerIdsByBusinessIds(List<Long> businessIds);

    List<Long> getProductsByIds(List<Long> list);

    List<Long> getCustomersAreaByBusinessIds(List<Long> list);

    List<Long> getCustomersResourceByBusinessIds(List<Long> list);

    List<Long> getConnectSaleChanceTypeByBusinessIds(List<Long> list);

    CrmMoneyTranslateModel getContractCostByBusinessIds(List<Long> list);

    CrmMoneyTranslateModel getConnectSaleChanceEstimatedContractAmountByBusinessIds(List<Long> list);
}
