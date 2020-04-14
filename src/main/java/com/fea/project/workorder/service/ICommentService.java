package com.fea.project.workorder.service;

import java.util.List;

import com.fea.project.workorder.model.CommentModel;

public interface ICommentService {

	Integer insert(CommentModel commentModel);
	
	 List<CommentModel> selectListByWorkorderId(Long workorderId);
}
