package com.fea.project.controller.task;

import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.baseconfig.ProjectCodeTaskRegChildModel;
import com.fea.project.model.project.vo.ProjectStepVo;
import com.fea.project.model.task.CommentSettingModel;
import com.fea.project.model.task.DeliverableSettingModel;
import com.fea.project.model.task.TaskHeadStatusModel;
import com.fea.project.model.task.TaskModel;
import com.fea.project.model.task.vo.TaskAndSonTaskModelVo;
import com.fea.project.model.task.vo.TaskBasePageInfo;
import com.fea.project.model.task.vo.TaskWithAllAppendixModelVo;
import com.fea.project.service.baseconfig.ProjectCodeTaskRegChildService;
import com.fea.project.service.task.ITaskHeadStatusService;
import com.fea.project.service.task.ITaskService;
import com.github.pagehelper.PageHelper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/task")
public class TaskController {

	@Resource
	private ITaskService service;
	
	@Resource
	private ProjectCodeTaskRegChildService projectCodeTaskRegChildService;
	
	@Resource
	private ITaskHeadStatusService taskHeadStatusService;
	
	 
	@PostMapping("/insert")
	public Map<String,Object> save(@RequestBody TaskWithAllAppendixModelVo modelVo){
		/*
		 * 新增一条任务的同时，即增加改业务类型下 对该用户的任务表头增加一条默认的设置
		 */
		TaskHeadStatusModel type = taskHeadStatusService.selectByCurUserIdAndTaskResourceType(modelVo.getModel().getTaskResourceType());
		if(type == null){
			TaskHeadStatusModel taskHeadStatusModel = new TaskHeadStatusModel(modelVo.getModel().getTaskResourceType());
			taskHeadStatusService.save(taskHeadStatusModel);
		}
		return service.save(modelVo.getModel(),modelVo);
	}
	
	/*
	 * 获取任务编号
	 */
	@GetMapping("/getTaskNum")
	public String getTaskNum(ProjectCodeTaskRegChildModel model) {
		return projectCodeTaskRegChildService.selectTaskCode(model);
	}
	
	
	/*
	 * 获取父任务集合
	 */
	@GetMapping("/getParentTaskList")
	public Map<String,Object> getParentTaskList(Long projectId,Long resourceBusinessId){
		return service.getParentTaskModelByProjectId(projectId,resourceBusinessId);
	}
	
	/*
	 * 通过项目Id获取参与人集合,传入projectId时，返回项目参与人，不传时返回非项目任务的参与人
	 */
	@GetMapping("/getParticipants")
	public Object getParticipants(Long projectId){
		if(projectId != null) {
			return service.getProjectTree_V1(projectId);
		}else {
			return service.selectByOrgIdAndParentId();
		}
		
	}
	
	/*
	 * 通过项目Id获取团队负责人集合
	 */
	@GetMapping("/getGroupLeaderByProjectId")
	public Map<String,Object> getGroupLeaderByProjectId(Long projectId){
			return service.getGroupLeaderByProjectId(projectId);
	}
	
	/*
	 * 通过任务Id获取一条带子任务的任务 
	 */
	@GetMapping("/getOne")
	public Map<String,Object> getOne(Long taskId){
		return service.getOne(taskId);
	}
	
	/*
	 * 通过任务Id修改一条任务
	 */
	@PostMapping("/update")
	public void update(@RequestBody TaskWithAllAppendixModelVo model){
		 service.update(model.getModel(),model);
	}
	
	/*
	 * 获取当前父任务Id下，所有子任务，不包含父任务
	 */
	@PostMapping("/getChildrenTask")
	public Object getChildrenTask(@RequestBody BasePageInfo<TaskAndSonTaskModelVo> page) {
		if(page == null || page.getModel().getTaskId()==null) {
			throw new SystemParamCheckException("传入参数异常，无法进行查询");
		}
		Map<String,Object> map = new HashMap<>();
		PageHelper.startPage(page.getPageNum(), page.getPageSize(), true);
		List<TaskAndSonTaskModelVo> sonPlanModel = service.getSonPlanModel(page.getModel());
		map.put("ChildrenList", new BasePageInfo<>(sonPlanModel));
		return map;
	}
	
