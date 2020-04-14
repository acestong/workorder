package com.fea.project.workorder.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.workorder.dao.CommentModelMapper;
import com.fea.project.workorder.enums.CreateIdOrSuperiorIdEnum;
import com.fea.project.workorder.model.CommentModel;
import com.fea.project.workorder.model.CommentWeightModel;
import com.fea.project.workorder.model.vo.WorkorderModelVo;
import com.fea.project.workorder.service.ICommentService;
import com.fea.project.workorder.service.ICommentWeightService;
import com.fea.project.workorder.service.IWorkorderService;

/**
 * 工单评价Service
 * @author st
 * @since 2020/03/31
 *
 */
@Service(version = "1.0.0" , timeout = 6000)
@Component
public class CommentServiceImpl implements ICommentService {

	@Resource
	private CommentModelMapper mapper;
	@Resource
	private SysUserService sysUserService;
	@Resource
	private IWorkorderService workorderService;
	@Resource
	private ICommentWeightService commentWeightService;
	/**
	 * 新增
	 */
	@Override
	@Transactional
	public Integer insert(CommentModel commentModel) {
		// TODO Auto-generated method stub
		if(commentModel == null) {
			return null;
		}
		if(commentModel.getWorkorderId() == null) {
			throw new SystemParamCheckException("未指明工单，无法评论");
		}
			WorkorderModelVo workorderModelVo = workorderService.selectOne(commentModel.getWorkorderId());
			SysUserModel currentUsr = sysUserService.getCurrentUsr();
			//根据当前用户orgId获取角色评论比重
			CommentWeightModel commentWeightModel = commentWeightService.selectByOrgId();
			Integer insertSelective = null;
			//创建人评论工单时
			if(workorderModelVo.getCreateId().longValue() == currentUsr.getUserId().longValue()) {
				commentModel.setCreateBy(currentUsr.getRealName());
				commentModel.setCreateId(currentUsr.getUserId());
				commentModel.setCreateTime(new Date());
				commentModel.setCreateRole(CreateIdOrSuperiorIdEnum.CTREATE_ID.getStatus().longValue());
				//设置创建人评论的评分比重
				commentModel.setQualityWeight(commentWeightModel.getQualityWeight());
				commentModel.setTimeWeight(commentWeightModel.getTimeWeight());
				commentModel.setSatisfyWeight(commentWeightModel.getSatisfyWeight());
				insertSelective = mapper.insert(commentModel);
			}
			//评论人是直属上级时
			SysUserModel superiorModel = sysUserService.selectUserByParentJobId(currentUsr.getUserId());
			if(superiorModel != null) {
				if(superiorModel.getUserId().longValue() == currentUsr.getUserId().longValue()) {
					commentModel.setCreateBy(currentUsr.getRealName());
					commentModel.setCreateId(currentUsr.getUserId());
					commentModel.setCreateTime(new Date());
					commentModel.setCreateRole(CreateIdOrSuperiorIdEnum.SUPORIOR_ID.getStatus().longValue());
					//设置直属评论的评分比重
					commentModel.setQualityWeight(commentWeightModel.getQualityWeight());
					commentModel.setTimeWeight(commentWeightModel.getTimeWeight());
					commentModel.setSatisfyWeight(commentWeightModel.getSatisfyWeight());
					insertSelective = mapper.insert(commentModel);
				}
			}
		return insertSelective;
	}
	
	/**
	 * 通过工单id获取评价列表
	 */
	@Override
	@Transactional
	public List<CommentModel> selectListByWorkorderId(Long workorderId) {
		// TODO Auto-generated method stub
		return workorderId == null ? null : mapper.selectListByWorkorderId(workorderId);
	}

}
