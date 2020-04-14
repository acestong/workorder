package com.fea.project.api.other.dao.customer;

import com.fea.project.api.other.model.customer.CrmStructureModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/10/24.
 * 客户组织结构表 mapper
 */
public interface CrmStructureMapper {

    /**
     * 按主键选择
     */
    CrmStructureModel selectById(Long ID);

    /**
     * 按模型选择
     */
    List<CrmStructureModel> selectByModel(CrmStructureModel model);


    List<CrmStructureModel> selectByCustomerIds(@Param("list") List<Long> customerIds);
}