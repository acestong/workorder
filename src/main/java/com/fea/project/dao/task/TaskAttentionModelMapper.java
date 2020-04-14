package com.fea.project.dao.task;

import com.fea.project.model.task.TaskAttentionModel;
import com.fea.project.model.task.TaskAttentionModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaskAttentionModelMapper {
    long countByExample(TaskAttentionModelExample example);

    int deleteByExample(TaskAttentionModelExample example);

    int deleteByPrimaryKey(Long attentionId);

    int insert(TaskAttentionModel record);

    int insertSelective(TaskAttentionModel record);

    List<TaskAttentionModel> selectByExample(TaskAttentionModelExample example);

    TaskAttentionModel selectByPrimaryKey(Long attentionId);
    
    /**
     * 通过任务id获取关注model
     * @param taskId
     * @return
     */
    TaskAttentionModel selectByTaskId(Long taskId);

    int updateByExampleSelective(@Param("record") TaskAttentionModel record, @Param("example") TaskAttentionModelExample example);

    int updateByExample(@Param("record") TaskAttentionModel record, @Param("example") TaskAttentionModelExample example);

    int updateByPrimaryKeySelective(TaskAttentionModel record);

    int updateByPrimaryKey(TaskAttentionModel record);
    
    /**
     * 修改关注状态
     */
    Integer updateByTaskId(TaskAttentionModel record);
}