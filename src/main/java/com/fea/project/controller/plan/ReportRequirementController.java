package com.fea.project.controller.plan;

import com.fea.project.model.plan.ReportRequirementModel;
import com.fea.project.model.plan.vo.PageInfoFromFrontModel;
import com.fea.project.model.plan.vo.ReportRequirementModelVo;
import com.fea.project.model.plan.vo.UpdateBusinessIdInProjectAppendixModelVo;
import com.fea.project.service.plan.IReportRequirementService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/plan/reportRequirement")
public class ReportRequirementController {

	@Resource
	private IReportRequirementService service;
	 
	@RequestMapping("/insert")
	public Map<String,Object> save(@RequestBody UpdateBusinessIdInProjectAppendixModelVo<ReportRequirementModel> modelVo){
		return service.save(modelVo.getModel(), modelVo.getAppendixIds());
	}
	 
	@RequestMapping("/delete")
	public Map<String,Object> delete(@RequestBody ReportRequirementModel reportRequirementModel){
		return service.delete(reportRequirementModel.getPlanReportRequirementId());
	}
	
	@RequestMapping("/update")
	public Map<String,Object> update(@RequestBody ReportRequirementModel reportRequirementModel){
		return service.update(reportRequirementModel);
	}
	
	@PostMapping
	public List<ReportRequirementModelVo> getAll(@RequestBody PageInfoFromFrontModel page){
		return service.getAll(page);
	}
	
	@GetMapping("/getOne")
	public Map<String,Object> getOne(Long planReportRequirementId){
		System.out.println("ReportRequirementController.getOne()"+planReportRequirementId);
		return service.getOne(planReportRequirementId);
	}
}
