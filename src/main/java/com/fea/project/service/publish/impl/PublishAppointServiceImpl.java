package com.fea.project.service.publish.impl;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.dao.publish.PublishAppointModelMapper;
import com.fea.project.enums.publish.IsReadEnum;
import com.fea.project.model.publish.PublishAppointModel;
import com.fea.project.service.publish.IPublishAppointService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class PublishAppointServiceImpl implements IPublishAppointService{

	@Resource
	private PublishAppointModelMapper mapper;

	@Resource
    private SysUserService sysUserService;
	
	/**
	 * 新增一条@提醒
	 */
	@Override
	public void save(PublishAppointModel publishAppointModel) {
		// TODO Auto-generated method stub
		SysUserModel currentUsr = sysUserService.getCurrentUsr();
		publishAppointModel.setCreateId(currentUsr.getUserId());
		publishAppointModel.setCreateBy(currentUsr.getRealName());
		publishAppointModel.setCreateTime(new Date());
		publishAppointModel.setIsRead(IsReadEnum.IS_NOT_READ.getStatus().longValue());
		mapper.insertSelective(publishAppointModel);
	}

	@Override
	public void delete(PublishAppointModel publishAppointModel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PublishAppointModel> getAll(Long publishId) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * 获取当前用户未读且被提醒的动态数量
	 */
	@Override
	public Integer getTotalCount() {
		// TODO Auto-generated method stub
		return mapper.selectCountByCurUserId(sysUserService.getCurrentUsr().getUserId());
	}

	@Override
	public void updateIsReadByCurUserId() {
		// TODO Auto-generated method stub
		mapper.updateIsReadByCurUserId(sysUserService.getCurrentUsr().getUserId());
	}
	
}
