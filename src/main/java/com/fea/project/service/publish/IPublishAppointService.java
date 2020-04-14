package com.fea.project.service.publish;

import com.fea.project.model.publish.PublishAppointModel;

import java.util.List;

public interface IPublishAppointService {

	void save(PublishAppointModel publishAppointModel);
	void delete(PublishAppointModel publishAppointModel);
	List<PublishAppointModel> getAll(Long publishId);
	Integer getTotalCount();
	void updateIsReadByCurUserId();
}
