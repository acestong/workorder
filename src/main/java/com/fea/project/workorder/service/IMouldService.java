package com.fea.project.workorder.service;

import java.util.List;

import com.fea.project.workorder.model.vo.MouldModelVo;

public interface IMouldService {

	Integer insert(MouldModelVo modelVo);
	
	MouldModelVo selectByPrimaryKey(Long mouldId);
	
	List<MouldModelVo> selectByOrgId();
}
