package com.fea.project.workorder.dao;

import com.fea.project.workorder.model.PoolAutoDispatchModel;
import com.fea.project.workorder.model.PoolAutoDispatchModelExample;
import com.fea.project.workorder.model.vo.PoolAutoDispatchModelVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PoolAutoDispatchModelMapper {
    long countByExample(PoolAutoDispatchModelExample example);

    int deleteByExample(PoolAutoDispatchModelExample example);

    int deleteByPrimaryKey(Long autoDispatchId);

    int insert(PoolAutoDispatchModel record);

    int insertSelective(PoolAutoDispatchModel record);
    
    int insertByList(@Param("poolId") Long workorderPoolId , @Param("list") List<PoolAutoDispatchModelVo> list);

    List<PoolAutoDispatchModel> selectByExample(PoolAutoDispatchModelExample example);

    PoolAutoDispatchModel selectByPrimaryKey(Long autoDispatchId);

    int updateByExampleSelective(@Param("record") PoolAutoDispatchModel record, @Param("example") PoolAutoDispatchModelExample example);

    int updateByExample(@Param("record") PoolAutoDispatchModel record, @Param("example") PoolAutoDispatchModelExample example);

    int updateByPrimaryKeySelective(PoolAutoDispatchModel record);

    int updateByPrimaryKey(PoolAutoDispatchModel record);
}