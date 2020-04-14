package com.fea.project.workorder.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.fea.project.workorder.dao.VisiblePersonModelMapper;
import com.fea.project.workorder.model.VisiblePersonModel;
import com.fea.project.workorder.service.IVisiblePersonService;

/**
 * 工单池可见人Service
 * @author st
 *
 */
@Service(version = "1.0.0",timeout = 6000)
@Component
public class VisiblePersonServiceImpl implements IVisiblePersonService {

	@Resource
	private VisiblePersonModelMapper mapper;
	
	@Override
	@Transactional
	public Integer insertByList(Long poolId, List<VisiblePersonModel> list) {
		// TODO Auto-generated method stub
		if(poolId == null || list.size() == 0) {
			return null;
		}
		return mapper.insertByList(poolId, list);
	}

}
