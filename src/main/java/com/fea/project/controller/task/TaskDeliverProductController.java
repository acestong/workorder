package com.fea.project.controller.task;

import com.fea.project.model.BasePageInfo;
import com.fea.project.model.task.TaskDeliverProductModel;
import com.fea.project.model.task.vo.TaskDeliverProductModelVo;
import com.fea.project.model.task.vo.UpdateBusinessIdInProjectAppendixModelVo;
import com.fea.project.service.task.ITaskDeliverProductService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/task/taskDeliverProduct")
public class TaskDeliverProductController {

	@Resource
	private ITaskDeliverProductService service;
	
	@PostMapping
	public Map<String,Object> getAll(@RequestBody BasePageInfo<TaskDeliverProductModel> page) {
		return service.getAll(page);
	} 
	
	@GetMapping("/getOne")
	public TaskDeliverProductModelVo getOne(Long deliverProductId,Long taskId) {
		return service.getOne(deliverProductId, taskId);
	}
	
	@PostMapping("/insert")
	public void save(@RequestBody UpdateBusinessIdInProjectAppendixModelVo<TaskDeliverProductModel> record) {
		System.out.println(record);
		service.save(record.getModel(),record.getAppendixIds());
	}
	
	@PostMapping("/delete")
	public void delete(@RequestBody TaskDeliverProductModel taskDeliverProductModel) {
		service.delete(taskDeliverProductModel);
	}
	
	@PostMapping("/update")
	public void update(@RequestBody TaskDeliverProductModel taskDeliverProductModel) {
		service.update(taskDeliverProductModel);
	}
	
	
}
