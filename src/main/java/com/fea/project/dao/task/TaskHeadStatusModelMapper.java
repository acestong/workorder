package com.fea.project.dao.task;

import com.fea.project.model.task.TaskHeadStatusModel;
import com.fea.project.model.task.TaskHeadStatusModelExample;
import com.fea.project.model.task.vo.TaskHeadModelVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TaskHeadStatusModelMapper {
    long countByExample(TaskHeadStatusModelExample example);

    int deleteByExample(TaskHeadStatusModelExample example);

    int deleteByPrimaryKey(Long taskHeadStatusId);

    int insert(TaskHeadStatusModel record);

    int insertSelective(TaskHeadStatusModel record);

    List<TaskHeadStatusModel> selectByExample(TaskHeadStatusModelExample example);

    TaskHeadStatusModel selectByPrimaryKey(Long taskHeadStatusId);
    
    //通过当前用户和任务类型查找一条自定义表头
    TaskHeadStatusModel selectByCurUserIdAndTaskResourceType(TaskHeadModelVo taskHeadModelVo);

    int updateByExampleSelective(@Param("record") TaskHeadStatusModel record, @Param("example") TaskHeadStatusModelExample example);

    int updateByExample(@Param("record") TaskHeadStatusModel record, @Param("example") TaskHeadStatusModelExample example);

    int updateByPrimaryKeySelective(TaskHeadStatusModel record);
    
    //通过当前用户Id修改自定义表头
    int updateByCurUserIdSelective(TaskHeadStatusModel record);

    int updateByPrimaryKey(TaskHeadStatusModel record);
}