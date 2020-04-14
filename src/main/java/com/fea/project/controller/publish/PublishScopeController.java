package com.fea.project.controller.publish;

import com.fea.project.service.publish.IPublishScopeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/publish/Scope")
public class PublishScopeController {

	@Resource
	private IPublishScopeService service;
	
//	@PostMapping("/saveByList")
//	public void saveByList(@RequestBody PublishScopeModelVo modelVo) {
//		System.out.println(modelVo);
//		service.insertByDepartmentList(modelVo);
//	}
}
