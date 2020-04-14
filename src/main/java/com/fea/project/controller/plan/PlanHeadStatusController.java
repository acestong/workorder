package com.fea.project.controller.plan;

import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.model.plan.PlanHeadStatusModel;
import com.fea.project.service.plan.IPlanHeadStatusService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/plan/planHeadStatus")
public class PlanHeadStatusController {

	@Resource
	private IPlanHeadStatusService service;
	@Resource
	private SysUserService sysUserService;
	
	@PostMapping("/insert")
	public void insert(PlanHeadStatusModel planHeadStatusModel) {
		service.save(planHeadStatusModel);
	} 
	
	
	@PostMapping("/delete")
	public void delete(PlanHeadStatusModel planHeadStatusModel) {
		service.delete(planHeadStatusModel.getCurUserId());
	}
	
	@PostMapping("/update")
	public void update(@RequestBody PlanHeadStatusModel planHeadStatusModel) {
		System.out.println(planHeadStatusModel);
		service.update(planHeadStatusModel);
	}
	
	@GetMapping("/getOne")
	public PlanHeadStatusModel getOne() {
		PlanHeadStatusModel one = service.getOne(sysUserService.getCurrentUsr().getUserId());
		return one;
	}
}
