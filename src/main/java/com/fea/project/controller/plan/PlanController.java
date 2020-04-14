package com.fea.project.controller.plan;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.enums.plan.PlanTypeEnum;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.baseconfig.ProjectCodePLanRegChildModel;
import com.fea.project.model.plan.PlanHeadStatusModel;
import com.fea.project.model.plan.PlanModel;
import com.fea.project.model.plan.vo.BaseProjectUserInfo;
import com.fea.project.model.plan.vo.PlanAndSonPlanModelVo;
import com.fea.project.model.plan.vo.PlanWithAllAppendixModelVO;
import com.fea.project.model.plan.vo.ProjectUserIdAndNameInfoModelVO;
import com.fea.project.model.project.ProjectModel;
import com.fea.project.model.user.ProjectUserModel;
import com.fea.project.service.baseconfig.ProjectCodePLanRegChildService;
import com.fea.project.service.plan.IPlanHeadStatusService;
import com.fea.project.service.plan.IPlanService;
import com.fea.project.service.project.ProjectService;
import com.fea.project.service.user.ProjectUserService;
import com.github.pagehelper.PageHelper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/*
 * 计划模型控制器
 */ 
@RestController
@RequestMapping("/plan")
public class PlanController {
  
	@Resource
	private IPlanService service;
	
	@Resource
	private ProjectUserService projectUserService;
	
	@Resource
	private ProjectService projectService;
	
	@Resource
	private IPlanHeadStatusService planHeadStatusService;
	
	@Resource
	private SysUserService sysUserService;
	
	@Resource
	private ProjectCodePLanRegChildService projectCodePLanRegChildService;
	
	/*
	 * 获取计划编号
	 */
	@GetMapping("/getPlanNum")
	public Map<String,Object> getPlanNum(ProjectCodePLanRegChildModel model) {
		Map<String,Object> map = new HashMap<String, Object>();
		String selectPlanCode = projectCodePLanRegChildService.selectPlanCode(model);
		map.put("planNum", selectPlanCode);
		return map;
		
	}
	
	
	/*
	 * 新增
	 */
	@RequestMapping("/insert")
	public PlanModel save(@RequestBody PlanWithAllAppendixModelVO model){
		return service.save(model.getModel(),model);
	}
	
	/*
	 * 删除
	 */
	@RequestMapping("/delete")
	public Map<String,Object> delete(@RequestBody PlanModel planModel){
		if ( planModel==null || planModel.getPlanId() == null ) {
            throw new SystemParamCheckException("参数传入异常，无法进行删除");
        }
		return service.delete(planModel.getPlanId());
	}
	

	
	
	/*
	 * 修改
	 */
	@RequestMapping("/update")
	public Map<String,Object> update(@RequestBody PlanWithAllAppendixModelVO model){
		return service.update(model.getModel(),model);
	}
	
	/*
	 * 获取所有非删除状态的模型对象集合
	 */
	@RequestMapping
	public Map<String,Object> getAll(@RequestBody BasePageInfo<PlanAndSonPlanModelVo> page){
		/*
		 * 在获取计划列表的同时，按照默认方式默认新建计划表头
		 */
		if(planHeadStatusService.getOne(sysUserService.getCurrentUsr().getUserId()) == null) {
			planHeadStatusService.save(new PlanHeadStatusModel(sysUserService.getCurrentUsr().getUserId()));
		}
		return service.getPlanWithoutParentPlanId(page);
	}
	
	/*
	 * 获取一个
	 */
	@RequestMapping("/getOne")
	public Map<String,Object> getOne(Long planId){
		return service.getOne(planId);
	}
	
	@RequestMapping("/selectUserListByProjectId")
    public List<SysUserModel> selectUserListByProjectId(@RequestBody ProjectUserModel model) {
        return this.projectUserService.selectUserListByProjectId(model);
    }
	
	/*
	 * 通过项目id获取所有的父计划
	 */
	@RequestMapping("/getParentPlanByProjectId")
	public Map<String,Object> getParentPlanByProjectId(Long projectId){
		System.out.println("PlanController.getParentPlanByProjectId()"+projectId);
		return service.getParentPlanByProjectId(projectId);
	}
	
