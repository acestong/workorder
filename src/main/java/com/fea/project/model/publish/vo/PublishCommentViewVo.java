package com.fea.project.model.publish.vo;

import com.fea.project.model.publish.PublishCommentModel;
import lombok.Data;

import java.util.List;

@Data
public class PublishCommentViewVo extends PublishCommentModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//评论人头像
	private String userImagePath;
	//评论的回复集合
	private List<PublishCommentReplyViewVo> replyList;
}
