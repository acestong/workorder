package com.fea.project.workorder.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.plan.vo.AppendixIdAndNameInfoModelVo;
import com.fea.project.service.appendix.ProjectAppendixService;
import com.fea.project.workorder.dao.ProcedureModelMapper;
import com.fea.project.workorder.enums.DeleteStatusEnum;
import com.fea.project.workorder.model.WorkorderModel;
import com.fea.project.workorder.model.vo.ProcedureModelVo;
import com.fea.project.workorder.model.vo.ProcedureReportModelVo;
import com.fea.project.workorder.service.IParticipantService;
import com.fea.project.workorder.service.IProcedureService;
import com.github.pagehelper.PageHelper;

/**
 * 工序Service
 * @author st
 *
 */
@Service(version = "1.0.0",timeout = 6000)
@Component
public class ProcedureServiceImpl implements IProcedureService {

	@Resource
	private ProcedureModelMapper mapper;
	@Resource
	private SysUserService sysUserService;
	@Resource
	private ProjectAppendixService projectAppendixService;
	@Resource
	private IParticipantService participantService;

	/**
	 * 按列表添加
	 */
	@Override
	@Transactional
	public Integer insertByList(Long mouldId, List<ProcedureModelVo> list) {
		// TODO Auto-generated method stub
		if(mouldId == null || list.size() == 0) {
			return null;
		}
		SysUserModel currentUsr = sysUserService.getCurrentUsr();
		return mapper.insertByList(mouldId, list, currentUsr.getUserId(), currentUsr.getRealName());
	}

	/**
	 * 插入
	 * @return 工序id
	 */
	@Override
	@Transactional
	public Long insert(ProcedureModelVo modelVo) {
		// TODO Auto-generated method stub
		/*
		 * 新增之前，将modelVo.getProcedureOrderNum()之后的所有排序加1
		 */
		mapper.updateProcedureOrderNum(modelVo);
		SysUserModel currentUsr = sysUserService.getCurrentUsr();
		modelVo.setCreateBy(currentUsr.getRealName());
		modelVo.setCreateId(currentUsr.getUserId());
		modelVo.setCreateTime(new Date());
		modelVo.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus().longValue());
		mapper.insertSelective(modelVo);
		if(modelVo.getAppendixList() != null) {
				projectAppendixService.updateByBusinessIdAndIds(modelVo.getProcedureId(), modelVo.getAppendixList());
		}
		if(modelVo.getParticipantList() != null) {
			participantService.insertByList(modelVo.getParticipantList(), modelVo.getProcedureId());
		}
		return modelVo.getProcedureId();
	}

	/**
	 * 通过工序id列表，批量修改模板Id
	 */
	@Override
	@Transactional
	public Integer updateMouldIdByProcedureIdList(List<Long> list, Long mouldId) {
		// TODO Auto-generated method stub
		if(list.size() == 0 || mouldId == null) {
			return null;
		}
		return mapper.updateMouldIdByProcedureIdList(list, mouldId);
	}

	/**
	 * 获取一条工序详情
	 */
	@Override
	@Transactional
	public ProcedureModelVo selectByPrimaryKey(Long procedureId) {
		// TODO Auto-generated method stub
		ProcedureModelVo modelVo = mapper.selectByPrimaryKey(procedureId);
		List<AppendixIdAndNameInfoModelVo> list = projectAppendixService.selectIdAndNameByBusiness(procedureId);
		modelVo.setAppendixInfoList(projectAppendixService.selectIdAndNameByBusiness(procedureId));
		return procedureId == null ? null : modelVo;
	}

	/**
	 * 通过工单Id和工序列表批量插入工序
	 */
	@Override
	@Transactional
	public Integer insertByListAndWorkorderId(Long workorderId, List<ProcedureModelVo> list) {
		// TODO Auto-generated method stub
		return workorderId == null || list.size() == 0 ? null : mapper.insertByListAndWorkorderId(workorderId, list);
	}

	/**
	 * 通过工单Id删除
	 */
	@Override
	@Transactional
	public Integer deleteByWorkorderId(Long workorderId) {
		// TODO Auto-generated method stub
		return workorderId == null ? null : mapper.deleteByWorkorderId(workorderId);
	}

	/**
     * 获取我负责的工序列表
     * @return
     */
	@Override
	@Transactional
	public BasePageInfo<ProcedureModelVo> selectListByLeaderId(BasePageInfo<ProcedureModelVo> page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page.getPageNum(), page.getPageSize(), true);
		List<ProcedureModelVo> list = mapper.selectListByLeaderId();
		return new BasePageInfo<ProcedureModelVo>(list);
	}
	
	/**
	 * 获取我参与的工序列表
	 * @return
	 */
	@Override
	@Transactional
	public BasePageInfo<ProcedureModelVo> selectListByParticipantUserId(BasePageInfo<ProcedureModelVo> page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page.getPageNum(), page.getPageSize(), true);
		List<ProcedureModelVo> list = mapper.selectListByParticipantUserId();
		return new BasePageInfo<ProcedureModelVo>(list);
	}

	/**
	 * 获取当前工单下的所有工序列表
	 */
	@Override
	@Transactional
	public List<ProcedureModelVo> selectListByWorkorderId(Long workorderId) {
		// TODO Auto-generated method stub
		return workorderId == null ? null : mapper.selectListByWorkorderId(workorderId);
	}
	
}
