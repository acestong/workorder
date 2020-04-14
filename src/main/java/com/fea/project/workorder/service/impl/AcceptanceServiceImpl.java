package com.fea.project.workorder.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.workorder.dao.AcceptanceModelMapper;
import com.fea.project.workorder.enums.ConclusionEnum;
import com.fea.project.workorder.enums.DeleteStatusEnum;
import com.fea.project.workorder.model.AcceptanceModel;
import com.fea.project.workorder.model.vo.AcceptanceModelVo;
import com.fea.project.workorder.service.IAcceptanceService;

/**
 * 工单验收Service
 * @author st
 * @since 2020/03/23
 *
 */
@Service(version = "1.0.0",timeout = 6000)
@Component
public class AcceptanceServiceImpl implements IAcceptanceService {

	@Resource
	private AcceptanceModelMapper mapper;
	@Resource
	private SysUserService sysUserService;
	
	@Override
	@Transactional
	public Integer insert(AcceptanceModel model) {
		// TODO Auto-generated method stub
		if(model == null) {
			return null;
		}
		SysUserModel currentUsr = sysUserService.getCurrentUsr();
		model.setCreateBy(currentUsr.getRealName());
		model.setCreateId(currentUsr.getUserId());
		model.setCreateTime(new Date());
		model.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus().longValue());
		return mapper.insertSelective(model);
	}

	/**
	 * 验收详情
	 */
	@Override
	@Transactional(readOnly = true)
	public AcceptanceModelVo selectByPrimaryKey(Long acceptanceId) {
		// TODO Auto-generated method stub
		if(acceptanceId == null ) {
			return null;
		}
		AcceptanceModelVo modelVo = mapper.selectByPrimaryKey(acceptanceId);
		modelVo.setConclusionStr(ConclusionEnum.getValue(modelVo.getConclusion().intValue()));
		return acceptanceId == null ? null : mapper.selectByPrimaryKey(acceptanceId);
	}

	/**
	 * 通过工单Id获取验收集合
	 */
	@Override
	@Transactional(readOnly = true)
	public List<AcceptanceModelVo> selectListByWorkorderId(Long workorderId) {
		// TODO Auto-generated method stub
		return workorderId == null ? null : mapper.selectListByWorkorderId(workorderId);
	}

}
