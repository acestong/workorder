package com.fea.project.dao.task;

import com.fea.project.model.task.TaskCommentModel;
import com.fea.project.model.task.TaskCommentModelExample;
import com.fea.project.model.task.vo.TaskCommentModelVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TaskCommentModelMapper {
    long countByExample(TaskCommentModelExample example);

    int deleteByExample(TaskCommentModelExample example);

    int deleteByPrimaryKey(Long taskCommentId);

    int insert(TaskCommentModel record);
 
    int insertSelective(TaskCommentModel record);

    List<TaskCommentModel> selectByExample(TaskCommentModelExample example);

    TaskCommentModel selectByPrimaryKey(Long taskCommentId);
    
    TaskCommentModel selectOneByTaskId(Long taskId);

    int updateByExampleSelective(@Param("record") TaskCommentModel record, @Param("example") TaskCommentModelExample example);

    int updateByExample(@Param("record") TaskCommentModel record, @Param("example") TaskCommentModelExample example);

    int updateByPrimaryKeySelective(TaskCommentModel record);

    int updateByPrimaryKey(TaskCommentModel record);
    
    List<TaskCommentModelVo> selectAllWithDelStatus(Long businessId);

    TaskCommentModel selectByPrimaryKeyWithDelStatus(TaskCommentModel record);
    
    int updateByPrimaryKeySelectiveWithDelStatus(TaskCommentModel record);
}