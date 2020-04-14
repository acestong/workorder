package com.fea.project.service.publish.impl;

import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.publish.PublishCollectModelMapper;
import com.fea.project.model.publish.PublishCollectModel;
import com.fea.project.service.publish.IPublishCollectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

@Service
@Transactional
public class PublishCollectServiceImpl implements IPublishCollectService {

	
	@Resource
	private PublishCollectModelMapper mapper;
	
	
	@Override
	public void save(PublishCollectModel publishCollectModel) {
		// TODO Auto-generated method stub
		if(publishCollectModel.getPublishId()==null||publishCollectModel.getUserId()==null||publishCollectModel.getUserName()==null) {
			throw new SystemParamCheckException("传入参数异常，无法新增收藏");
		}
		publishCollectModel.setCreateTime(new Date());
		mapper.insertSelective(publishCollectModel);
	}

	@Override
	public void delete(PublishCollectModel publishCollectModel) {
		// TODO Auto-generated method stub
		if(publishCollectModel.getPublishCollectId() == null) {
			throw new SystemParamCheckException("传入参数异常，无法删除收藏");
		}
		mapper.deleteByPrimaryKey(publishCollectModel.getPublishCollectId());
	}

	@Override
	public PublishCollectModel getOne(PublishCollectModel publishCollectModel) {
		// TODO Auto-generated method stub
		if(publishCollectModel.getPublishId() == null || publishCollectModel.getUserId() == null) {
			throw new SystemParamCheckException("传入参数异常，无法查询收藏");
		}
		PublishCollectModel selectByPublishIdAndUserId = mapper.selectByPublishIdAndUserId(publishCollectModel);
		return selectByPublishIdAndUserId;
	}

}
