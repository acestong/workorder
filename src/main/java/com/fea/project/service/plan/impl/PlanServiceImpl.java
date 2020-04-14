package com.fea.project.service.plan.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.plan.PlanModelMapper;
import com.fea.project.enums.apply.ProjectApplyVerifyStatusEnum;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.enums.config.ProjectConfigEnum;
import com.fea.project.enums.plan.PlanAppendixTypeEnum;
import com.fea.project.enums.plan.PlanCheckStatusEnum;
import com.fea.project.enums.plan.PlanPorityEnum;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.apply.ProjectApplyModel;
import com.fea.project.model.baseconfig.ProjectCodePLanRegChildModel;
import com.fea.project.model.config.ProjectConfigModel;
import com.fea.project.model.plan.DeliverRequirementModel;
import com.fea.project.model.plan.PlanAppendixModel;
import com.fea.project.model.plan.PlanAssociationModel;
import com.fea.project.model.plan.PlanModel;
import com.fea.project.model.plan.PlanParticipantModel;
import com.fea.project.model.plan.QualityRequirementModel;
import com.fea.project.model.plan.ReportRequirementModel;
import com.fea.project.service.appendix.ProjectAppendixService;
import com.fea.project.service.apply.ProjectApplyService;
import com.fea.project.service.apply.io.IProjectApplyBusiness;
import com.fea.project.model.plan.*;
import com.fea.project.model.plan.vo.*;
import com.fea.project.service.base.ProjectDictionaryItemService;
import com.fea.project.service.baseconfig.ProjectCodePLanRegChildService;
import com.fea.project.service.plan.*;
import com.fea.project.service.businessflow.flowtype.ProjectBusinessPlanApplyImplService;
import com.fea.project.service.businessflow.flowtype.ProjectBusinessPlanChangeApplyImplService;
import com.fea.project.service.businessflow.flowtype.ProjectBusinessTeamPlanApplyImplService;
import com.fea.project.service.businessflow.flowtype.ProjectBusinessTeamPlanChangeApplyImplService;
import com.fea.project.service.businessflow.flowtype.ProjectBusinessTeamerPlanApplyImplService;
import com.fea.project.service.businessflow.flowtype.ProjectBusinessTeamerPlanChangeApplyImplService;
import com.fea.project.service.config.ProjectConfigService;
import com.fea.project.service.plan.IDeliverRequirementService;
import com.fea.project.service.plan.IPlanAppendixService;
import com.fea.project.service.plan.IPlanAssociationService;
import com.fea.project.service.plan.IPlanParticipantService;
import com.fea.project.service.plan.IPlanService;
import com.fea.project.service.plan.IQualityRequirementService;
import com.fea.project.service.plan.IReportRequirementService;
import com.fea.project.service.project.ProjectService;
import com.fea.project.service.project.ProjectStepService;
import com.fea.project.service.user.ProjectUserService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * 计划模型控制器
 * @author st
 * @since 2019/11/1 12:13
 *
 */
@Service
@Transactional
public class PlanServiceImpl implements IPlanService, IProjectApplyBusiness {

	
	@Resource
	private PlanModelMapper mapper;
	
	@Resource
	private ProjectUserService userService;
	
	@Resource
	private IPlanParticipantService planParticipantService;
	 
	@Resource
	private SysUserService sysUserService;
	
	@Resource
	private ProjectDictionaryItemService projectDictionaryItemService;
	
	@Resource
	private ProjectStepService projectStepService;
	
	@Resource
	private ProjectService projectService;
	
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
	private ProjectCodePLanRegChildService projectCodePLanRegChildService;

	@Resource
	private ProjectConfigService projectConfigService;
	//流程申请类
	@Resource
	private ProjectApplyService projectApplyService;
	//流程相关类
	@Resource
	private ProjectBusinessPlanApplyImplService projectBusinessPlanApplyImplService;
	@Resource
	private ProjectBusinessPlanChangeApplyImplService projectBusinessPlanChangeApplyImplService;
	@Resource
	private ProjectBusinessTeamPlanApplyImplService projectBusinessTeamPlanApplyImplService;
	@Resource
	private ProjectBusinessTeamPlanChangeApplyImplService projectBusinessTeamPlanChangeApplyImplService;
	@Resource
	private ProjectBusinessTeamerPlanApplyImplService projectBusinessTeamerPlanApplyImplService;
	@Resource
	private ProjectBusinessTeamerPlanChangeApplyImplService projectBusinessTeamerPlanChangeApplyImplService;
	@Resource
	private ProjectAppendixService projectAppendixService;
	
	
	/*
	 * 新增
	 */
	
