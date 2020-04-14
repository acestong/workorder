package com.fea.project.api.other.service.crm;


import com.fea.project.api.other.dao.crm.CrmDictionaryRegionMapper;
import com.fea.project.api.other.model.crm.CrmDictionaryRegionModel;
import com.fea.project.configure.exception.SystemParamCheckException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/10/28.
 * 销售区域表 Service
 */
@Service
public class CrmDictionaryRegionService {

    @Autowired
    private CrmDictionaryRegionMapper crmDictionaryRegionMapper;

    /**
     * 按主键选择
     */
    public CrmDictionaryRegionModel selectById(Long ID) {
        return ID == null ? null : this.crmDictionaryRegionMapper.selectById(ID);
    }

    /**
     * 按模型选择
     */
    public List<CrmDictionaryRegionModel> selectByModel(CrmDictionaryRegionModel model) {
        return model == null ? new ArrayList<>(0) : this.crmDictionaryRegionMapper.selectByModel(model);
    }

    public List<CrmDictionaryRegionModel> selectRegionByLevel(Long parentId, Long regId) {
        if (regId == null) {
            throw new SystemParamCheckException("传入的组织机构id无效，无法进行区域查询");
        }
        return this.crmDictionaryRegionMapper.selectRegionByLevel(parentId, regId);
    }

    public List<CrmDictionaryRegionModel> selectByIds(List<Long> ids) {
        if (ids == null) {
            throw new SystemParamCheckException("传入的参数异常,无法进行查询");
        }
        if (ids.isEmpty()) {
            return new ArrayList<>();
        }
        return this.crmDictionaryRegionMapper.selectByIds(ids);
    }

    public List<CrmDictionaryRegionModel> selectUsefulRegion(Long regId) {
        if(regId == null){
            throw new SystemParamCheckException("组织id传入异常，无法进行查询");
        }
        return this.crmDictionaryRegionMapper.selectUsefulRegion(regId);
    }
}