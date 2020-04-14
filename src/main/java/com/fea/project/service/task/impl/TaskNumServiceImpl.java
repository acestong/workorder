package com.fea.project.service.task.impl;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.task.TaskNumModelMapper;
import com.fea.project.enums.task.IsDateEnum;
import com.fea.project.enums.task.IsHeadLetterEnum;
import com.fea.project.enums.task.TaskSortEnum;
import com.fea.project.model.task.TaskNumModel;
import com.fea.project.service.task.ITaskNumService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TaskNumServiceImpl implements ITaskNumService {

	@Resource
	private TaskNumModelMapper mapper;
	
	@Resource
	private  SysUserService sysUserService;
	
	//增加任务编号模型，此设置为默认设置，当前用户只能修改自己的任务编号模型
	@Override
	public void save() {
		// TODO Auto-generated method stub
		SysUserModel currentUsr = sysUserService.getCurrentUsr();
		List<TaskNumModel> listTemp = new ArrayList<TaskNumModel>();
		TaskNumModel taskNumModel = new TaskNumModel(null, currentUsr.getUserId(),
				IsHeadLetterEnum.IS_HEAD_LETTER.getStatus().longValue(), // 换行
				"RWGL", IsDateEnum.IS_DATE.getStatus().longValue(), new Date(), 4L, 1L,
				TaskSortEnum.TASK.getStatus().longValue());
		listTemp.add(taskNumModel);
		TaskNumModel sonTaskNumModel = new TaskNumModel(null, currentUsr.getUserId(),
				IsHeadLetterEnum.IS_HEAD_LETTER.getStatus().longValue(), // 换行
				"ZRW", IsDateEnum.IS_DATE.getStatus().longValue(), new Date(), 4L, 1L,
				TaskSortEnum.SON_TASK.getStatus().longValue());
		listTemp.add(sonTaskNumModel);
		mapper.insertTaskNumAndSonTaskNum(listTemp);
	}

	//通过当前用户Id和任务和子任务类型获取当前用户的任务编号列表，如果当前用户没有设置编号则进行设置默认值并存库
	//isSonTask为null时，返回任务和子任务的编号，为0时返回任务编号，为1时返回子任务编号
	@Override
	public List<TaskNumModel> selectByConUserId(Long isSonTask) {
		// TODO Auto-generated method stub
		SysUserModel currentUsr = sysUserService.getCurrentUsr();
		TaskNumModel taskNumModel = new TaskNumModel();
		taskNumModel.setCurUserId(currentUsr.getUserId());
		List<TaskNumModel> list = new ArrayList<>();
			taskNumModel.setIsSonTask(isSonTask);
			list = mapper.selectByConUserId(taskNumModel);
		if (list.size() == 0 ) {
			save();
			list = mapper.selectByConUserId(taskNumModel);
		}
		return list;
	}

	//通过当前用户Id和任务和子任务类型进行修改today和seriesDigit的值
	@Override
	public void updateByCurUserIdAndIsSonTask(TaskNumModel taskNumModel) {
		// TODO Auto-generated method stub
		SysUserModel currentUsr = sysUserService.getCurrentUsr();
		if(taskNumModel.getIsSonTask() == null ) {
			throw new SystemParamCheckException("传入参数为空，无法判断任务或子任务");
		}
		taskNumModel.setCurUserId(currentUsr.getUserId());
		mapper.updateByCurUserIdAndIsSonTask(taskNumModel);
	}

}
