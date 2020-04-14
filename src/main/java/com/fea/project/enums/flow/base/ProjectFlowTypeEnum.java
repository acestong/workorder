package com.fea.project.enums.flow.base;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.configure.SpringContextHelper;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.enums.config.ProjectConfigEnum;
import com.fea.project.enums.config.ProjectEstablishConfigEnum;
import com.fea.project.enums.flow.base.flowtype.ProjectFlowChangeProjectConditionTypeEnum;
import com.fea.project.enums.flow.base.flowtype.ProjectFlowCreateProjectConditionTypeEnum;
import com.fea.project.enums.flow.base.flowtype.ProjectFlowEstablishProjectConditionTypeEnum;
import com.fea.project.model.apply.pojo.ProjectApplyFlowInfoPojo;
import com.fea.project.model.businessflow.ProjectBusinessFlowModel;
import com.fea.project.model.deliverable.ProjectDeliverableModel;
import com.fea.project.model.establishproject.project.ProjectEstablishStepModel;
import com.fea.project.model.feebudget.ProjectFeeDubgetParentModel;
import com.fea.project.model.flow.ProjectFlowListConditionModel;
import com.fea.project.model.flow.flowtype.FlowTypeIdAndParamIdModel;
import com.fea.project.model.flow.vo.ProjectFlowListConditionVo;
import com.fea.project.model.milestone.ProjectMilestoneDeliverableModel;
import com.fea.project.model.milestone.ProjectMilestoneModel;
import com.fea.project.model.milestone.ProjectMilestoneVerifyModel;
import com.fea.project.model.plan.PlanModel;
import com.fea.project.model.project.ProjectModel;
import com.fea.project.model.task.TaskDeliverProductModel;
import com.fea.project.service.apply.ProjectApplyFlowConditionCheckService;
import com.fea.project.service.businessflow.flowtype.*;
import com.fea.project.service.deliverable.ProjectDeliverableService;
import com.fea.project.service.establishproject.project.ProjectEstablishStepService;
import com.fea.project.service.feebudget.ProjectFeeDubgetService;
import com.fea.project.service.flow.flowtype.ProjectFlowChangeProjectServiceImpl;
import com.fea.project.service.flow.flowtype.ProjectFlowCreateProjectServiceImpl;
import com.fea.project.service.flow.flowtype.ProjectFlowEstablishProjectServiceImpl;
import com.fea.project.service.milestone.ProjectMilestoneDeliverableService;
import com.fea.project.service.milestone.ProjectMilestoneService;
import com.fea.project.service.milestone.ProjectMilestoneVerifyService;
import com.fea.project.service.plan.impl.PlanServiceImpl;
import com.fea.project.service.project.ProjectService;
import com.fea.project.service.task.impl.TaskDeliverProductServiceImpl;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/11/5 10:31
 * 项目流程设置，基本流程类型
 **/
public enum ProjectFlowTypeEnum {

