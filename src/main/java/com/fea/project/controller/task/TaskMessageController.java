package com.fea.project.controller.task;

import com.fea.project.model.task.TaskMessageModel;
import com.fea.project.service.task.ITaskMessageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/task/taskMessage")
public class TaskMessageController {

	@Resource
	private ITaskMessageService service;
	
	@GetMapping
	public List<TaskMessageModel> getAll(Long taskId) {
		return service.getAll(taskId);
	} 
	
	@GetMapping("/getOne")
	public TaskMessageModel getOne(Long taskMessageId , Long taskId) {
		return service.getOne(taskMessageId, taskId);
	}
	
	
	@PostMapping("/insert")
	public void save(@RequestBody TaskMessageModel taskMessageModel) {
		service.save(taskMessageModel);
	}
	
	@PostMapping("/update")
	public void update(@RequestBody TaskMessageModel taskMessageModel) {
		service.update(taskMessageModel);
	}
	
	@PostMapping("/delete")
	public void delete(@RequestBody TaskMessageModel taskMessageModel) {
		service.delete(taskMessageModel);
	}
}