	@Override
 	public PlanModel save(PlanModel planModel,PlanWithAllAppendixModelVO model) {
		// TODO Auto-generated method stub
		List<Long> tempIds = null;
		Long planIdTemp = null;
		SysUserModel currentUsr = sysUserService.getCurrentUsr();
		planModel.setCreateId(currentUsr.getUserId());
		planModel.setCreateBy(currentUsr.getRealName());
		planModel.setCreateTime(new Date());
		planModel.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus().longValue());
		planModel.setCheckStatus(ProjectApplyVerifyStatusEnum.TYPE_UNCOMMIT.getValue().longValue());
		//  设置计划编号
		ProjectCodePLanRegChildModel planNumModel = new ProjectCodePLanRegChildModel();
		planNumModel.setProjectId(planModel.getProjectId());
		if(planModel.getParentPlanId() == null) {
			planNumModel.setTypeId(1); //传1代表非子计划
		}else {
			planNumModel.setTypeId(2); //传2代表子计划
			planNumModel.setParentPlanId(planModel.getParentPlanId());
		}
		planModel.setPlanNum(projectCodePLanRegChildService.selectPlanCode(planNumModel));
		mapper.insertSelective(planModel);
		planIdTemp = planModel.getPlanId();
		model.setBusinessId(planModel.getPlanId());
		if(null != model.getDeliverRequirementIds()) {
			deliverRequirementService.updateByList(planModel.getPlanId(), model.getDeliverRequirementIds());
		}
		if(null != model.getBusinessAppendixIds()) {
			planAppendixService.updateByList(planModel.getPlanId(), model.getBusinessAppendixIds(), 
					planModel.getPlanName(), planModel.getProjectId(), planModel.getProjectStep());
		}
		if(null != model.getBusinessAssociationIds()) {
			planAssociationService.updateByList(planModel.getPlanId(), model.getBusinessAssociationIds());
		}
		if(null != model.getQualityRequirementIds()) {
			qualityRequirementService.updateByList(planModel.getPlanId(), model.getQualityRequirementIds());
		}
		if(null != model.getReportRequirementIds()) {
			reportRequirementService.updateByList(planModel.getPlanId(), model.getReportRequirementIds());
		}
		if(null != model.getBusinessParticipantUserIds()) {
			List<PlanParticipantModel> list = new ArrayList<>();
			model.getBusinessParticipantUserIds().stream().forEach((userId)->{
				list.add(new PlanParticipantModel(null, planModel.getPlanId(), userId, sysUserService.selectById(userId).getRealName()));
			});
			planParticipantService.insertByList(list);
		}
		return planModel;
	}

	/*
	 * 只修改delStatus状态，数据库实质不做修改
	 */
	@Override
	public Map<String, Object> delete(Long planId) {
		// TODO Auto-generated method stub
		SysUserModel currentUsr = sysUserService.getCurrentUsr();
		Map<String,Object> map = new HashMap<String,Object>();
		PlanModel planModel = null;
		if ( planId == null ) {
            throw new SystemParamCheckException("参数传入异常，无法进行删除");
        }
		planModel = mapper.selectByPrimaryKeyWithDelStatus(planId);
		planModel.setUpdateId(currentUsr.getUserId());
		planModel.setUpdateBy(currentUsr.getRealName());
		planModel.setUpdateTime(new Date());
		mapper.updateByPrimaryKeySelectiveWithDelStatus(planModel);
		return map;
	}

	/*
	 * 修改
	 */
	@Override
	public Map<String, Object> update(PlanModel planModel,PlanWithAllAppendixModelVO model) {
		// TODO Auto-generated method stub
		if ( planModel == null || planModel.getPlanId() ==null) {
            throw new SystemParamCheckException("参数传入异常，无法进行删除");
        }
		Map<String,Object> map = new HashMap<String,Object>();
		planModel.setUpdateId(sysUserService.getCurrentUsr().getUserId());
		planModel.setUpdateBy(sysUserService.getCurrentUsr().getRealName());
		planModel.setUpdateTime(new Date());
		mapper.updateByPrimaryKeySelective(planModel);
		/*
		 * 修改参与人，先删除旧信息，在存入新的信息
		 */
		planParticipantService.deleteByPlanId(planModel.getPlanId());
		if(model.getBusinessParticipantUserIds() !=null) {
			List<PlanParticipantModel> list = new ArrayList<PlanParticipantModel>();
			model.getBusinessParticipantUserIds().stream().forEach((userId)->{
				list.add(new PlanParticipantModel(null, planModel.getPlanId(), userId, sysUserService.selectById(userId).getRealName()));
			});
			planParticipantService.insertByList(list);
		}
		/*
		 * 修改关联计划，先删除旧信息，在存入新的信息
		 */
		planAssociationService.deleteByBusinessId(planModel.getPlanId());
		if(model.getBusinessAssociationIds().size() >0) {
			planAssociationService.updateByList(planModel.getPlanId(), model.getBusinessAssociationIds());
		}
		
		/*
		 * 修改计划附件，先删除旧信息，在存入新的信息
		 */
		planAppendixService.deleteByBusinessId(planModel.getPlanId());
		if(model.getBusinessAppendixIds().size() >0) {
			planAppendixService.updateByList(planModel.getPlanId(), model.getBusinessAppendixIds(), 
					planModel.getPlanName(), planModel.getProjectId(), planModel.getProjectStep());
		}
		/*
		 * 修改交付要求，先删除旧信息，在存入新的信息
		 */
		deliverRequirementService.deleteByBusinessId(planModel.getPlanId());
		if(model.getDeliverRequirementIds().size() >0) {
			deliverRequirementService.updateByList(planModel.getPlanId(), model.getDeliverRequirementIds());
		}
		/*
		 * 修改质量要求，先删除旧信息，在存入新的信息
		 */
		qualityRequirementService.deleteByBusinessId(planModel.getPlanId());
		if(model.getQualityRequirementIds().size() >0) {
			qualityRequirementService.updateByList(planModel.getPlanId(), model.getQualityRequirementIds());
		}
		/*
		 * 修改汇报要求，先删除旧信息，在存入新的信息
		 */
		reportRequirementService.deleteByBusinessId(planModel.getPlanId());
		if(model.getReportRequirementIds().size() >0) {
			reportRequirementService.updateByList(planModel.getPlanId(), model.getReportRequirementIds());
		}
		return map;
	}

	/*
	 * 获取所有为未删除状态（即：delStatus为0的模型集合）
	 */
	@SuppressWarnings("null")
	@Override
	public Map<String, Object> getAll(BasePageInfo<PlanModel> page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page.getPageNum(), page.getPageSize(), true);
		Map<String,Object> map = new HashMap<String,Object>();
		List<PlanModel> selectByExample = mapper.selectAllWithOrderBy(page);
		map.put("selectData", new BasePageInfo<>(selectByExample));
		return map;
	}
	
	


	/*
	 * 获取一个为未删除状态（即：delStatus为0的模型集合）
	 */
	@Override
	public Map<String, Object> getOne(Long planId) {
		// TODO Auto-generated method stub
		if ( planId == null ) {
            throw new SystemParamCheckException("参数传入异常，无法进行删除");
        }
		Map<String,Object> map = new HashMap<String,Object>();
		PlanAndSonPlanModelVo selectByPrimaryKey = mapper.selectByPrimaryKeyWithDelStatus(planId);
		if(selectByPrimaryKey != null) {
			//添加父计划名称
			if(selectByPrimaryKey.getParentPlanId() != null) 
				selectByPrimaryKey.setParentPlanName(this.selectOne(planId).getPlanName());
			//添加优先级str
			if(selectByPrimaryKey.getPriority() != null)
			selectByPrimaryKey.setPriorityStr(PlanPorityEnum.getValue(selectByPrimaryKey.getPriority().intValue()));
			//添加参与人
			selectByPrimaryKey.setPlanParticipantInfos(mapper.selectParticipantInfos(selectByPrimaryKey.getPlanId()));
		}
		/*
		 * 按照枚举的取值，返回枚举的信息
		 */
		map.put("selectData", selectByPrimaryKey);
		return map;
	}
	


	/*
	 * 通过项目Id获取父计划
	 */
	@Override
	public Map<String, Object> getParentPlanByProjectId(Long projectId) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		List<PlanNameInfoModelVO> selectParentPlanByProjectId = mapper.selectParentPlanByProjectId(projectId);
		map.put("parentPlanList", selectParentPlanByProjectId);
		return map;
	}

	/*
	 * 通过计划id,获取团队负责人信息
	 */
	@Override
	public Map<String, Object> getGroupLeaderByProjectId(Long projectId) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		List<TeamLeaderAndGroupInfoModelVO> selectGroupLeaderByProjectId = mapper.selectGroupLeaderByProjectId(projectId);
		selectGroupLeaderByProjectId.stream().forEach((modelVo)->{
			SysUserModel selectById = sysUserService.selectById(modelVo.getGroupLeaderId());
			if(selectById != null)
			modelVo.setGroupLeaderName(selectById.getRealName());
		});
		map.put("teamList", selectGroupLeaderByProjectId);
		return map;
	}

	/*
	 * 通过创建人id，即查找自己的计划信息集合
	 */
	@Override
	public Map<String, Object> getSelfPlanByCreateId(Long createId) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		List<PlanModel> selectSelfPlanByCreateId = mapper.selectSelfPlanByCreateId(createId);
		map.put("selfPlan",selectSelfPlanByCreateId);
		return map;
	}

	

	/*
	 * 通过项目id，teamId，userId查找到所有的项目成员结构
	 */
	@Override
	public List<ProjectUserIdAndNameInfoModelVO> getProjectUserInfoByBaseProjectUserInfo(BaseProjectUserInfo baseProjectUserInfo) {
		// TODO Auto-generated method stub
		List<ProjectUserIdAndNameInfoModelVO> selectProjectUserInfoListByProjectId = mapper.selectProjectUserInfoByBaseProjectUserInfo(baseProjectUserInfo);
		selectProjectUserInfoListByProjectId.stream().forEach((model)->{
			model.setProjectManagerName(sysUserService.selectById(model.getProjectManagerId()).getRealName());
			model.setTeamLeaderName(sysUserService.selectById(model.getTeamLeaderId()).getRealName());
			model.setUserName(sysUserService.selectById(model.getUserId()).getRealName());
		});
		return selectProjectUserInfoListByProjectId;
	}
	
	
	/*
	 * 通过项目id,userId查找到所有的项目成员结构，此方法为加载页面时使用
	 * 
	 */
	@Override
	public List<ProjectUserIdAndNameInfoModelVO> getProjectUserInfoByProjectIdAndUserId(BaseProjectUserInfo baseProjectUserInfo) {
		// TODO Auto-generated method stub
		List<ProjectUserIdAndNameInfoModelVO> selectProjectUserInfoListByProjectId = mapper.selectProjectUserInfoByProjectIdAndUserId(baseProjectUserInfo);
		selectProjectUserInfoListByProjectId.stream().forEach((model)->{
			model.setProjectManagerName(sysUserService.selectById(model.getProjectManagerId()).getRealName());
			model.setTeamLeaderName(sysUserService.selectById(model.getTeamLeaderId()).getRealName());
			model.setUserName(sysUserService.selectById(model.getUserId()).getRealName());
		});
		return selectProjectUserInfoListByProjectId;
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
			 if(projectTreeModelVo.getChildren() != null) {
				 for (ProjectTreeModelVo modelVo : projectTreeModelVo.getChildren()) {
					 recursion(modelVo);
				 }
			 }
		}
		 map.put("ProjectInfo", list);
		return map;
	}
	
	private ProjectTreeModelVo recursion(ProjectTreeModelVo modelVo) {
		if(modelVo.getChildren() != null) {
			if(modelVo.getLeaderId() != null) {
				 ProjectTreeModelVo managerInfo = sysUserService.selectManagerInfo(modelVo.getLeaderId());
				 if(managerInfo != null) {
				 managerInfo.setJob("团队负责人");
				 modelVo.setLeader(sysUserService.selectManagerInfo(modelVo.getLeaderId()));
				 for (ProjectTreeModelVo model : modelVo.getChildren()) {
					 if(sysUserService.selectById(model.getId()) != null)
					model.setLabel(sysUserService.selectById(model.getId()).getRealName());
				}
				 }
			}
			 if(modelVo.getChildren() != null) {
				 for (ProjectTreeModelVo vo : modelVo.getChildren()) {
					 recursion(vo);
				 }
			 }
		}
		return modelVo;
	}

	
	

	
	/*
	 * 查询所有父计划Id不为空的集合
	 */
	@Override
	public Map<String, Object> getPlanWithoutParentPlanId(BasePageInfo<PlanAndSonPlanModelVo> page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page.getPageNum(), page.getPageSize(), true);
		if ( page == null || page.getModel().getProjectId() == null || page.getModel().getPlanType() == null) {
            throw new SystemParamCheckException("id传入异常，无法进行查询");
        }
		List<PlanAndSonPlanModelVo> selectPlanWithoutParentId = mapper.selectPlanWithoutParentId(page);
		if(selectPlanWithoutParentId.size()>0) {
			for (PlanAndSonPlanModelVo planAndSonPlanModelVo : selectPlanWithoutParentId) {
				if(planAndSonPlanModelVo != null) {
					planAndSonPlanModelVo.setChildren(getSonPlanModel(planAndSonPlanModelVo));
					planAndSonPlanModelVo.setCheckStatusStr(ProjectApplyVerifyStatusEnum.getValueNum(planAndSonPlanModelVo.getCheckStatus().intValue()));
					planAndSonPlanModelVo.setPlanParticipantInfos(planParticipantService.getAll(planAndSonPlanModelVo.getPlanId()));
					planAndSonPlanModelVo.setPriorityStr(PlanPorityEnum.getValue(planAndSonPlanModelVo.getPriority().intValue()));
				}
			}
		}
		Map<String,Object> map = new HashMap<>();
		map.put("planModel", selectPlanWithoutParentId);
		return map;
	}

	/*
	 * 无限递归获取子计划
	 */
	@Override
	public List<PlanAndSonPlanModelVo> getSonPlanModel(PlanAndSonPlanModelVo planAndSonPlanModelVo) {
		// TODO Auto-generated method stub
		Long parentPlanId = planAndSonPlanModelVo.getParentPlanId();
		planAndSonPlanModelVo.setParentPlanId(planAndSonPlanModelVo.getPlanId());
		List<PlanAndSonPlanModelVo> selectSonPlanModel = mapper.selectSonPlanModel(planAndSonPlanModelVo);
		if(selectSonPlanModel != null) {
			for (PlanAndSonPlanModelVo planAndSonPlanModelVo2 : selectSonPlanModel) {
				planAndSonPlanModelVo2.setChildren(getSonPlanModel(planAndSonPlanModelVo2));
				if(planAndSonPlanModelVo2.getParentPlanId()!=null) {
					planAndSonPlanModelVo2.setParentPlanName(mapper.selectByPrimaryKeyWithDelStatus(planAndSonPlanModelVo.getParentPlanId()).getPlanName());
				} 
				planAndSonPlanModelVo2.setPlanParticipantInfos(planParticipantService.getAll(planAndSonPlanModelVo.getPlanId()));
				planAndSonPlanModelVo2.setPriorityStr(PlanPorityEnum.getValue(planAndSonPlanModelVo2.getPriority().intValue()));
				planAndSonPlanModelVo2.setCheckStatusStr(ProjectApplyVerifyStatusEnum.getValueNum(planAndSonPlanModelVo2.getCheckStatus().intValue()));
			}
		}
		planAndSonPlanModelVo.setParentPlanId(parentPlanId);
		return selectSonPlanModel;
	}
	
	public Object test() {
		String value = PlanAppendixTypeEnum.getValue(2);
		return value;
	}

	@Override
	public List<AppendixIdAndNameInfoModelVo> selectAppendixIDAndNameInfoByBusinessId(Long businessId) {
		// TODO Auto-generated method stub
		if ( businessId == null) {
            throw new SystemParamCheckException("id传入异常，无法进行查询");
        }
		return mapper.selectAppendixIDAndNameInfoByBusinessId(businessId);
	}

	
	@Override
	public BasePageInfo<PlanAndSonPlanModelVo> selectPlanByProjectIdOrPlanTeamIdOrPlanLeaderId(
			BasePageInfo<PlanAndSonPlanModelVo> page) {
		// TODO Auto-generated method stub
		List<PlanAndSonPlanModelVo> selectPlanByProjectIdOrPlanTeamIdOrPlanLeaderId = mapper.selectPlanByProjectIdOrPlanTeamIdOrPlanLeaderId(page);
		for (PlanAndSonPlanModelVo planAndSonPlanModelVo : selectPlanByProjectIdOrPlanTeamIdOrPlanLeaderId) {
			planAndSonPlanModelVo.setChildren(getSonPlanModel(planAndSonPlanModelVo));
			planAndSonPlanModelVo.setProjectStepStr(( projectStepService.selectById(planAndSonPlanModelVo.getProjectStep())).getName());
			planAndSonPlanModelVo.setPriorityStr((projectDictionaryItemService.selectById(planAndSonPlanModelVo.getPriority())).getName());
			planAndSonPlanModelVo.setCheckStatusStr(PlanCheckStatusEnum.getValue(planAndSonPlanModelVo.getCheckStatus().intValue()));
			planAndSonPlanModelVo.setProjectName(projectService.selectById(planAndSonPlanModelVo.getProjectId()).getName());
			planAndSonPlanModelVo.setPlanParticipantInfos(planParticipantService.getAll(planAndSonPlanModelVo.getPlanId()));
		}
		return new BasePageInfo<>(selectPlanByProjectIdOrPlanTeamIdOrPlanLeaderId);
	}
	/**
	 * 通过里程碑id获取计划列表
	 */
	@Override
	public List<PlanAndSonPlanModelVo> selectPlanModelByMilestoneId(Long milestoneId){
		List<PlanAndSonPlanModelVo> planAndSonPlanModelVos = mapper.selectPlanModelByMilestoneId(milestoneId);
		return planAndSonPlanModelVos;
	}

	/**
	 * 删除里程碑关联关系
	 */
	@Override
	public int cancelMilestone(List<Long> ids){
		int i = mapper.cancelMilestone(ids);
		return i;
	}

	/**
	 * 项目计划新建需要审批时的方法
	 */
	@Override
	public PlanModel planApplyFlow(PlanModel planModel) {
		planModel = mapper.selectOneByPlanId(planModel.getPlanId());
		if(!checkVerifyStatus(planModel)) {
			throw new SystemParamCheckException("当前审批状态无法提交审批");
		}
		planModel.setCheckStatus(ProjectApplyVerifyStatusEnum.TYPE_VERIFYING.getValue().longValue());
		if(this.projectBusinessPlanApplyImplService.createApplyInfo(planModel) &&  mapper.updateByPrimaryKeySelective(planModel)>= 0) {
			return planModel;
		}
		throw new SystemParamCheckException("项目提交审核异常，无法进行提交");
	}
	
	
	/**
	 * 项目计划变更需要审批时的方法
	 */
	@Override
	public PlanModel planChangeFlow(PlanModel planModel) {
		if(planModel.getPlanId()==null) {
			throw new SystemParamCheckException("计划Id传入为空，无法进入审批流程");
		}
		planModel = mapper.selectOneByPlanId(planModel.getPlanId());
//		if(!checkVerifyStatus(planModel)) {
//			throw new SystemParamCheckException("当前审批状态无法提交审批");
//		}
		planModel.setCheckStatus(ProjectApplyVerifyStatusEnum.TYPE_VERIFYING.getValue().longValue());
		if(this.projectBusinessPlanChangeApplyImplService.createApplyInfo(planModel) &&  mapper.updateByPrimaryKeySelective(planModel)>= 0) {
			return planModel;
		}
		throw new SystemParamCheckException("项目提交审核异常，无法进行提交");
	}
	

	/**
	 * 团队计划新建需要审批的方法
	 */
	@Override
	public PlanModel teamPlanApplyFlow(PlanModel planModel) {
		if(planModel.getPlanId()==null) {
			throw new SystemParamCheckException("计划Id传入为空，无法进入审批流程");
		}
		planModel = mapper.selectOneByPlanId(planModel.getPlanId());
		if(!checkVerifyStatus(planModel)) {
			throw new SystemParamCheckException("当前审批状态无法提交审批");
		}
		planModel.setCheckStatus(ProjectApplyVerifyStatusEnum.TYPE_VERIFYING.getValue().longValue());
		if(this.projectBusinessTeamPlanApplyImplService.createApplyInfo(planModel) &&  mapper.updateByPrimaryKeySelective(planModel)>= 0) {
			return planModel;
		}
		throw new SystemParamCheckException("项目提交审核异常，无法进行提交");
	}
	
	/**
	 * 团队计划变更时需要审批的方法
	 */
	@Override
	public PlanModel teamPlanChangeFlow(PlanModel planModel) {
		if(planModel.getPlanId()==null) {
			throw new SystemParamCheckException("计划Id传入为空，无法进入审批流程");
		}
		planModel = mapper.selectOneByPlanId(planModel.getPlanId());
		if(!checkVerifyStatus(planModel)) {
			throw new SystemParamCheckException("当前审批状态无法提交审批");
		}
		planModel.setCheckStatus(ProjectApplyVerifyStatusEnum.TYPE_VERIFYING.getValue().longValue());
		if(this.projectBusinessTeamPlanChangeApplyImplService.createApplyInfo(planModel) &&  mapper.updateByPrimaryKeySelective(planModel)>= 0) {
			return planModel;
		}
		throw new SystemParamCheckException("项目提交审核异常，无法进行提交");
	}
	
	/**
	 * 团队成员计划审批时的方法
	 */
	@Override
	public PlanModel teamerPlanApplyFlow(PlanModel planModel) {
		if(planModel.getPlanId()==null) {
			throw new SystemParamCheckException("计划Id传入为空，无法进入审批流程");
		}
		planModel = mapper.selectOneByPlanId(planModel.getPlanId());
		if(!checkVerifyStatus(planModel)) {
			throw new SystemParamCheckException("当前审批状态无法提交审批");
		}
		planModel.setCheckStatus(ProjectApplyVerifyStatusEnum.TYPE_VERIFYING.getValue().longValue());
		if(this.projectBusinessTeamerPlanApplyImplService.createApplyInfo(planModel) &&  mapper.updateByPrimaryKeySelective(planModel)>= 0) {
			return planModel;
		}
		throw new SystemParamCheckException("项目提交审核异常，无法进行提交");
	}
	
	/**
	 * 团队成员计划变更时审批的方法
	 */
	@Override
	public PlanModel teamerPlanChangeFlow(PlanModel planModel) {
		if(planModel.getPlanId()==null) {
			throw new SystemParamCheckException("计划Id传入为空，无法进入审批流程");
		}
		planModel = mapper.selectOneByPlanId(planModel.getPlanId());
		if(!checkVerifyStatus(planModel)) {
			throw new SystemParamCheckException("当前审批状态无法提交审批");
		}
		planModel.setCheckStatus(ProjectApplyVerifyStatusEnum.TYPE_VERIFYING.getValue().longValue());
		if(this.projectBusinessTeamerPlanChangeApplyImplService.createApplyInfo(planModel) &&  mapper.updateByPrimaryKeySelective(planModel)>= 0) {
			return planModel;
		}
		throw new SystemParamCheckException("项目提交审核异常，无法进行提交");
	}

	/**
	 * 实现IProjectApplyBusiness接口方法，返回计划Id=计划名称map集合
	 */
	@Override
	public Map<? extends Long, ? extends String> getBusinessNameMap(List<Long> ids) {
		// TODO Auto-generated method stub
		List<PlanModel> selectListByIds = mapper.selectListByIds(ids);
		return selectListByIds.stream().collect(Collectors.toMap(PlanModel::getPlanId, PlanModel::getPlanName));
	}

	/**
	 * 传入planId，判断此计划是否为未审批计划，已拒绝，已撤销审批的计划
	 * @param planModel
	 * @return
	 */
	private boolean checkVerifyStatus(PlanModel planModel) {
		System.out.println(planModel);
		 if (ProjectApplyVerifyStatusEnum.getCanSubmitStatus().contains(planModel.getCheckStatus()==null?ProjectApplyVerifyStatusEnum.TYPE_UNCOMMIT.getValue():planModel.getCheckStatus().intValue())){
             return true;
         }
		return false;
	}
	
	public Integer update(PlanModel planModel) {
		return mapper.updateByPrimaryKeySelectiveWithDelStatus(planModel);
	}

	@Override
	public PlanModel selectOneByPlanId(Long planId) {
		// TODO Auto-generated method stub
		if(planId == null) {
			throw new SystemParamCheckException("传入计划Id为空，无法进行查询");
		}
		return mapper.selectOneByPlanId(planId);
	}

	@Override
	public List<PlanModel> selectUnCommitPlanList(PlanModel model) {
		// TODO Auto-generated method stub
		if(model == null || model.getProjectId() == null) {
			throw new SystemParamCheckException("projectId传入异常，无法查询所有未审批计划");
		}
		return mapper.selectUnCommitPlanList(model);
	}

	@Override
	public PlanModel selectOne(Long planId) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(planId);
	}

	/** 
	 * 获取项目经理的个人计划
	 */
	@Override
	public BasePageInfo<PlanAndSonPlanModelVo> selectListByPMPerson(BasePageInfo<PlanAndSonPlanModelVo> page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page.getPageNum(), page.getPageSize()); 
		List<PlanAndSonPlanModelVo> list = mapper.selectListByPMPerson(page);
		return new BasePageInfo<>(list);
	}

	/**
	 * 获取当前项目经理的项目计划
	 */
	@Override
	public BasePageInfo<PlanAndSonPlanModelVo> selectProjectPlanListByprojectId(
			BasePageInfo<PlanAndSonPlanModelVo> page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page.getPageNum(), page.getPageSize()); 
		List<PlanAndSonPlanModelVo> list = mapper.selectProjectPlanListByprojectId(page);
		return new BasePageInfo<>(list);
	}
	/**
	 * 获取当前团队的计划列表
	 */
	@Override
	public BasePageInfo<PlanAndSonPlanModelVo> selectTeamPlanListByTeamId(
			BasePageInfo<PlanAndSonPlanModelVo> page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page.getPageNum(), page.getPageSize()); 
		List<PlanAndSonPlanModelVo> list = mapper.selectTeamPlanListByTeamId(page);
		return new BasePageInfo<>(list);
	}
	/**
	 * 获取当前团队的计划列表
	 */
	@Override
	public BasePageInfo<PlanAndSonPlanModelVo> selectTeamLeaderPlanListByTeamLeaderId(
			BasePageInfo<PlanAndSonPlanModelVo> page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page.getPageNum(), page.getPageSize()); 
		List<PlanAndSonPlanModelVo> list = mapper.selectTeamLeaderPlanListByTeamLeaderId(page);
		return new BasePageInfo<>(list);
	}
	/**
	 * 获取当前负责人的计划列表
	 */
	@Override
	public BasePageInfo<PlanAndSonPlanModelVo> selectLeaderPlanListByLeaderId(
			BasePageInfo<PlanAndSonPlanModelVo> page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page.getPageNum(), page.getPageSize()); 
		List<PlanAndSonPlanModelVo> list = mapper.selectLeaderPlanListByLeaderId(page);
		return new BasePageInfo<>(list);
	}

}
