package com.fea.project.workorder.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.workorder.dao.AttentionModelMapper;
import com.fea.project.workorder.model.AttentionModel;
import com.fea.project.workorder.service.IWorkorderAttentionService;

@Service(version = "1.0.0",timeout = 6000)
@Component
public class WorkorderAttentionServiceImpl implements IWorkorderAttentionService {

	@Resource
	private AttentionModelMapper mapper;
	@Resource
	private SysUserService sysUserService;
	
	/**
	 * 新增关注
	 */
	@Override
	@Transactional
	public Integer insert(AttentionModel model) {
		// TODO Auto-generated method stub
		if(model.getAttentionStatus() == null && model.getWorkorderId() == null) {
			throw new SystemParamCheckException("参数传入异常");
		}
		SysUserModel currentUsr = sysUserService.getCurrentUsr();
		model.setCreateBy(currentUsr.getRealName());
		model.setCreateId(currentUsr.getUserId());
		model.setCreateTime(new Date());
		return  mapper.insertSelective(model);
	}
	/**
	 * 修改关注
	 */
	@Override
	@Transactional
	public Integer update(AttentionModel model) {
		// TODO Auto-generated method stub
		if(model.getAttentionStatus() == null && model.getWorkorderId() == null) {
			throw new SystemParamCheckException("参数传入异常");
		}
		return  mapper.updateByWorkorderId(model);
	}

	@Override
	@Transactional
	public Boolean selectByWorkorderId(Long workorderId) {
		// TODO Auto-generated method stub
		if(workorderId == null) {
			throw new SystemParamCheckException("参数传入异常");
		}
		return  mapper.selectByWorkorderId(workorderId) == null ;
	}

}
