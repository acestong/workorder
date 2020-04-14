package com.fea.project.api.other.dao.crm;

import com.fea.project.api.other.model.crm.CrmDictionaryRegionModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/10/28.
 * 销售区域表 mapper
 */
public interface CrmDictionaryRegionMapper {
    /**
     * 按主键选择
     */
    CrmDictionaryRegionModel selectById(Long ID);

    /**
     * 按模型选择
     */
    List<CrmDictionaryRegionModel> selectByModel(CrmDictionaryRegionModel model);

    List<CrmDictionaryRegionModel> selectRegionByLevel(@Param("parentId") Long parentId, @Param("regId") Long regId);

    List<CrmDictionaryRegionModel> selectByIds(@Param("list") List<Long> ids);

    List<CrmDictionaryRegionModel> selectUsefulRegion(@Param("regId") Long regId);
}