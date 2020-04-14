package com.fea.project.api.other.dao.crm;

import com.fea.project.api.other.model.crm.CrmOrderModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2019/09/10.
 */
@Mapper
@Component
public interface CrmOrderMapper {
    /**
     * 按主键选择
     */
    CrmOrderModel selectById(Long id);

}