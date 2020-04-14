package com.fea.project.controller.task;

import com.fea.project.model.BasePageInfo;
import com.fea.project.model.task.TaskWorkReportModel;
import com.fea.project.model.task.vo.ReportModelVo;
import com.fea.project.model.task.vo.TaskWorkReportModelVo;
import com.fea.project.service.task.ITaskWorkReportService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/task/taskWorkReport")
public class TaskWorkReportController {

	@Resource
	private ITaskWorkReportService service;
	
	@PostMapping
	public Map<String,Object> getAll(@RequestBody BasePageInfo<TaskWorkReportModelVo> page) {
		return service.getAll(page);
	}
	  
	@GetMapping("/getOne")
	public ReportModelVo getOne(TaskWorkReportModel taskWorkReportModel) {
		return service.getOne(taskWorkReportModel);
	}
	TaskWorkReportModelVo t = null;
	
	@PostMapping("/son/insert") 
	public void save(@RequestBody TaskWorkReportModelVo taskWorkReportModelVo) {
		service.save(taskWorkReportModelVo);
	}
	
	@PostMapping("/insert")
	public void insert(@RequestBody TaskWorkReportModelVo taskWorkReportModelVo) {
		service.insert(taskWorkReportModelVo);
	}
	
	@PostMapping("/update")
	public void update(@RequestBody ReportModelVo reportModel) {
		service.update(reportModel);
	}
	
	@PostMapping("/delete")
	public void delete(@RequestBody TaskWorkReportModel taskWorkReportModel) {
		service.delete(taskWorkReportModel);
	}
}