    PROJECT_ESTABLISH_VERIFY(ProjectEstablishConfigEnum.ESTABLISH_PROJECT_TYPE, "项目立项审批", "项目立项申请") {
        @Override
        public Map<Integer, Map<Long, String>> getTargetTypeConditionNameMap(Map<Integer, Set<Object>> conditionMap) {
            return ProjectFlowEstablishProjectConditionTypeEnum.getTargetTypeConditionNameMap(conditionMap);
        }

        @Override
        public Map<? extends Long, ? extends String> getBusinessNameMap(List<Long> ids) {
            return SpringContextHelper.getBean(ProjectEstablishStepService.class).getBusinessNameMap(ids);
        }

        @Override
        public Object getFlowParamDetail(FlowTypeIdAndParamIdModel model) {
            return SpringContextHelper.getBean(ProjectFlowEstablishProjectServiceImpl.class).getFlowTypeParam(model);
        }

        @Override
        public Object getFlowTypeParam() {
            return ProjectFlowEstablishProjectConditionTypeEnum.getMapInfo();
        }

        @Override
        public String getConditionStr(ProjectFlowListConditionModel model) {
            return ProjectFlowEstablishProjectConditionTypeEnum.getSqlStrByConditionTypeAndConditionStr(model);
        }

        @Override
        public Map<Integer, String> getFlowTypeConditionMap() {
            return ProjectFlowEstablishProjectConditionTypeEnum.getMap();
        }

        @Override
        public <T> boolean createApplyInfo(T model) {
            ProjectEstablishStepModel projectEstablishStepModel = (ProjectEstablishStepModel) model;
            return SpringContextHelper.getBean(ProjectBusinessEstablishApplyImplService.class).createApplyInfo(projectEstablishStepModel);
        }

        @Override
        public boolean updateBusinessInfoWhenFlowFinish(Long businessId) {
            return SpringContextHelper.getBean(ProjectBusinessEstablishApplyImplService.class).updateBusinessInfoWhenFlowFinish(businessId);
        }

        @Override
        public List<ProjectApplyFlowInfoPojo> getProjectApplyFlowInfo(Long applyerId, ProjectBusinessFlowModel projectBusinessFlowModel, SysUserModel sysUserModel, Long businessFlowVerifyId) {
            return SpringContextHelper.getBean(ProjectBusinessEstablishApplyImplService.class).getProjectApplyFlowInfo(applyerId, projectBusinessFlowModel, sysUserModel, businessFlowVerifyId);
        }

        @Override
        public boolean revertBusinessInfo(Long businessId) {
            return SpringContextHelper.getBean(ProjectBusinessEstablishApplyImplService.class).revertBusinessInfo(businessId);
        }

        @Override
        public boolean refuseBusinessInfo(Long businessId) {
            return SpringContextHelper.getBean(ProjectBusinessEstablishApplyImplService.class).refuseBusinessInfo(businessId);
        }

        @Override
        public List<Integer> getOtherDBCheckTypeList() {
            return ProjectFlowEstablishProjectConditionTypeEnum.getOtherDBCheckTypeList();
        }

        @Override
        public Object getConnectInfoByBusinessId(int typeId, Long businessId) {
            return ProjectFlowEstablishProjectConditionTypeEnum.getConnectInfoByBusinessId(typeId, businessId);
        }

        @Override
        public boolean isSatisfied(Integer typeId, ProjectFlowListConditionVo projectFlowListConditionVo, Object businessInfo) {
            return ProjectFlowEstablishProjectConditionTypeEnum.isSatisfied(typeId, projectFlowListConditionVo, businessInfo);
        }
    },
    PROJECT_CREATE_VERIFY(ProjectConfigEnum.PROJECT_CREATE_VERIFY, "项目创建审批", "项目创建申请") {
        @Override
        public Map<Integer, Map<Long, String>> getTargetTypeConditionNameMap(Map<Integer, Set<Object>> conditionMap) {
            return ProjectFlowCreateProjectConditionTypeEnum.getTargetTypeConditionNameMap(conditionMap);
        }

        @Override
        public Map<? extends Long, ? extends String> getBusinessNameMap(List<Long> ids) {
            return SpringContextHelper.getBean(ProjectService.class).getBusinessNameMap(ids);
        }

        @Override
        public Object getFlowParamDetail(FlowTypeIdAndParamIdModel model) {
            return SpringContextHelper.getBean(ProjectFlowCreateProjectServiceImpl.class).getFlowTypeParam(model);
        }

        @Override
        public Object getFlowTypeParam() {
            return ProjectFlowCreateProjectConditionTypeEnum.getMapInfo();
        }

        @Override
        public String getConditionStr(ProjectFlowListConditionModel model) {
            return ProjectFlowCreateProjectConditionTypeEnum.getSqlStrByConditionTypeAndConditionStr(model);
        }

        @Override
        public Map<Integer, String> getFlowTypeConditionMap() {
            return ProjectFlowCreateProjectConditionTypeEnum.getMap();
        }

        @Override
        public <T> boolean createApplyInfo(T model) {
            ProjectModel projectModel = (ProjectModel) model;
            return SpringContextHelper.getBean(ProjectBusinessCreateApplyImplService.class).createApplyInfo(projectModel);
        }

        @Override
        public boolean updateBusinessInfoWhenFlowFinish(Long businessId) {
            return SpringContextHelper.getBean(ProjectBusinessCreateApplyImplService.class).updateBusinessInfoWhenFlowFinish(businessId);
        }

        @Override
        public List<ProjectApplyFlowInfoPojo> getProjectApplyFlowInfo(Long applyerId, ProjectBusinessFlowModel projectBusinessFlowModel, SysUserModel sysUserModel, Long businessFlowVerifyId) {
            return SpringContextHelper.getBean(ProjectBusinessCreateApplyImplService.class).getProjectApplyFlowInfo(applyerId, projectBusinessFlowModel, sysUserModel, businessFlowVerifyId);
        }

        @Override
        public boolean revertBusinessInfo(Long businessId) {
            return SpringContextHelper.getBean(ProjectBusinessCreateApplyImplService.class).revertBusinessInfo(businessId);
        }

        @Override
        public boolean refuseBusinessInfo(Long businessId) {
            return SpringContextHelper.getBean(ProjectBusinessCreateApplyImplService.class).refuseBusinessInfo(businessId);
        }

        @Override
        public List<Integer> getOtherDBCheckTypeList() {
            return ProjectFlowCreateProjectConditionTypeEnum.getOtherDBCheckTypeList();
        }

        @Override
        public Object getConnectInfoByBusinessId(int typeId, Long businessId) {
            return ProjectFlowCreateProjectConditionTypeEnum.getConnectInfoByBusinessId(typeId, businessId);
        }

        @Override
        public boolean isSatisfied(Integer typeId, ProjectFlowListConditionVo projectFlowListConditionVo, Object businessInfo) {
            return ProjectFlowCreateProjectConditionTypeEnum.isSatisfied(typeId, projectFlowListConditionVo, businessInfo);
        }
    },
    PROJECT_CHANGE_VERIFY(ProjectConfigEnum.PROJECT_CHANGE_VERIFY, "项目变更审批", "项目变更申请") {
        @Override
        public Map<Integer, Map<Long, String>> getTargetTypeConditionNameMap(Map<Integer, Set<Object>> conditionMap) {
            return ProjectFlowChangeProjectConditionTypeEnum.getTargetTypeConditionNameMap(conditionMap);
        }

        @Override
        public Map<? extends Long, ? extends String> getBusinessNameMap(List<Long> ids) {
            return SpringContextHelper.getBean(ProjectService.class).getBusinessNameMap(ids);
        }

        @Override
        public Object getFlowParamDetail(FlowTypeIdAndParamIdModel model) {
            return SpringContextHelper.getBean(ProjectFlowChangeProjectServiceImpl.class).getFlowTypeParam(model);
        }

        @Override
        public Object getFlowTypeParam() {
            return ProjectFlowChangeProjectConditionTypeEnum.getMapInfo();
        }

        @Override
        public String getConditionStr(ProjectFlowListConditionModel model) {
            return ProjectFlowChangeProjectConditionTypeEnum.getSqlStrByConditionTypeAndConditionStr(model);
        }

        @Override
        public Map<Integer, String> getFlowTypeConditionMap() {
            return ProjectFlowChangeProjectConditionTypeEnum.getMap();
        }

        @Override
        public <T> boolean createApplyInfo(T model) {
            return false;
        }

        @Override
        public boolean updateBusinessInfoWhenFlowFinish(Long businessId) {
            return SpringContextHelper.getBean(ProjectBusinessChangeApplyImplService.class).updateBusinessInfoWhenFlowFinish(businessId);
        }

        @Override
        public List<ProjectApplyFlowInfoPojo> getProjectApplyFlowInfo(Long applyerId, ProjectBusinessFlowModel projectBusinessFlowModel, SysUserModel sysUserModel, Long businessFlowVerifyId) {
            return SpringContextHelper.getBean(ProjectBusinessChangeApplyImplService.class).getProjectApplyFlowInfo(applyerId, projectBusinessFlowModel, sysUserModel, businessFlowVerifyId);
        }

        @Override
        public boolean revertBusinessInfo(Long businessId) {
            return SpringContextHelper.getBean(ProjectBusinessChangeApplyImplService.class).revertBusinessInfo(businessId);
        }

        @Override
        public boolean refuseBusinessInfo(Long businessId) {
            return SpringContextHelper.getBean(ProjectBusinessChangeApplyImplService.class).refuseBusinessInfo(businessId);
        }

        @Override
        public List<Integer> getOtherDBCheckTypeList() {
            return ProjectFlowChangeProjectConditionTypeEnum.getOtherDBCheckTypeList();
        }

        @Override
        public Object getConnectInfoByBusinessId(int typeId, Long businessId) {
            return ProjectFlowChangeProjectConditionTypeEnum.getConnectInfoByBusinessId(typeId, businessId);
        }

        @Override
        public boolean isSatisfied(Integer typeId, ProjectFlowListConditionVo projectFlowListConditionVo, Object businessInfo) {
            return SpringContextHelper.getBean(ProjectApplyFlowConditionCheckService.class).isSatisfied(projectFlowListConditionVo, businessInfo);
        }
    },
    VERIFY_SET_PROJECT_PLAN_VERIFY(ProjectConfigEnum.VERIFY_SET_PROJECT_PLAN_VERIFY, "项目计划审批", "项目计划申请") {
        @Override
        public Map<Integer, Map<Long, String>> getTargetTypeConditionNameMap(Map<Integer, Set<Object>> conditionMap) {
        	 //无条件流程
            return new HashMap<>();
        }

        @Override
        public Map<? extends Long, ? extends String> getBusinessNameMap(List<Long> ids) {
            return SpringContextHelper.getBean(PlanServiceImpl.class).getBusinessNameMap(ids);
        }

        @Override
        public Object getFlowParamDetail(FlowTypeIdAndParamIdModel model) {
        	 //无条件参数
            return null;
        }

        @Override
        public Object getFlowTypeParam() {
        	 //无该条件参数
            return null;
        }

        @Override
        public String getConditionStr(ProjectFlowListConditionModel model) {
        	 //无该条件参数
            return null;
        }

        @Override
        public Map<Integer, String> getFlowTypeConditionMap() {
        	 //无该条件参数
            return new HashMap<>();
        }

        @Override
        public <T> boolean createApplyInfo(T model) {
            return SpringContextHelper.getBean(ProjectBusinessPlanApplyImplService.class).createApplyInfo((PlanModel)model);
        }

        @Override
        public boolean updateBusinessInfoWhenFlowFinish(Long businessId) {
            return SpringContextHelper.getBean(ProjectBusinessPlanApplyImplService.class).updateBusinessInfoWhenFlowFinish(businessId);
        }

        @Override
        public List<ProjectApplyFlowInfoPojo> getProjectApplyFlowInfo(Long applyerId, ProjectBusinessFlowModel projectBusinessFlowModel, SysUserModel sysUserModel, Long businessFlowVerifyId) {
            return SpringContextHelper.getBean(ProjectBusinessPlanApplyImplService.class).getProjectApplyFlowInfo(applyerId, projectBusinessFlowModel, sysUserModel, businessFlowVerifyId);
        }

        @Override
        public boolean revertBusinessInfo(Long businessId) {
            return SpringContextHelper.getBean(ProjectBusinessPlanApplyImplService.class).revertBusinessInfo(businessId);
        }

        @Override
        public boolean refuseBusinessInfo(Long businessId) {
            return SpringContextHelper.getBean(ProjectBusinessPlanApplyImplService.class).refuseBusinessInfo(businessId);
        }

        @Override
        public List<Integer> getOtherDBCheckTypeList() {
        	//无该条件参数
            return new ArrayList<>();
        }

        @Override
        public Object getConnectInfoByBusinessId(int typeId, Long businessId) {
        	 //无该条件参数
            return null;
        }

        @Override
        public boolean isSatisfied(Integer typeId, ProjectFlowListConditionVo projectFlowListConditionVo, Object businessInfo) {
        	 return true;
        }
    },
    VERIFY_SET_PROJECT_TEAM_PLAN_VERIFY(ProjectConfigEnum.VERIFY_SET_PROJECT_TEAM_PLAN_VERIFY, "项目团队计划审批", "项目团队计划申请") {
    	 @Override
         public Map<Integer, Map<Long, String>> getTargetTypeConditionNameMap(Map<Integer, Set<Object>> conditionMap) {
         	 //无条件流程
             return new HashMap<>();
         }

         @Override
         public Map<? extends Long, ? extends String> getBusinessNameMap(List<Long> ids) {
             return SpringContextHelper.getBean(PlanServiceImpl.class).getBusinessNameMap(ids);
         }

         @Override
         public Object getFlowParamDetail(FlowTypeIdAndParamIdModel model) {
         	 //无条件参数
             return null;
         }

         @Override
         public Object getFlowTypeParam() {
         	 //无该条件参数
             return null;
         }

         @Override
         public String getConditionStr(ProjectFlowListConditionModel model) {
         	 //无该条件参数
             return null;
         }

         @Override
         public Map<Integer, String> getFlowTypeConditionMap() {
         	 //无该条件参数
             return new HashMap<>();
         }

         @Override
         public <T> boolean createApplyInfo(T model) {
             return SpringContextHelper.getBean(ProjectBusinessPlanApplyImplService.class).createApplyInfo((PlanModel)model);
         }

         @Override
         public boolean updateBusinessInfoWhenFlowFinish(Long businessId) {
             return SpringContextHelper.getBean(ProjectBusinessPlanApplyImplService.class).updateBusinessInfoWhenFlowFinish(businessId);
         }

         @Override
         public List<ProjectApplyFlowInfoPojo> getProjectApplyFlowInfo(Long applyerId, ProjectBusinessFlowModel projectBusinessFlowModel, SysUserModel sysUserModel, Long businessFlowVerifyId) {
             return SpringContextHelper.getBean(ProjectBusinessPlanApplyImplService.class).getProjectApplyFlowInfo(applyerId, projectBusinessFlowModel, sysUserModel, businessFlowVerifyId);
         }

         @Override
         public boolean revertBusinessInfo(Long businessId) {
             return SpringContextHelper.getBean(ProjectBusinessPlanApplyImplService.class).revertBusinessInfo(businessId);
         }

         @Override
         public boolean refuseBusinessInfo(Long businessId) {
             return SpringContextHelper.getBean(ProjectBusinessPlanApplyImplService.class).refuseBusinessInfo(businessId);
         }

         @Override
         public List<Integer> getOtherDBCheckTypeList() {
         	//无该条件参数
             return new ArrayList<>();
         }

         @Override
         public Object getConnectInfoByBusinessId(int typeId, Long businessId) {
         	 //无该条件参数
             return null;
         }

         @Override
         public boolean isSatisfied(Integer typeId, ProjectFlowListConditionVo projectFlowListConditionVo, Object businessInfo) {
         	 return true;
         }
      
    },
    VERIFY_SET_PROJECT_TEAMER_PLAN_VERIFY(ProjectConfigEnum.VERIFY_SET_PROJECT_TEAMER_PLAN_VERIFY, "项目成员计划审批", "项目成员计划申请") {
    	 @Override
         public Map<Integer, Map<Long, String>> getTargetTypeConditionNameMap(Map<Integer, Set<Object>> conditionMap) {
         	 //无条件流程
             return new HashMap<>();
         }

         @Override
         public Map<? extends Long, ? extends String> getBusinessNameMap(List<Long> ids) {
             return SpringContextHelper.getBean(PlanServiceImpl.class).getBusinessNameMap(ids);
         }

         @Override
         public Object getFlowParamDetail(FlowTypeIdAndParamIdModel model) {
         	 //无条件参数
             return null;
         }

         @Override
         public Object getFlowTypeParam() {
         	 //无该条件参数
             return null;
         }

         @Override
         public String getConditionStr(ProjectFlowListConditionModel model) {
         	 //无该条件参数
             return null;
         }

         @Override
         public Map<Integer, String> getFlowTypeConditionMap() {
         	 //无该条件参数
             return new HashMap<>();
         }

         @Override
         public <T> boolean createApplyInfo(T model) {
             return SpringContextHelper.getBean(ProjectBusinessPlanApplyImplService.class).createApplyInfo((PlanModel)model);
         }

         @Override
         public boolean updateBusinessInfoWhenFlowFinish(Long businessId) {
             return SpringContextHelper.getBean(ProjectBusinessPlanApplyImplService.class).updateBusinessInfoWhenFlowFinish(businessId);
         }

         @Override
         public List<ProjectApplyFlowInfoPojo> getProjectApplyFlowInfo(Long applyerId, ProjectBusinessFlowModel projectBusinessFlowModel, SysUserModel sysUserModel, Long businessFlowVerifyId) {
             return SpringContextHelper.getBean(ProjectBusinessPlanApplyImplService.class).getProjectApplyFlowInfo(applyerId, projectBusinessFlowModel, sysUserModel, businessFlowVerifyId);
         }

         @Override
         public boolean revertBusinessInfo(Long businessId) {
             return SpringContextHelper.getBean(ProjectBusinessPlanApplyImplService.class).revertBusinessInfo(businessId);
         }

         @Override
         public boolean refuseBusinessInfo(Long businessId) {
             return SpringContextHelper.getBean(ProjectBusinessPlanApplyImplService.class).refuseBusinessInfo(businessId);
         }

         @Override
         public List<Integer> getOtherDBCheckTypeList() {
         	//无该条件参数
             return new ArrayList<>();
         }

         @Override
         public Object getConnectInfoByBusinessId(int typeId, Long businessId) {
         	 //无该条件参数
             return null;
         }

         @Override
         public boolean isSatisfied(Integer typeId, ProjectFlowListConditionVo projectFlowListConditionVo, Object businessInfo) {
         	 return true;
         }
    },
    VERIFY_SET_TASK_DELIVERABLE_VERIFY(ProjectConfigEnum.VERIFY_SET_TASK_DELIVERABLE_VERIFY, "项目任务交付物审批", "项目任务交付物申请") {
        @Override
        public Map<Integer, Map<Long, String>> getTargetTypeConditionNameMap(Map<Integer, Set<Object>> conditionMap) {
            return new HashMap<>();
        }

        @Override
        public Map<? extends Long, ? extends String> getBusinessNameMap(List<Long> ids) {
            return SpringContextHelper.getBean(TaskDeliverProductServiceImpl.class).getBusinessNameMap(ids);
        }

        @Override
        public Object getFlowParamDetail(FlowTypeIdAndParamIdModel model) {
            return null;
        }

        @Override
        public Object getFlowTypeParam() {
            return null;
        }

        @Override
        public String getConditionStr(ProjectFlowListConditionModel model) {
            return null;
        }

        @Override
        public Map<Integer, String> getFlowTypeConditionMap() {
            return new HashMap<>();
        }

        @Override
        public <T> boolean createApplyInfo(T model) {
            TaskDeliverProductModel productModel = (TaskDeliverProductModel) model;
            return SpringContextHelper.getBean(ProjectBusinessTaskDeliverableApplyImplService.class).createApplyInfo(productModel);
        }

        @Override
        public boolean updateBusinessInfoWhenFlowFinish(Long businessId) {
            return SpringContextHelper.getBean(ProjectBusinessTaskDeliverableApplyImplService.class).updateBusinessInfoWhenFlowFinish(businessId);
        }

        @Override
        public List<ProjectApplyFlowInfoPojo> getProjectApplyFlowInfo(Long applyerId, ProjectBusinessFlowModel projectBusinessFlowModel, SysUserModel sysUserModel, Long businessFlowVerifyId) {
            return SpringContextHelper.getBean(ProjectBusinessTaskDeliverableApplyImplService.class).getProjectApplyFlowInfo(applyerId, projectBusinessFlowModel, sysUserModel, businessFlowVerifyId);
        }

        @Override
        public boolean revertBusinessInfo(Long businessId) {
            return SpringContextHelper.getBean(ProjectBusinessTaskDeliverableApplyImplService.class).revertBusinessInfo(businessId);
        }

        @Override
        public boolean refuseBusinessInfo(Long businessId) {
            return SpringContextHelper.getBean(ProjectBusinessTaskDeliverableApplyImplService.class).refuseBusinessInfo(businessId);
        }

        @Override
        public List<Integer> getOtherDBCheckTypeList() {
            return Collections.emptyList();
        }

        @Override
        public Object getConnectInfoByBusinessId(int typeId, Long businessId) {
            return null;
        }

        @Override
        public boolean isSatisfied(Integer typeId, ProjectFlowListConditionVo projectFlowListConditionVo, Object businessInfo) {
            return true;
        }
    },
    VERIFY_SET_PROJECT_FINISH_VERIFY(ProjectConfigEnum.VERIFY_SET_PROJECT_FINISH_VERIFY, "项目结项审批", "项目结项申请") {
        @Override
        public Map<Integer, Map<Long, String>> getTargetTypeConditionNameMap(Map<Integer, Set<Object>> conditionMap) {
            return null;
        }

        @Override
        public Map<? extends Long, ? extends String> getBusinessNameMap(List<Long> ids) {
            return null;
        }

        @Override
        public Object getFlowParamDetail(FlowTypeIdAndParamIdModel model) {
            return null;
        }

        @Override
        public Object getFlowTypeParam() {
            return null;
        }

        @Override
        public String getConditionStr(ProjectFlowListConditionModel model) {
            return null;
        }

        @Override
        public Map<Integer, String> getFlowTypeConditionMap() {
            return null;
        }

        @Override
        public <T> boolean createApplyInfo(T model) {
            return false;
        }

        @Override
        public boolean updateBusinessInfoWhenFlowFinish(Long businessId) {
            return SpringContextHelper.getBean(ProjectBusinessFinishApplyImplService.class).updateBusinessInfoWhenFlowFinish(businessId);
        }

        @Override
        public List<ProjectApplyFlowInfoPojo> getProjectApplyFlowInfo(Long applyerId, ProjectBusinessFlowModel projectBusinessFlowModel, SysUserModel sysUserModel, Long businessFlowVerifyId) {
            return SpringContextHelper.getBean(ProjectBusinessFinishApplyImplService.class).getProjectApplyFlowInfo(applyerId, projectBusinessFlowModel, sysUserModel, businessFlowVerifyId);
        }

        @Override
        public boolean revertBusinessInfo(Long businessId) {
            return SpringContextHelper.getBean(ProjectBusinessFinishApplyImplService.class).revertBusinessInfo(businessId);
        }

        @Override
        public boolean refuseBusinessInfo(Long businessId) {
            return SpringContextHelper.getBean(ProjectBusinessFinishApplyImplService.class).refuseBusinessInfo(businessId);
        }

        @Override
        public List<Integer> getOtherDBCheckTypeList() {
            return Collections.emptyList();
        }

        @Override
        public Object getConnectInfoByBusinessId(int typeId, Long businessId) {
            return null;
        }

        @Override
        public boolean isSatisfied(Integer typeId, ProjectFlowListConditionVo projectFlowListConditionVo, Object businessInfo) {
            return false;
        }
    },
    VERIFY_SET_PROJECT_BUDGET_VERIFY(ProjectConfigEnum.VERIFY_SET_PROJECT_BUDGET_VERIFY, "项目预算审批", "项目预算申请") {
        @Override
        public Map<Integer, Map<Long, String>> getTargetTypeConditionNameMap(Map<Integer, Set<Object>> conditionMap) {
            return new HashMap<>();
        }

        @Override
        public Map<? extends Long, ? extends String> getBusinessNameMap(List<Long> ids) {
            return SpringContextHelper.getBean(ProjectFeeDubgetService.class).getBusinessNameMap(ids);
        }

        @Override
        public Object getFlowParamDetail(FlowTypeIdAndParamIdModel model) {
            return null;
        }

        @Override
        public Object getFlowTypeParam() {
            return null;
        }

        @Override
        public String getConditionStr(ProjectFlowListConditionModel model) {
            return null;
        }

        @Override
        public Map<Integer, String> getFlowTypeConditionMap() {
            return null;
        }

        @Override
        public <T> boolean createApplyInfo(T model) {
            ProjectFeeDubgetParentModel projectFeeDubgetParentModel = (ProjectFeeDubgetParentModel) model;
            return SpringContextHelper.getBean(ProjectBusinessFeeDubgetApplyImplService.class).createApplyInfo(projectFeeDubgetParentModel);
        }

        @Override
        public boolean updateBusinessInfoWhenFlowFinish(Long businessId) {
            return SpringContextHelper.getBean(ProjectBusinessFeeDubgetApplyImplService.class).updateBusinessInfoWhenFlowFinish(businessId);
        }

        @Override
        public List<ProjectApplyFlowInfoPojo> getProjectApplyFlowInfo(Long applyerId, ProjectBusinessFlowModel projectBusinessFlowModel, SysUserModel sysUserModel, Long businessFlowVerifyId) {
            return SpringContextHelper.getBean(ProjectBusinessFeeDubgetApplyImplService.class).getProjectApplyFlowInfo(applyerId, projectBusinessFlowModel, sysUserModel, businessFlowVerifyId);
        }

        @Override
        public boolean revertBusinessInfo(Long businessId) {
            return SpringContextHelper.getBean(ProjectBusinessFeeDubgetApplyImplService.class).revertBusinessInfo(businessId);
        }

        @Override
        public boolean refuseBusinessInfo(Long businessId) {
            return SpringContextHelper.getBean(ProjectBusinessFeeDubgetApplyImplService.class).refuseBusinessInfo(businessId);
        }

        @Override
        public List<Integer> getOtherDBCheckTypeList() {
            return new ArrayList<>();
        }

        @Override
        public Object getConnectInfoByBusinessId(int tmp, Long businessId) {
            return null;
        }

        @Override
        public boolean isSatisfied(Integer typeId, ProjectFlowListConditionVo projectFlowListConditionVo, Object businessInfo) {
            return true;
        }
    },
    CHANGE_APPLY_PROJECT_PLAN_CHANGE_VERIFY(ProjectConfigEnum.CHANGE_APPLY_PROJECT_PLAN_CHANGE_VERIFY, "项目计划变更审批", "项目计划变更申请") {
    	@Override
        public Map<Integer, Map<Long, String>> getTargetTypeConditionNameMap(Map<Integer, Set<Object>> conditionMap) {
        	 //无条件流程
            return new HashMap<>();
        }

        @Override
        public Map<? extends Long, ? extends String> getBusinessNameMap(List<Long> ids) {
            return SpringContextHelper.getBean(PlanServiceImpl.class).getBusinessNameMap(ids);
        }

        @Override
        public Object getFlowParamDetail(FlowTypeIdAndParamIdModel model) {
        	 //无条件参数
            return null;
        }

        @Override
        public Object getFlowTypeParam() {
        	 //无该条件参数
            return null;
        }

        @Override
        public String getConditionStr(ProjectFlowListConditionModel model) {
        	 //无该条件参数
            return null;
        }

        @Override
        public Map<Integer, String> getFlowTypeConditionMap() {
        	 //无该条件参数
            return new HashMap<>();
        }

        @Override
        public <T> boolean createApplyInfo(T model) {
            return SpringContextHelper.getBean(ProjectBusinessPlanApplyImplService.class).createApplyInfo((PlanModel)model);
        }

        @Override
        public boolean updateBusinessInfoWhenFlowFinish(Long businessId) {
            return SpringContextHelper.getBean(ProjectBusinessPlanApplyImplService.class).updateBusinessInfoWhenFlowFinish(businessId);
        }

        @Override
        public List<ProjectApplyFlowInfoPojo> getProjectApplyFlowInfo(Long applyerId, ProjectBusinessFlowModel projectBusinessFlowModel, SysUserModel sysUserModel, Long businessFlowVerifyId) {
            return SpringContextHelper.getBean(ProjectBusinessPlanApplyImplService.class).getProjectApplyFlowInfo(applyerId, projectBusinessFlowModel, sysUserModel, businessFlowVerifyId);
        }

        @Override
        public boolean revertBusinessInfo(Long businessId) {
            return SpringContextHelper.getBean(ProjectBusinessPlanApplyImplService.class).revertBusinessInfo(businessId);
        }

        @Override
        public boolean refuseBusinessInfo(Long businessId) {
            return SpringContextHelper.getBean(ProjectBusinessPlanApplyImplService.class).refuseBusinessInfo(businessId);
        }

        @Override
        public List<Integer> getOtherDBCheckTypeList() {
        	//无该条件参数
            return new ArrayList<>();
        }

        @Override
        public Object getConnectInfoByBusinessId(int typeId, Long businessId) {
        	 //无该条件参数
            return null;
        }

        @Override
        public boolean isSatisfied(Integer typeId, ProjectFlowListConditionVo projectFlowListConditionVo, Object businessInfo) {
        	 return true;
        }
    },
    CHANGE_APPLY_PROJECT_TEAM_PLAN_CHANGE_VERIFY(ProjectConfigEnum.CHANGE_APPLY_PROJECT_TEAM_PLAN_CHANGE_VERIFY, "项目团队计划变更审批", "项目团队计划变更申请") {
    	 @Override
         public Map<Integer, Map<Long, String>> getTargetTypeConditionNameMap(Map<Integer, Set<Object>> conditionMap) {
         	 //无条件流程
             return new HashMap<>();
         }

         @Override
         public Map<? extends Long, ? extends String> getBusinessNameMap(List<Long> ids) {
             return SpringContextHelper.getBean(PlanServiceImpl.class).getBusinessNameMap(ids);
         }

         @Override
         public Object getFlowParamDetail(FlowTypeIdAndParamIdModel model) {
         	 //无条件参数
             return null;
         }

         @Override
         public Object getFlowTypeParam() {
         	 //无该条件参数
             return null;
         }

         @Override
         public String getConditionStr(ProjectFlowListConditionModel model) {
         	 //无该条件参数
             return null;
         }

         @Override
         public Map<Integer, String> getFlowTypeConditionMap() {
         	 //无该条件参数
             return new HashMap<>();
         }

         @Override
         public <T> boolean createApplyInfo(T model) {
             return SpringContextHelper.getBean(ProjectBusinessPlanApplyImplService.class).createApplyInfo((PlanModel)model);
         }

         @Override
         public boolean updateBusinessInfoWhenFlowFinish(Long businessId) {
             return SpringContextHelper.getBean(ProjectBusinessPlanApplyImplService.class).updateBusinessInfoWhenFlowFinish(businessId);
         }

         @Override
         public List<ProjectApplyFlowInfoPojo> getProjectApplyFlowInfo(Long applyerId, ProjectBusinessFlowModel projectBusinessFlowModel, SysUserModel sysUserModel, Long businessFlowVerifyId) {
             return SpringContextHelper.getBean(ProjectBusinessPlanApplyImplService.class).getProjectApplyFlowInfo(applyerId, projectBusinessFlowModel, sysUserModel, businessFlowVerifyId);
         }

         @Override
         public boolean revertBusinessInfo(Long businessId) {
             return SpringContextHelper.getBean(ProjectBusinessPlanApplyImplService.class).revertBusinessInfo(businessId);
         }

         @Override
         public boolean refuseBusinessInfo(Long businessId) {
             return SpringContextHelper.getBean(ProjectBusinessPlanApplyImplService.class).refuseBusinessInfo(businessId);
         }

         @Override
         public List<Integer> getOtherDBCheckTypeList() {
         	//无该条件参数
             return new ArrayList<>();
         }

         @Override
         public Object getConnectInfoByBusinessId(int typeId, Long businessId) {
         	 //无该条件参数
             return null;
         }

         @Override
         public boolean isSatisfied(Integer typeId, ProjectFlowListConditionVo projectFlowListConditionVo, Object businessInfo) {
         	 return true;
         }
    },
    CHANGE_APPLY_PROJECT_TEAMER_PLAN_CHANGE_VERIFY(ProjectConfigEnum.CHANGE_APPLY_PROJECT_TEAMER_PLAN_CHANGE_VERIFY, "项目成员计划变更审批", "项目成员计划变更申请") {
    	@Override
        public Map<Integer, Map<Long, String>> getTargetTypeConditionNameMap(Map<Integer, Set<Object>> conditionMap) {
        	 //无条件流程
            return new HashMap<>();
        }

        @Override
        public Map<? extends Long, ? extends String> getBusinessNameMap(List<Long> ids) {
            return SpringContextHelper.getBean(PlanServiceImpl.class).getBusinessNameMap(ids);
        }

        @Override
        public Object getFlowParamDetail(FlowTypeIdAndParamIdModel model) {
        	 //无条件参数
            return null;
        }

        @Override
        public Object getFlowTypeParam() {
        	 //无该条件参数
            return null;
        }

        @Override
        public String getConditionStr(ProjectFlowListConditionModel model) {
        	 //无该条件参数
            return null;
        }

        @Override
        public Map<Integer, String> getFlowTypeConditionMap() {
        	 //无该条件参数
            return new HashMap<>();
        }

        @Override
        public <T> boolean createApplyInfo(T model) {
            return SpringContextHelper.getBean(ProjectBusinessPlanApplyImplService.class).createApplyInfo((PlanModel)model);
        }

        @Override
        public boolean updateBusinessInfoWhenFlowFinish(Long businessId) {
            return SpringContextHelper.getBean(ProjectBusinessPlanApplyImplService.class).updateBusinessInfoWhenFlowFinish(businessId);
        }

        @Override
        public List<ProjectApplyFlowInfoPojo> getProjectApplyFlowInfo(Long applyerId, ProjectBusinessFlowModel projectBusinessFlowModel, SysUserModel sysUserModel, Long businessFlowVerifyId) {
            return SpringContextHelper.getBean(ProjectBusinessPlanApplyImplService.class).getProjectApplyFlowInfo(applyerId, projectBusinessFlowModel, sysUserModel, businessFlowVerifyId);
        }

        @Override
        public boolean revertBusinessInfo(Long businessId) {
            return SpringContextHelper.getBean(ProjectBusinessPlanApplyImplService.class).revertBusinessInfo(businessId);
        }

        @Override
        public boolean refuseBusinessInfo(Long businessId) {
            return SpringContextHelper.getBean(ProjectBusinessPlanApplyImplService.class).refuseBusinessInfo(businessId);
        }

        @Override
        public List<Integer> getOtherDBCheckTypeList() {
        	//无该条件参数
            return new ArrayList<>();
        }

        @Override
        public Object getConnectInfoByBusinessId(int typeId, Long businessId) {
        	 //无该条件参数
            return null;
        }

        @Override
        public boolean isSatisfied(Integer typeId, ProjectFlowListConditionVo projectFlowListConditionVo, Object businessInfo) {
        	 return true;
        }
    },
    CHANGE_APPLY_PROJECT_BUDGET_PLAN_CHANGE_VERIFY(ProjectConfigEnum.CHANGE_APPLY_PROJECT_BUDGET_PLAN_CHANGE_VERIFY, "项目预算变更审批", "项目预算变更申请") {
        @Override
        public Map<Integer, Map<Long, String>> getTargetTypeConditionNameMap(Map<Integer, Set<Object>> conditionMap) {
            return new HashMap<>();
        }

        @Override
        public Map<? extends Long, ? extends String> getBusinessNameMap(List<Long> ids) {
            return SpringContextHelper.getBean(ProjectFeeDubgetService.class).getBusinessNameMap(ids);
        }

        @Override
        public Object getFlowParamDetail(FlowTypeIdAndParamIdModel model) {
            return null;
        }

        @Override
        public Object getFlowTypeParam() {
            return null;
        }

        @Override
        public String getConditionStr(ProjectFlowListConditionModel model) {
            return null;
        }

        @Override
        public Map<Integer, String> getFlowTypeConditionMap() {
            return null;
        }

        @Override
        public <T> boolean createApplyInfo(T model) {
            ProjectFeeDubgetParentModel projectFeeDubgetParentModel = (ProjectFeeDubgetParentModel) model;
            return SpringContextHelper.getBean(ProjectBusinessFeeDubgetChangeApplyImplService.class).createApplyInfo(projectFeeDubgetParentModel);
        }

        @Override
        public boolean updateBusinessInfoWhenFlowFinish(Long businessId) {
            return SpringContextHelper.getBean(ProjectBusinessFeeDubgetChangeApplyImplService.class).updateBusinessInfoWhenFlowFinish(businessId);
        }

        @Override
        public List<ProjectApplyFlowInfoPojo> getProjectApplyFlowInfo(Long applyerId, ProjectBusinessFlowModel projectBusinessFlowModel, SysUserModel sysUserModel, Long businessFlowVerifyId) {
            return SpringContextHelper.getBean(ProjectBusinessFeeDubgetChangeApplyImplService.class).getProjectApplyFlowInfo(applyerId, projectBusinessFlowModel, sysUserModel, businessFlowVerifyId);
        }

        @Override
        public boolean revertBusinessInfo(Long businessId) {
            return SpringContextHelper.getBean(ProjectBusinessFeeDubgetChangeApplyImplService.class).revertBusinessInfo(businessId);
        }

        @Override
        public boolean refuseBusinessInfo(Long businessId) {
            return SpringContextHelper.getBean(ProjectBusinessFeeDubgetChangeApplyImplService.class).refuseBusinessInfo(businessId);
        }

        @Override
        public List<Integer> getOtherDBCheckTypeList() {
            return new ArrayList<>();
        }

        @Override
        public Object getConnectInfoByBusinessId(int tmp, Long businessId) {
            return null;
        }

        @Override
        public boolean isSatisfied(Integer typeId, ProjectFlowListConditionVo projectFlowListConditionVo, Object businessInfo) {
            return true;
        }
    },
    VERIFY_SET_PROJECT_DELIVERABLE_VERIFY(ProjectConfigEnum.VERIFY_SET_PROJECT_DELIVERABLE_VERIFY,"项目交付物审批", "项目交付物申请") {
        @Override
        public Map<Integer, Map<Long, String>> getTargetTypeConditionNameMap(Map<Integer, Set<Object>> conditionMap) {
            //无条件流程
            return new HashMap<>();
        }

        @Override
        public Map<? extends Long, ? extends String> getBusinessNameMap(List<Long> ids) {

            return SpringContextHelper.getBean(ProjectDeliverableService.class).getBusinessNameMap(ids);
        }

        @Override
        public Object getFlowParamDetail(FlowTypeIdAndParamIdModel model) {
            //无条件参数
            return null;
        }

        @Override
        public Object getFlowTypeParam() {
            //无该条件参数
            return null;
        }

        @Override
        public String getConditionStr(ProjectFlowListConditionModel model) {
            //无该条件参数
            return null;
        }

        @Override
        public Map<Integer, String> getFlowTypeConditionMap() {
            //无该条件参数
            return new HashMap<>();
        }

        @Override
        public <T> boolean createApplyInfo(T model) {
            ProjectDeliverableModel projectDeliverableModel = (ProjectDeliverableModel) model;
            return SpringContextHelper.getBean(ProjectBusinessProjectDeliverableApplyImplService.class).createApplyInfo(projectDeliverableModel);
        }

        @Override
        public boolean updateBusinessInfoWhenFlowFinish(Long businessId) {

            return SpringContextHelper.getBean(ProjectBusinessProjectDeliverableApplyImplService.class).updateBusinessInfoWhenFlowFinish(businessId);
        }

        @Override
        public List<ProjectApplyFlowInfoPojo> getProjectApplyFlowInfo(Long applyerId, ProjectBusinessFlowModel projectBusinessFlowModel, SysUserModel sysUserModel, Long businessFlowVerifyId) {
            return SpringContextHelper.getBean(ProjectBusinessProjectDeliverableApplyImplService.class).getProjectApplyFlowInfo(applyerId, projectBusinessFlowModel, sysUserModel, businessFlowVerifyId);
        }

        @Override
        public boolean revertBusinessInfo(Long businessId) {

            return SpringContextHelper.getBean(ProjectBusinessProjectDeliverableApplyImplService.class).revertBusinessInfo(businessId);
        }

        @Override
        public boolean refuseBusinessInfo(Long businessId) {
            return SpringContextHelper.getBean(ProjectBusinessProjectDeliverableApplyImplService.class).refuseBusinessInfo(businessId);
        }

        @Override
        public List<Integer> getOtherDBCheckTypeList() {
            //无该条件参数
            return new ArrayList<>();
        }

        @Override
        public Object getConnectInfoByBusinessId(int tmp, Long businessId) {
            //无该条件参数
            return null;
        }

        @Override
        public boolean isSatisfied(Integer typeId, ProjectFlowListConditionVo projectFlowListConditionVo, Object businessInfo) {
            return true;
        }
    },
    VERIFY_SET_MILESTONE_DELIVERABLE_VERIFY(ProjectConfigEnum.VERIFY_SET_MILESTONE_DELIVERABLE_VERIFY,"项目里程碑交付物审批","项目里程碑交付物申请") {
        @Override
        public Map<Integer, Map<Long, String>> getTargetTypeConditionNameMap(Map<Integer, Set<Object>> conditionMap) {
            return new HashMap<>();
        }

        @Override
        public Map<? extends Long, ? extends String> getBusinessNameMap(List<Long> ids) {

            return SpringContextHelper.getBean(ProjectMilestoneDeliverableService.class).getBusinessNameMap(ids);
        }

        @Override
        public Object getFlowParamDetail(FlowTypeIdAndParamIdModel model) {
            //无
            return null;
        }

        @Override
        public Object getFlowTypeParam() {
            //无
            return null;
        }

        @Override
        public String getConditionStr(ProjectFlowListConditionModel model) {

            return null;
        }

        @Override
        public Map<Integer, String> getFlowTypeConditionMap() {

            return new HashMap<>();
        }

        @Override
        public <T> boolean createApplyInfo(T model) {
            ProjectMilestoneDeliverableModel projectMilestoneDeliverableModel = (ProjectMilestoneDeliverableModel) model;
            boolean applyInfo = SpringContextHelper.getBean(ProjectBusinessMilestoneDeliverableApplyImplService.class).createApplyInfo(projectMilestoneDeliverableModel);
            return applyInfo;
        }

        @Override
        public boolean updateBusinessInfoWhenFlowFinish(Long businessId) {

            return SpringContextHelper.getBean(ProjectBusinessMilestoneDeliverableApplyImplService.class).updateBusinessInfoWhenFlowFinish(businessId);
        }

        @Override
        public List<ProjectApplyFlowInfoPojo> getProjectApplyFlowInfo(Long applyerId, ProjectBusinessFlowModel projectBusinessFlowModel, SysUserModel sysUserModel, Long businessFlowVerifyId) {
            return SpringContextHelper.getBean(ProjectBusinessMilestoneDeliverableApplyImplService.class).getProjectApplyFlowInfo(applyerId, projectBusinessFlowModel, sysUserModel, businessFlowVerifyId);
        }

        @Override
        public boolean revertBusinessInfo(Long businessId) {
            return SpringContextHelper.getBean(ProjectBusinessMilestoneDeliverableApplyImplService.class).revertBusinessInfo(businessId);
        }

        @Override
        public boolean refuseBusinessInfo(Long businessId) {
            return SpringContextHelper.getBean(ProjectBusinessMilestoneDeliverableApplyImplService.class).refuseBusinessInfo(businessId);
        }

        @Override
        public List<Integer> getOtherDBCheckTypeList() {
            return new ArrayList<>();
        }

        @Override
        public Object getConnectInfoByBusinessId(int tmp, Long businessId) {
            return null;
        }

        @Override
        public boolean isSatisfied(Integer typeId, ProjectFlowListConditionVo projectFlowListConditionVo, Object businessInfo) {
            return true;
        }
    },
    VERIFY_SET_PROJECT_MILESTONE_VERIFY(ProjectConfigEnum.VERIFY_SET_PROJECT_MILESTONE_VERIFY,"项目里程碑审批", "项目里程碑申请") {
        @Override
        public Map<Integer, Map<Long, String>> getTargetTypeConditionNameMap(Map<Integer, Set<Object>> conditionMap) {
            return new HashMap<>();
        }

        @Override
        public Map<? extends Long, ? extends String> getBusinessNameMap(List<Long> ids) {
            return SpringContextHelper.getBean(ProjectMilestoneVerifyService.class).getBusinessNameMap(ids);
        }

        @Override
        public Object getFlowParamDetail(FlowTypeIdAndParamIdModel model) {
            return null;
        }

        @Override
        public Object getFlowTypeParam() {
            return null;
        }

        @Override
        public String getConditionStr(ProjectFlowListConditionModel model) {
            return null;
        }

        @Override
        public Map<Integer, String> getFlowTypeConditionMap() {
            return new HashMap<>();
        }

        @Override
        public <T> boolean createApplyInfo(T model) {
            boolean applyInfo = SpringContextHelper.getBean(ProjectBusinessMilestoneApplyImplService.class).createApplyInfo((ProjectMilestoneVerifyModel) model);
            return applyInfo;
        }

        @Override
        public boolean updateBusinessInfoWhenFlowFinish(Long businessId) {
            return SpringContextHelper.getBean(ProjectBusinessMilestoneApplyImplService.class).updateBusinessInfoWhenFlowFinish(businessId);
        }

        @Override
        public List<ProjectApplyFlowInfoPojo> getProjectApplyFlowInfo(Long applyerId, ProjectBusinessFlowModel projectBusinessFlowModel, SysUserModel sysUserModel, Long businessFlowVerifyId) {
            return SpringContextHelper.getBean(ProjectBusinessMilestoneApplyImplService.class).getProjectApplyFlowInfo(applyerId, projectBusinessFlowModel, sysUserModel, businessFlowVerifyId);
        }

        @Override
        public boolean revertBusinessInfo(Long businessId) {
            return SpringContextHelper.getBean(ProjectBusinessMilestoneApplyImplService.class).revertBusinessInfo(businessId);
        }

        @Override
        public boolean refuseBusinessInfo(Long businessId) {
            return SpringContextHelper.getBean(ProjectBusinessMilestoneApplyImplService.class).refuseBusinessInfo(businessId);
        }

        @Override
        public List<Integer> getOtherDBCheckTypeList() {
            return new ArrayList<>();
        }

        @Override
        public Object getConnectInfoByBusinessId(int tmp, Long businessId) {
            return null;
        }

        @Override
        public boolean isSatisfied(Integer typeId, ProjectFlowListConditionVo projectFlowListConditionVo, Object businessInfo) {
            return true;
        }
    },
    CHANGE_APPLY_PROJECT_MILESTONE_CHANGE_VERIFY(ProjectConfigEnum.CHANGE_APPLY_PROJECT_MILESTONE_CHANGE_VERIFY,"项目里程碑变更审批", "项目里程碑变更申请") {
        @Override
        public Map<Integer, Map<Long, String>> getTargetTypeConditionNameMap(Map<Integer, Set<Object>> conditionMap) {
            return new HashMap<>();
        }

        @Override
        public Map<? extends Long, ? extends String> getBusinessNameMap(List<Long> ids) {
            return SpringContextHelper.getBean(ProjectMilestoneVerifyService.class).getBusinessNameMap(ids);
        }

        @Override
        public Object getFlowParamDetail(FlowTypeIdAndParamIdModel model) {
            return null;
        }

        @Override
        public Object getFlowTypeParam() {
            return null;
        }

        @Override
        public String getConditionStr(ProjectFlowListConditionModel model) {
            return null;
        }

        @Override
        public Map<Integer, String> getFlowTypeConditionMap() {
            return null;
        }

        @Override
        public <T> boolean createApplyInfo(T model) {
            ProjectMilestoneVerifyModel projectMilestoneModel = (ProjectMilestoneVerifyModel) model;
            return SpringContextHelper.getBean(ProjectBusinessMilestoneChangeApplyImplService.class).createApplyInfo(projectMilestoneModel);
        }

        @Override
        public boolean updateBusinessInfoWhenFlowFinish(Long businessId) {
            return SpringContextHelper.getBean(ProjectBusinessMilestoneChangeApplyImplService.class).updateBusinessInfoWhenFlowFinish(businessId);
        }

        @Override
        public List<ProjectApplyFlowInfoPojo> getProjectApplyFlowInfo(Long applyerId, ProjectBusinessFlowModel projectBusinessFlowModel, SysUserModel sysUserModel, Long businessFlowVerifyId) {
            return SpringContextHelper.getBean(ProjectBusinessMilestoneChangeApplyImplService.class).getProjectApplyFlowInfo(applyerId, projectBusinessFlowModel, sysUserModel, businessFlowVerifyId);
        }

        @Override
        public boolean revertBusinessInfo(Long businessId) {
            return SpringContextHelper.getBean(ProjectBusinessMilestoneChangeApplyImplService.class).revertBusinessInfo(businessId);
        }

        @Override
        public boolean refuseBusinessInfo(Long businessId) {
            return SpringContextHelper.getBean(ProjectBusinessMilestoneChangeApplyImplService.class).refuseBusinessInfo(businessId);
        }

        @Override
        public List<Integer> getOtherDBCheckTypeList() {
            return new ArrayList<>();
        }

        @Override
        public Object getConnectInfoByBusinessId(int tmp, Long businessId) {
            return null;
        }

        @Override
        public boolean isSatisfied(Integer typeId, ProjectFlowListConditionVo projectFlowListConditionVo, Object businessInfo) {
            return true;
        }
    };


