package com.fea.project.controller.plan;

import com.fea.project.model.plan.PlanAppendixModel;
import com.fea.project.model.plan.vo.AppendixModelVo;
import com.fea.project.model.plan.vo.BusinessAppendixModelVo;
import com.fea.project.model.plan.vo.PageInfoFromFrontModel;
import com.fea.project.model.plan.vo.UpdateBusinessIdInProjectAppendixModelVo;
import com.fea.project.service.plan.IPlanAppendixService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import java.util.List;
import java.util.Map;

/**
 * 计划附件控制器
 * @author st
 * @since 2019/11/1 10:58
 *
 */ 
@RestController
@RequestMapping("/plan/planAppendix")
public class PlanAppendixController {

	@Resource
	private IPlanAppendixService service;
	
	
	
	/*
	 * 新增
	 */
	@RequestMapping("/insert")
	public Map<String,Object> save(@RequestBody UpdateBusinessIdInProjectAppendixModelVo<PlanAppendixModel> modelVo) throws Exception{
		return service.save(modelVo.getModel(), modelVo.getAppendixIds());
		
	}
	
	/*
	 * 删除
	 */
	@RequestMapping("/delete")
	public void delete(@RequestBody PlanAppendixModel planAppendixModel){
		service.delete(planAppendixModel.getBusinessAppendixId());
	}

//	/*
//	 * 修改
//	 */
//	@RequestMapping("/update")
//	public void update(@RequestBody PlanAppendixModel planAppendixModel){
//		service.update(planAppendixModel);
//	}
	
	/*
	 * 修改
	 */
	@RequestMapping("/update")
	public void update(@RequestBody BusinessAppendixModelVo businessAppendixModelVo){
		service.update_v2(businessAppendixModelVo);
	}
	
	/*
	 * 查询所有
	 */
	@PostMapping
	public List<AppendixModelVo> getAll(@RequestBody PageInfoFromFrontModel page){
		return service.getAll(page);
	}
	
	/*
	 * 查询一个
	 */
	@GetMapping("/getOne")
	public Map<String,Object> getOne(Long planAppendixId){
		return service.getOne(planAppendixId);
	}
	
	
	/*
	 * 查询一个业务附件的详情，带附件
	 */
	@GetMapping("/selectByBusinessAppendixId")
	public BusinessAppendixModelVo selectByBusinessAppendixId(Long businessAppendixId){
		return service.selectByBusinessAppendixId(businessAppendixId);
	}
	
	


}
