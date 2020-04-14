package com.fea.project.controller.task;

import com.fea.project.model.task.vo.UserIdAndNameInfo;
import com.fea.project.service.task.ITaskParticipantService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/task/taskParticipant")
public class TaskParticipantController {

	@Resource
	private ITaskParticipantService service;
	
	@GetMapping
	public List<UserIdAndNameInfo> getAll(Long taskId){
		return service.getAll(taskId);
	}
}
