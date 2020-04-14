package com.fea.project.workorder.service;

import java.util.List;

import com.fea.project.workorder.model.PoolAutoDispatchModel;
import com.fea.project.workorder.model.vo.PoolAutoDispatchModelVo;

public interface IPoolAutoDispatchService {

	Integer insertByList(Long workorderPoolId,List<PoolAutoDispatchModelVo> list);
}
