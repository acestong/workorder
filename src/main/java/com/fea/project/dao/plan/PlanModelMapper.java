package com.fea.project.dao.plan;

import com.fea.project.model.BasePageInfo;
import com.fea.project.model.plan.PlanModel;
import com.fea.project.model.plan.PlanModelExample;
import com.fea.project.model.plan.vo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PlanModelMapper {
    long countByExample(PlanModelExample example);

    int deleteByExample(PlanModelExample example);
 
    int deleteByPrimaryKey(Long planId);

    int insert(PlanModel record);

    int insertSelective(PlanModel record);

    List<PlanModel> selectByExample(PlanModelExample example);
 
    PlanModel selectByPrimaryKey(Long planId);

    int updateByExampleSelective(@Param("record") PlanModel record, @Param("example") PlanModelExample example);

    int updateByExample(@Param("record") PlanModel record, @Param("example") PlanModelExample example);

    int updateByPrimaryKeySelective(PlanModel record);

    int updateByPrimaryKey(PlanModel record);
    
    /*
     * 存放未删除状态的计划模型集合
     */
    List<PlanModel> selectByExampleWithDelStatus(PlanModelExample example);
    
    /*
     * 存放未删除状态的单个计划模型
     */
    PlanAndSonPlanModelVo selectByPrimaryKeyWithDelStatus(Long planId);
    
    /*
     * 修改删除状态为已删除（delStatus状态由0改为1）
     */
    int updateByPrimaryKeySelectiveWithDelStatus(PlanModel record);
    
    /*
     * 通过项目id查找所有的计划，当前计划还未生成，故当前计划不在列表之内
     */
    List<PlanNameInfoModelVO> selectParentPlanByProjectId(Long projectId);
    
    /*
     * 通过项目id查找所有的项目团队及其负责人
     */
    List<TeamLeaderAndGroupInfoModelVO> selectGroupLeaderByProjectId(Long projectId);
    
    
    /*
     * 通过登录人id查找所有的项目团队及其负责人
     */
    List<PlanModel> selectSelfPlanByCreateId(Long createId);
    
    /*
     * 通过projectId，teamId,userId获取到项目下的用户id及Name结构集合
     */
    
    List<ProjectUserIdAndNameInfoModelVO> selectProjectUserInfoByBaseProjectUserInfo(BaseProjectUserInfo baseProjectUserInfo);
    
    /*
     * 通过projectId，和,userId获取到项目下的用户id及Name结构集合
     */
    List<ProjectUserIdAndNameInfoModelVO> selectProjectUserInfoByProjectIdAndUserId(BaseProjectUserInfo baseProjectUserInfo);
    
    
    List<PlanModel> selectAllWithOrderBy(BasePageInfo page);
    
    /*
     * 通过项目Id查找项目ID及项目名
     */
    ProjectUserIdAndNameInfoModelVO selectProjectIdAndName(Long projectId);
    
    /*
     * 通过项目Id查找团队ID及项目名
     */
    List<ProjectUserIdAndNameInfoModelVO> selectTeamIdAndName(Long projectId);
    
    /*
     * 通过项目Id及团队Id查找团队成员ID及姓名
     */
    List<ProjectUserIdAndNameInfoModelVO> selectUserIdAndName(ProjectUserIdAndNameInfoModelVO model);
    
    
    
    /**
     * 通过项目Id获取到当前项目下所有的用户，实现参与人功能
     */
    List<PlanParticipantInfoModelVo> selectParticipantInfo(Long projectId);
    
   /**
    * 通过条件Id 查询计划列表
    */
    List<PlanModel> selectPlanListByConditionId(BasePageInfo<PlanModel> page);
    
    /**
     * 查询所有无父计划的计划 
     */
    List<PlanAndSonPlanModelVo> selectPlanWithoutParentId(BasePageInfo<PlanAndSonPlanModelVo> page);
    
    /**
     * 通过项目Id，团队Id或者负责人Id查询所有的父计划
     */
    List<PlanAndSonPlanModelVo> selectPlanByProjectIdOrPlanTeamIdOrPlanLeaderId(BasePageInfo<PlanAndSonPlanModelVo> page);
    
    /**
     * 通过父计划planId 查询所有的子计划
     */
    List<PlanAndSonPlanModelVo> selectSonPlanModel(PlanAndSonPlanModelVo planAndSonPlanModelVo);
    
    /**
     * 通过业务Id获取到附件Id和名称
     */
    List<AppendixIdAndNameInfoModelVo> selectAppendixIDAndNameInfoByBusinessId(Long businessId);
    /**
     * 通过里程碑id获取计划列表
     */
    List<PlanAndSonPlanModelVo> selectPlanModelByMilestoneId(@Param("milestoneId")Long milestoneId);
    /**
     * 删除里程碑关联关系
     */
    int cancelMilestone(List<Long> ids);
    /**
     * 通过Id集合返回计划模型集合
     */
    List<PlanModel> selectListByIds(List<Long> ids);
    /**
     * 获取所有的未审批的计划列表
     */
    List<PlanModel> selectUnCommitPlanList(PlanModel model);
    /**
     * 通过一条计划Id获取一条非删除状态的计划模型
     */
    PlanModel selectOneByPlanId(Long planId);
    /**
     * 通过计划id获取参与人id以及姓名集合
     */
    List<ProjectUserIdAndNameInfoModelVO> selectParticipantInfos(Long planId);
    
    /**
     * 获取项目经理个人计划
     */
    List<PlanAndSonPlanModelVo> selectListByPMPerson(BasePageInfo<PlanAndSonPlanModelVo> page);
    /**
     * 获取当前项目经理的项目计划
     */
    List<PlanAndSonPlanModelVo> selectProjectPlanListByprojectId(BasePageInfo<PlanAndSonPlanModelVo> page);
    /**
     * 获取当前团队计划列表
     */
    List<PlanAndSonPlanModelVo> selectTeamPlanListByTeamId(BasePageInfo<PlanAndSonPlanModelVo> page);
    /**
     * 获取项目团队负责人的计划列表
     */
    List<PlanAndSonPlanModelVo> selectTeamLeaderPlanListByTeamLeaderId(BasePageInfo<PlanAndSonPlanModelVo> page);
    /**
     * 获取当前成员的计划列表
     */
    List<PlanAndSonPlanModelVo> selectLeaderPlanListByLeaderId(BasePageInfo<PlanAndSonPlanModelVo> page);
}