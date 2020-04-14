package com.fea.project.service.publish;

import com.fea.project.model.publish.PublishCommentReplyModel;
import com.fea.project.model.publish.vo.PublishCommentReplyViewVo;

import java.util.List;

public interface IPublishCommentReplyService {
	void save(PublishCommentReplyModel publishCommentReplyModel);
	void delete(PublishCommentReplyModel publishCommentReplyModel);
	List<PublishCommentReplyViewVo> getAll(Long publishCommentId);
}
