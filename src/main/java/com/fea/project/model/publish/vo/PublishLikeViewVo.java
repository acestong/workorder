package com.fea.project.model.publish.vo;

import com.fea.project.model.publish.PublishLikeModel;
import lombok.Data;

@Data
public class PublishLikeViewVo extends PublishLikeModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String userImagePath;

	public PublishLikeViewVo(PublishLikeModel model) {
		super.setPublishLikeId(model.getPublishLikeId());
		super.setPublishId(model.getPublishId());
		super.setUserId(model.getUserId());
		super.setUserName(model.getUserName());
		super.setPublishLikeTime(model.getPublishLikeTime());
		super.setIsRead(model.getIsRead());
	}
	
	
}
