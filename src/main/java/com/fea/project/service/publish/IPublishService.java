package com.fea.project.service.publish;

import com.fea.project.model.BasePageInfo;
import com.fea.project.model.publish.vo.*;

import java.util.List;

public interface IPublishService {

	void save(PublishModelVo publishModelVo);
	void delete(PublishModelVo publishModelVo);
	BasePageInfo<PublishViewVo> getAll(BasePageInfo<PublishGetViewVo> page);
	List<PublishNavigateViewVo> getAllCount(Long businessId,Long businessType);
	EmpInfoVo getUserInfo();
	List<ProjectUserViewVo> selectScopeUserListByprojectId(Long projectId);
}
