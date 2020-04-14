package com.fea.project.workorder.service;

import java.util.List;

import com.fea.project.workorder.model.WorkorderRecordModel;

public interface IWorkorderRecordService {

	Integer insert(WorkorderRecordModel model);
	
	 List<WorkorderRecordModel> selectByWorkorderId(Long workorderId);
}
