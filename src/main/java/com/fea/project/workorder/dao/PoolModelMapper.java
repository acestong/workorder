package com.fea.project.workorder.dao;

import com.fea.project.workorder.model.PoolModel;
import com.fea.project.workorder.model.PoolModelExample;
import com.fea.project.workorder.model.vo.IdAndNameModelVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PoolModelMapper {
    long countByExample(PoolModelExample example);

    int deleteByExample(PoolModelExample example);

    int deleteByPrimaryKey(Long workorderPoolId);

    int insert(PoolModel record);

    int insertSelective(PoolModel record);

    List<PoolModel> selectByExample(PoolModelExample example);
    
    /**
     * 通过orgId获取工单池列表
     * @param orgId
     * @return
     */
    List<PoolModel> selectListByOrgId(Long orgId);

    PoolModel selectByPrimaryKey(Long workorderPoolId);
    
    /**
     * 通过组织Id获取工单池Id和name集合
     * @return
     */
    List<IdAndNameModelVo> selectIdAndNameListByOrgId(Long orgId);

    int updateByExampleSelective(@Param("record") PoolModel record, @Param("example") PoolModelExample example);

    int updateByExample(@Param("record") PoolModel record, @Param("example") PoolModelExample example);

    int updateByPrimaryKeySelective(PoolModel record);

    int updateByPrimaryKey(PoolModel record);
    
    
}