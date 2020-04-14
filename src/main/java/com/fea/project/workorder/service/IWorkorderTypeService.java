package com.fea.project.workorder.service;

import java.util.List;

import com.fea.project.workorder.model.WorkorderTypeModel;
import com.fea.project.workorder.model.vo.TypeModelVo;

public interface IWorkorderTypeService {

	Integer insert(WorkorderTypeModel model);
	
	List<TypeModelVo> selectRootTypeListByorgId();
}
