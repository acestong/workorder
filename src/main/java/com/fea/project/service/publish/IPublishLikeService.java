package com.fea.project.service.publish;

import com.fea.project.model.publish.PublishLikeModel;

import java.util.List;

public interface IPublishLikeService {

	void save(PublishLikeModel publishLikeModel);
	void delete(PublishLikeModel publishLikeModel);
	List<PublishLikeModel> getAll(Long pubishId);
	Integer getTotalCount();
	void updateIsReadByCurUserId();
}
