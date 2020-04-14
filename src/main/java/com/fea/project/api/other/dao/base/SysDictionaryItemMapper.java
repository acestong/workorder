package com.fea.project.api.other.dao.base;

import com.fea.project.api.other.model.base.SysDictionaryItemModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/12/07.
 * 数据字典子表 mapper
 */
public interface SysDictionaryItemMapper {

    /**
     * 按主键选择
     */
    SysDictionaryItemModel selectById(Long ITEMID);

    /**
     * 按模型选择
     */
    List<SysDictionaryItemModel> selectByModel(SysDictionaryItemModel model);

    List<SysDictionaryItemModel> selectByShortNameAndRegId(@Param("dicCode") String shortName, @Param("regId") Long regId);
}