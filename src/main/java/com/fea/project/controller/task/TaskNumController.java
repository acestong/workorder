package com.fea.project.controller.task;


import com.fea.project.model.task.TaskNumModel;
import com.fea.project.service.task.ITaskNumService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/task/taskNum")
public class TaskNumController {

	@Resource
	private ITaskNumService service;
	
	@GetMapping("/selectByConUserId")
	public List<TaskNumModel> selectByConUserId(Long isSonTask) {
		return service.selectByConUserId(isSonTask);
	}
	
	@PostMapping("/update")
	public void update(@RequestBody TaskNumModel taskNumModel) {
		service.updateByCurUserIdAndIsSonTask(taskNumModel);
	}
}
