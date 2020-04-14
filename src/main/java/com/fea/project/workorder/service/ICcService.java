package com.fea.project.workorder.service;

import java.util.List;

import com.fea.project.workorder.model.CcModel;
import com.fea.project.workorder.model.vo.PersonInfoModelVo;

public interface ICcService {

	void insertList(List<CcModel> list);
	
	List<PersonInfoModelVo> selectCCPerson(Long workorderId);
	
	Integer deleteByBusinessId(Long workorderId);
}