    private Integer value;
    private String type;
    private String describe;
    private String applyName;

    ProjectFlowTypeEnum(ProjectConfigEnum projectConfigEnum, String describe, String applyName) {
        this.value = projectConfigEnum.getValue();
        this.type = projectConfigEnum.getType();
        this.describe = describe;
        this.applyName = applyName;
    }

    ProjectFlowTypeEnum(ProjectEstablishConfigEnum establishProjectType, String describe, String applyName) {
        this.value = establishProjectType.getValue();
        this.type = establishProjectType.getType();
        this.describe = describe;
        this.applyName = applyName;
    }

    public static Map<Integer, ProjectFlowTypeEnum> getEnumMap() {
        return Stream.of(ProjectFlowTypeEnum.values())
                .collect(Collectors.toMap(ProjectFlowTypeEnum::getValue, x -> x));
    }

    public static Object getProjectFlowParam(Integer flowType) {
        ProjectFlowTypeEnum targetEnum = getEnumMap().get(flowType);
        if (targetEnum == null) {
            throw new SystemParamCheckException("流程类型未定义");
        }
        return targetEnum.getFlowTypeParam();
    }

    public static Object getProjectFlowParamDetailInfo(FlowTypeIdAndParamIdModel model) {
        ProjectFlowTypeEnum targetEnum = getEnumMap().get(model.getFlowType());
        if (targetEnum == null) {
            throw new SystemParamCheckException("流程类型未定义");
        }
        return targetEnum.getFlowParamDetail(model);
    }

