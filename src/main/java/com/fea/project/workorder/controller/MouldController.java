package com.fea.project.workorder.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fea.project.workorder.model.vo.MouldModelVo;
import com.fea.project.workorder.service.IMouldService;

@RestController
@RequestMapping("/mould")
public class MouldController {

	
	@Resource
	private IMouldService service;
	
	@PostMapping("/insert")
	public void insert(@RequestBody MouldModelVo modelVo) {
		service.insert(modelVo);
	}
	
	
	@PostMapping("/selectByPrimaryKey")
	public MouldModelVo selectByPrimaryKey(@RequestBody MouldModelVo modelVo) {
		return service.selectByPrimaryKey(modelVo.getMouldId());
	}
	
	@RequestMapping("/selectByOrgId")
	public List<MouldModelVo> selectByOrgId() {
		return service.selectByOrgId();
	}
}
