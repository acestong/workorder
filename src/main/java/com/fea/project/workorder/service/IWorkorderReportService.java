package com.fea.project.workorder.service;

import java.util.List;

import com.fea.project.workorder.model.WorkorderReportModel;
import com.fea.project.workorder.model.vo.WorkorderReportModelVo;

public interface IWorkorderReportService {

	Integer insert(WorkorderReportModel model);
	
	List<WorkorderReportModelVo> selectListByWorkorderId(Long workorderId);
	
	WorkorderReportModel selectById(Long reportId);
	
	Integer update(WorkorderReportModel model);
	
	Integer delete(Long reportId);
}
