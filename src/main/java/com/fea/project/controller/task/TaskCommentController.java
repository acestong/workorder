package com.fea.project.controller.task;

import com.fea.project.model.task.TaskCommentModel;
import com.fea.project.model.task.vo.TaskCommentModelVo;
import com.fea.project.service.task.ITaskCommentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/task/taskComment")
public class TaskCommentController {

	@Resource
	private ITaskCommentService service;
	
	@GetMapping
	public List<TaskCommentModelVo> getAll(Long taskId){
		return service.getAll(taskId);
	}
	 
	@GetMapping("/getOne")
	public TaskCommentModel getOne(Long taskCommentId,Long taskId){
		return service.getOne(taskCommentId,taskId);
	}
	
	@PostMapping("/insert")
	public void save(@RequestBody TaskCommentModel taskCommentModel) {
		service.save(taskCommentModel);
	}
	
	@PostMapping("/delete")
	public void delete(@RequestBody TaskCommentModel taskCommentModel) {
		service.delete(taskCommentModel);
	}
	
	@PostMapping("/update")
	public void update(@RequestBody TaskCommentModel taskCommentModel) {
		service.update(taskCommentModel);
	}
}
