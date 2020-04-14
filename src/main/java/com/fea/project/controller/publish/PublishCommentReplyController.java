package com.fea.project.controller.publish;

import com.fea.project.model.publish.PublishCommentReplyModel;
import com.fea.project.service.publish.IPublishCommentReplyService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/publish/publishCommentReply")
public class PublishCommentReplyController {

	@Resource
	private IPublishCommentReplyService service;
	
	@PostMapping("/insert")
	public void save(@RequestBody PublishCommentReplyModel publishCommentReplyModel) {
		service.save(publishCommentReplyModel);
	}
	
	@PostMapping("/delete")
	public void delete(@RequestBody PublishCommentReplyModel publishCommentReplyModel) {
		service.delete(publishCommentReplyModel);
	}
}