    public static List<Map<String, Object>> getFullType() {
        return Stream.of(ProjectFlowTypeEnum.values()).map(x ->
                new HashMap<String, Object>(3) {{
                    put("value", x.value);
                    put("type", x.type);
                    put("text", x.describe);
                }}
        ).collect(Collectors.toList());
    }

    public static ProjectFlowTypeEnum getTargetMap(Integer flowConfigType) {
        if (flowConfigType == null) {
            throw new SystemParamCheckException("传入参数异常，无法找到对应流程");
        }
        ProjectFlowTypeEnum targetEnum = getEnumMap().get(flowConfigType);
        if (targetEnum == null) {
            throw new SystemParamCheckException("流程类型未定义");
        }
        return targetEnum;
    }

    public static Map<Integer, String> getMap() {
        return Stream.of(ProjectFlowTypeEnum.values()).collect(
                Collectors.toMap(ProjectFlowTypeEnum::getValue, ProjectFlowTypeEnum::getDescribe));
    }

    /**
     * 通过流程类型，以及对应的集合，查询对应的业务名称，流程详情使用
     * @param map 类型为key，业务主键id为value的map
     * @return
     */
    public static Map<Long, String> getNamesMap(Map<Integer, Set<Long>> map) {
        Map<Long, String> namesMap = new HashMap<>();
        Map<Integer, ProjectFlowTypeEnum> enumMap = getEnumMap();
        map.forEach((x, y) -> {
            if (enumMap.get(x) == null) {
                throw new SystemParamCheckException("申请的流程类型未定义").appendAlaramMsg("flowType:" + x);
            }
            namesMap.putAll(enumMap.get(x).getBusinessNameMap(new ArrayList<>(y)));
        });
        return namesMap;
    }

