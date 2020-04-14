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
import com.fea.project.workorder.dao.WorkorderReportModelMapper;
import com.fea.project.workorder.enums.DeleteStatusEnum;
import com.fea.project.workorder.model.WorkorderReportModel;
import com.fea.project.workorder.model.vo.WorkorderReportModelVo;
import com.fea.project.workorder.service.IWorkorderReportService;
import com.fea.project.workorder.service.IWorkorderService;

/**
 * 工单汇报Service
 * @author st
 * @since 2020/3/17
 *
 */
@Service(version = "1.0.0",timeout = 6000)
@Component
public class WorkorderReportServiceImpl implements IWorkorderReportService {

	@Resource
	private WorkorderReportModelMapper mapper;
	@Resource
	private SysUserService sysUserService;
	
	/**
	 * 新增一条工单汇报
	 */
	@Override
	@Transactional
	public Integer insert(WorkorderReportModel model) {
		// TODO Auto-generated method stub
		if( model == null ) {
			return null;
		}
		SysUserModel currentUsr = sysUserService.getCurrentUsr();
		model.setCreateBy(currentUsr.getRealName());
		model.setCreateId(currentUsr.getUserId());
		model.setCreateTime(new Date());
		model.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus().longValue());
		return mapper.insertSelective(model);
	}

	/**
	 * 通过工单id获取工单列表
	 */
	@Override
	@Transactional
	public List<WorkorderReportModelVo> selectListByWorkorderId(Long workorderId) {
		// TODO Auto-generated method stub
		return workorderId == null ? null : mapper.selectListByWorkorderId(workorderId);
	}

	/**
	 * 通过工单汇报id获取工单model
	 */
	@Override
	@Transactional
	public WorkorderReportModel selectById(Long reportId) {
		// TODO Auto-generated method stub
		return reportId == null ? null :mapper.selectByPrimaryKey(reportId);
	}

	/**
	 *修改工单汇报
	 */
	@Override
	@Transactional
	public Integer update(WorkorderReportModel model) {
		// TODO Auto-generated method stub
		if(model.getReportId() == null) {
			return null;
		}
		SysUserModel currentUsr = sysUserService.getCurrentUsr();
		model.setUpdateBy(currentUsr.getRealName());
		model.setUpdateId(currentUsr.getUserId());
		model.setUpdateTime(new Date());
		return mapper.updateByPrimaryKeySelective(model);
	}

	/**
	 * 删除一条工单汇报
	 */
	@Override
	@Transactional
	public Integer delete(Long reportId) {
		// TODO Auto-generated method stub
		if(reportId == null) {
			throw new SystemParamCheckException("参数传入为空，无法删除");
		}
		WorkorderReportModel model = new WorkorderReportModel();
		SysUserModel currentUsr = sysUserService.getCurrentUsr();
		model.setReportId(reportId);
		model.setDelStatus(DeleteStatusEnum.DELETE.getStatus().longValue());
		model.setUpdateBy(currentUsr.getRealName());
		model.setUpdateId(currentUsr.getUserId());
		model.setUpdateTime(new Date());
		return mapper.updateByPrimaryKeySelective(model);
	}
	
	

}
