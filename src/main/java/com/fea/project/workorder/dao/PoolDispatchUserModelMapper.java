package com.fea.project.workorder.dao;

import com.fea.project.workorder.model.PoolDispatchUserModel;
import com.fea.project.workorder.model.PoolDispatchUserModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PoolDispatchUserModelMapper {
    long countByExample(PoolDispatchUserModelExample example);

    int deleteByExample(PoolDispatchUserModelExample example);

    int deleteByPrimaryKey(Long dispatchId);

    int insert(PoolDispatchUserModel record);

    int insertSelective(PoolDispatchUserModel record);
    
    int insertByList(@Param("poolId")Long workorderPoolId, @Param("autoDispatchId") Long autoDispatchId ,@Param("list")List<PoolDispatchUserModel> list);

    List<PoolDispatchUserModel> selectByExample(PoolDispatchUserModelExample example);

    PoolDispatchUserModel selectByPrimaryKey(Long dispatchId);
    /**
     * 通过工单池id获取当前需要分配的负责人model
     * @param poolId
     * @return
     */
    PoolDispatchUserModel selectModelByPoolId(Long poolId);

    int updateByExampleSelective(@Param("record") PoolDispatchUserModel record, @Param("example") PoolDispatchUserModelExample example);

    int updateByExample(@Param("record") PoolDispatchUserModel record, @Param("example") PoolDispatchUserModelExample example);

    int updateByPrimaryKeySelective(PoolDispatchUserModel record);

    int updateByPrimaryKey(PoolDispatchUserModel record);
}