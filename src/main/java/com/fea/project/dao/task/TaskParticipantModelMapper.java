package com.fea.project.dao.task;

import com.fea.project.model.task.TaskParticipantModel;
import com.fea.project.model.task.TaskParticipantModelExample;
import com.fea.project.model.task.vo.UserIdAndNameInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TaskParticipantModelMapper {
    long countByExample(TaskParticipantModelExample example);

    int deleteByExample(TaskParticipantModelExample example);

    int deleteByPrimaryKey(Long taskPanticipantId);
    
    /**
     * 通过taskId删除
     * @param taskId
     * @return
     */
    Integer deleteByTaskId(Long taskId);
 
    int insert(TaskParticipantModel record);

    int insertSelective(TaskParticipantModel record);
    
    Integer insertByList(@Param("list")List<TaskParticipantModel> list);

    List<TaskParticipantModel> selectByExample(Long taskId);
    
    List<UserIdAndNameInfo> selectAllByTaskId(Long taskId);

    TaskParticipantModel selectByPrimaryKey(Long taskPanticipantId);

    int updateByExampleSelective(@Param("record") TaskParticipantModel record, @Param("example") TaskParticipantModelExample example);

    int updateByExample(@Param("record") TaskParticipantModel record, @Param("example") TaskParticipantModelExample example);

    int updateByPrimaryKeySelective(TaskParticipantModel record);

    int updateByPrimaryKey(TaskParticipantModel record);
}