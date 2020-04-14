package com.fea.project.workorder.service;

import com.fea.project.workorder.model.AttentionModel;

public interface IWorkorderAttentionService {

	Integer insert(AttentionModel model);
	
	Integer update(AttentionModel model);
	
	Boolean selectByWorkorderId(Long workorderId);
}