	/*
	 * 获取当前任务下，所有子任务的得分
	 */
	@GetMapping("/getChildrenAvgScore")
	public Double getChildrenAvgScore(Long taskId) {
		return service.getChildrenAvgScore(taskId);
	}
	
	/*
	 * 获取项目优先级Id以及name
	 */
	@GetMapping("/getProjectPority")
	public Object getProjectPority() {
		return service.getProjectPority();
	}
	
	/*
	 * 获取项目阶段id及name;
	 */
	@GetMapping("/getStepInfo")
	public List<ProjectStepVo> getStepInfo(Long projectId) {
		return service.getStepInfo(projectId);
	}
	
	@GetMapping("/getTaskLeftNavigationInfo")
	public Object getTaskLeftNavigationInfo(TaskModel taskModel) {
		return service.getTaskLeftNavigationInfo(taskModel);
	}
	
	
	
	@RequestMapping("/getTaskByProjectStepAndProjectId")
	public Object getTaskByProjectStepAndProjectId(@RequestBody TaskModel taskModel) {
		return service.getTaskByProjectStepAndProjectId(taskModel);
	}
	
	
	@GetMapping("/getProjectTree") 
	public Object getProjectTree(Long projectId) {
		if(projectId != null) {
			//返回团队列表
			return service.getProjectTree_V1(projectId);
		}else {
			//返回当前公司组织架构
			return service.selectByOrgIdAndParentId();
		}
	}
	
	
	@PostMapping("/getParentTaskByGroupCondition") 
	public Object getParentTaskByGroupCondition(@RequestBody BasePageInfo<TaskAndSonTaskModelVo> page) {
		return service.getParentTaskByGroupCondition(page);
	}
	
	

	@PostMapping("/getTaskByProjectId")
	public BasePageInfo<TaskAndSonTaskModelVo> getTaskByProjectId(@RequestBody BasePageInfo<TaskAndSonTaskModelVo> page) {
			return service.getTaskByProjectId(page);
	}
	

	/*
	 * 按照条件获取我的任务列表V2优化版本
	 */
	@PostMapping("/getMyTaskList")
	public Map<String,Object> test(@RequestBody TaskBasePageInfo<TaskAndSonTaskModelVo> page) {
		Map<String,Object> map = new HashMap<String, Object>();
		BasePageInfo<TaskAndSonTaskModelVo> modelVo = null;
		switch (page.getType()) {
		case 1:
			 modelVo = service.selectMyDrawfTaskList(page);
			break;
		case 2:
			modelVo = service.selectMyResponibleTaskTempList(page);
			break;
		case 3:
			modelVo = service.selectDispatchToMeTaskTempList(page);
			break;
		case 4:
			modelVo = service.selectDispatchByMeTaskTempList(page);
			break;
		case 5:
			modelVo = service.selectMyParticipantTaskTempList(page);
			break;
		case 6:
			modelVo = service.selectMyAttentionTaskTempList(page);
			break;
		case 7:
			modelVo = service.selectMyCommentTaskTempList(page);
			break;
		case 8:
			modelVo = service.selectNeedToCommentTaskTempList(page);
			break;

		default:
			break;
		}
		map.put("taskList", modelVo);
		return map;
	}
	
	
	@PostMapping("/getCommentSetting")
	public Object getCommentSetting(@RequestBody CommentSettingModel commentSettingModel) {
		return service.getCommentSetting(commentSettingModel);
	}
	
	@PostMapping("/getDeliverableSetting")
	public Object getDeliverableSetting(@RequestBody DeliverableSettingModel deliverableSettingModel) {
		return service.getDeliverableSetting(deliverableSettingModel);
	}
	
	@GetMapping("/selectTaskName")
	public Object selectTaskName(Long taskId) {
		return service.test(taskId);
	}
	
	/**
	 * 删除
	 */
	@GetMapping("/delete")
	public void delete(Long taskId) {
		service.delete(taskId);
	}
}
