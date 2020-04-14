package com.fea.project.service.task;

import com.fea.project.api.other.model.base.vo.EmpTreeModelVo;
import com.fea.project.api.other.model.base.vo.SysJobVo;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.plan.PlanModel;
import com.fea.project.model.project.vo.ProjectStepVo;
import com.fea.project.model.task.CommentSettingModel;
import com.fea.project.model.task.DeliverableSettingModel;
import com.fea.project.model.task.TaskModel;
import com.fea.project.model.task.vo.*;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ITaskService {

	Map<String,Object> save(TaskModel taskModel,TaskWithAllAppendixModelVo modelVo);
	
	
	
	Map<String,Object> getParentTaskModelByProjectId(Long projectId,Long resourceBusinessId);
	
	
	/*
	 * 获取项目所有的组织列表
	 */
	Map<String, Object> getProjectTree_V1(Long projectId);
	/*
	 * 获取团队负责人
	 */
	Map<String, Object> getGroupLeaderByProjectId(Long projectId);
	
	/*
	 * 假删除任务
	 */
	void delete(Long taskId);
	
	/*
	 * 获取所有的子任务
	 */
	List<TaskAndSonTaskModelVo> getSonPlanModel(TaskAndSonTaskModelVo taskAndSonTaskModelVo);
	
	/*
	 * 通过任务Id，获取到封装了子任务和显示字段的taskModel模型
	 */
	Map<String, Object> getOne(Long taskId);
	
	/*
	 * 编辑修改任务接口，可修改附件以及相关信息
	 */
	void update(TaskModel taskModel,TaskWithAllAppendixModelVo model);
	/*
	 * 编辑修改任务接口，不可修改附件以及相关信息
	 */
	void update(TaskAndSonTaskModelVo taskAndSonTaskModelVo);
	/*
	 * 编辑修改任务接口，不可修改附件以及相关信息
	 */
	void update(TaskModel taskModel);
	/*
	 * 返回当前项目下所有子任务的平均得分
	 */
	Double getChildrenAvgScore(Long taskId);
	
	/*
	 * 获取优先级Id及名称
	 */
	Object getProjectPority();
	
	/*
	 * 获取项目阶段的id及名称
	 */
	List<ProjectStepVo> getStepInfo(Long projectId);
	
	/*
	 * 获取任务页面左侧导航栏计数及信息
	 */
	List<TaskCountInfoVo> getTaskLeftNavigationInfo(TaskModel taskModel);
	
	/*
	 * 通过项目阶段和项目id获取所有的任务列表
	 */
	List<TaskModelVo> getTaskByProjectStepAndProjectId(TaskModel taskModel);
	
	/*
	 * 通过条件获取父任务
	 */
	BasePageInfo<TaskAndSonTaskModelVo> getParentTaskByGroupCondition(BasePageInfo<TaskAndSonTaskModelVo> page);
	
	/*
	 * 通过项目Id，获取任务列表
	 */
	BasePageInfo<TaskAndSonTaskModelVo> getTaskByProjectId(BasePageInfo<TaskAndSonTaskModelVo> page);
	
	
	/*
	 * 计划转为任务
	 */
	void planToTask(PlanModel planModel);
	
	 /*
     * 获取当前用户的工作状态信息
     */
    WorkStatusVo selectCurWorkStatusByCurUserInfo();
    /*
     * 通过项目Id获取所有的任务列表
     */
    BasePageInfo<TaskAndSonTaskModelVo> selectTaskListByProjectId(BasePageInfo<TaskAndSonTaskModelVo> page);




	
	
	/*
	 * 通过业务来源Id查找任务列表
	 */
	BasePageInfo<TaskAndSonTaskModelVo> getTaskByResourceBusinessId(BasePageInfo<TaskAndSonTaskModelVo> page);
	/*
	 * 获取里程碑关联任务
	 */
	List<TaskAndSonTaskModelVo> selectTaskModelByMilestoneId(Long milestoneId);
	
	/*
	 * 通过resourceBusinessId和resourceBusinessType来获取评分的相关参数列表
	 */
	EstimateModelVo getCommentSetting(CommentSettingModel commentSettingModel);
	/*
	 * 通过resourceBusinessId和resourceBusinessType来获取评分的相关参数列表
	 */
	EstimateModelVo getDeliverableSetting(DeliverableSettingModel deliverableSettingModel);
	

	Object test(Long taskId);
	
	 /*
     * 获取我的任务草稿，如果我的任务仅是子任务，则返回当前子任务的父任务带所有子任务的列表
     */
	BasePageInfo<TaskAndSonTaskModelVo> selectMyDrawfTaskList(TaskBasePageInfo<TaskAndSonTaskModelVo> page);
	/*
	 * 获取我负责的任务，如果我的任务仅是子任务，则返回当前子任务的父任务带所有子任务的列表
	 */
	BasePageInfo<TaskAndSonTaskModelVo> selectMyResponibleTaskTempList(TaskBasePageInfo<TaskAndSonTaskModelVo> page);
	/*
	 * 获取分配给我的任务，如果我的任务仅是子任务，则返回当前子任务的父任务带所有子任务的列表
	 */
	BasePageInfo<TaskAndSonTaskModelVo> selectDispatchToMeTaskTempList(TaskBasePageInfo<TaskAndSonTaskModelVo> page);
	/*
	 * 获取我分配的任务，如果我的任务仅是子任务，则返回当前子任务的父任务带所有子任务的列表
	 */
	BasePageInfo<TaskAndSonTaskModelVo> selectDispatchByMeTaskTempList(TaskBasePageInfo<TaskAndSonTaskModelVo> page);
	/*
	 * 获取我参与的任务，如果我的任务仅是子任务，则返回当前子任务的父任务带所有子任务的列表
	 */
	BasePageInfo<TaskAndSonTaskModelVo> selectMyParticipantTaskTempList(TaskBasePageInfo<TaskAndSonTaskModelVo> page);
	/*
	 * 我关注的任务
	 */
	BasePageInfo<TaskAndSonTaskModelVo> selectMyAttentionTaskTempList(TaskBasePageInfo<TaskAndSonTaskModelVo> page);
	/*
	 * 我关注的任务
	 */
	BasePageInfo<TaskAndSonTaskModelVo> selectMyCommentTaskTempList(TaskBasePageInfo<TaskAndSonTaskModelVo> page);
	/*
	 * 我关注的任务
	 */
	BasePageInfo<TaskAndSonTaskModelVo> selectNeedToCommentTaskTempList(TaskBasePageInfo<TaskAndSonTaskModelVo> page);
	
	List<EmpTreeModelVo> selectByOrgIdAndParentId();
}
