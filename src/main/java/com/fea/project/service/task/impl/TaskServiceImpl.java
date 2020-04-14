package com.fea.project.service.task.impl;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.model.base.vo.EmpTreeModelVo;
import com.fea.project.api.other.model.base.vo.SysJobVo;
import com.fea.project.api.other.service.base.SysJobService;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.task.TaskModelMapper;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.enums.task.*;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.baseconfig.ProjectCodeTaskRegChildModel;
import com.fea.project.model.plan.*;
import com.fea.project.model.plan.vo.ProjectTreeModelVo;
import com.fea.project.model.project.ProjectStepModel;
import com.fea.project.model.project.vo.ProjectStepVo;
import com.fea.project.model.task.CommentSettingModel;
import com.fea.project.model.task.DeliverableSettingModel;
import com.fea.project.model.task.OpdcaTaskModel;
import com.fea.project.model.task.TaskModel;
import com.fea.project.model.task.TaskNumModel;
import com.fea.project.model.task.TaskParticipantModel;
import com.fea.project.model.task.vo.*;
import com.fea.project.service.base.ProjectDictionaryItemService;
import com.fea.project.service.baseconfig.ProjectCodeTaskRegChildService;
import com.fea.project.service.plan.*;
import com.fea.project.service.project.ProjectService;
import com.fea.project.service.project.ProjectStepService;
import com.fea.project.service.task.ICommentSettingService;
import com.fea.project.service.task.IDeliverableSettingService;
import com.fea.project.service.task.IOpdcaTaskService;
import com.fea.project.service.task.ITaskAttentionService;
import com.fea.project.service.task.ITaskNumService;
import com.fea.project.service.task.ITaskParticipantService;
import com.fea.project.service.task.ITaskService;
import com.fea.project.service.user.ProjectUserService;
import com.fea.project.util.CommentSettingUtil;
import com.fea.project.util.ListSortUtil;
import com.fea.project.util.TaskNumUtil;
import com.github.pagehelper.PageHelper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class TaskServiceImpl implements ITaskService {

	@Resource
	private TaskModelMapper mapper;
	@Resource
	private SysUserService sysUserService;
	@Resource
	private ProjectCodeTaskRegChildService projectCodeTaskRegChildService;
	@Resource
	private ProjectDictionaryItemService projectDictionaryItemService;
	@Resource
	private ProjectStepService projectStepService;
	@Resource
	private ITaskParticipantService taskParticipantService;
	/*
	 * 附件以及相关信息计划和任务模块通用，故调用计划模块相关service层
	 */
	@Resource
	private IPlanAssociationService planAssociationService;
	@Resource
	private IPlanAppendixService planAppendixService;
	@Resource
	private IDeliverRequirementService deliverRequirementService;
	@Resource
	private IQualityRequirementService qualityRequirementService;
	@Resource
	private IReportRequirementService reportRequirementService;
	@Resource
	private IPlanService planService;
	@Resource
	private IPlanParticipantService planParticipantService;
	@Resource
	private ITaskNumService taskNumService;
	@Resource
	private ProjectUserService projectUserService;
	@Resource
	private ICommentSettingService commentSettingService;
	@Resource
	private IPercentSettingServiceImpl percentSettingServiceImpl;
	@Resource
	private IDeliverableSettingService deliverableSettingService;
	// 调用OpdcaTaskService 将新数据同样的存入到老数据库一份
	@Resource
	private IOpdcaTaskService opdcaTaskService;
	@Resource
	private SysJobService sysJobService;
	@Resource
	private ITaskAttentionService taskAttentionService;
	@Resource
	private ProjectService projectService;
	// 存放当前的userId
	private static HashSet<Long> set = new HashSet<>();

	/**
	 * 新增任务
	 */
	@Override
	public Map<String, Object> save(TaskModel taskModel, TaskWithAllAppendixModelVo model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		mapper.insert(this.setDefaultInfo(taskModel));
		// 默认为未关注任务
		taskAttentionService.Insert(taskModel.getTaskId());
		map.put("taskId", taskModel.getTaskId());
		model.setBusinessId(taskModel.getTaskId());
		if (null != model.getTaskParticipantUserIds() && model.getTaskParticipantUserIds().size() > 0) {
			List<TaskParticipantModel> list = new ArrayList<TaskParticipantModel>();
			model.getTaskParticipantUserIds().stream().forEach(userId -> {
				TaskParticipantModel taskParticipantModel = new TaskParticipantModel(null, taskModel.getTaskId(),
						userId);
				list.add(taskParticipantModel);
			});
			taskParticipantService.insertByList(list);
		}
		if (null != model.getDeliverRequirementIds() && model.getDeliverRequirementIds().size() > 0) {
			deliverRequirementService.updateByList(taskModel.getTaskId(), model.getDeliverRequirementIds());
		}
		if (null != model.getBusinessAppendixIds() && model.getBusinessAppendixIds().size() > 0) {
			planAppendixService.updateByList(taskModel.getTaskId(), model.getBusinessAppendixIds(),
					taskModel.getTaskName(), taskModel.getProjectId(), taskModel.getProjectStep());
		}
		if (null != model.getBusinessAssociationIds() && model.getBusinessAssociationIds().size() > 0) {
			planAssociationService.updateByList(taskModel.getTaskId(), model.getBusinessAssociationIds());
		}
		if (null != model.getQualityRequirementIds() && model.getQualityRequirementIds().size() > 0) {
			qualityRequirementService.updateByList(taskModel.getTaskId(), model.getQualityRequirementIds());
		}
		if (null != model.getReportRequirementIds() && model.getReportRequirementIds().size() > 0) {
			reportRequirementService.updateByList(taskModel.getTaskId(), model.getReportRequirementIds());
		}
		// 为工作任务时，需要传入起始时间，新增工作任务后，会在旧系统日历中同步添加工作日历
		if (taskModel.getWorkTaskStatus() != null
				&& taskModel.getWorkTaskStatus().intValue() - WorkTaskStatusEnum.IS_WORKTASK.getStatus() == 0
				&& isWorkTaskAvailible(taskModel))
			copeToOldSystem(taskModel);
		return map;
	}

	/*
	 * 通过项目Id 获得所有父计划
	 */
	@Override
	public Map<String, Object> getParentTaskModelByProjectId(Long projectId, Long resourceBusinessId) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		if (projectId != null) {
			// 查询项目任务的父任务
			map.put("ParentTaskList", mapper.selectParentTaskModelByProjectId(projectId));
		} else if (resourceBusinessId != null) {
			// 查询所有业务任务的父任务
			map.put("ParentTaskList", mapper.selectParentTaskModelByResourceBusinessIdId(resourceBusinessId));
		} else {
			// 查询所有常规任务的父任务
			map.put("ParentTaskList", mapper.selectParentTaskModel());
		}
		return map;
	}

	/*
	 * 获取项目中的树型团队列表接口 V1版本
	 */
	public Map<String, Object> getProjectTree_V1(Long projectId) {
		Map<String, Object> map = new HashMap<>();
		List<ProjectTreeModelVo> list = projectService.selectProjectTreeById(projectId);
		for (ProjectTreeModelVo projectTreeModelVo : list) {
			ProjectTreeModelVo managerInfo = sysUserService.selectManagerInfo(projectTreeModelVo.getLeaderId());
			managerInfo.setJob("项目经理");
			projectTreeModelVo.setLeader(sysUserService.selectManagerInfo(projectTreeModelVo.getLeaderId()));
			if (projectTreeModelVo.getChildren() != null) {
				for (ProjectTreeModelVo modelVo : projectTreeModelVo.getChildren()) {
					recursion(modelVo);
				}
			}
		}
		map.put("ProjectInfo", list);
		return map;
	}

	/*
	 * 遍历所有负责人
	 */
	private ProjectTreeModelVo recursion(ProjectTreeModelVo modelVo) {
		if (modelVo.getChildren() != null) {
			if (modelVo.getLeaderId() != null) {
				ProjectTreeModelVo managerInfo = sysUserService.selectManagerInfo(modelVo.getLeaderId());
				if (managerInfo != null) {
					managerInfo.setJob("团队负责人");
					modelVo.setLeader(sysUserService.selectManagerInfo(modelVo.getLeaderId()));
					for (ProjectTreeModelVo model : modelVo.getChildren()) {
						if (sysUserService.selectById(model.getId()) != null)
							model.setLabel(sysUserService.selectById(model.getId()).getRealName());
					}
				}
			}
			if (modelVo.getChildren() != null) {
				for (ProjectTreeModelVo vo : modelVo.getChildren()) {
					recursion(vo);
				}
			}
		}
		return modelVo;
	}

	@Override
	public Map<String, Object> getGroupLeaderByProjectId(Long projectId) {
		// TODO Auto-generated method stub
		if (projectId == null) {
			throw new SystemParamCheckException("参数传入异常，无法进行查询");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		List<TeamLeaderAndGroupInfoModelVo> list = mapper.selectGroupLeaderByProjectId(projectId);
		list.stream().forEach((modelVo) -> {
			SysUserModel selectById = sysUserService.selectById(modelVo.getGroupLeaderId());
			if (selectById != null)
				modelVo.setGroupLeaderName(selectById.getRealName());
		});
		map.put("LeaderList", list);
		return map;
	}

	@Override
	public void delete(Long taskId) {
		// TODO Auto-generated method stub
		if (taskId == null) {
			throw new SystemParamCheckException("参数传入异常，无法进行查询");
		}
		mapper.updateToDelete(taskId);
	}

	/*
	 * 通过任务Id，获取到封装了子任务和显示字段的taskModel模型
	 */
	@Override
	public Map<String, Object> getOne(Long taskId) {
		// TODO Auto-generated method stub
		if (taskId == null) {
			throw new SystemParamCheckException("参数传入异常，无法进行查询");
		}
		TaskAndSonTaskModelVo taskAndSonTaskModelVo = mapper.selectByPrimaryKeyWithDelStatus(taskId);
		/*
		 * 获取父计划名称
		 */
		if (taskAndSonTaskModelVo.getParentTaskId() != null) {
			TaskAndSonTaskModelVo parentTaskAndSonTaskModelVo = mapper
					.selectByPrimaryKeyWithDelStatus(taskAndSonTaskModelVo.getParentTaskId());
			taskAndSonTaskModelVo.setParentTaskName(parentTaskAndSonTaskModelVo.getTaskName());
		}

		taskAndSonTaskModelVo.setChildren(getSonPlanModel(taskAndSonTaskModelVo));
		if (taskAndSonTaskModelVo.getProjectId() != null) {
			taskAndSonTaskModelVo.setProjectStepStr(
					(projectStepService.selectById(taskAndSonTaskModelVo.getProjectStep())).getName());
		}
		;
		taskAndSonTaskModelVo.setPriorityStr(TaskPorityEnum.getValue(taskAndSonTaskModelVo.getPriority().intValue()));
		taskAndSonTaskModelVo.setTaskParticipantList(taskParticipantService.getAll(taskId));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("taskModel", taskAndSonTaskModelVo);
		return map;
	}

	/*
	 * 仅修改模型内字段
	 */
	@Override
	public void update(TaskAndSonTaskModelVo taskAndSonTaskModelVo) {
		// TODO Auto-generated method stub
		if (taskAndSonTaskModelVo == null || taskAndSonTaskModelVo.getModel().getTaskId() == null) {
			throw new SystemParamCheckException("传入参数为空，无法进行修改");
		}
		mapper.updateByPrimaryKeySelective(taskAndSonTaskModelVo.getModel());
	}

	/*
	 * 可修改相关内容以及附件
	 */
	@Override
	public void update(TaskModel taskModel, TaskWithAllAppendixModelVo model) {
		// TODO Auto-generated method stub
		if (taskModel == null || taskModel.getTaskId() == null) {
			throw new SystemParamCheckException("参数传入为空，无法进行修改");
		}
		SysUserModel currentUsr = sysUserService.getCurrentUsr();
		// 关注 取消关注
		if (taskModel.getTaskAttentionStatus() != null) {
			taskAttentionService.updateByTaskId(taskModel.getTaskId());
		}

		// 若为修改为工作状态时使用，任务起始时间必填，且一个时间段内只能有一个工作任务
		if (null != model.getModel().getWorkTaskStatus() && model.getModel().getWorkTaskStatus()
				.longValue() == WorkTaskStatusEnum.IS_WORKTASK.getStatus().longValue()) {
			this.isWorkTaskAvailible(taskModel);
			// 复制数据到老系统
			this.updateCopeToOldSystem(taskModel);
			TaskModel taskModelTemp = model.getModel();
			if (taskModel.getProjectId() != null) {
				// 设置项目编号,仅在项目任务中有工作任务编号，其他任务中工作任务编号即任务编号
				ProjectCodeTaskRegChildModel taskNumModel = new ProjectCodeTaskRegChildModel();
				taskNumModel.setProjectId(taskModel.getProjectId());
				taskNumModel.setTypeId(3); // 3为工作任务
				taskModelTemp.setWorkTaskNum(projectCodeTaskRegChildService.selectTaskCode(taskNumModel));
			}

			taskModelTemp.setWorkTaskStatus(WorkTaskStatusEnum.IS_WORKTASK.getStatus().longValue());
			mapper.updateByPrimaryKeySelective(taskModelTemp);

		} else {
			if (taskModel.getRestartTaskStatus() != null) {
				taskModel.setCancelTaskStatus(CancelTaskStatusEnum.NOT_CANCEL_TASK.getStatus().longValue());
				taskModel.setStopTaskStatus(StopTaskStatusEnum.NOT_STOP_TASK.getStatus().longValue());
			}
			if (taskModel.getStopTaskReason() != null) {
				taskModel.setCancelTaskStatus(CancelTaskStatusEnum.NOT_CANCEL_TASK.getStatus().longValue());
			}
			taskModel.setWorkTaskStatus(WorkTaskStatusEnum.IS_NOT_WORKTASK.getStatus().longValue());

			// 分配负责人时，
			if (taskModel.getTaskLeaderId() != null) {
				taskModel.setTaskDispatcherId(currentUsr.getUserId());
				taskModel.setTaskDispatchUserId(taskModel.getTaskLeaderId());
			}
			mapper.updateByPrimaryKeySelective(taskModel);
		}
		/*
		 * 参与人，先删除旧数据，在新增新数据
		 */
		if (model.getTaskParticipantUserIds() != null) {
			taskParticipantService.deleteByTaskId(taskModel.getTaskId());
			List<TaskParticipantModel> list = new ArrayList<TaskParticipantModel>();
			model.getTaskParticipantUserIds().stream().forEach(userId -> {
				list.add(new TaskParticipantModel(null, taskModel.getTaskId(), userId));
			});
			taskParticipantService.insertByList(list);
		}
		/*
		 * 修改关联计划，先删除旧信息，在存入新的信息
		 */
		if (model.getBusinessAssociationIds() != null) {
			planAssociationService.deleteByBusinessId(taskModel.getTaskId());
			planAssociationService.updateByList(taskModel.getTaskId(), model.getBusinessAssociationIds());
		}
		/*
		 * 修改计划附件，先删除旧信息，在存入新的信息
		 */
		if (model.getBusinessAppendixIds() != null) {
			planAppendixService.deleteByBusinessId(taskModel.getTaskId());
			planAppendixService.updateByList(taskModel.getTaskId(), model.getBusinessAppendixIds(),
					taskModel.getTaskName(), taskModel.getProjectId(), taskModel.getProjectStep());
		}
		/*
		 * 修改交付要求，先删除旧信息，在存入新的信息
		 */
		if (model.getDeliverRequirementIds() != null) {
			deliverRequirementService.deleteByBusinessId(taskModel.getTaskId());
			deliverRequirementService.updateByList(taskModel.getTaskId(), model.getDeliverRequirementIds());
		}
		/*
		 * 修改质量要求，先删除旧信息，在存入新的信息
		 */
		if (model.getQualityRequirementIds() != null) {
			qualityRequirementService.deleteByBusinessId(taskModel.getTaskId());
			qualityRequirementService.updateByList(taskModel.getTaskId(), model.getQualityRequirementIds());
		}
		/*
		 * 修改汇报要求，先删除旧信息，在存入新的信息
		 */
		if (model.getReportRequirementIds() != null) {
			reportRequirementService.deleteByBusinessId(taskModel.getTaskId());
			reportRequirementService.updateByList(taskModel.getTaskId(), model.getReportRequirementIds());
		}
	}

	private BasePageInfoWithCount<TaskAndSonTaskModelVo> setInfo(
			BasePageInfoWithCount<TaskAndSonTaskModelVo> pageInfo) {
		pageInfo.setTotalTask(mapper.selectTotalTask());
		pageInfo.setUnStartTask(mapper.selectUnstartTask());
		pageInfo.setProcedingTask(mapper.selectProcedingTask());
		pageInfo.setFinishedTask(mapper.selectFinishedTask());
		pageInfo.setUncommentedTask(mapper.selectUncommentedTask());
		pageInfo.setCommentedTask(mapper.selectCommentedTask());
		return pageInfo;
	}

	/*
	 * 获取子任务平均得分
	 */
	@Override
	public Double getChildrenAvgScore(Long taskId) {
		// TODO Auto-generated method stub
		if (taskId == null) {
			throw new SystemParamCheckException("参数传入异常，无法进行查询");
		}
		return mapper.selectChildrenTaskAvgScore(taskId);
	}

	/*
	 * 返回优先级的Id以及类型名称
	 */
	@Override
	public Object getProjectPority() {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		for (Integer i = 1; i <= TaskPorityEnum.values().length; i++) {
			Map<String, Object> map = new HashMap<>();
			map.put("id", i);
			map.put("name", TaskPorityEnum.getValue(i));
			list.add(map);
		}
		return list;
	}

	/*
	 * 通过项目id，查出此项目配置中所属阶段的id以及name
	 */
	@Override
	public List<ProjectStepVo> getStepInfo(Long projectId) {
		// TODO Auto-generated method stub
		Map<Long, String> map = new HashMap<Long, String>();
		ProjectStepModel model = new ProjectStepModel();
		model.setProjectId(projectId);
		List<ProjectStepVo> listByProjectId = projectStepService.listByProjectId(model);
		return listByProjectId;
	}

	/*
	 * 返回任务左侧导航栏中的计数及相关信息
	 */
	@Override
	public List<TaskCountInfoVo> getTaskLeftNavigationInfo(TaskModel taskModel) {
		// TODO Auto-generated method stub
		List<TaskCountInfoVo> taskCountInfos = new ArrayList<>();
		Long userId = sysUserService.getCurrentUsr().getUserId();
		for (TaskLeftNavigationEnum e : TaskLeftNavigationEnum.values()) {
			TaskCountInfoVo countInfo = null;
			switch (e.getStatus()) {
			case 1:
				countInfo = new TaskCountInfoVo(mapper.selectMyDrawfTaskCount(taskModel), e.getInfo(),
						e.getStatus().longValue());
				break;
			case 2:
				Long taskLeaderId = userId;
				taskModel.setTaskLeaderId(taskLeaderId);
				countInfo = new TaskCountInfoVo(mapper.selectMyResponsibleTaskCount(taskModel), e.getInfo(),
						e.getStatus().longValue());
				break;
			case 3:
				Long taskDispatchUserId = userId;
				taskModel.setTaskDispatchUserId(taskDispatchUserId);
				countInfo = new TaskCountInfoVo(mapper.selectDiapatchedTaskToMeCount(taskModel), e.getInfo(),
						e.getStatus().longValue());
				break;
			case 4:
				Long taskDispatcherId = userId;
				taskModel.setTaskDispatcherId(taskDispatcherId);
				countInfo = new TaskCountInfoVo(mapper.selectDispatchTaskByMeCount(taskModel), e.getInfo(),
						e.getStatus().longValue());
				break;
			case 5:
				Long taskParticipants = userId;
				taskModel.setTaskParticipants(taskParticipants);
				countInfo = new TaskCountInfoVo(mapper.selectParticipatedTaskByMeCount(taskModel), e.getInfo(),
						e.getStatus().longValue());
				break;
			case 6:
				countInfo = new TaskCountInfoVo(mapper.selectAttentionedTaskByMeCount(taskModel), e.getInfo(),
						e.getStatus().longValue());
				break;
			case 7:
				// 传入userId代替taskLeaderId
				taskModel.setTaskLeaderId(userId);
				countInfo = new TaskCountInfoVo(mapper.selectMyCommentedTaskCount(taskModel), e.getInfo(),
						e.getStatus().longValue());
				break;
			case 8:
				// 传入userId代替taskLeaderId
				taskModel.setTaskLeaderId(userId);
				countInfo = new TaskCountInfoVo(mapper.selectCommentTaskByMeCount(taskModel), e.getInfo(),
						e.getStatus().longValue());
				break;

			default:
				break;
			}
			taskCountInfos.add(countInfo);
		}
		return taskCountInfos;
	}

	@Override
	public List<TaskModelVo> getTaskByProjectStepAndProjectId(TaskModel taskModel) {
		// TODO Auto-generated method stub
		List<TaskModelVo> selectTaskByProjectStepAndProjectId = mapper.selectTaskByProjectStepAndProjectId(taskModel);
		return selectTaskByProjectStepAndProjectId;
	}

	@Override
	public BasePageInfo<TaskAndSonTaskModelVo> getParentTaskByGroupCondition(BasePageInfo<TaskAndSonTaskModelVo> page) {
		// TODO Auto-generated method stub
		List<TaskAndSonTaskModelVo> selectTaskByProjectIdOrTaskTeamIdOrTaskLeaderId = mapper
				.selectTaskByProjectIdOrTaskTeamIdOrTaskLeaderId(page);
		for (TaskAndSonTaskModelVo taskAndSonTaskModelVo : selectTaskByProjectIdOrTaskTeamIdOrTaskLeaderId) {
			taskAndSonTaskModelVo.setChildren(getSonPlanModel(taskAndSonTaskModelVo));
			if (page.getModel().getProjectId() != null) {
				taskAndSonTaskModelVo.setProjectStepStr(
						(projectStepService.selectById(taskAndSonTaskModelVo.getProjectStep())).getName());
			}
			;
			taskAndSonTaskModelVo
					.setPriorityStr(TaskPorityEnum.getValue(taskAndSonTaskModelVo.getPriority().intValue()));
			taskAndSonTaskModelVo
					.setTaskParticipantList(taskParticipantService.getAll(taskAndSonTaskModelVo.getTaskId()));
		}
		System.out.println(
				"selectTaskByProjectIdOrTaskTeamIdOrTaskLeaderId" + selectTaskByProjectIdOrTaskTeamIdOrTaskLeaderId);
		return new BasePageInfo<>(selectTaskByProjectIdOrTaskTeamIdOrTaskLeaderId);
	}

	/*
	 * 通过项目Id获取任务列表
	 */
	@Override
	public BasePageInfo<TaskAndSonTaskModelVo> getTaskByProjectId(BasePageInfo<TaskAndSonTaskModelVo> page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page.getPageNum(), page.getPageSize(), true);
		List<TaskAndSonTaskModelVo> selectTaskByProjectId = mapper.selectTaskByProjectId(page);
		for (TaskAndSonTaskModelVo taskAndSonTaskModelVo : selectTaskByProjectId) {
			if (page.getModel().getProjectId() != null) {
				taskAndSonTaskModelVo.setProjectStepStr(
						(projectStepService.selectById(taskAndSonTaskModelVo.getProjectStep())).getName());
			}
			;
			taskAndSonTaskModelVo
					.setPriorityStr(TaskPorityEnum.getValue(taskAndSonTaskModelVo.getPriority().intValue()));
		}
		return new BasePageInfo<>(selectTaskByProjectId);
	}

	/*
	 * 通过业务来源Id获取任务列表
	 */
	@Override
	public BasePageInfo<TaskAndSonTaskModelVo> getTaskByResourceBusinessId(BasePageInfo<TaskAndSonTaskModelVo> page) {
		// TODO Auto-generated method stub
		if (page == null || page.getModel().getProjectId() == null) {
			throw new SystemParamCheckException("传入参数异常，无法进行查询");
		}
		PageHelper.startPage(page.getPageNum(), page.getPageSize(), true);
		List<TaskAndSonTaskModelVo> selectTaskByProjectId = mapper.selectTaskByProjectId(page);
		for (TaskAndSonTaskModelVo taskAndSonTaskModelVo : selectTaskByProjectId) {
			if (page.getModel().getProjectId() != null) {
				taskAndSonTaskModelVo.setProjectStepStr(
						(projectStepService.selectById(taskAndSonTaskModelVo.getProjectStep())).getName());
			}
			;
			taskAndSonTaskModelVo
					.setPriorityStr(TaskPorityEnum.getValue(taskAndSonTaskModelVo.getPriority().intValue()));
		}
		return new BasePageInfo<>(selectTaskByProjectId);
	}

	/*
	 * 计划转为任务
	 */
	@Override
	public void planToTask(PlanModel planModel) {
		// TODO Auto-generated method stub
		TaskModel taskModel = new TaskModel(planModel);
		// 设置项目任务编号
		ProjectCodeTaskRegChildModel taskNumModel = new ProjectCodeTaskRegChildModel();
		taskNumModel.setProjectId(taskModel.getProjectId());
		taskNumModel.setTypeId(1); // 1为项目任务
		String taskNum = projectCodeTaskRegChildService.selectTaskCode(taskNumModel);
		taskModel.setTaskNum(taskNum);
		mapper.insert(taskModel);
		participantToTask(planModel.getPlanId(), taskModel.getTaskId());
	}

	/*
	 * 复制计划模型中的参与人
	 */
	private void participantToTask(Long planId, Long taskId) {
		List<PlanParticipantModel> listByPlanId = planParticipantService.selectPlanParticipantListByPlanId(planId);
		if (listByPlanId != null) {
			for (PlanParticipantModel planParticipantModel : listByPlanId) {
				TaskParticipantModel taskParticipantModel = new TaskParticipantModel();
				taskParticipantModel.setTaskId(taskId);
				taskParticipantModel.setTaskPaticipantUserId(planParticipantModel.getPlanPaticipantUserId());
				taskParticipantService.save(taskParticipantModel);
			}
		}
	}

	@Override
	public WorkStatusVo selectCurWorkStatusByCurUserInfo() {
		// TODO Auto-generated method stub
		return mapper.selectCurWorkStatusByCurUserInfo(sysUserService.getCurrentUsr().getUserId());
	}

	@Override
	public BasePageInfo<TaskAndSonTaskModelVo> selectTaskListByProjectId(BasePageInfo<TaskAndSonTaskModelVo> page) {
		// TODO Auto-generated method stub
		if (page.getModel().getProjectId() == null) {
			throw new SystemParamCheckException("projectId为空");
		}
		PageHelper.startPage(page.getPageNum(), page.getPageSize(), true);
		return new BasePageInfo<>(mapper.selectTaskListByProjectId(page.getModel().getProjectId()));
	}

	/**
	 * 获取里程碑关联任务
	 */
	@Override
	public List<TaskAndSonTaskModelVo> selectTaskModelByMilestoneId(Long milestoneId) {
		List<TaskAndSonTaskModelVo> vos = mapper.selectTaskModelByMilestoneId(milestoneId);
		return vos;
	}

	/**
	 * 如果传入的数据在数据库查不到，则返回默认设置
	 */
	@Override
	public EstimateModelVo getCommentSetting(CommentSettingModel commentSettingModel) {
		// TODO Auto-generated method stub
		if (commentSettingModel.getResourceBusinessId() == null
				|| commentSettingModel.getResourceBusinessType() == null) {
			throw new SystemParamCheckException("业务来源传入参数为空，无法进行查询");
		}
		List<CommentSettingModel> list = commentSettingService.selectByModel(commentSettingModel);
		if (list.size() <= 0) {
			CommentSettingModel setting = CommentSettingUtil.getDefaultCommentSetting();
			return new EstimateModelVo(setting.getQualityEstimateWeight(), setting.getTimeEstimateWeight(),
					CommentSettingUtil.getDefaultPercentSetting());
		} else {
			EstimateModelVo estimateModelVo = new EstimateModelVo();
			BeanUtils.copyProperties(list.get(0), estimateModelVo);
			List<PercentSettingModelVo> selectByResourceBusinessId = percentSettingServiceImpl
					.selectByResourceBusinessId(commentSettingModel.getResourceBusinessId());
			if (selectByResourceBusinessId.size() <= 0) {
				estimateModelVo.setActionList(CommentSettingUtil.getDefaultPercentSetting());
			} else {
				estimateModelVo.setActionList(selectByResourceBusinessId);
			}
			return estimateModelVo;
		}
	}

	@Override
	public EstimateModelVo getDeliverableSetting(DeliverableSettingModel deliverableSettingModel) {
		// TODO Auto-generated method stub
		if (deliverableSettingModel.getResourceBusinessId() == null
				|| deliverableSettingModel.getResourceBusinessType() == null) {
			throw new SystemParamCheckException("业务来源传入参数为空，无法进行查询");
		}
		List<DeliverableSettingModel> list = deliverableSettingService.selectByModel(deliverableSettingModel);
		if (list.size() <= 0) {
			DeliverableSettingModel setting = CommentSettingUtil.getDefaultDeliverableSetting();
			return new EstimateModelVo(setting.getQualityEstimateWeight(), setting.getTimeEstimateWeight(),
					CommentSettingUtil.getDefaultPercentSetting());
		} else {
			EstimateModelVo estimateModelVo = new EstimateModelVo();
			BeanUtils.copyProperties(list.get(0), estimateModelVo);
			List<PercentSettingModelVo> selectByResourceBusinessId = percentSettingServiceImpl
					.selectByResourceBusinessId(deliverableSettingModel.getResourceBusinessId());
			if (selectByResourceBusinessId.size() <= 0) {
				estimateModelVo.setActionList(CommentSettingUtil.getDefaultPercentSetting());
			} else {
				estimateModelVo.setActionList(selectByResourceBusinessId);
			}
			return estimateModelVo;
		}
	}

	/*
	 * 递归查询parentTaskId为空的taskId
	 */
	private TaskAndSonTaskModelVo selectModelByParentTaskId(Long parentTaskId) {
		TaskAndSonTaskModelVo modelVo = new TaskAndSonTaskModelVo();
		List<TaskAndSonTaskModelVo> list = mapper.selectModelByParentTaskId(parentTaskId);
		modelVo = list.get(0);
		if (list.get(0).getParentTaskId() != null) {
			modelVo = this.selectModelByParentTaskId(list.get(0).getParentTaskId());
		}
		return modelVo;
	}

	/*
	 * 无限递归获取子计划
	 */
	@Override
	public List<TaskAndSonTaskModelVo> getSonPlanModel(TaskAndSonTaskModelVo taskAndSonTaskModelVo) {
		// TODO Auto-generated method stub
		Long parentTaskId = taskAndSonTaskModelVo.getParentTaskId();
		taskAndSonTaskModelVo.setParentTaskId(taskAndSonTaskModelVo.getTaskId());
		taskAndSonTaskModelVo.setParentTaskName(taskAndSonTaskModelVo.getParentTaskName());
		List<TaskAndSonTaskModelVo> selectSonTaskModel = mapper.selectSonTaskModel(taskAndSonTaskModelVo);
		// 设置任务和子任务向前端显示的项目阶段和优先级的字符串
		for (TaskAndSonTaskModelVo taskAndSonTaskModelVo2 : selectSonTaskModel) {
			if (taskAndSonTaskModelVo2.getProjectId() != null) {
				taskAndSonTaskModelVo.setProjectStepStr(
						(projectStepService.selectById(taskAndSonTaskModelVo2.getProjectStep())).getName());
			}
			;
			taskAndSonTaskModelVo
					.setPriorityStr(TaskPorityEnum.getValue(taskAndSonTaskModelVo2.getPriority().intValue()));
		}
		if (selectSonTaskModel != null) {
			for (TaskAndSonTaskModelVo modelVo : selectSonTaskModel) {
				modelVo.setChildren(getSonPlanModel(modelVo));
			}
		}
		taskAndSonTaskModelVo.setParentTaskId(parentTaskId);
		return selectSonTaskModel;
	}

	/*
	 * List 排序的Util类 按照传入的属性和排序方式进行排列
	 */
	private List<TaskAndSonTaskModelVo> getSortList(String sortKey, String sortValue,
			List<TaskAndSonTaskModelVo> listTemp) {
		ListSortUtil<TaskAndSonTaskModelVo> sortUtil = new ListSortUtil(TaskAndSonTaskModelVo.class);
		try {
			if ("desc".equalsIgnoreCase(sortValue)) {
				sortUtil.addDesc(sortKey);
			} else if ("asc".equalsIgnoreCase(sortValue)) {
				sortUtil.addAsc(sortKey);
			} else {
				return listTemp;
			}

		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return listTemp;
		}
		return sortUtil.sortList(listTemp);
	}

	@Override
	public Object test(Long taskId) {
		// TODO Auto-generated method stub
		return mapper.selectTaskName(taskId);
	}

	@Override
	public BasePageInfo<TaskAndSonTaskModelVo> selectMyDrawfTaskList(TaskBasePageInfo<TaskAndSonTaskModelVo> page) {
		// TODO Auto-generated method stub
		TaskAndSonTaskModelVo model = page.getPage().getModel();
		PageHelper.startPage(page.getPage().getPageNum(), page.getPage().getPageSize(), true);
		List<TaskAndSonTaskModelVo> list = mapper.selectMyDraftTaskTempList(page);
		List<TaskAndSonTaskModelVo> sortList = getSortList(page.getPage().getSortKey(), page.getPage().getSortValue(),
				list);
		return setInfo(new BasePageInfoWithCount<>(addFieldStr(sortList)));
	}

	@Override
	public BasePageInfo<TaskAndSonTaskModelVo> selectMyResponibleTaskTempList(
			TaskBasePageInfo<TaskAndSonTaskModelVo> page) {
		// TODO Auto-generated method stub
		TaskAndSonTaskModelVo model = page.getPage().getModel();
//		if(model.getProjectId()==null && model.getResourceBusinessId() == null) {
//			throw new SystemParamCheckException("任务来源参数id传入为空，无法进行查询");
//		}
		PageHelper.startPage(page.getPage().getPageNum(), page.getPage().getPageSize(), true);
		List<TaskAndSonTaskModelVo> list = mapper.selectMyResponibleTaskTempList(page);
		List<TaskAndSonTaskModelVo> sortList = getSortList(page.getPage().getSortKey(), page.getPage().getSortValue(),
				list);
		return setInfo(new BasePageInfoWithCount<>(addFieldStr(sortList)));
	}

	/*
	 * 返回项目阶段和优先级的str
	 */
	private List<TaskAndSonTaskModelVo> addFieldStr(List<TaskAndSonTaskModelVo> sortList) {
		if (sortList != null) {
			sortList.stream().forEach((taskAndSonTaskModelVo) -> {
				if (taskAndSonTaskModelVo.getProjectId() != null) {
					if (taskAndSonTaskModelVo.getProjectStep() != null) {
						taskAndSonTaskModelVo.setProjectStepStr(
								(projectStepService.selectById(taskAndSonTaskModelVo.getProjectStep())).getName());
					}
				}
				;
				taskAndSonTaskModelVo
						.setPriorityStr(TaskPorityEnum.getValue(taskAndSonTaskModelVo.getPriority().intValue()));
				List<UserIdAndNameInfo> all = taskParticipantService.getAll(taskAndSonTaskModelVo.getTaskId());
				taskAndSonTaskModelVo.setTaskParticipantList(all);
			});
		}
		return sortList;
	}

	/**
	 * 分配给我的任务
	 */
	@Override
	public BasePageInfo<TaskAndSonTaskModelVo> selectDispatchToMeTaskTempList(
			TaskBasePageInfo<TaskAndSonTaskModelVo> page) {
		// TODO Auto-generated method stub
		TaskAndSonTaskModelVo model = page.getPage().getModel();
		PageHelper.startPage(page.getPage().getPageNum(), page.getPage().getPageSize(), true);
		List<TaskAndSonTaskModelVo> list = mapper.selectDispatchToMeTaskTempList(page);
		List<TaskAndSonTaskModelVo> sortList = getSortList(page.getPage().getSortKey(), page.getPage().getSortValue(),
				list);
		return setInfo(new BasePageInfoWithCount<>(addFieldStr(sortList)));
	}

	@Override
	public BasePageInfo<TaskAndSonTaskModelVo> selectDispatchByMeTaskTempList(
			TaskBasePageInfo<TaskAndSonTaskModelVo> page) {
		// TODO Auto-generated method stub
		TaskAndSonTaskModelVo model = page.getPage().getModel();
		PageHelper.startPage(page.getPage().getPageNum(), page.getPage().getPageSize(), true);
		List<TaskAndSonTaskModelVo> list = mapper.selectDispatchByMeTaskTempList(page);
		List<TaskAndSonTaskModelVo> sortList = getSortList(page.getPage().getSortKey(), page.getPage().getSortValue(),
				list);
		return setInfo(new BasePageInfoWithCount<>(addFieldStr(sortList)));
	}

	@Override
	public BasePageInfo<TaskAndSonTaskModelVo> selectMyParticipantTaskTempList(
			TaskBasePageInfo<TaskAndSonTaskModelVo> page) {
		// TODO Auto-generated method stub
		TaskAndSonTaskModelVo model = page.getPage().getModel();
		PageHelper.startPage(page.getPage().getPageNum(), page.getPage().getPageSize(), true);
		List<TaskAndSonTaskModelVo> list = mapper.selectMyParticipantTaskTempList(page);
		List<TaskAndSonTaskModelVo> sortList = getSortList(page.getPage().getSortKey(), page.getPage().getSortValue(),
				list);
		return setInfo(new BasePageInfoWithCount<>(addFieldStr(sortList)));
	}

	@Override
	public BasePageInfo<TaskAndSonTaskModelVo> selectMyAttentionTaskTempList(
			TaskBasePageInfo<TaskAndSonTaskModelVo> page) {
		// TODO Auto-generated method stub
		TaskAndSonTaskModelVo model = page.getPage().getModel();
		PageHelper.startPage(page.getPage().getPageNum(), page.getPage().getPageSize(), true);
		List<TaskAndSonTaskModelVo> list = mapper.selectMyAttentionTaskTempList(page);
		List<TaskAndSonTaskModelVo> sortList = getSortList(page.getPage().getSortKey(), page.getPage().getSortValue(),
				list);
		return setInfo(new BasePageInfoWithCount<>(addFieldStr(sortList)));
	}

	@Override
	public BasePageInfo<TaskAndSonTaskModelVo> selectMyCommentTaskTempList(
			TaskBasePageInfo<TaskAndSonTaskModelVo> page) {
		// TODO Auto-generated method stub
		TaskAndSonTaskModelVo model = page.getPage().getModel();
		PageHelper.startPage(page.getPage().getPageNum(), page.getPage().getPageSize(), true);
		List<TaskAndSonTaskModelVo> list = mapper.selectMyCommentTaskTempList(page);
		List<TaskAndSonTaskModelVo> sortList = getSortList(page.getPage().getSortKey(), page.getPage().getSortValue(),
				list);
		return setInfo(new BasePageInfoWithCount<>(addFieldStr(sortList)));
	}

	@Override
	public BasePageInfo<TaskAndSonTaskModelVo> selectNeedToCommentTaskTempList(
			TaskBasePageInfo<TaskAndSonTaskModelVo> page) {
		// TODO Auto-generated method stub
		TaskAndSonTaskModelVo model = page.getPage().getModel();
		PageHelper.startPage(page.getPage().getPageNum(), page.getPage().getPageSize(), true);
		List<TaskAndSonTaskModelVo> list = mapper.selectNeedToCommentTaskTempList(page);
		List<TaskAndSonTaskModelVo> sortList = getSortList(page.getPage().getSortKey(), page.getPage().getSortValue(),
				list);
		return setInfo(new BasePageInfoWithCount<>(addFieldStr(sortList)));
	}

	/*
	 * 判断新旧系统中当前起始时间是否存在任务
	 */
	private Boolean isWorkTaskAvailible(TaskModel taskModel) {
		if (taskModel.getTaskStartTime() == null || taskModel.getTaskEndTime() == null) {
			throw new SystemParamCheckException("起始时间为空，无法转工作任务");
		}
		if (mapper.selectExistedWorkTaskIdCount(taskModel) > 0) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			throw new SystemParamCheckException(format.format(taskModel.getTaskStartTime()) + "--"
					+ format.format(taskModel.getTaskEndTime()) + "时间段内,已经存在工作任务，无法新建工作任务,请选择其他时间段");
		}
		return true;
	}

	/*
	 * 新增时， 将工作任务信息同步拷贝到旧系统中
	 */
	private void copeToOldSystem(TaskModel taskModel) {
		OpdcaTaskModelVo opdcaTaskModelVo = new OpdcaTaskModelVo(taskModel);
		opdcaTaskModelVo.setOwner("owner暂时写死");
		opdcaTaskModelVo.setOrgId(sysUserService.getCurrentUsr().getOrgId());
		opdcaTaskModelVo.setRelationRoutineName("relationRoutineName暂时写死");
		opdcaTaskModelVo.setBusinessName("businessName暂时写死");
		opdcaTaskModelVo.setBusSourceName("busSourceName暂时写死");
		OpdcaTaskModel opdcaTaskModel = new OpdcaTaskModel(opdcaTaskModelVo);
		opdcaTaskService.save(opdcaTaskModel);
	}

	/*
	 * 更新时， 将工作任务信息同步拷贝到旧系统中
	 */
	private void updateCopeToOldSystem(TaskModel taskModel) {
		OpdcaTaskModel opdcaTaskModel = new OpdcaTaskModel();
		OpdcaTaskModelVo opdcaTaskModelVo = new OpdcaTaskModelVo();
		opdcaTaskModelVo = new OpdcaTaskModelVo(taskModel);
		opdcaTaskModelVo.setOwner("owner暂时写死");
		opdcaTaskModelVo.setOrgId(sysUserService.getCurrentUsr().getOrgId());
		opdcaTaskModelVo.setRelationRoutineName("relationRoutineName暂时写死");
		opdcaTaskModelVo.setBusinessName("businessName暂时写死");
		opdcaTaskModelVo.setBusSourceName("busSourceName暂时写死");
		opdcaTaskModel = new OpdcaTaskModel(opdcaTaskModelVo);
		opdcaTaskModel.setId(taskModel.getOldTaskId());
		if (taskModel.getOldTaskId() != null) {
			System.out.println("opdcaTaskModel~~~~~~~~~~"+opdcaTaskModel);
			opdcaTaskService.update(opdcaTaskModel);
		}else {
			System.out.println("opdcaTaskModel++++++++"+opdcaTaskModel);
			opdcaTaskService.save(opdcaTaskModel);
		}

	}

	@Override
	public List<EmpTreeModelVo> selectByOrgIdAndParentId() {
		// TODO Auto-generated method stub
		SysUserModel currentUsr = sysUserService.getCurrentUsr();
		return sysJobService.selectByOrgIdAndParentId(currentUsr.getOrgId());
	}

	/**
	 * 仅修改任务中的相关字段
	 */
	@Override
	public void update(TaskModel taskModel) {
		// TODO Auto-generated method stub
		mapper.updateByPrimaryKeySelective(taskModel);
	}

	private TaskModel setDefaultInfo(TaskModel taskModel) {
		SysUserModel currentUsr = sysUserService.getCurrentUsr();
		// 设置默认值
		// 任务编号
		String taskNum = "";
		if (taskModel.getTaskResourceType() != null
				&& taskModel.getTaskResourceType() == TaskResourceEnum.PROJECT_TASK.getStatus().longValue()) {
			// 设置项目任务编号
			ProjectCodeTaskRegChildModel taskNumModel = new ProjectCodeTaskRegChildModel();
			taskNumModel.setProjectId(taskModel.getProjectId());
			if (taskModel.getParentTaskId() == null) {
				taskNumModel.setTypeId(1); // 1为项目任务
			} else {
				taskNumModel.setTypeId(2); // 2为子任务
				taskNumModel.setParentTaskId(taskModel.getParentTaskId());
			}
			taskNum = projectCodeTaskRegChildService.selectTaskCode(taskNumModel);
		} else {
			List<TaskNumModel> list = new ArrayList<>();
			if (taskModel.getParentTaskId() != null) {
				// 获取非项目任务的子任务编号
				list = taskNumService.selectByConUserId(TaskSortEnum.SON_TASK.getStatus().longValue());
			} else {
				// 获取非项目任务的任务编号
				list = taskNumService.selectByConUserId(TaskSortEnum.TASK.getStatus().longValue());
			}
			TaskNumModel taskNumModel = list.get(0);
			Date todayDB = taskNumModel.getToday();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			if (!sdf.format(todayDB).equals(sdf.format(new Date()))) {
				taskNumModel.setToday(new Date());
				taskNumModel.setSeriesDigit(0L);
			}
			taskNumModel.setSeriesDigit(taskNumModel.getSeriesDigit() + 1);
			taskNumService.updateByCurUserIdAndIsSonTask(taskNumModel);
			taskNum = TaskNumUtil.getNum(taskNumModel);
		}

		taskModel.setTaskNum(taskNum);
		taskModel.setCancelTaskStatus(CancelTaskStatusEnum.NOT_CANCEL_TASK.getStatus().longValue());
		taskModel.setStopTaskStatus(StopTaskStatusEnum.NOT_STOP_TASK.getStatus().longValue());
		taskModel.setRestartTaskStatus(RestartTaskStatusEnum.NOT_RESTART_TASK.getStatus().longValue());
		taskModel.setTaskProgrossRate(0d);
		taskModel.setCreateId(currentUsr.getUserId());
		taskModel.setCreateBy(currentUsr.getRealName());
		taskModel.setCreateTime(new Date());
		taskModel.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus().longValue());
		if (taskModel.getProjectId() == null && taskModel.getResourceBusinessId() == null) {
			taskModel.setTaskResourceType(TaskResourceEnum.NORMAL_TASK.getStatus().longValue());
		}
		if (taskModel.getTaskStatus() == null) {
			taskModel.setTaskStatus(TaskStatusEnum.UNPERMITTED.getStatus().longValue());
		}
		if (taskModel.getTaskLeaderId() == null) {
			taskModel.setTaskLeaderId(currentUsr.getUserId());
			taskModel.setTaskLeaderName(currentUsr.getRealName());
		}
		return taskModel;

	}
}
