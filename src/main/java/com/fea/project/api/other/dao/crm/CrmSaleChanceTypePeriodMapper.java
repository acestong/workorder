package com.fea.project.api.other.dao.crm;

import com.fea.project.api.other.model.crm.CrmSaleChanceTypePeriodModel;

import java.util.List;

/**
 * Created by Administrator on 2019/11/11.
 */
public interface CrmSaleChanceTypePeriodMapper {

    /**
     * 按主键选择
     */
    CrmSaleChanceTypePeriodModel selectById(Long id);

    /**
     * 按模型选择
     */
    List<CrmSaleChanceTypePeriodModel> selectByModel(CrmSaleChanceTypePeriodModel model);

}