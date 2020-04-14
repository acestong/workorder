package com.fea.project.service.publish;

import com.fea.project.model.publish.PublishCommentModel;
import com.fea.project.model.publish.vo.PublishCommentViewVo;

import java.util.List;

public interface IPublishCommentService {
	void save(PublishCommentModel publishCommentModel);
	void delete(PublishCommentModel publishCommentModel);
	List<PublishCommentViewVo> getAll(Long businessId);
	Integer getTotalCount();
	Integer getTotalCountMe();
	void updateIsReadByCurUserId();
}
