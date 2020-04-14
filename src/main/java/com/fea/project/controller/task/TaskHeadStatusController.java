package com.fea.project.controller.task;

import com.fea.project.model.task.TaskHeadStatusModel;
import com.fea.project.service.task.ITaskHeadStatusService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/task/taskHeadStatus")
public class TaskHeadStatusController {

	@Resource
	private ITaskHeadStatusService service;
	
	@PostMapping("/insert")
	public void insert(TaskHeadStatusModel model) {
		service.save(model);
	}
	@GetMapping
	public TaskHeadStatusModel getAll(Long taskResourceType) {
		return  service.selectByCurUserIdAndTaskResourceType(taskResourceType);
	}
	@PostMapping("/update")
	public void update(@RequestBody TaskHeadStatusModel model) {
		service.updateByCurUserId(model);
	}
}
