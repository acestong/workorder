package com.fea.project.service.publish.impl;

import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.publish.PublishImageModelMapper;
import com.fea.project.model.publish.PublishImageModel;
import com.fea.project.service.publish.IPublishImageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class PublishImageService implements IPublishImageService {

	@Resource
	private PublishImageModelMapper mapper;
	@Override
	public void save(PublishImageModel publishImageModel) {
		// TODO Auto-generated method stub
		mapper.insertSelective(publishImageModel);
	}

	@Override
	public List<PublishImageModel> getAll(Long publishId) {
		// TODO Auto-generated method stub
		if(publishId == null) {
			throw new SystemParamCheckException("publishId传入异常，无法进行查询");
		}
		return mapper.selectListByPublishId(publishId);
	}

}
