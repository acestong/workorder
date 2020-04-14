package com.fea.project.dao.task;

import com.fea.project.model.task.OpdcaTaskModel;
import com.fea.project.model.task.OpdcaTaskModelExample;
import com.fea.project.model.task.TaskModel;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OpdcaTaskModelMapper {
    long countByExample(OpdcaTaskModelExample example);

    int deleteByExample(OpdcaTaskModelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OpdcaTaskModel record);

    int insertSelective(OpdcaTaskModel record);

    List<OpdcaTaskModel> selectByExample(OpdcaTaskModelExample example);

    OpdcaTaskModel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OpdcaTaskModel record, @Param("example") OpdcaTaskModelExample example);

    int updateByExample(@Param("record") OpdcaTaskModel record, @Param("example") OpdcaTaskModelExample example);

    int updateByPrimaryKeySelective(OpdcaTaskModel record);

    int updateByPrimaryKey(OpdcaTaskModel record);
    
    //查询当前时间段内是否存在工作任务
    Integer selectExistedWorkTaskIdCount(TaskModel taskModel);
}