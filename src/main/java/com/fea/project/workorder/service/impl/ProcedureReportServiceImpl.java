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
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.plan.vo.AppendixIdAndNameInfoModelVo;
import com.fea.project.service.appendix.ProjectAppendixService;
import com.fea.project.workorder.configure.annotation.OptionAnno;
import com.fea.project.workorder.dao.ProcedureReportModelMapper;
import com.fea.project.workorder.enums.DeleteStatusEnum;
import com.fea.project.workorder.model.vo.ProcedureReportModelVo;
import com.fea.project.workorder.service.IProcedureReportService;
import com.github.pagehelper.PageHelper;

/**
 * 工序汇报Service
 * @author st
 * @since 2020/03/23
 *
 */
@Service(version = "1.0.0",timeout = 6000)
@Component
public class ProcedureReportServiceImpl implements IProcedureReportService {

	@Resource
	private ProcedureReportModelMapper mapper;
	@Resource
	private SysUserService sysUserService;
	@Resource
	private ProjectAppendixService projectAppendixService;
	
	/**
	 * 新增 
	 */
	@Override
	@OptionAnno(type=3)
	@Transactional
	public Integer insert(ProcedureReportModelVo modelVo) {
		// TODO Auto-generated method stub
		if(modelVo == null) {
			return null;
		}
		if(modelVo.getProcedureId() == null) {
			throw new SystemParamCheckException("工序id请求为空，请确认工序id！");
		}
		if(modelVo.getProgrossRate() <=0 || modelVo.getProgrossRate() >= 1) {
			throw new SystemParamCheckException("进度输入范围在0%-100%之间");
		}
		SysUserModel currentUsr = sysUserService.getCurrentUsr();
		modelVo.setCreateBy(currentUsr.getRealName());
		modelVo.setCreateId(currentUsr.getUserId());
		modelVo.setCreateTime(new Date());
		modelVo.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus().longValue());
		int insertSelective = mapper.insertSelective(modelVo);
		if(modelVo.getAppendixList().size() > 0) {
			modelVo.getAppendixList().stream().forEach(System.out::println);
			projectAppendixService.updateByBusinessIdAndIds(modelVo.getProcedureId(), modelVo.getAppendixList());
		}
		return insertSelective;
	}

	/**
	 * 按主键返回详情
	 */
	@Override
	@Transactional
	public ProcedureReportModelVo selectById(Long id) {
		// TODO Auto-generated method stub
		 ProcedureReportModelVo modelVo = mapper.selectByPrimaryKey(id);
		 modelVo.setAppendixInfoList(projectAppendixService.selectIdAndNameByBusiness(modelVo.getProcedureId()));
		return id == null ? null : modelVo;
	}

	/**
	 * 通过工单id获取到此工单下所有已经汇报的平均进度
	 */
	@Override
	@Transactional
	public Double selectAvgRateByWorkorderId(Long workorderId) {
		// TODO Auto-generated method stub
		return workorderId == null ? null : mapper.selectAvgRateByWorkorderId(workorderId);
	}

	/**
	 * 按照工序id返回工序汇报列表
	 */
	@Override
	@Transactional
	public BasePageInfo<ProcedureReportModelVo> selectByProcedureId(BasePageInfo<ProcedureReportModelVo> page) {
		// TODO Auto-generated method stub
		if(page.getModel().getProcedureId() == null) {
			return null;
		}
		PageHelper.startPage(page.getPageNum(), page.getPageSize(), true);
		List<ProcedureReportModelVo> list = mapper.selectByProcedureId(page.getModel().getProcedureId());
		list.stream().forEach(model->{
			model.setAppendixInfoList(projectAppendixService.selectIdAndNameByBusiness(model.getProcedureId()));
		});
		return new BasePageInfo<>(list);
	}

}
