package com.fea.project.workorder.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.fea.project.api.other.dao.base.SysUserMapper;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.workorder.dao.WorkorderResponseModelMapper;
import com.fea.project.workorder.model.WorkorderModel;
import com.fea.project.workorder.model.WorkorderResponseModel;
import com.fea.project.workorder.service.IWorkorderResponseService;
import com.fea.project.workorder.service.IWorkorderService;

@Service(version = "1.0.0",timeout = 6000)
@Component
public class WorkorderResponseServiceImpl implements IWorkorderResponseService {

	
	@Resource
	private WorkorderResponseModelMapper mapper;
	@Resource
	private SysUserService sysUserService;
	/**
	 * 新增一条响应信息
	 */
	@Override
	@Transactional
	public Integer insert(WorkorderResponseModel model) {
		// TODO Auto-generated method stub
		if(model.getIsConfirm() == null) {
			throw new SystemParamCheckException("请确认是否响应");
		}
		SysUserModel currentUsr = sysUserService.getCurrentUsr();
		model.setCreateId(currentUsr.getUserId());
		model.setCreateBy(currentUsr.getRealName());
		model.setCreateTime(new Date());
		int insertSelective = mapper.insertSelective(model);
		return insertSelective;
	}

}
