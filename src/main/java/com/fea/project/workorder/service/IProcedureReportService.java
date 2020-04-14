package com.fea.project.workorder.service;

import java.util.List;

import com.fea.project.model.BasePageInfo;
import com.fea.project.workorder.model.vo.ProcedureReportModelVo;

public interface IProcedureReportService {

	Integer insert(ProcedureReportModelVo modelVo);
	
	ProcedureReportModelVo selectById(Long id);
	
	Double selectAvgRateByWorkorderId(Long workorderId); 
	
	BasePageInfo<ProcedureReportModelVo> selectByProcedureId(BasePageInfo<ProcedureReportModelVo> page);
}
