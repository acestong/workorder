package com.fea.project.workorder.dao;

import com.fea.project.workorder.model.WorkorderReportModel;
import com.fea.project.workorder.model.WorkorderReportModelExample;
import com.fea.project.workorder.model.vo.WorkorderReportModelVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkorderReportModelMapper {
    long countByExample(WorkorderReportModelExample example);

    int deleteByExample(WorkorderReportModelExample example);

    int deleteByPrimaryKey(Long reportId);

    int insert(WorkorderReportModel record);

    int insertSelective(WorkorderReportModel record);

    List<WorkorderReportModel> selectByExample(WorkorderReportModelExample example);

    WorkorderReportModel selectByPrimaryKey(Long reportId);
    
    /**
     * 通过工单id获取工单列表
     * @param workorderId
     * @return
     */
    List<WorkorderReportModelVo> selectListByWorkorderId(Long workorderId);

    int updateByExampleSelective(@Param("record") WorkorderReportModel record, @Param("example") WorkorderReportModelExample example);

    int updateByExample(@Param("record") WorkorderReportModel record, @Param("example") WorkorderReportModelExample example);

    int updateByPrimaryKeySelective(WorkorderReportModel record);

    int updateByPrimaryKey(WorkorderReportModel record);
}