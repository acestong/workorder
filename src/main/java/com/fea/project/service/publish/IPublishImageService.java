package com.fea.project.service.publish;

import com.fea.project.model.publish.PublishImageModel;

import java.util.List;

public interface IPublishImageService {

	void save(PublishImageModel publishImageModel);
	List<PublishImageModel> getAll(Long publishId);
}
