package com.fea.project.controller.publish;

import com.fea.project.model.publish.PublishCollectModel;
import com.fea.project.service.publish.IPublishCollectService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/publish/publishCollect")
public class PublishCollectController {

	@Resource
	private IPublishCollectService service;
	
	@PostMapping("/insert")
	public void save(@RequestBody PublishCollectModel publishCollectModel) {
		service.save(publishCollectModel);
	}
	
	
	@PostMapping("/delete")
	public void delete(@RequestBody PublishCollectModel publishCollectModel) {
		service.delete(publishCollectModel);
	}
	@PostMapping
	public Object get(@RequestBody PublishCollectModel publishCollectModel) {
		return service.getOne(publishCollectModel);
	}
}
