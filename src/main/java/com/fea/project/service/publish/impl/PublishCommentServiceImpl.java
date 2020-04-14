package com.fea.project.service.publish.impl;

import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.publish.PublishCommentModelMapper;
import com.fea.project.enums.publish.CommentTypeEnum;
import com.fea.project.enums.publish.IsReadEnum;
import com.fea.project.model.publish.PublishCommentModel;
import com.fea.project.model.publish.vo.PublishCommentViewVo;
import com.fea.project.service.publish.IPublishCommentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class PublishCommentServiceImpl implements IPublishCommentService {

	@Resource
	private PublishCommentModelMapper mapper;
	
	@Resource
    private SysUserService sysUserService;
	
	@Override
	public void save(PublishCommentModel publishCommentModel) {
		// TODO Auto-generated method stub
		if(publishCommentModel.getUserId()==null || publishCommentModel.getBusinessId()==null) {
			throw new SystemParamCheckException("评论人或动态id传入为空，无法新增");
		}
		publishCommentModel.setCommentTime(new Date());
		publishCommentModel.setIsRead(IsReadEnum.IS_NOT_READ.getStatus().longValue());
		publishCommentModel.setCommentType(CommentTypeEnum.COMMENT.getStatus().longValue());
		mapper.insertSelective(publishCommentModel);
	}

	@Override
	public void delete(PublishCommentModel publishCommentModel) {
		// TODO Auto-generated method stub
		if(publishCommentModel.getPublishCommentId() == null) {
			throw new SystemParamCheckException("publishCommentId传入异常，无法进行删除");
		}
		mapper.deleteByPrimaryKey(publishCommentModel.getPublishCommentId());
	}

	@Override
	public List<PublishCommentViewVo> getAll(Long businessId) {
		// TODO Auto-generated method stub
		if(businessId == null) {
			throw new SystemParamCheckException("publishCommentId传入异常，无法进行删除");
		}
		return mapper.selectAllByPublishId(businessId);
	}

	@Override
	public Integer getTotalCount() {
		// TODO Auto-generated method stub
		return mapper.selectCountByCurUserId(sysUserService.getCurrentUsr().getUserId());
	}
	@Override
	public Integer getTotalCountMe() {
		// TODO Auto-generated method stub
		return mapper.selectCountMeByCurUserId(sysUserService.getCurrentUsr().getUserId());
	}

	@Override
	public void updateIsReadByCurUserId() {
		// TODO Auto-generated method stub
		mapper.updateIsReadByCurUserId(sysUserService.getCurrentUsr().getUserId());
	}

}
