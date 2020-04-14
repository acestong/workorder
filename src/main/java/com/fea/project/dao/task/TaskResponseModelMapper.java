package com.fea.project.dao.task;

import com.fea.project.model.task.TaskResponseModel;
import com.fea.project.model.task.TaskResponseModelExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TaskResponseModelMapper {
    long countByExample(TaskResponseModelExample example);

    int deleteByExample(TaskResponseModelExample example);

    int deleteByPrimaryKey(Long taskResponseId);

    int insert(TaskResponseModel record);
 
    int insertSelective(TaskResponseModel record);

    List<TaskResponseModel> selectByExample(TaskResponseModelExample example);

    TaskResponseModel selectByPrimaryKey(Long taskResponseId);

    int updateByExampleSelective(@Param("record") TaskResponseModel record, @Param("example") TaskResponseModelExample example);

    int updateByExample(@Param("record") TaskResponseModel record, @Param("example") TaskResponseModelExample example);

    int updateByPrimaryKeySelective(TaskResponseModel record);

    int updateByPrimaryKey(TaskResponseModel record);
    
    List<TaskResponseModel> selectAllWithDelStatus(Long taskResponseId);
    
    TaskResponseModel selectByPrimaryKeyWithDelStatus(TaskResponseModel record);
    
    int updateByPrimaryKeySelectiveWithDelStatus(TaskResponseModel record);
    
}