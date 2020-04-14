package com.fea.project.service.publish;


import com.fea.project.model.publish.PublishCollectModel;

public interface IPublishCollectService {
	void save(PublishCollectModel publishCollectModel);
	void delete(PublishCollectModel publishCollectModel);
	PublishCollectModel getOne(PublishCollectModel publishCollectModel);
}
