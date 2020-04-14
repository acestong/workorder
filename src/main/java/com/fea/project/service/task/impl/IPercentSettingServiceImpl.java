package com.fea.project.service.task.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.task.PercentSettingModelMapper;
import com.fea.project.model.task.vo.PercentSettingModelVo;
import com.fea.project.service.task.IPercentSettingService;

@Service
@Transactional
public class IPercentSettingServiceImpl implements IPercentSettingService {

	@Resource
	private PercentSettingModelMapper mapper;
	@Override
	public List<PercentSettingModelVo> selectByResourceBusinessId(Long resourceBusinessId) {
		// TODO Auto-generated method stub
		if(resourceBusinessId == null) {
			throw new SystemParamCheckException("resourceBusinessId传入为空，无法进行查询");
		}
		return mapper.selectByResourceBusinessId(resourceBusinessId);
	}

}
