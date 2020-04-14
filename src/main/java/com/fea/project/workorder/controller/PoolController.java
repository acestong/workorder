package com.fea.project.workorder.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fea.project.model.BasePageInfo;
import com.fea.project.workorder.model.vo.IdAndNameModelVo;
import com.fea.project.workorder.model.vo.PoolModelVo;
import com.fea.project.workorder.model.vo.WorkorderModelVo;
import com.fea.project.workorder.service.IPoolService;
import com.fea.project.workorder.service.IWorkorderService;

@RestController
@RequestMapping("/pool")
public class PoolController {

	@Resource
	private IPoolService service;
	@Resource
	private IWorkorderService workorderService;
	
	@PostMapping("/insert")
	public void insert(@RequestBody PoolModelVo poolModelVo) {
		service.insert(poolModelVo);
	}
	
	@PostMapping("/selectIdAndNameListByOrgId")
	public List<IdAndNameModelVo> selectIdAndNameListByOrgId(){
		return service.selectIdAndNameListByOrgId();
	}
	
	@PostMapping("/selectListByPoolId")
	public BasePageInfo<WorkorderModelVo> selectListByPoolId(@RequestBody BasePageInfo<WorkorderModelVo> page){
		return workorderService.selectListByPoolId(page);
	}
}
