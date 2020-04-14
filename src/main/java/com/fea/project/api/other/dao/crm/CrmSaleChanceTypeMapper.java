package com.fea.project.api.other.dao.crm;

import com.fea.project.api.other.model.crm.CrmSaleChanceTypeModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/11/11.
 */
public interface CrmSaleChanceTypeMapper {

    /**
     * 按主键选择
     */
    CrmSaleChanceTypeModel selectById(Long ID);

    /**
     * 按模型选择
     */
    List<CrmSaleChanceTypeModel> selectByModel(CrmSaleChanceTypeModel model);

    List<CrmSaleChanceTypeModel> selectByIds(@Param("list") List<Long> ids);
}