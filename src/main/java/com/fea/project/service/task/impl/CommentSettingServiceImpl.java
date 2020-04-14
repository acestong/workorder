package com.fea.project.service.task.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.task.CommentSettingModelMapper;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.model.task.CommentSettingModel;
import com.fea.project.service.task.ICommentSettingService;

@Service
@Transactional
public class CommentSettingServiceImpl implements ICommentSettingService {

	@Resource
	private CommentSettingModelMapper mapper;
	@Resource
	private SysUserService sysUserService;
	
	@Override
	public Integer save(CommentSettingModel model) {
		// TODO Auto-generated method stub
		//如果该来源业务id下没有数据才新建一条
		if(mapper.selectByModel(new CommentSettingModel(model.getResourceBusinessId(),model.getResourceBusinessType())) != null) {
			return null;
		}else {
			return mapper.insert(model);
		}
	}

	@Override
	public Integer delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer update(CommentSettingModel model) {
		// TODO Auto-generated method stub
		if(model.getId() ==null) {
			throw new SystemParamCheckException("id传入为空，无法进行修改");
		}
		return mapper.updateByPrimaryKeySelective(model);
	}

	@Override
	public CommentSettingModel selectOneByResourceBusinessId(Long resourceBusinessId,Long resourceBusinessType) {
		// TODO Auto-generated method stub
		if(resourceBusinessId== null || resourceBusinessType == null) {
			throw new SystemParamCheckException("参数传入异常，无法查询");
		}
		SysUserModel currentUsr = sysUserService.getCurrentUsr();
		//如果该来源业务id下没有数据就新建一条
		if(mapper.selectByModel(new CommentSettingModel(resourceBusinessId,resourceBusinessType)).size()==0) {
			mapper.insert(new CommentSettingModel(null, resourceBusinessId, resourceBusinessType, null, 0.5, 0.5, currentUsr.getUserId(), 
					currentUsr.getRealName(), new Date(), null, null, null, DeleteStatusEnum.NOT_DELETE.getStatus().longValue()));
		}
		return mapper.selectByModel(new CommentSettingModel(resourceBusinessId,resourceBusinessType)).get(0);
	}

	@Override
	public List<CommentSettingModel> selectByModel(CommentSettingModel commentSettingModel) {
		// TODO Auto-generated method stub
		return mapper.selectByModel(commentSettingModel);
	}

}
