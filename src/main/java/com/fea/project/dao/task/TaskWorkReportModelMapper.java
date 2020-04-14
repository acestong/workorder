package com.fea.project.dao.task;

import com.fea.project.model.task.TaskWorkReportModel;
import com.fea.project.model.task.TaskWorkReportModelExample;
import com.fea.project.model.task.vo.ReportModelVo;
import com.fea.project.model.task.vo.TaskWorkReportModelVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TaskWorkReportModelMapper {
    long countByExample(TaskWorkReportModelExample example);

    int deleteByExample(TaskWorkReportModelExample example);
 
    int deleteByPrimaryKey(Long workReportId);

    int insert(TaskWorkReportModel record);

    int insertSelective(TaskWorkReportModel record);

    List<TaskWorkReportModel> selectByExample(TaskWorkReportModelExample example);

    TaskWorkReportModel selectByPrimaryKey(Long workReportId);
    
    TaskWorkReportModel selectLatestOneByTaskId(Long taskId);

    int updateByExampleSelective(@Param("record") TaskWorkReportModel record, @Param("example") TaskWorkReportModelExample example);

    int updateByExample(@Param("record") TaskWorkReportModel record, @Param("example") TaskWorkReportModelExample example);

    int updateByPrimaryKeySelective(ReportModelVo record);

    int updateByPrimaryKey(TaskWorkReportModel record);
    
    int updateBusinessIdInAppendix(TaskWorkReportModelVo modelVo);
    
    List<TaskWorkReportModelVo> selectAllWithDelStatus(Long workReportId);
    
    ReportModelVo selectByPrimaryKeyWithDelStatus(TaskWorkReportModel record);
    
    int updateByPrimaryKeySelectiveWithDelStatus(TaskWorkReportModel record);
}