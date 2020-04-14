package com.fea.project.service.establishproject.project;

import com.fea.project.api.other.io.project.IProjectConnectBusiness;
import com.fea.project.api.other.model.crm.CrmMoneyTranslateModel;
import com.fea.project.enums.base.DictionaryTypeEnum;
import com.fea.project.model.base.ProjectDictionaryModel;
import com.fea.project.service.base.ProjectDictionaryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/12/26 17:20
 **/
@Service
public class ProjectEstablishConnectBusinessService implements IProjectConnectBusiness<Map<String, Object>> {

    @Autowired
    private ProjectDictionaryItemService projectDictionaryItemService;


    @Override
    public List<Map<String, Object>> getConnectBusiness(Long regId) {
        return this.projectDictionaryItemService.listByShortNameAndRegIdWhenNullCreate(new ProjectDictionaryModel(DictionaryTypeEnum.PROJECT_RESOURCE_DETAIL.getValue(),regId))
                .stream().map(x -> new HashMap<String, Object>(2){{
                    put("id", x.getId() + "");
                    put("name", x.getName());
                }}).collect(Collectors.toList());
    }

    @Override
    public List<Long> getCustomerIdsByBusinessIds(List<Long> businessIds) {
        return Collections.emptyList();
    }

    @Override
    public List<Long> getProductsByIds(List<Long> list) {
        return Collections.emptyList();
    }

    @Override
    public List<Long> getCustomersAreaByBusinessIds(List<Long> list) {
        return Collections.emptyList();
    }

    @Override
    public List<Long> getCustomersResourceByBusinessIds(List<Long> list) {
        return Collections.emptyList();
    }

    @Override
    public List<Long> getConnectSaleChanceTypeByBusinessIds(List<Long> list) {
        return Collections.emptyList();
    }

    @Override
    public CrmMoneyTranslateModel getContractCostByBusinessIds(List<Long> list) {
        return null;
    }

    @Override
    public CrmMoneyTranslateModel getConnectSaleChanceEstimatedContractAmountByBusinessIds(List<Long> list) {
        return null;
    }
}
