package com.fea.project.controller.task;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fea.project.model.task.CommentSettingModel;
import com.fea.project.service.task.ICommentSettingService;

@RestController
@RequestMapping("/CommentSetting")
public class CommentSettingController {

	@Resource
	private ICommentSettingService service;
	
	@PostMapping("/update")
	public void update(@RequestBody CommentSettingModel model) {
		service.update(model);
	}
}
