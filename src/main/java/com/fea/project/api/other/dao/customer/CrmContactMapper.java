package com.fea.project.api.other.dao.customer;

import com.fea.project.api.other.model.customer.CrmContactInfoModel;
import com.fea.project.api.other.model.customer.CrmContactModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/10/24.
 * 联系人基本信息表 mapper
 */
public interface CrmContactMapper {

    /**
     * 按主键选择
     */
    CrmContactModel selectById(Long ID);

    /**
     * 按模型选择
     */
    List<CrmContactModel> selectByModel(CrmContactModel model);

    List<CrmContactModel> selectByCustomerIds(List<Long> customerIds);

    List<CrmContactModel> selectByContactorIds(@Param("list") List<Long> contactorIds);
    
    /**
     * 按customerId选择
     * @param customerId
     * @return
     */
    List<CrmContactInfoModel> selectEmpInfoById(Long customerId);
}