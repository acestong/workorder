package com.fea.project.model.publish.vo;


import com.fea.project.model.publish.PublishImageModel;
import com.fea.project.model.publish.PublishModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class PublishViewVo extends PublishModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//动态类型字符串
	private String originTypeStr;
	//用户头像
	private String userImagePath;
	//图片模型列表
	private List<PublishImageModel> imageList;
	//附件模型列表
	private List<PublishFileViewVo> fileList;
	//所有赞集合
	private List<PublishLikeViewVo> likeList;
	//获赞数
	private Integer likeCount;
	//获取所有的评论
	private List<PublishCommentViewVo> commentList;
	//评论数
	private Integer commentCount;
	//是否收藏
	private Integer isCollect;
	//存放转发的动态模型
	private PublishViewVo transmitedPublishModel;
	//存放显示类型
	private Integer type;
	
	public PublishViewVo(PublishModel model) {
		super.setPublishId(model.getPublishId());
		super.setUserId(model.getUserId());
		super.setUserName(model.getUserName());
		super.setCreateTime(model.getCreateTime());
		super.setOriginType(model.getOriginType());
		super.setPlace(model.getPlace());
		super.setContent(model.getContent());
		super.setIsCompanyPublish(model.getIsCompanyPublish());
		super.setRegId(model.getRegId());
		super.setBusinessId(model.getBusinessId());
		super.setBusinessType(model.getBusinessType());
		super.setProjectId(model.getProjectId());
	}
}
