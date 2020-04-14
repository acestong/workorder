package com.fea.project.api.other.dao.crm;

import com.fea.project.api.other.model.crm.CrmSaleChanceModel;
import com.fea.project.api.other.model.crm.vo.CrmSaleChanceVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/09/26.
 */
public interface CrmSaleChanceMapper {

    /**
     * 按主键选择
     */
    CrmSaleChanceModel selectById(Long ID);

    /**
     * 按模型选择
     */
    List<CrmSaleChanceModel> selectByModel(CrmSaleChanceModel model);

    List<CrmSaleChanceModel> selectByIds(@Param("list") List<Long> ids);

    List<Long> getProductsByIds(@Param("list") List<Long> list);

    List<CrmSaleChanceVo> selectVosByIds(List<Long> ids);
}