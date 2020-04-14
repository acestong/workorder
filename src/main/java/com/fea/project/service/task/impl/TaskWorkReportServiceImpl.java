package com.fea.project.service.task.impl;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.task.TaskWorkReportModelMapper;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.plan.PlanAppendixModel;
import com.fea.project.model.task.TaskModel;
import com.fea.project.model.task.TaskWorkReportModel;
import com.fea.project.model.task.vo.ReportModelVo;
import com.fea.project.model.task.vo.TaskAndSonTaskModelVo;
import com.fea.project.model.task.vo.TaskWorkReportModelVo;
import com.fea.project.service.appendix.ProjectAppendixService;
import com.fea.project.service.plan.IPlanAppendixService;
import com.fea.project.service.task.ITaskService;
import com.fea.project.service.task.ITaskWorkReportService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class TaskWorkReportServiceImpl implements ITaskWorkReportService {

	@Resource
	private TaskWorkReportModelMapper mapper;
	
	@Resource
	private SysUserService sysUserService;
	
	@Resource
	private ITaskService taskService;
	@Resource
	private ProjectAppendixService projectAppendixService;
	@Resource
	private IPlanAppendixService planAppendixService;
	
	/*
	 * 子任务的工作汇报
	 */
	@Override 
	public void save(TaskWorkReportModelVo taskWorkReportModelVo) {
		// TODO Auto-generated method stub
		if ( taskWorkReportModelVo == null) {
            throw new SystemParamCheckException("任务模型传入为空，无法进行新增");
        }
		taskWorkReportModelVo.setCreateBy(sysUserService.getCurrentUsr().getRealName());
		taskWorkReportModelVo.setCreateId(sysUserService.getCurrentUsr().getUserId());
		taskWorkReportModelVo.setCreateTime(new Date());
		taskWorkReportModelVo.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus().longValue());
		mapper.insert(taskWorkReportModelVo);
		/*
		 * 修改计划表中的进度
		 */
		TaskAndSonTaskModelVo taskAndSonTaskModelVo = new TaskAndSonTaskModelVo();
			taskAndSonTaskModelVo.setTaskId(taskWorkReportModelVo.getTaskId());
				TaskModel taskModel = new TaskModel();
				taskModel.setTaskId(taskWorkReportModelVo.getTaskId());
				taskModel.setTaskProgrossRate(taskWorkReportModelVo.getTaskProgrossRate());
			taskAndSonTaskModelVo.setModel(taskModel);
		taskService.update(taskAndSonTaskModelVo);
		/*
		 * 关联附件以及工作汇报
		 */
		if(taskWorkReportModelVo.getAppendixIds() != null) {
			planAppendixService.updateByList(taskWorkReportModelVo.getWorkReportId(),taskWorkReportModelVo.getAppendixIds() ,
					taskWorkReportModelVo.getWorkReportTitle(), null, null);
		}
	}
	
	
	@Override
	public void insert(TaskWorkReportModelVo taskWorkReportModelVo) {
		// TODO Auto-generated method stub
		if ( taskWorkReportModelVo == null) {
            throw new SystemParamCheckException("任务模型传入为空，无法进行新增");
        }
		taskWorkReportModelVo.setCreateBy(sysUserService.getCurrentUsr().getRealName());
		taskWorkReportModelVo.setCreateId(sysUserService.getCurrentUsr().getUserId());
		taskWorkReportModelVo.setCreateTime(new Date());
		taskWorkReportModelVo.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus().longValue());
		mapper.insert(taskWorkReportModelVo);
		/*
		 * 修改计划表中的进度
		 */
		TaskAndSonTaskModelVo taskAndSonTaskModelVo = new TaskAndSonTaskModelVo();
			taskAndSonTaskModelVo.setTaskId(taskWorkReportModelVo.getTaskId());
				TaskModel taskModel = new TaskModel();
				taskModel.setTaskId(taskWorkReportModelVo.getTaskId());
				taskModel.setTaskProgrossRate(taskWorkReportModelVo.getTaskProgrossRate());
			taskAndSonTaskModelVo.setModel(taskModel);
		taskService.update(taskAndSonTaskModelVo);
		if(taskWorkReportModelVo.getAppendixIds() != null) {
			planAppendixService.updateByList(taskWorkReportModelVo.getWorkReportId(),taskWorkReportModelVo.getAppendixIds() ,
					taskWorkReportModelVo.getWorkReportTitle(), null, null);
		}
	}

	@Override
	public void delete(TaskWorkReportModel taskWorkReportModel) {
		// TODO Auto-generated method stub
		if ( taskWorkReportModel == null) {
            throw new SystemParamCheckException("任务模型传入为空，无法进行新增");
        }
		mapper.deleteByPrimaryKey(taskWorkReportModel.getWorkReportId());
	}

	@Override
	public void update(ReportModelVo reportModel) {
		// TODO Auto-generated method stub
		SysUserModel currentUsr = sysUserService.getCurrentUsr();
		reportModel.setUpdateBy(currentUsr.getRealName());
		reportModel.setUpdateId(currentUsr.getUserId());
		reportModel.setUpdateTime(new Date());
		if(reportModel.getTaskProgrossRate() != null) {
			//级联更新任务中的进度
			TaskModel taskModel = new TaskModel();
			taskModel.setTaskProgrossRate(reportModel.getTaskProgrossRate());
			taskModel.setTaskId(reportModel.getTaskId());
			taskService.update(taskModel);
		}
		mapper.updateByPrimaryKeySelective(reportModel);
	}

	@Override
	public Map<String,Object> getAll(BasePageInfo<TaskWorkReportModelVo> page) {
		// TODO Auto-generated method stub
		if ( page.getModel().getTaskId() == null ) {
            throw new SystemParamCheckException("传入参数任务id为空，无法进行查询");
        }
		PageHelper.startPage(page.getPageNum(), page.getPageSize(), true);
		List<TaskWorkReportModelVo> selectAllWithDelStatus = mapper.selectAllWithDelStatus(page.getModel().getTaskId());
		if ( selectAllWithDelStatus == null ) {
            throw new SystemParamCheckException("数据不存在");
        }
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("workReportList", new BasePageInfo<>(selectAllWithDelStatus));
		return map;
	}

	@Override
	public ReportModelVo getOne(TaskWorkReportModel taskWorkReportModel) {
		// TODO Auto-generated method stub
		if ( taskWorkReportModel.getWorkReportId() == null ) {
            throw new SystemParamCheckException("传入参数异常，无法进行查询");
        }
		ReportModelVo modelVo = mapper.selectByPrimaryKeyWithDelStatus(taskWorkReportModel);
		List<PlanAppendixModel> all = planAppendixService.getAll(taskWorkReportModel.getWorkReportId());
		modelVo.setAppendixList(all);
		return modelVo;
	}

	/*
	 * 通过taskId获取最新的一个汇报
	 */
	@Override
	public TaskWorkReportModel getLatestOneByTaskId(Long taskId) {
		// TODO Auto-generated method stub
		if ( taskId == null ) {
            throw new SystemParamCheckException("传入参数异常，无法进行查询");
        }
		TaskWorkReportModel selectLatestOneByTaskId = mapper.selectLatestOneByTaskId(taskId);
		return selectLatestOneByTaskId;
	}
	
	

	

}
