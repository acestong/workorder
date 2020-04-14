package com.fea.project.api.other.service.customer;

import com.fea.project.api.other.dao.customer.CrmCustomerMapper;
import com.fea.project.api.other.model.customer.CrmCustomerModel;
import com.fea.project.util.ListUtil;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/10/24.
 * 客户表 Service
 */
@Service
public class CrmCustomerService {

    @Autowired
    private CrmCustomerMapper crmCustomerMapper;


    /**
     * 按主键选择
     */
    public CrmCustomerModel selectById(Long ID) {
        return ID == null ? null : this.crmCustomerMapper.selectById(ID);
    }

    /**
     * 按模型选择
     */
    public List<CrmCustomerModel> selectByModel(CrmCustomerModel model) {
        return model == null ? new ArrayList<>(0) : this.crmCustomerMapper.selectByModel(model);
    }


    public List<CrmCustomerModel> selectByIds(List<Long> ids) {
        if (ListUtil.isNullOrEmpty(ids)) {
            return new ArrayList<>();
        }
        return this.crmCustomerMapper.selectByIds(ids);
    }
    
    /**
     * 通过客户Id获取地址
     * @param customerId
     * @return
     */
    public String selectAddressByCustomerId(Long customerId) {
    	 if (customerId == null) {
             return null;
         }
         return this.crmCustomerMapper.selectAddressByCustomerId(customerId);
    }
}