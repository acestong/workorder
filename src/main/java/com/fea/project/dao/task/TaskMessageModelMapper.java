package com.fea.project.dao.task;

import com.fea.project.model.task.TaskMessageModel;
import com.fea.project.model.task.TaskMessageModelExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TaskMessageModelMapper {
    long countByExample(TaskMessageModelExample example);

    int deleteByExample(TaskMessageModelExample example);

    int deleteByPrimaryKey(Long taskMessageId);
 
    int insert(TaskMessageModel record);

    int insertSelective(TaskMessageModel record);

    List<TaskMessageModel> selectByExample(TaskMessageModelExample example);

    TaskMessageModel selectByPrimaryKey(Long taskMessageId);

    int updateByExampleSelective(@Param("record") TaskMessageModel record, @Param("example") TaskMessageModelExample example);

    int updateByExample(@Param("record") TaskMessageModel record, @Param("example") TaskMessageModelExample example);

    int updateByPrimaryKeySelective(TaskMessageModel record);

    int updateByPrimaryKey(TaskMessageModel record);
    
    List<TaskMessageModel> selectAllWithDelStatus(Long taskId);
    
    TaskMessageModel selectByPrimaryKeyWithDelStatus(TaskMessageModel record);
    
    int updateByPrimaryKeySelectiveWithDelStatus(TaskMessageModel record);
}