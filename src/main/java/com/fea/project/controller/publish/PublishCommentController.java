package com.fea.project.controller.publish;

import com.fea.project.model.publish.PublishCommentModel;
import com.fea.project.service.publish.IPublishCommentService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/publish/publishComment")
public class PublishCommentController {

	@Resource
	private IPublishCommentService service;
	
	@RequestMapping("/insert")
	public void save(@RequestBody PublishCommentModel publishCommentModel) {
		service.save(publishCommentModel);
	}
	@RequestMapping("/delete")
	public void delete(@RequestBody PublishCommentModel publishCommentModel) {
		service.delete(publishCommentModel);
	}
}
