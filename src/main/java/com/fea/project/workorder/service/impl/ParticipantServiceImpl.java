package com.fea.project.workorder.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.fea.project.workorder.dao.ParticipantModelMapper;
import com.fea.project.workorder.enums.OptionBusinessEnum;
import com.fea.project.workorder.model.ParticipantModel;
import com.fea.project.workorder.service.IParticipantService;

/**
 * 工序参与人Service
 * @author st
 * @since 2020/03/20
 *
 */
@Service(version = "1.0.0",timeout = 6000)
@Component
public class ParticipantServiceImpl implements IParticipantService {

	@Resource
	private ParticipantModelMapper mapper;
	
	/**
	 * 按列表批量新增
	 */
	@Override
	@Transactional
	public Integer insertByList(List<ParticipantModel> list, Long businessId) {
		// TODO Auto-generated method stub
		if(businessId == null || list.size() == 0) {
			return null;
		}
		return mapper.insertByList(list, OptionBusinessEnum.PROCEDURE.getStatus().longValue(), businessId);
	}

}
