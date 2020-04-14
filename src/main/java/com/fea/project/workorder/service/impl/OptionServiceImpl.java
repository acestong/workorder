package com.fea.project.workorder.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.fea.project.workorder.dao.OptionModelMapper;
import com.fea.project.workorder.model.OptionModel;
import com.fea.project.workorder.service.IOptionService;

/**
 * 操作记录Service
 * @author st
 * @since 2020/03/21
 *
 */
@Service(version = "1.0.0",timeout = 6000)
@Component
public class OptionServiceImpl implements IOptionService {

	@Resource
	private OptionModelMapper mapper;
	/**
	 * 新增
	 */
	@Override
	@Transactional
	public Integer insert(OptionModel model) {
		// TODO Auto-generated method stub
		return model == null ? null : mapper.insertSelective(model);
	}

	
}
