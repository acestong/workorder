package com.fea.project.api.other.service.base;

import com.fea.project.api.other.dao.base.SysDictionaryItemMapper;
import com.fea.project.api.other.model.base.SysDictionaryItemModel;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/12/07.
 * 数据字典子表 Service
 */
@Service
public class SysDictionaryItemService {

    @Autowired
    private SysDictionaryItemMapper sysDictionaryItemMapper;

    /**
     * 按主键选择
     */
    public SysDictionaryItemModel selectById(Long ITEMID) {
        return ITEMID == null ? null : this.sysDictionaryItemMapper.selectById(ITEMID);
    }

    /**
     * 按模型选择
     */
    public List<SysDictionaryItemModel> selectByModel(SysDictionaryItemModel model) {
        return model == null ? new ArrayList<>(0) : this.sysDictionaryItemMapper.selectByModel(model);
    }

    public List<SysDictionaryItemModel> selectByShortNameAndRegId(String shortName, Long regId) {
        if (StringUtil.isEmpty(shortName) || regId == null) {
            throw new SystemParamCheckException("传入的类型简称或是组织id异常，无法进行查询");
        }
        return this.sysDictionaryItemMapper.selectByShortNameAndRegId(shortName, regId);
    }


}