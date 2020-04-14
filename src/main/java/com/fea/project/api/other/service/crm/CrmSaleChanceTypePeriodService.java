package com.fea.project.api.other.service.crm;

import com.fea.project.api.other.dao.crm.CrmSaleChanceTypePeriodMapper;
import com.fea.project.api.other.model.crm.CrmSaleChanceTypePeriodModel;
import com.fea.project.configure.exception.SystemParamCheckException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/11/11.
 */
@Service
public class CrmSaleChanceTypePeriodService {

    @Autowired
    private CrmSaleChanceTypePeriodMapper crmSaleChanceTypePeriodMapper;

    /**
     * 按主键选择
     */
    public CrmSaleChanceTypePeriodModel selectById(Long id) {
        return id == null ? null : this.crmSaleChanceTypePeriodMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<CrmSaleChanceTypePeriodModel> selectByModel(CrmSaleChanceTypePeriodModel model) {
        return model == null ? new ArrayList<>(0) : this.crmSaleChanceTypePeriodMapper.selectByModel(model);
    }


    public Object selectCrmChanceTypePeriodByRegIdAndSaleChanceId(Long regId, Long saleChanceTypeId) {
        if (regId == null || saleChanceTypeId == null) {
            throw new SystemParamCheckException("传入的参数异常，无法查询销售类型下的销售阶段");
        }
        return this.crmSaleChanceTypePeriodMapper.selectByModel(new CrmSaleChanceTypePeriodModel(regId, saleChanceTypeId));
    }
}