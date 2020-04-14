package com.fea.project.api.other.service.customer;

import com.fea.project.api.other.dao.customer.CrmStructureMapper;
import com.fea.project.api.other.model.customer.CrmStructureModel;
import com.fea.project.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/10/24.
 * 客户组织结构表 Service
 */
@Service
public class CrmStructureService {

    @Autowired
    private CrmStructureMapper crmStructureMapper;


    /**
     * 按主键选择
     */
    public CrmStructureModel selectById(Long ID) {
        return ID == null ? null : this.crmStructureMapper.selectById(ID);
    }

    /**
     * 按模型选择
     */
    public List<CrmStructureModel> selectByModel(CrmStructureModel model) {
        return model == null ? new ArrayList<>(0) : this.crmStructureMapper.selectByModel(model);
    }


    public List<CrmStructureModel> selectByCustomerIds(List<Long> customerIds) {
        if (ListUtil.isNullOrEmpty(customerIds)) {
            return new ArrayList<>();
        }
        return this.crmStructureMapper.selectByCustomerIds(customerIds);
    }
}