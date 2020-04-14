package com.fea.project.dao.plan;

import com.fea.project.model.plan.PlanHeadStatusModel;
import com.fea.project.model.plan.PlanHeadStatusModelExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PlanHeadStatusModelMapper {
    long countByExample(PlanHeadStatusModelExample example);

    int deleteByExample(PlanHeadStatusModelExample example);

    int deleteByPrimaryKey(Long curUserId);

    int insert(PlanHeadStatusModel record);

    int insertSelective(PlanHeadStatusModel record);
 
    List<PlanHeadStatusModel> selectByExample(PlanHeadStatusModelExample example);

    PlanHeadStatusModel selectByPrimaryKey(Long curUserId);
    
    PlanHeadStatusModel selectByCurUserId(Long curUserId);

    int updateByExampleSelective(@Param("record") PlanHeadStatusModel record, @Param("example") PlanHeadStatusModelExample example);

    int updateByExample(@Param("record") PlanHeadStatusModel record, @Param("example") PlanHeadStatusModelExample example);

    int updateByPrimaryKeySelective(PlanHeadStatusModel record);

    int updateByPrimaryKey(PlanHeadStatusModel record);
}