package com.fea.project.workorder.dao;

import com.fea.project.workorder.model.PoolRuleModel;
import com.fea.project.workorder.model.PoolRuleModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PoolRuleModelMapper {
    long countByExample(PoolRuleModelExample example);

    int deleteByExample(PoolRuleModelExample example);

    int deleteByPrimaryKey(Long poolRuleId);

    int insert(PoolRuleModel record);

    int insertSelective(PoolRuleModel record);
    
    int insertByList(@Param("poolId") Long workorderPoolId,@Param("list") List<PoolRuleModel> list);

    List<PoolRuleModel> selectByExample(PoolRuleModelExample example);
    
    /**
     * 按照工单池id获取到所有的入池规则
     * @param workorderPoolId
     * @return
     */
    List<PoolRuleModel> selectListByPoolId(Long workorderPoolId);
    
    List<PoolRuleModel> selectByModel(PoolRuleModel model);

    PoolRuleModel selectByPrimaryKey(Long poolRuleId);

    int updateByExampleSelective(@Param("record") PoolRuleModel record, @Param("example") PoolRuleModelExample example);

    int updateByExample(@Param("record") PoolRuleModel record, @Param("example") PoolRuleModelExample example);

    int updateByPrimaryKeySelective(PoolRuleModel record);

    int updateByPrimaryKey(PoolRuleModel record);
}