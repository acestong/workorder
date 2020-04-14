package com.fea.project.service.task.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fea.project.dao.task.DeliverableSettingModelMapper;
import com.fea.project.model.task.DeliverableSettingModel;
import com.fea.project.service.task.IDeliverableSettingService;

@Service
@Transactional
public class DeliverableSettingServiceImpl implements IDeliverableSettingService {

	@Resource
	private DeliverableSettingModelMapper mapper;
	@Override
	public List<DeliverableSettingModel> selectByModel(DeliverableSettingModel model) {
		// TODO Auto-generated method stub
		return mapper.selectByModel(model);
	}

}
