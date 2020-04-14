package com.fea.project.dao.task;

import com.fea.project.model.task.TaskNumModel;
import com.fea.project.model.task.TaskNumModelExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TaskNumModelMapper {
    long countByExample(TaskNumModelExample example);

    int deleteByExample(TaskNumModelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TaskNumModel record);
    
    //同时插入当前用户的任务编号和子任务编号
    int insertTaskNumAndSonTaskNum(List<TaskNumModel> list);

    int insertSelective(TaskNumModel record);

    List<TaskNumModel> selectByExample(TaskNumModelExample example);

    TaskNumModel selectByPrimaryKey(Long id);

    //通过当前用户Id获取任务列表
    List<TaskNumModel> selectByConUserId(TaskNumModel taskNumModel);

    int updateByExampleSelective(@Param("record") TaskNumModel record, @Param("example") TaskNumModelExample example);

    int updateByExample(@Param("record") TaskNumModel record, @Param("example") TaskNumModelExample example);

    int updateByPrimaryKeySelective(TaskNumModel record);

    int updateByPrimaryKey(TaskNumModel record);
    //通过当前用户Id和任务和子任务分类来更新任务和子任务的序列号
    int updateByCurUserIdAndIsSonTask(TaskNumModel record);
}