package com.fea.project.service.plan;

import com.fea.project.model.BasePageInfo;
import com.fea.project.model.apply.ProjectApplyModel;
import com.fea.project.model.config.ProjectConfigModel;
import com.fea.project.model.plan.PlanModel;
import com.fea.project.model.plan.vo.*;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface IPlanService {

	PlanModel save(PlanModel planModel,PlanWithAllAppendixModelVO model);
	Map<String,Object> delete(Long planId);
	Map<String,Object> update(PlanModel planModel,PlanWithAllAppendixModelVO model);
	Map<String,Object> getAll(BasePageInfo<PlanModel> page);
	Map<String,Object> getOne(Long planId);
	PlanModel selectOne(Long planId);
	Map<String,Object> getParentPlanByProjectId(Long projectId);
	Map<String,Object> getGroupLeaderByProjectId(Long projectId);
	Map<String,Object> getSelfPlanByCreateId(Long createId);
	List<ProjectUserIdAndNameInfoModelVO> getProjectUserInfoByBaseProjectUserInfo(BaseProjectUserInfo baseProjectUserInfo);
	List<ProjectUserIdAndNameInfoModelVO> getProjectUserInfoByProjectIdAndUserId(BaseProjectUserInfo baseProjectUserInfo);
	
	Map<String, Object> getProjectTree_V1(Long projectId);
	
	List<PlanAndSonPlanModelVo> getSonPlanModel(PlanAndSonPlanModelVo planAndSonPlanModelVo);
	Map<String,Object> getPlanWithoutParentPlanId(BasePageInfo<PlanAndSonPlanModelVo> page);
	List<AppendixIdAndNameInfoModelVo> selectAppendixIDAndNameInfoByBusinessId(Long businessId);
	BasePageInfo<PlanAndSonPlanModelVo> selectPlanByProjectIdOrPlanTeamIdOrPlanLeaderId(BasePageInfo<PlanAndSonPlanModelVo> page);
	Object test();
	/**
	 * 获取里程碑关联计划
	 */
	List<PlanAndSonPlanModelVo> selectPlanModelByMilestoneId(Long milestoneId);
	/**
	 * 删除里程碑关联关系
	 */
	int cancelMilestone(List<Long> ids);
	
	/**
	 * 计划申请审批流程
	 */
	PlanModel planApplyFlow(PlanModel planModel);
	
	/**
	 * 计划变更审批流程
	 */
	PlanModel planChangeFlow(PlanModel planModel);
	
	/**
	 * 团队计划申请审批流程
	 */
	PlanModel teamPlanApplyFlow(PlanModel planModel);
	
	/**
	 * 团队计划变更时审批流程
	 */
	PlanModel teamPlanChangeFlow(PlanModel planModel);
	
	/**
	 * 团队成员申请时审批流程
	 */
	PlanModel teamerPlanApplyFlow(PlanModel planModel);
	
	/**
	 * 团队成员变更时审批流程
	 */
	PlanModel teamerPlanChangeFlow(PlanModel planModel);
	
	/**
	 * 按主键获取任务模型
	 */
	PlanModel selectOneByPlanId(Long planId);
	
	 /**
     * 获取所有的未审批的计划列表
     */
    List<PlanModel> selectUnCommitPlanList(PlanModel model);
    
    /**
     * 获取项目经理个人计划
     */
    BasePageInfo<PlanAndSonPlanModelVo> selectListByPMPerson(BasePageInfo<PlanAndSonPlanModelVo> page);
    /**
     * 获取当前项目经理的项目计划
     */
    BasePageInfo<PlanAndSonPlanModelVo> selectProjectPlanListByprojectId(BasePageInfo<PlanAndSonPlanModelVo> page);
    /**
     * 获取当前团队计划列表
     */
    BasePageInfo<PlanAndSonPlanModelVo> selectTeamPlanListByTeamId(BasePageInfo<PlanAndSonPlanModelVo> page);
    /**
     * 获取当前团队负责人列表
     */
    BasePageInfo<PlanAndSonPlanModelVo> selectTeamLeaderPlanListByTeamLeaderId(BasePageInfo<PlanAndSonPlanModelVo> page);
    /**
     * 获取当前成员计划列表
     */
    BasePageInfo<PlanAndSonPlanModelVo> selectLeaderPlanListByLeaderId(BasePageInfo<PlanAndSonPlanModelVo> page);
    
 
}
 