package com.fea.project.api.other.service.crm;

import com.fea.project.api.other.dao.crm.CrmDictionaryIndustryMapper;
import com.fea.project.api.other.model.crm.CrmDictionaryIndustryModel;
import com.fea.project.configure.exception.SystemParamCheckException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/10/28.
 * 销售行业表 Service
 */
@Service
public class CrmDictionaryIndustryService {

    @Autowired
    private CrmDictionaryIndustryMapper crmDictionaryIndustryMapper;


    /**
     * 按主键选择
     */
    public CrmDictionaryIndustryModel selectById(Long ID) {
        return ID == null ? null : this.crmDictionaryIndustryMapper.selectById(ID);
    }

    /**
     * 按模型选择
     */
    public List<CrmDictionaryIndustryModel> selectByModel(CrmDictionaryIndustryModel model) {
        return model == null ? new ArrayList<>(0) : this.crmDictionaryIndustryMapper.selectByModel(model);
    }

    public List<CrmDictionaryIndustryModel> selectIndustryByLevel(Long parentId, Long regId) {
        if (regId == null) {
            throw new SystemParamCheckException("组织id传入异常，无法查询对应行业");
        }
        return this.crmDictionaryIndustryMapper.selectIndustryByLevel(parentId, regId);
    }

    public List<CrmDictionaryIndustryModel> selectByIds(List<Long> ids) {
        if (ids == null) {
            throw new SystemParamCheckException("传入的参数异常，无法进行查询");
        }
        if (ids.isEmpty()) {
            return new ArrayList<>();
        }
        return this.crmDictionaryIndustryMapper.selectByIds(ids);
    }

    public List<CrmDictionaryIndustryModel> selectUsefulIndustry(Long regId) {
        if(regId == null){
            throw new SystemParamCheckException("组织id异常，数据无法查询");
        }
        return this.crmDictionaryIndustryMapper.selectByRegId(regId);
    }
}