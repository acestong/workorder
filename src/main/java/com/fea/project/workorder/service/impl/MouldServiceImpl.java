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
import com.fea.project.service.appendix.ProjectAppendixService;
import com.fea.project.workorder.dao.MouldModelMapper;
import com.fea.project.workorder.enums.DeleteStatusEnum;
import com.fea.project.workorder.model.MouldModel;
import com.fea.project.workorder.model.vo.MouldModelVo;
import com.fea.project.workorder.service.IMouldService;
import com.fea.project.workorder.service.IProcedureService;

/**
 * 工单模板service
 * @author st
 * @since 2020/03/20
 *
 */
@Service(version = "1.0.0",timeout = 6000)
@Component
public class MouldServiceImpl implements IMouldService {

	
	@Resource
	private MouldModelMapper mapper;
	@Resource
	private SysUserService sysUserService;
	@Resource
	private IProcedureService procedureService;
	@Resource
	private ProjectAppendixService projectAppendixService;
	
	/**
	 * 新增一条模板id
	 */
	@Override
	@Transactional
	public Integer insert(MouldModelVo model) {
		// TODO Auto-generated method stub
		if(model == null) {
			throw new SystemParamCheckException("参数传入为空，无法新建工单模板");
		}
		SysUserModel currentUsr = sysUserService.getCurrentUsr();
		model.setOrgId(currentUsr.getOrgId());
		model.setCreateBy(currentUsr.getRealName());
		model.setCreateId(currentUsr.getUserId());
		model.setCreateTime(new Date());
		model.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus().longValue());
		int insertSelective = mapper.insertSelective(model);
		if(model.getProcedureList() != null) {
			procedureService.updateMouldIdByProcedureIdList(model.getProcedureList(), model.getMouldId());
		}
		return insertSelective;
	}

	/**
	 * 通过主键Id获取一条模板详情
	 */
	@Override
	@Transactional
	public MouldModelVo selectByPrimaryKey(Long mouldId) {
		// TODO Auto-generated method stub
		if(mouldId == null) {
			return null;
		}
		MouldModelVo modelVo = mapper.selectByPrimaryKey(mouldId);
		if(modelVo.getProcedureInfoList().size() > 0) {
			modelVo.getProcedureInfoList().stream().forEach(procedureModel->{
				procedureModel.setAppendixInfoList(projectAppendixService.selectIdAndNameByBusiness(procedureModel.getProcedureId()));
			});
		}
		return modelVo;
	}

	/**
	 * 获取当前组织下，所有的模板列表
	 */
	@Override
	@Transactional
	public List<MouldModelVo> selectByOrgId() {
		// TODO Auto-generated method stub
		return mapper.selectByOrgId(sysUserService.getCurrentUsr().getOrgId());
	}

}
