package com.fea.project.api.other.service.crm;

import com.fea.project.api.other.dao.crm.CrmSaleChanceTypeMapper;
import com.fea.project.api.other.model.crm.CrmSaleChanceTypeModel;
import com.fea.project.configure.exception.SystemParamCheckException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/11/11.
 */
@Service
public class CrmSaleChanceTypeService {

    @Autowired
    private CrmSaleChanceTypeMapper crmSaleChanceTypeMapper;


    /**
     * 按主键选择
     */
    public CrmSaleChanceTypeModel selectById(Long ID) {
        return ID == null ? null : this.crmSaleChanceTypeMapper.selectById(ID);
    }

    /**
     * 按模型选择
     */
    public List<CrmSaleChanceTypeModel> selectByModel(CrmSaleChanceTypeModel model) {
        return model == null ? new ArrayList<>(0) : this.crmSaleChanceTypeMapper.selectByModel(model);
    }


    public Object selectCrmChanceTypeByRegId(Long regId) {
        if (regId == null) {
            throw new SystemParamCheckException("传入的组织结构id异常，无法进行查询");
        }
        List<CrmSaleChanceTypeModel> list = this.selectByModel(new CrmSaleChanceTypeModel(regId));
        List<Map<String, Object>> finalList = new ArrayList<>();
        list.forEach(x -> {
            Map<String, Object> map = new HashMap<>();
            map.put("id", x.getID() + "");
            map.put("name", x.getTYPE());
            finalList.add(map);
        });
        return finalList;
    }

    public List<CrmSaleChanceTypeModel> selectByIds(List<Long> ids) {
        if (ids == null) {
            throw new SystemParamCheckException("传入的参数异常，无法进行查询");
        }
        return this.crmSaleChanceTypeMapper.selectByIds(ids);
    }


}