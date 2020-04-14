package com.fea.project.workorder.dao;

import com.fea.project.workorder.model.ProcedureReportModel;
import com.fea.project.workorder.model.ProcedureReportModelExample;
import com.fea.project.workorder.model.vo.ProcedureReportModelVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProcedureReportModelMapper {
    long countByExample(ProcedureReportModelExample example);

    int deleteByExample(ProcedureReportModelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProcedureReportModel record);

    int insertSelective(ProcedureReportModel record);

    List<ProcedureReportModel> selectByExample(ProcedureReportModelExample example);
    
    List<ProcedureReportModel> selectByModel(ProcedureReportModel model);

    ProcedureReportModelVo selectByPrimaryKey(Long id);
    
    Double selectAvgRateByWorkorderId(Long workorderId);

    int updateByExampleSelective(@Param("record") ProcedureReportModel record, @Param("example") ProcedureReportModelExample example);

    int updateByExample(@Param("record") ProcedureReportModel record, @Param("example") ProcedureReportModelExample example);

    int updateByPrimaryKeySelective(ProcedureReportModel record);

    int updateByPrimaryKey(ProcedureReportModel record);
    
    List<ProcedureReportModelVo> selectByProcedureId(Long procedureId);
}