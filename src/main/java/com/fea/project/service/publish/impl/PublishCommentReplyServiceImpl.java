package com.fea.project.service.publish.impl;

import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.publish.PublishCommentReplyModelMapper;
import com.fea.project.model.publish.PublishCommentReplyModel;
import com.fea.project.model.publish.vo.PublishCommentReplyViewVo;
import com.fea.project.service.publish.IPublishCommentReplyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class PublishCommentReplyServiceImpl implements IPublishCommentReplyService {

	@Resource
	private PublishCommentReplyModelMapper mapper;
	
	/**
	 * 新增回复
	 */
	@Override
	public void save(PublishCommentReplyModel publishCommentReplyModel) {
		// TODO Auto-generated method stub
		if(publishCommentReplyModel.getReplyUserId()==null || publishCommentReplyModel.getUserId() == null  //
				|| publishCommentReplyModel.getPublishCommentId() ==null) {
			throw new SystemParamCheckException("评论人或回复人id或评论id传入为空");
		}
		publishCommentReplyModel.setReplyTime(new Date());
		mapper.insertSelective(publishCommentReplyModel);
	}

	/**
	 * 删除回复
	 */
	@Override
	public void delete(PublishCommentReplyModel publishCommentReplyModel) {
		// TODO Auto-generated method stub
		if( publishCommentReplyModel.getPublishCommentReplyId() ==null) {
			throw new SystemParamCheckException("评论人或回复人id或评论id传入为空");
		}
		mapper.deleteByPrimaryKey(publishCommentReplyModel.getPublishCommentReplyId());
	}

	@Override
	public List<PublishCommentReplyViewVo> getAll(Long publishCommentId) {
		// TODO Auto-generated method stub
		if( publishCommentId ==null) {
			throw new SystemParamCheckException("评论人id传入为空");
		}
		return mapper.selectAllByPublishCommentReplyId(publishCommentId);
	}

}
