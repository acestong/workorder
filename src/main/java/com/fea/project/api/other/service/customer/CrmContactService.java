package com.fea.project.api.other.service.customer;

import com.fea.project.api.other.dao.customer.CrmContactMapper;
import com.fea.project.api.other.model.customer.CrmContactInfoModel;
import com.fea.project.api.other.model.customer.CrmContactModel;
import com.fea.project.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/10/24.
 * 联系人基本信息表 Service
 */
@Service
public class CrmContactService {

    @Autowired
    private CrmContactMapper crmContactMapper;

    /**
     * 按主键选择
     */
    public CrmContactModel selectById(Long ID) {
        return ID == null ? null : this.crmContactMapper.selectById(ID);
    }

    /**
     * 按模型选择
     */
    public List<CrmContactModel> selectByModel(CrmContactModel model) {
        return model == null ? new ArrayList<>(0) : this.crmContactMapper.selectByModel(model);
    }

    public List<CrmContactModel> selectByCustomerIds(List<Long> customerIds) {
        if (ListUtil.isNullOrEmpty(customerIds)) {
            return new ArrayList<>();
        }
        return this.crmContactMapper.selectByCustomerIds(customerIds);
    }

    public List<CrmContactModel> selectByIds(List<Long> contactorIds) {
        if (ListUtil.isNullOrEmpty(contactorIds)) {
            return new ArrayList<>();
        }
        return this.crmContactMapper.selectByContactorIds(contactorIds);
    }
    
    
    /**
     * 按照customerId选择
     * @param customerId
     * @return
     */
   public List<CrmContactInfoModel> selectEmpInfoById(Long contactId){
		return contactId == null ? null : this.crmContactMapper.selectEmpInfoById(contactId);
    	
    }
}