    public static Map<Integer, Map<Long, String>> getTargetConditionNamesMap(Integer typeId, Map<Integer, Set<Object>> conditionMap) {
        ProjectFlowTypeEnum typeEnum = getEnumMap().get(typeId);
        if (typeEnum == null) {
            throw new SystemParamCheckException("流程类型参数未定义");
        }
        return typeEnum.getTargetTypeConditionNameMap(conditionMap);
    }

    public static List<Map<String, Object>> getFlowTypes() {
        return Stream.of(ProjectFlowTypeEnum.values()).map(x -> new HashMap<String, Object>() {{
            put("value", x.getValue());
            put("text", x.getApplyName());
        }}).collect(Collectors.toList());
    }

    public static List<Integer> getProjectFlowTypes() {
        return new ArrayList<Integer>(){{
            add(PROJECT_CREATE_VERIFY.value);
            add(PROJECT_CHANGE_VERIFY.value);
        }};
    }

    public static List<Integer> getEstablishProjectFlowTypes() {
        return new ArrayList<Integer>(){{
            add(PROJECT_ESTABLISH_VERIFY.value);
        }};
    }

    /**
     * 通过类型，业务数据ids，查询对应的名称数据
     * @param conditionMap
     * @return
     */
    public abstract Map<Integer, Map<Long, String>> getTargetTypeConditionNameMap(Map<Integer, Set<Object>> conditionMap);

