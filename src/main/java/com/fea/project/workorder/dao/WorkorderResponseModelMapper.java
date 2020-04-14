package com.fea.project.workorder.dao;

import com.fea.project.workorder.model.WorkorderResponseModel;
import com.fea.project.workorder.model.WorkorderResponseModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkorderResponseModelMapper {
    long countByExample(WorkorderResponseModelExample example);

    int deleteByExample(WorkorderResponseModelExample example);

    int deleteByPrimaryKey(Long responseId);

    int insert(WorkorderResponseModel record);

    int insertSelective(WorkorderResponseModel record);

    List<WorkorderResponseModel> selectByExample(WorkorderResponseModelExample example);
    
    List<WorkorderResponseModel> selectByModel(WorkorderResponseModel model);

    WorkorderResponseModel selectByPrimaryKey(Long responseId);

    int updateByExampleSelective(@Param("record") WorkorderResponseModel record, @Param("example") WorkorderResponseModelExample example);

    int updateByExample(@Param("record") WorkorderResponseModel record, @Param("example") WorkorderResponseModelExample example);

    int updateByPrimaryKeySelective(WorkorderResponseModel record);

    int updateByPrimaryKey(WorkorderResponseModel record);
}