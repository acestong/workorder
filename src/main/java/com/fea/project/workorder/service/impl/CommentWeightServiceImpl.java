package com.fea.project.workorder.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.workorder.dao.CommentWeightModelMapper;
import com.fea.project.workorder.model.CommentWeightModel;
import com.fea.project.workorder.service.ICommentWeightService;

/**
 * 评价权重Service
 * @author st
 * @since 2020/03/23
 */
@Service(version = "1.0.0",timeout = 6000)
@Component
public class CommentWeightServiceImpl implements ICommentWeightService {

	@Resource
	private CommentWeightModelMapper mapper;
	@Resource
	private SysUserService sysUserService;
	
	/**
	 * 修改权重
	 */
	@Override
	@Transactional
	public Integer update(CommentWeightModel model) {
		// TODO Auto-generated method stub
		if(model.getQualityWeight()+model.getSatisfyWeight()+model.getTimeWeight() > 1) {
			throw new SystemParamCheckException("质量，时间，满意度权重之和不为100%");
		}
		if(model.getCreateIdWeight()+model.getSuperiorIdWeight() > 1) {
			throw new SystemParamCheckException("创建人和上级权重之和不为100%");
		}
		if(model.getCommentWeightId() == null) {
			throw new SystemParamCheckException("参数设置主键id传入为空");
		}
		SysUserModel currentUsr = sysUserService.getCurrentUsr();
		model.setUpdateBy(currentUsr.getRealName());
		model.setUpdateId(currentUsr.getUserId());
		model.setUpdateTime(new Date());
		return mapper.updateByPrimaryKeySelective(model);
	}

	/**
	 * 通过orgId获取权重
	 */
	@Override
	@Transactional
	public CommentWeightModel selectByOrgId() {
		// TODO Auto-generated method stub
		return mapper.selectByOrgId(sysUserService.getCurrentUsr().getOrgId());
	}
	
	

}