	/*
	 * 通过项目id获取所有的父计划
	 */
	@RequestMapping("/getGroupLeaderByProjectId")
	public Map<String,Object> getGroupLeaderByProjectId(Long projectId){
		return service.getGroupLeaderByProjectId(projectId);
	}
	
	/*
	 * 通过项目id,返回项目信息
	 */
	@RequestMapping("/getProjectInfoByProjectId")
	public ProjectModel getProjectInfoByProjectId(@RequestBody ProjectModel projectModel) throws Exception{
		return projectService.selectOne(projectModel, false);
	}
	
	/*
	 * 传入用户id,返回此用户所有的计划
	 */
	@RequestMapping("/getSelfPlanByCreateId")
	public Map<String,Object> getSelfPlanByCreateId(Long createId) throws Exception{
		return service.getSelfPlanByCreateId(createId);
	}
	
	
	
	
	/*
	 * 通过项目id查找项目用户信息结构集合
	 */
	@RequestMapping("/getProjectUserInfoByBaseProjectUserInfo")
	public List<ProjectUserIdAndNameInfoModelVO> getProjectUserInfoByBaseProjectUserInfo(@RequestBody BaseProjectUserInfo baseProjectUserInfo) throws Exception{
		return service.getProjectUserInfoByBaseProjectUserInfo(baseProjectUserInfo);
	}
	
	/*
	 * 通过项目Id
	 */
	@RequestMapping("/getProjectUserInfoByProjectIdAndUserId")
	public List<ProjectUserIdAndNameInfoModelVO> getProjectUserInfoByProjectIdAndUserId(@RequestBody BaseProjectUserInfo baseProjectUserInfo) throws Exception{
		return service.getProjectUserInfoByProjectIdAndUserId(baseProjectUserInfo);
	}
	
	@GetMapping("/getProjectTree")
	public Map<String,Object> getProjectTree(Long projectId){
		return service.getProjectTree_V1(projectId);
	}
	
	@GetMapping("/getParticipants")
	public Map<String,Object> getParticipants(Long projectId){
		return service.getProjectTree_V1(projectId);
	}
	
	/*
	 * 通过项目Id，团队Id，负责人Id来查找计划列表
	 */
	@PostMapping("/getPlanByProjectIdOrPlanTeamIdOrPlanLeaderId")
	public BasePageInfo<PlanAndSonPlanModelVo> getPlanByProjectIdOrPlanTeamIdOrPlanLeaderId(@RequestBody BasePageInfo<PlanAndSonPlanModelVo> page){
		return service.selectPlanByProjectIdOrPlanTeamIdOrPlanLeaderId(page);
	}
	
	
	
