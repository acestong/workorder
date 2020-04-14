package com.fea.project.service.publish;

import com.fea.project.model.publish.PublishFileModel;
import com.fea.project.model.publish.vo.PublishFileViewVo;

import java.util.List;

public interface IPublishFileService {

	void save(PublishFileModel publishFileModel);
	void delete(PublishFileModel publishFileModel);
	List<PublishFileViewVo> getAll(Long publishId);
}