    /**
     * 通过传入的业务id，查询对应的业务id名称map
     * @param ids
     * @return
     */
    public abstract Map<? extends Long, ? extends String> getBusinessNameMap(List<Long> ids);

    public abstract Object getFlowParamDetail(FlowTypeIdAndParamIdModel model);

    public Integer getValue() {
        return value;
    }

    public String getType() {
        return type;
    }

    public String getDescribe() {
        return describe;
    }

    public String getApplyName() {
        return applyName;
    }

    /**
     * 获取流程类型参数
     * @return
     */
    public abstract Object getFlowTypeParam();

    /**
     * 获取条件字符串
     * @param model
     * @return
     */
    public abstract String getConditionStr(ProjectFlowListConditionModel model);

    /**
     * 获取流程类型下的参数类型map
     * @return
     */
    public abstract Map<Integer, String> getFlowTypeConditionMap();

    /**
     * 创建申请信息
     * @param model
     * @param <T>
     * @return
     */
    public abstract <T> boolean createApplyInfo(T model);

    /**
     * 当流程审核通过进行的操作
     * @param businessId
     * @return
     */
    public abstract boolean updateBusinessInfoWhenFlowFinish(Long businessId);

    /**
     * 通过申请人id以及实际创建提交的流程信息，生成下一流程待插入的信息
     * @param applyerId 申请人id
     * @param projectBusinessFlowModel 业务流程id，和确认的flowListId
     * @param sysUserModel 用户信息 当前的用户信息
     * @param businessFlowVerifyId 业务流程审核id， 上一步流程审核id
     * @return
     */
    public abstract List<ProjectApplyFlowInfoPojo> getProjectApplyFlowInfo(Long applyerId, ProjectBusinessFlowModel projectBusinessFlowModel, SysUserModel sysUserModel, Long businessFlowVerifyId);

    /**
     * 撤销申请信息
     *
     * @param businessId
     * @return
     */
    public abstract boolean revertBusinessInfo(Long businessId);

    /**
     * 拒绝操作下各个业务流程类型根据传入的主键id进行数据拒绝操作更新
     * @param businessId
     * @return
     */
    public abstract boolean refuseBusinessInfo(Long businessId);

    /**
     * 获取该类型下，内置条件数据中，需要跨库查询的业务类型
     * @return
     */
    public abstract List<Integer> getOtherDBCheckTypeList();

    /**
     * 通过参数类型，查询该类型下对应的业务id为bussinessId的业务
     * @param typeId
     * @param businessId
     * @return
     */
    public abstract Object getConnectInfoByBusinessId(int typeId, Long businessId);

    /**
     * 查询当前类型条件下，实际数据是否满足条件流程定义的数据
     * @param typeId
     * @param projectFlowListConditionVo
     * @param businessInfo
     * @return
     */
    public abstract boolean isSatisfied(Integer typeId, ProjectFlowListConditionVo projectFlowListConditionVo, Object businessInfo);
}
