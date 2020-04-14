package com.fea.project.api.other.dao.crm;

import com.fea.project.api.other.model.crm.CrmContractModel;
import com.fea.project.api.other.model.crm.vo.CrmContractVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/09/26.
 * 合同 mapper
 */
public interface CrmContractMapper {

    /**
     * 按主键选择
     */
    CrmContractModel selectById(Long id);

    /**
     * 按模型选择
     */
    List<CrmContractModel> selectByModel(CrmContractModel model);

    List<CrmContractModel> selectByIds(@Param("list") List<Long> ids);

    List<Long> getProductsByIds(@Param("list") List<Long> ids);

    List<CrmContractModel> selectBySaleChanceTypes(@Param("list") List<Long> list);

    List<CrmContractVo> selectVosByIds(List<Long> ids);
}