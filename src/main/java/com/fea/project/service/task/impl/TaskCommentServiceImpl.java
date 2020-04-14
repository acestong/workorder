package com.fea.project.service.task.impl;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.task.TaskCommentModelMapper;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.model.task.TaskCommentModel;
import com.fea.project.model.task.TaskWorkReportModel;
import com.fea.project.model.task.vo.TaskCommentModelVo;
import com.fea.project.service.task.ITaskCommentService;
import com.fea.project.service.task.ITaskDeliverProductService;
import com.fea.project.service.task.ITaskWorkReportService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TaskCommentServiceImpl implements ITaskCommentService {

	@Resource
	private TaskCommentModelMapper mapper;
	
	@Resource
	private SysUserService sysUserService;
	
	@Resource
	private ITaskWorkReportService taskWorkReportService;
	
	@Resource
	private ITaskDeliverProductService taskDeliverProductService;
	
	@Override 
	public void save(TaskCommentModel taskCommentModel) {
		// TODO Auto-generated method stub
		if ( taskCommentModel == null) {
            throw new SystemParamCheckException("评论信息传入为空，无法进行新增");
        }
		taskCommentModel.setCreateBy(sysUserService.getCurrentUsr().getRealName());
		taskCommentModel.setCreateId(sysUserService.getCurrentUsr().getUserId());
		taskCommentModel.setCreateTime(new Date());
		taskCommentModel.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus().longValue());
		mapper.insert(taskCommentModel);
	}

	@Override
	public void delete(TaskCommentModel taskCommentModel) {
		// TODO Auto-generated method stub
		if ( taskCommentModel.getTaskId() == null || taskCommentModel.getTaskCommentId()==null|| taskCommentModel == null) {
            throw new SystemParamCheckException("传入参数异常，无法进行删除");
        }
		taskCommentModel = mapper.selectByPrimaryKeyWithDelStatus(taskCommentModel);
		if ( taskCommentModel == null) {
            throw new SystemParamCheckException("该条数据不存在，无法进行删除");
        }
		taskCommentModel.setUpdateBy(sysUserService.getCurrentUsr().getRealName());
		taskCommentModel.setUpdateId(sysUserService.getCurrentUsr().getUserId());
		taskCommentModel.setUpdateTime(new Date());
		mapper.updateByPrimaryKeySelectiveWithDelStatus(taskCommentModel);
	}

	@Override
	public void update(TaskCommentModel taskCommentModel) {
		// TODO Auto-generated method stub
		if ( taskCommentModel == null || taskCommentModel.getTaskId() == null) {
            throw new SystemParamCheckException("评论模型传入为空，无法进行修改");
        }
		SysUserModel currentUsr = sysUserService.getCurrentUsr();
		taskCommentModel.setTaskCommentId(mapper.selectOneByTaskId(taskCommentModel.getTaskId()).getTaskCommentId());
		taskCommentModel.setUpdateBy(currentUsr.getRealName());
		taskCommentModel.setUpdateId(currentUsr.getUserId());
		taskCommentModel.setUpdateTime(new Date());
		taskCommentModel.setTaskCommentTime(new Date());
		mapper.updateByPrimaryKeySelective(taskCommentModel);
	}

	@Override
	public List<TaskCommentModelVo> getAll(Long taskId) {
		// TODO Auto-generated method stub
		List<TaskCommentModelVo> selectAllWithDelStatus = mapper.selectAllWithDelStatus(taskId);
		List<TaskCommentModelVo> listTemp = new ArrayList<>();
		for (TaskCommentModelVo taskCommentModelVo : selectAllWithDelStatus) {
			TaskWorkReportModel latestOneByTaskId = taskWorkReportService.getLatestOneByTaskId(taskId);
			taskCommentModelVo.setActualTaskDuration(latestOneByTaskId.getActualTaskDuration());
			taskCommentModelVo.setActualTaskEndTime(latestOneByTaskId.getActualTaskEndTime());
			taskCommentModelVo.setActualTaskStartTime(latestOneByTaskId.getActualTaskStartTime());
			taskCommentModelVo.setDeliverProductList(taskDeliverProductService.getAll(taskId));
			listTemp.add(taskCommentModelVo);
		}
		return listTemp;
	}

	@Override 
	public TaskCommentModel getOne(Long taskCommentId,Long taskId) {
		// TODO Auto-generated method stub
		TaskCommentModel taskCommentModel2 = new TaskCommentModel();
		taskCommentModel2.setTaskId(taskId);
		taskCommentModel2.setTaskCommentId(taskCommentId);
		if ( taskCommentId == null || taskId == null) {
            throw new SystemParamCheckException("传入参数异常，无法进行查询");
        }
		TaskCommentModel taskCommentModel = mapper.selectByPrimaryKeyWithDelStatus(taskCommentModel2);
		if ( taskCommentModel == null) {
            throw new SystemParamCheckException("该条数据不存在");
        }
		return taskCommentModel;
	}

}
