package com.fea.project.workorder.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.fea.project.workorder.dao.ContactModelMapper;
import com.fea.project.workorder.model.ContactModel;
import com.fea.project.workorder.service.IContactService;

/**
 * 联系人Service，此联系人仅针对来源是工单的，且此客户在当前数据库中不存在，此处暂存在工单中的联系人表中 
 * @author st
 * @since 2020/03/25
 *
 */
@Service(version = "1.0.0",timeout = 6000)
@Component
public class ContactServiceImpl implements IContactService{

	@Resource
	private ContactModelMapper mapper;

	/**
	 * 新增
	 */
	@Override
	@Transactional
	public Integer insert(ContactModel model) {
		// TODO Auto-generated method stub
		return mapper.insert(model);
	}

	/**
	 * 按照工单id获取联系人
	 */
	@Override
	@Transactional
	public ContactModel selectByWorkorderId(Long workorderId) {
		// TODO Auto-generated method stub
		return workorderId == null ? null : mapper.selectByWorkorderId(workorderId);
	}
	
	
}
