package com.fea.project.controller.plan;

import com.fea.project.model.plan.DeliverRequirementModel;
import com.fea.project.model.plan.vo.PageInfoFromFrontModel;
import com.fea.project.model.plan.vo.UpdateBusinessIdInProjectAppendixModelVo;
import com.fea.project.service.plan.IDeliverRequirementService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import java.util.List;
import java.util.Map;

/**
 * 交付要求控制器
 * @author st
 * @since 2019/11/1 9:51
 *
 */ 
@RestController
@RequestMapping("/plan/driverRequirement")
public class DeliverRequirementController {

	 
	@Resource
	private IDeliverRequirementService service;
	
	/*
	 * 向数据库新增一个交付要求模型
	 */
	@RequestMapping("/insert")
	public Map<String,Object> save(@RequestBody UpdateBusinessIdInProjectAppendixModelVo<DeliverRequirementModel> modelVo){
		return service.save(modelVo.getModel(),modelVo.getAppendixIds());
	}
	
	/*
	 * 删除数据库一个交付要求模型
	 */
	@RequestMapping("/delete")
	public Map<String,Object> delete(@RequestBody DeliverRequirementModel deliverRequirementModel){
		return service.delete(deliverRequirementModel.getPlanDeliverRequirementId());
	}
	
	/*
	 * 修改数据库一个交付要求模型
	 */
	
	@RequestMapping("/update")
	public Map<String,Object> update(@RequestBody DeliverRequirementModel deliverRequirementModel){
		return service.update(deliverRequirementModel);
	}
	/*
	 * 获取数据库所有交付要求模型
	 */
	
	@PostMapping
	public List<DeliverRequirementModel> getAll(@RequestBody PageInfoFromFrontModel pageInfoFromFrontModel){
		return service.getAll(pageInfoFromFrontModel);
	}
	
	
	/*
	 * 获取数据库一个交付要求模型
	 */
	@RequestMapping("/getOne")
	public Map<String, Object> getOne(@RequestBody DeliverRequirementModel deliverRequirementModel){
		return service.getOne(deliverRequirementModel.getPlanDeliverRequirementId());
	}
}
