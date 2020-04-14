package com.fea.project.controller.plan;

import com.fea.project.model.plan.QualityRequirementModel;
import com.fea.project.model.plan.vo.PageInfoFromFrontModel;
import com.fea.project.model.plan.vo.UpdateBusinessIdInProjectAppendixModelVo;
import com.fea.project.service.plan.IQualityRequirementService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/plan/qualityRequirement")
public class QualityRequirementController {

	@Resource
	private IQualityRequirementService service;
	 
	@RequestMapping("/insert")
	public Map<String,Object> save(@RequestBody UpdateBusinessIdInProjectAppendixModelVo<QualityRequirementModel> modelVo){
		return service.save(modelVo.getModel(), modelVo.getAppendixIds());
	} 
	
	@RequestMapping("/delete")
	public Map<String,Object> delete(@RequestBody QualityRequirementModel qualityRequirementModel){
		System.out.println("QualityRequirementController.delete()"+qualityRequirementModel);
		return service.delete(qualityRequirementModel.getPlanQualityRequirementId());
	}
	
	@RequestMapping("/update")
	public Map<String,Object> update(@RequestBody QualityRequirementModel qualityRequirementModel){
		return service.update(qualityRequirementModel);
	}
	
	@PostMapping
	public List<Object> getAll(@RequestBody PageInfoFromFrontModel page){
		return service.getAll(page);
	}
	
	@GetMapping("/getOne")
	public Map<String,Object> getOne(Long planQualityRequirementId){
		System.out.println("QualityRequirementController.getOne()");
		return service.getOne(planQualityRequirementId);
	}
}
