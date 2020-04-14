package com.fea.project.workorder.service;

import java.util.List;

import com.fea.project.workorder.model.PoolModel;
import com.fea.project.workorder.model.vo.IdAndNameModelVo;
import com.fea.project.workorder.model.vo.PoolModelVo;

public interface IPoolService {

	Integer insert(PoolModelVo poolModelVo);
	
	List<PoolModel> selectListByOrgId();
	
	List<IdAndNameModelVo> selectIdAndNameListByOrgId();
}
