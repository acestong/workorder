package com.fea.project.workorder.service;

import com.fea.project.workorder.model.CommentWeightModel;

public interface ICommentWeightService {

	Integer update(CommentWeightModel model);
	
	CommentWeightModel selectByOrgId();
	
}
