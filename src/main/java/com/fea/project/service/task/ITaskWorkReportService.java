package com.fea.project.service.task;

import com.fea.project.model.BasePageInfo;
import com.fea.project.model.task.TaskWorkReportModel;
import com.fea.project.model.task.vo.ReportModelVo;
import com.fea.project.model.task.vo.TaskWorkReportModelVo;

import java.util.Map;

public interface ITaskWorkReportService {

	void save(TaskWorkReportModelVo taskWorkReportModelVo);
	void insert(TaskWorkReportModelVo taskWorkReportModelVo);
	void delete(TaskWorkReportModel taskWorkReportModel);
	void update(ReportModelVo taskWorkReportModel);
	Map<String,Object> getAll(BasePageInfo<TaskWorkReportModelVo> page);
	ReportModelVo getOne(TaskWorkReportModel taskWorkReportModel);
	TaskWorkReportModel getLatestOneByTaskId(Long taskId);
}
 