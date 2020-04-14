package com.fea.project.api.other.dao.crm;

import com.fea.project.api.other.model.crm.CrmDictionaryIndustryModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/10/28.
 * 销售行业表 mapper
 */
public interface CrmDictionaryIndustryMapper {

    /**
     * 按主键选择
     */
    CrmDictionaryIndustryModel selectById(Long ID);

    /**
     * 按模型选择
     */
    List<CrmDictionaryIndustryModel> selectByModel(CrmDictionaryIndustryModel model);

    List<CrmDictionaryIndustryModel> selectIndustryByLevel(@Param("parentId") Long parentId, @Param("regId") Long regId);

    List<CrmDictionaryIndustryModel> selectByIds(@Param("list") List<Long> ids);

    List<CrmDictionaryIndustryModel> selectByRegId(@Param("regId") Long regId);
}