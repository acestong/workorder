package com.fea.project.service.task;

import java.util.List;

import com.fea.project.model.task.CommentSettingModel;

public interface ICommentSettingService {

	Integer save(CommentSettingModel model);
	Integer delete(Long id);
	Integer update(CommentSettingModel model);
	CommentSettingModel selectOneByResourceBusinessId(Long resourceBusinessId,Long resourceBusinessType);
	List<CommentSettingModel> selectByModel(CommentSettingModel commentSettingModel);
}
