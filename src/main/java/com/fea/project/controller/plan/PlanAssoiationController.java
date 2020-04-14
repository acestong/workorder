package com.fea.project.controller.plan;

import com.fea.project.model.plan.PlanAssociationModel;
import com.fea.project.model.plan.vo.BusinessAssociationShowModelVo;
import com.fea.project.model.plan.vo.PageInfoFromFrontModel;
import com.fea.project.service.plan.IPlanAssociationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import java.util.List;
import java.util.Map;

/**
 * 关联计划控制层
 * @author st
 * @since 2019/11/1 11:51
 *
 */ 
@RestController
@RequestMapping("/plan/planAssociation")
public class PlanAssoiationController {
 
	@Resource
	private IPlanAssociationService service;
	
	/*
	 * 新增
	 */
	@RequestMapping("/insert")
	public Map<String,Object> save(@RequestBody PlanAssociationModel planAssociationModel){
		return service.save(planAssociationModel);
	}
	
	/*
	 * 删除
	 */
	@RequestMapping("/delete")
	public Map<String,Object> delete(@RequestBody PlanAssociationModel planAssociationModel){
		return service.delete(planAssociationModel.getPlanAssociationId());
	}
	
	/*
	 * 修改
	 */
	@RequestMapping("/update")
	public Map<String,Object> update(@RequestBody PlanAssociationModel planAssociationModel){
		return service.update(planAssociationModel);
	}
	
	/*
	 * 获取所有
	 */
	@PostMapping
	public List<BusinessAssociationShowModelVo> getAll(@RequestBody PageInfoFromFrontModel page){
		return service.getAll(page);
	}
	
	/*
	 * 获取一个
	 */
	@RequestMapping("/getOne")
	public Map<String,Object> getOne(Long planAssociationId){
		return service.getOne(planAssociationId);
	}
	
	/*
	 * 获取一个
	 */
	@RequestMapping("/getAssociationInfoByPlanId") 
	public Map<String,Object> getAssociationInfoByPlanId(Long planId){
		return service.getAssociationInfoByPlanId(planId);
	}
	
	
}
