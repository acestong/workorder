package com.fea.project.service.publish.impl;

import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.publish.PublishFileModelMapper;
import com.fea.project.model.publish.PublishFileModel;
import com.fea.project.model.publish.vo.PublishFileViewVo;
import com.fea.project.service.publish.IPublishFileService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class PublishFileServiceImp implements IPublishFileService{

	@Resource
	private PublishFileModelMapper mapper;

	@Override
	public void save(PublishFileModel publishFileModel) {
		// TODO Auto-generated method stub
		mapper.insertSelective(publishFileModel);
	}

	@Override
	public void delete(PublishFileModel publishFileModel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PublishFileViewVo> getAll(Long publishId) {
		// TODO Auto-generated method stub
		if(publishId == null) {
			throw new SystemParamCheckException("publishId传入异常，无法进行查询");
		}
		return mapper.selectFileListByPublishId(publishId);
	}
}
