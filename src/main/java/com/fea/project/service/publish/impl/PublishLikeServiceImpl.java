package com.fea.project.service.publish.impl;

import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.publish.PublishLikeModelMapper;
import com.fea.project.enums.publish.IsReadEnum;
import com.fea.project.model.publish.PublishLikeModel;
import com.fea.project.service.publish.IPublishLikeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/*
 * 赞service层
 */
@Service
@Transactional
public class PublishLikeServiceImpl implements IPublishLikeService {

	@Resource
	private PublishLikeModelMapper mapper;
	
	@Resource
    private SysUserService sysUserService;
	
	
	@Override
	public void save(PublishLikeModel publishLikeModel) {
		// TODO Auto-generated method stub
		publishLikeModel.setPublishLikeTime(new Date());
		publishLikeModel.setIsRead(IsReadEnum.IS_NOT_READ.getStatus().longValue());
		mapper.insertSelective(publishLikeModel);
	}

	@Override
	public void delete(PublishLikeModel publishLikeModel) {
		// TODO Auto-generated method stub
		if(publishLikeModel.getPublishId() == null || publishLikeModel.getUserId() == null) {
			throw new SystemParamCheckException("publishId或userId传入为空，赞无法取消");
		}
		mapper.deleteByPublishIdAndUserId(publishLikeModel);
	}

	@Override
	public List<PublishLikeModel> getAll(Long publishId) {
		// TODO Auto-generated method stub
		if(publishId == null) {
			throw new SystemParamCheckException("publishId传入为空，无法获取点赞信息");
		}
		return mapper.selectLikeListByPublishId(publishId);
	}

	//查所有计数
	@Override
	public Integer getTotalCount() {
		// TODO Auto-generated method stub
		return mapper.selectCountByCurUserId(sysUserService.getCurrentUsr().getUserId());
	}

	//修改已读
	@Override
	public void updateIsReadByCurUserId() {
		// TODO Auto-generated method stub
		mapper.updateIsReadByCurUserId(sysUserService.getCurrentUsr().getUserId());
	}

}
