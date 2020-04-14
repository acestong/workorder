package com.fea.project.workorder.service;

import java.util.List;

import com.fea.project.workorder.model.AcceptanceModel;
import com.fea.project.workorder.model.vo.AcceptanceModelVo;

public interface IAcceptanceService {

	Integer insert(AcceptanceModel model);
	
	AcceptanceModelVo selectByPrimaryKey(Long acceptanceId);
	
	List<AcceptanceModelVo> selectListByWorkorderId(Long workorderId);
}
