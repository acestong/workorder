package com.fea.project.controller.publish;

import com.fea.project.model.publish.PublishLikeModel;
import com.fea.project.service.publish.IPublishLikeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/publish/publishLike")
public class PublishLikeController {

	@Resource
	private IPublishLikeService service;
	
	@PostMapping("/insert")
	public void save(@RequestBody PublishLikeModel model) {
		service.save(model);
	}
	
	@PostMapping("/delete")
	public void delete(@RequestBody PublishLikeModel model) {
		service.delete(model);
	}
	
//	@PostMapping("/updateIsReadByCurUserId")
//	public void updateIsReadByCurUserId() {
//		service.updateIsReadByCurUserId();
//	}
	
}