	@PostMapping("/getChildrenPlan")
	public Object getChildrenPlan(@RequestBody BasePageInfo<PlanAndSonPlanModelVo> page){
		if(page==null || page.getModel().getPlanId() == null) {
			throw new SystemParamCheckException("传入参数异常，无法进行查询");
		}
		PageHelper.startPage(page.getPageNum(), page.getPageSize(), true);
		List<PlanAndSonPlanModelVo> sonPlanModel = service.getSonPlanModel(page.getModel());
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("ChildrenPlan", new BasePageInfo<>(sonPlanModel));
		return map; 
	}
	
	
	@PostMapping("/test")
	public Object test(@RequestBody PlanModel planModel){
		return service.getProjectTree_V1(planModel.getProjectId()); 
	}
	
	
	//已生成计划，仅实现项目申请流程
	@PostMapping("/planApplyFlow")
	public PlanModel planApplyFlow(@RequestBody PlanModel planModel) {
		if(Objects.equals(planModel.getPlanType().intValue(), PlanTypeEnum.TEAM_PLAN.getStatus().intValue())) {
			 service.teamPlanApplyFlow(planModel);
		}else if(Objects.equals(planModel.getPlanType().intValue(), PlanTypeEnum.TEAMER_PLAN.getStatus().intValue())) {
			 service.teamerPlanApplyFlow(planModel);
		}else {
			 service.planApplyFlow(planModel);
		}
		return planModel;
	}
	
	
	//查询当前所有未审批的计划，对计划进行一次性提交
	@PostMapping("/ApplyFlowByUncommitPlanList")
	public void ApplyFlowByUncommitPlanList(@RequestBody PlanModel model) {
		List<PlanModel> list = service.selectUnCommitPlanList(model);
		list.stream().forEach(planModel ->{
			if(Objects.equals(planModel.getPlanType().intValue(), PlanTypeEnum.TEAM_PLAN.getStatus().intValue())) {
				 service.teamPlanApplyFlow(planModel);
			}else if(Objects.equals(planModel.getPlanType().intValue(), PlanTypeEnum.TEAMER_PLAN.getStatus().intValue())) {
				 service.teamerPlanApplyFlow(planModel);
			}else {
				 service.planApplyFlow(planModel);
			}
		});
	}
	
	
	//对计划并同时提交审批
		@PostMapping("/insertPlanThenApplyFlow")
		public PlanModel insertPlanThenApplyFlow(@RequestBody PlanWithAllAppendixModelVO model) {
			PlanModel planModel = model.getModel();
			service.save(planModel, model);
			if(Objects.equals(planModel.getPlanType().intValue(), PlanTypeEnum.TEAM_PLAN.getStatus().intValue())) {
				 service.teamPlanApplyFlow(planModel);
			}else if(Objects.equals(planModel.getPlanType().intValue(), PlanTypeEnum.TEAMER_PLAN.getStatus().intValue())) {
				 service.teamerPlanApplyFlow(planModel);
			}else {
				 service.planApplyFlow(planModel);
			}
			return planModel;
		}
	//变更计划并同时提交审批
	@PostMapping("/updatePlanThenApplyFlow")
	public PlanModel updatePlanThenApplyFlow(@RequestBody PlanWithAllAppendixModelVO model) {
		PlanModel planModel = model.getModel();
		service.update(model.getModel(), model);
		if(Objects.equals(planModel.getPlanType().intValue(), PlanTypeEnum.TEAM_PLAN.getStatus().intValue())) {
			service.teamPlanChangeFlow(planModel);
		}else if(Objects.equals(planModel.getPlanType().intValue(), PlanTypeEnum.TEAMER_PLAN.getStatus().intValue())) {
			service.teamerPlanChangeFlow(planModel);
		}else {
			service.planChangeFlow(planModel);
		}
		return planModel;
	}
	
	 /**
     * 获取项目经理个人计划
     */
	@PostMapping("/selectListByPMPerson") 
    public BasePageInfo<PlanAndSonPlanModelVo> selectListByPMPerson(@RequestBody BasePageInfo<PlanAndSonPlanModelVo> page){
    	return service.selectListByPMPerson(page); 
    }
	
	/**
	 * 获取项目经理下的项目计划
	 */
	@PostMapping("/selectProjectPlanListByprojectId")
	public BasePageInfo<PlanAndSonPlanModelVo> selectProjectPlanListByprojectId(@RequestBody BasePageInfo<PlanAndSonPlanModelVo> page){
		System.out.println(page.getModel().getProjectId() +"  "+ page.getModel().getCreateId());
		return service.selectProjectPlanListByprojectId(page); 
	}
	
	/**
	 * 获取当前团队的计划列表
	 */
	@PostMapping("/selectTeamPlanListByTeamId")
	public BasePageInfo<PlanAndSonPlanModelVo> selectTeamPlanListByTeamId(@RequestBody BasePageInfo<PlanAndSonPlanModelVo> page){
		return service.selectTeamPlanListByTeamId(page); 
	}
	/**
	 * 获取当前团队的计划列表
	 */
	@PostMapping("/selectTeamLeaderPlanListByTeamLeaderId")
	public BasePageInfo<PlanAndSonPlanModelVo> selectTeamLeaderPlanListByTeamLeaderId(@RequestBody BasePageInfo<PlanAndSonPlanModelVo> page){
		return service.selectTeamLeaderPlanListByTeamLeaderId(page); 
	}
	
	/**
	 * 获取当前团队的计划列表
	 */
	@PostMapping("/selectLeaderPlanListByLeaderId")
	public BasePageInfo<PlanAndSonPlanModelVo> selectLeaderPlanListByLeaderId(@RequestBody BasePageInfo<PlanAndSonPlanModelVo> page){
		return service.selectLeaderPlanListByLeaderId(page); 
	}
	
}
