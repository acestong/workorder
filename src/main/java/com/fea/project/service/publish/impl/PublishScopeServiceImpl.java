package com.fea.project.service.publish.impl;

import com.fea.project.dao.publish.PublishScopeModelMapper;
import com.fea.project.model.publish.PublishScopeModel;
import com.fea.project.model.publish.vo.ProjectUserViewVo;
import com.fea.project.service.publish.IPublishScopeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class PublishScopeServiceImpl implements IPublishScopeService {

	@Resource
	private PublishScopeModelMapper mapper;
	
	
	/**
	 * 新增一条范围
	 */
	@Override
	public void save(PublishScopeModel publishScopeModel) {
		// TODO Auto-generated method stub
		mapper.insertSelective(publishScopeModel);
	}
	

	@Override
	public void delete(Long publishId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<PublishScopeModel> getAll(Long publishId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<ProjectUserViewVo> selectScopeUserListByprojectId(Long projectId) {
		// TODO Auto-generated method stub
		return mapper.selectScopeUserListByprojectId(projectId);
	}


}
