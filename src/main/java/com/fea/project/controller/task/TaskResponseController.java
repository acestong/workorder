package com.fea.project.controller.task;

import com.fea.project.model.task.TaskResponseModel;
import com.fea.project.model.task.vo.TaskResponseModelVo;
import com.fea.project.service.task.ITaskResponseService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/task/taskResponse")
public class TaskResponseController {

	@Resource
	private ITaskResponseService service;
	
	
	@GetMapping
	public List<TaskResponseModelVo> getAll(Long taskId) {
		return service.getAll(taskId);
	} 
	
	@GetMapping("/getOne")
	public TaskResponseModel getOne(Long taskResponseId , Long taskId) {
		TaskResponseModel taskResponseModel = new TaskResponseModel();
		taskResponseModel.setTaskResponseId(taskResponseId);
		taskResponseModel.setTaskId(taskId);
		return service.getOne(taskResponseModel);
	}
	
	@PostMapping("/insert")
	public void save(@RequestBody TaskResponseModel taskResponseModel) {
		service.save(taskResponseModel);
	}
	
	@PostMapping("/update")
	public void update(@RequestBody TaskResponseModel taskResponseModel) {
		service.update(taskResponseModel);
	}
	
	@PostMapping("/delete")
	public void delete(@RequestBody TaskResponseModel taskResponseModel) {
		service.delete(taskResponseModel);
	}
}
