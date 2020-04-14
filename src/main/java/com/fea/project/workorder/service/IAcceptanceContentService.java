package com.fea.project.workorder.service;

import java.util.List;

import com.fea.project.workorder.model.AcceptanceContentModel;
import com.fea.project.workorder.model.vo.AcceptanceContentModelVo;

public interface IAcceptanceContentService {

	Integer insert(AcceptanceContentModel model);
	
	List<AcceptanceContentModelVo> selectListByAcceptanceId(Long acceptanceId);
	
	
}
