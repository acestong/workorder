package com.fea.project.api.other.dao.customer;

import com.fea.project.api.other.model.customer.CrmCustomerModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/10/24.
 * 客户表 mapper
 */
public interface CrmCustomerMapper {
    /**
     * 按主键选择
     */
    CrmCustomerModel selectById(Long ID);

    /**
     * 按模型选择
     */
    List<CrmCustomerModel> selectByModel(CrmCustomerModel model);

    List<CrmCustomerModel> selectByIds(@Param("list") List<Long> ids);
    
    /**
     * 通过customerId 获取地址
     * @param customerId
     * @return
     */
    String selectAddressByCustomerId(@Param("customerId") Long customerId);
}