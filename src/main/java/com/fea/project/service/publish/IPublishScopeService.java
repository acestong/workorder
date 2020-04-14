package com.fea.project.service.publish;

import com.fea.project.model.publish.PublishScopeModel;
import com.fea.project.model.publish.vo.ProjectUserViewVo;

import java.util.List;

public interface IPublishScopeService {

	void save(PublishScopeModel publishScopeModel);
	void delete(Long publishId);
	List<PublishScopeModel> getAll(Long publishId);
	List<ProjectUserViewVo> selectScopeUserListByprojectId(Long projectId);
}
