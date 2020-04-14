package com.fea.project.workorder.service;

import java.util.List;

import com.fea.project.workorder.model.vo.AcceptanceFileModelVo;

public interface IAcceptanceFileService {

	Integer insert(AcceptanceFileModelVo modelVo);
	
	List<AcceptanceFileModelVo> selectListByAcceptanceId(Long acceptanceId);
}
