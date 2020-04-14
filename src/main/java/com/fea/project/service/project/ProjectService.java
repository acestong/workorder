package com.fea.project.service.project;

import com.alibaba.fastjson.JSON;
import com.fea.project.api.other.io.project.IProjectBusinessModel;
import com.fea.project.api.other.model.base.SysDepartmentModel;
import com.fea.project.api.other.model.base.SysDictionaryItemModel;
import com.fea.project.api.other.model.base.SysJobModel;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.model.base.vo.SysJobVo;
import com.fea.project.api.other.model.base.vo.SysUserVo;
import com.fea.project.api.other.model.crm.CrmDictionaryIndustryModel;
import com.fea.project.api.other.model.crm.CrmDictionaryRegionModel;
import com.fea.project.api.other.model.crm.vo.*;
import com.fea.project.api.other.service.base.SysDepartmentService;
import com.fea.project.api.other.service.base.SysDictionaryItemService;
import com.fea.project.api.other.service.base.SysJobService;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.api.other.service.crm.*;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.project.ProjectMapper;
import com.fea.project.enums.apply.ProjectApplyVerifyStatusEnum;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.enums.base.EnableStatusEnum;
import com.fea.project.enums.project.*;
import com.fea.project.enums.task.ProjectTeamTagEnum;
import com.fea.project.enums.team.ProjectDefaultRoleEnum;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.apply.vo.ProjectApplyVo;
import com.fea.project.model.base.ProjectDictionaryItemModel;
import com.fea.project.model.establishproject.vo.ProjectInnerProjectBusinessVo;
import com.fea.project.model.plan.vo.ProjectTreeModelVo;
import com.fea.project.model.project.ProjectConcernModel;
import com.fea.project.model.project.ProjectModel;
import com.fea.project.model.project.ProjectVersionModel;
import com.fea.project.model.project.pojo.ProjectAttentionPojo;
import com.fea.project.model.project.pojo.ProjectCodeQueryPojo;
import com.fea.project.model.project.pojo.ProjectPojo;
import com.fea.project.model.project.vo.*;
import com.fea.project.model.role.ProjectRoleModel;
import com.fea.project.model.role.ProjectRoleUserModel;
import com.fea.project.model.team.ProjectTeamUserModel;
import com.fea.project.model.team.vo.TeamPersonSelectVo;
import com.fea.project.model.user.ProjectUserModel;
import com.fea.project.service.apply.ProjectApplyBusinessService;
import com.fea.project.service.apply.ProjectApplyService;
import com.fea.project.service.apply.io.IProjectApplyBusiness;
import com.fea.project.service.apply.io.IProjectFlowListChoose;
import com.fea.project.service.base.ProjectDictionaryItemService;
import com.fea.project.service.baseconfig.ProjectCodeRegService;
import com.fea.project.service.businessflow.flowtype.ProjectBusinessCreateApplyImplService;
import com.fea.project.service.establishproject.project.ProjectEstablishProjectService;
import com.fea.project.service.flow.ProjectFlowListService;
import com.fea.project.service.flow.ProjectFlowService;
import com.fea.project.service.role.ProjectRoleAuthorityDetailService;
import com.fea.project.service.role.ProjectRoleService;
import com.fea.project.service.role.ProjectRoleUserService;
import com.fea.project.service.team.ProjectTeamService;
import com.fea.project.service.team.ProjectTeamUserService;
import com.fea.project.service.user.ProjectUserService;
import com.fea.project.util.HttpServletRequestUtil;
import com.fea.project.util.ListUtil;
import com.fea.project.util.UserUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2019/09/23.
 * 项目信息表 Service
 */
@Service
public class ProjectService implements IProjectApplyBusiness, IProjectFlowListChoose {

    @Autowired
    private ProjectMapper projectMapper;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private ThreadPoolExecutor threadPoolExecutor;

    @Autowired
    private ProjectDictionaryItemService projectDictionaryItemService;

    @Autowired
    private CrmContractService crmContractService;

    @Autowired
    private CrmSaleChanceService crmSaleChanceService;

    @Autowired
    private ProjectCodeRegService projectCodeRegService;

    @Autowired
    private ProjectUserService projectUserService;

    @Autowired
    private ProjectConcernService projectConcernService;

    @Autowired
    private ProjectTeamService projectTeamService;

    @Autowired
    private ProjectTeamUserService projectTeamUserService;

    @Autowired
    private ProjectRoleService projectRoleService;

    @Autowired
    private SysDepartmentService sysDepartmentService;

    @Autowired
    private CrmOrderService crmOrderService;

    @Autowired
    private ProjectBusinessCreateApplyImplService projectBusinessCreateApplyImplService;

    @Autowired
    private ProjectFlowService projectFlowService;

    @Autowired
    private ProjectVersionService projectVersionService;

    @Autowired
    private ProjectEstablishProjectService projectEstablishProjectService;

    @Autowired
    private ProjectRoleUserService projectRoleUserService;

    @Autowired
    private ProjectApplyBusinessService projectApplyBusinessService;

    @Autowired
    private ProjectRoleAuthorityDetailService projectRoleAuthorityDetailService;

    @Autowired
    private CrmDictionaryIndustryService crmDictionaryIndustryService;

    @Autowired
    private CrmDictionaryRegionService crmDictionaryRegionService;

    @Autowired
    private SysDictionaryItemService sysDictionaryItemService;

    @Autowired
    private SysJobService sysJobService;

    @Autowired
    private ProjectApplyService projectApplyService;


    /**
     * 获取项目创建或是更新的基础参数
     *
     * @return
     */
    public Map<String, Object> selectCreateOrUpdateBaseInfo() {
        Map<String, Object> map = this.projectDictionaryItemService.selectProjectInitParamWhenNullCreate();
        map.put("project_from", ProjectResourceEnum.getProjectResource());
        map.put("project_action_status", ProjectActionStatusEnum.getProjectActionStatus());
        return map;
    }

    public Object selectAssociatedBusiness(ProjectModel model) {
        if (model == null || model.getResource() == null) {
            throw new SystemParamCheckException("传入的项目来源无效");
        }
        Long regId = UserUtil.getUserRegId();
        return ProjectResourceEnum.getConnectBusinessByBussinessType(model.getResource(), regId);
    }

    public List<SysUserModel> selectUsersByRegId() {
        Long regId = UserUtil.getUserRegId();
        return sysUserService.selectByRegId(regId);
    }

    public BasePageInfo<ProjectVo> listByParam(BasePageInfo<ProjectPojo> pageInfo) throws ExecutionException, InterruptedException {
        //查询用户关注项目
        List<Long> attentionIds = this.projectConcernService.selectByModel(new ProjectConcernModel(UserUtil.getUserId()))
                .stream().map(ProjectConcernModel::getProjectId).collect(Collectors.toList());
        //进行类型区分
        List<ProjectVo> list = null;
        if(Objects.equals(ProjectQueryTypeEnum.TYPE_ALL_PROJECT.getValue(), pageInfo.getModel().getQueryType())){
            //1 全部项目
            list = this.selectAllProjectModel(pageInfo);
        }else{
            //2 条件项目
            PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize(), true);
            list = this.projectMapper.selectByFilterAndOrderParams(pageInfo);
        }
        list = fileProjectInfo(list);
        translateProjectAttentionByAttentionIds(attentionIds, list);

        return new BasePageInfo<>(list);
    }

    private void translateProjectAttentionByAttentionIds(List<Long> attentionIds, List<ProjectVo> list) {
        list.forEach(x -> {
            if (attentionIds.contains(x.getId())) {
                x.setAttention(Boolean.TRUE);
                return;
            }
            x.setAttention(Boolean.FALSE);
        });
    }

    public List<ProjectVo> selectAllProjectModel(BasePageInfo<ProjectPojo> pageInfo) throws ExecutionException, InterruptedException {
        List<Long> projectIds = selectCurrentUserCanSelectAllProjectIds();
        pageInfo.getModel().setIds(projectIds);
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize(), true);
        return this.projectMapper.selectByFilterAndOrderParams(pageInfo);
    }

    /**
     * 查询当前用户的所有项目
     */
    private List<Long> selectCurrentUserCanSelectAllProjectIds() {
        List<Long> projectIds = new ArrayList<>();
        //我创建的项目
        List<Long> createProjectIds = this.projectMapper.selectByCreateId(UserUtil.getUserId()).stream().map(ProjectModel::getId).collect(Collectors.toList());
        //我关注的项目
        List<Long> payAttentionIds = this.projectMapper.selectByAttention(UserUtil.getUserId()).stream().map(ProjectModel::getId).collect(Collectors.toList());
        //我负责的项目
        List<Long> leaderProjectIds = this.projectMapper.selectByLeader(UserUtil.getUserId()).stream().map(ProjectModel::getId).collect(Collectors.toList());
        //我参与的项目
        List<Long> joinProjectIds = this.projectMapper.selectByJoiner(UserUtil.getUserId()).stream().map(ProjectModel::getId).collect(Collectors.toList());
        //我管辖人员负责项目
        List<Long> leaderIds = this.selectUserIdsByCurrentUser();
        List<Long> managePersonProjectIds = ListUtil.isNullOrEmpty(leaderIds)?new ArrayList<>():this.projectMapper.selectByLeaders(leaderIds).stream().map(ProjectModel::getId).collect(Collectors.toList());
        //我额外的项目TODO

        projectIds.addAll(createProjectIds);
        projectIds.addAll(payAttentionIds);
        projectIds.addAll(leaderProjectIds);
        projectIds.addAll(joinProjectIds);
        projectIds.addAll(managePersonProjectIds);
        return projectIds.stream().distinct().collect(Collectors.toList());
    }

    public List<Long> selectUserIdsByCurrentUser(){
        Long jobId = this.sysJobService.selectJobIdByUserId(UserUtil.getUserId());
        if(jobId == null){
            return new ArrayList<>();
        }
        List<SysJobVo> sysJobVos = this.sysJobService.selectTreeListByJobId(jobId);
        List<Long> jobIds = sysJobVos.stream().filter(x -> !Objects.equals(jobId, x.getID())).map(SysJobModel::getID).collect(Collectors.toList());
        //通过jobId,查询对应的用户信息
        List<UserIdAndJobIdModel> list = sysJobService.selectByRegIdAndJobIds(UserUtil.getUserRegId(), jobIds);
        return list.stream().map(UserIdAndJobIdModel::getUserId).distinct().collect(Collectors.toList());
    }


    public BasePageInfo<ProjectVo> listWithEstablishProjectByParam(BasePageInfo<ProjectPojo> pageInfo) throws ExecutionException, InterruptedException {
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize(), true);
        List<ProjectVo> list = fileProjectInfo(this.projectMapper.selectWithEstablishProjectByFilterAndOrderParams(pageInfo));
        return new BasePageInfo<>(list);
    }

    /**
     * 填充项目中的人员以及部门信息
     *
     * @param list
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public List<ProjectVo> fileProjectInfo(List<ProjectVo> list) throws ExecutionException, InterruptedException {
        Map<Long, SysUserVo> sysUserVoMap = this.getAllUserInfoMap(list);
        Map<Long, String> departmentModelMap = this.getAllDeptInfoMap(list);
        Map<Long, String> regionMap = this.getAllRegionInfoMap(list);
        Map<Long, String> industryMap = this.getAllIndustryInfoMap(list);
        Map<Integer, Map<Long, IProjectBusinessModel>> businessMap = this.getAllBusinessInfoMap(list);
        Map<Integer, String> projectVerifyMap = ProjectApplyVerifyStatusEnum.getMap();
        Map<Integer, String> projectEstablishmentMap = ProjectEstablishmentEnum.getMap();
        Map<Integer, String> projectStatusMap = ProjectStatusEnum.getMap();
        Map<Integer, String> projectActionStatusMap = ProjectActionStatusEnum.getMap();
        Map<Long, String> dicMap = this.getDicMapByList(list);
        Map<Long, String> projectFromMap = translateDicListMapToMap(ProjectResourceEnum.getApplyProjectResource());
        Map<Long, String> versionMap = this.projectVersionService.selectByIds(list.stream().map(ProjectVo::getVersion).distinct()
                .collect(Collectors.toList())).stream().collect(Collectors.toMap(ProjectVersionModel::getId, ProjectVersionModel::getVersionCode));
        list.forEach(tmp -> {
            tmp.setLeaderName(sysUserVoMap.get(tmp.getLeader()) == null ? null : sysUserVoMap.get(tmp.getLeader()).getRealName());
            tmp.setApplyerName(sysUserVoMap.get(tmp.getApplyer()) == null ? null : sysUserVoMap.get(tmp.getApplyer()).getRealName());
            tmp.setParterNames(this.translateListToStr(tmp.getPartners(), sysUserVoMap));
            tmp.setDeptName(departmentModelMap.get(tmp.getApplyDepart()));
            Map<Long, IProjectBusinessModel> tmpMap = businessMap.get(tmp.getResource());
            if (tmpMap != null) {
                if(Objects.equals(tmp.getResource(), ProjectResourceEnum.INNER_PROJECT.getValue())){
                    tmp.setProjectBusinessModels(Stream.of(tmp.getId()).map(tmpMap::get).collect(Collectors.toList()));
                }else{
                    tmp.setProjectBusinessModels(Stream.of(tmp.getConnectId().split(",")).filter(StringUtil::isNotEmpty)
                            .map(str -> tmpMap.get(Long.valueOf(str))).collect(Collectors.toList()));
                }
            }
            tmp.setConnectBusinessName(this.getBusinessNames(tmp.getProjectBusinessModels()));
            tmp.setVerifyStatusName(projectVerifyMap.get(tmp.getVerifyStatus()));
            tmp.setProjectStatusName(projectStatusMap.get(tmp.getProjectStatus()));
            tmp.setEstablishmentName(projectEstablishmentMap.get(tmp.getEstablishment()));
            tmp.setActionStatusName(projectActionStatusMap.get(tmp.getActionStatus()));
            tmp.setTypeName(dicMap.get(tmp.getType()));
            tmp.setPriorityName(dicMap.get(tmp.getPriority()));
            tmp.setLevelName(dicMap.get(tmp.getLevel()));
            tmp.setRiskLevelName(dicMap.get(tmp.getRiskLevel()));
            tmp.setResourceName(projectFromMap.get(tmp.getResource() != null ? Long.valueOf(tmp.getResource() + "") : null));
            tmp.setVersionCode(versionMap.get(tmp.getVersion()));
            tmp.setIndustryName(industryMap.get(tmp.getIndustry()));
            tmp.setAreaName(regionMap.get(tmp.getArea()));
        });
        return list;
    }

    private Map<Long, String> getAllIndustryInfoMap(List<ProjectVo> list) {
        List<Long> industryIds = list.stream().filter(x -> x.getIndustry() != null).map(ProjectVo::getIndustry).distinct().collect(Collectors.toList());
        List<CrmDictionaryIndustryModel> crmDictionaryIndustryModels = this.crmDictionaryIndustryService.selectByIds(industryIds);
        return crmDictionaryIndustryModels.stream().collect(Collectors.toMap(CrmDictionaryIndustryModel::getID, CrmDictionaryIndustryModel::getNAME));
    }

    private Map<Long, String> getAllRegionInfoMap(List<ProjectVo> list) {
        List<Long> regions = list.stream().filter(x -> x.getArea() != null).map(ProjectVo::getArea).distinct().collect(Collectors.toList());
        List<CrmDictionaryRegionModel> crmDictionaryRegionModels = this.crmDictionaryRegionService.selectByIds(regions);
        return crmDictionaryRegionModels.stream().collect(Collectors.toMap(CrmDictionaryRegionModel::getID, CrmDictionaryRegionModel::getNAME));
    }

    private Map<Long, String> getDicMapByList(List<ProjectVo> list) {
        if (ListUtil.isNullOrEmpty(list)) {
            return new HashMap<>(0);
        }
        Set<Long> ids = new HashSet<>();
        list.forEach(tmp -> {
            Set<Long> dicSet = tmp.translateDicIdsToSet();
            if (!dicSet.isEmpty()) {
                ids.addAll(dicSet);
            }
        });
        return this.projectDictionaryItemService.selectByIds(new ArrayList<>(ids))
                .stream().collect(Collectors.toMap(ProjectDictionaryItemModel::getId, ProjectDictionaryItemModel::getName));
    }

    private Map<Long, String> translateDicListMapToMap(List<Map<String, Object>> list) {
        if (ListUtil.isNullOrEmpty(list)) {
            return new HashMap<>(0);
        }
        Map<Long, String> map = new HashMap<>(list.size());
        list.forEach(tmp -> map.put(Long.parseLong((String) tmp.get("id")), (String) tmp.get("name")));
        return map;
    }

    private String getBusinessNames(List<IProjectBusinessModel> projectBusinessModels) {
        if (ListUtil.isNullOrEmpty(projectBusinessModels)) {
            return null;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < projectBusinessModels.size(); i++) {
            if (projectBusinessModels.get(i) == null) {
                continue;
            }
            if (StringUtil.isEmpty(projectBusinessModels.get(i).getShowName())) {
                continue;
            }
            sb = sb.append(projectBusinessModels.get(i).getShowName()).append(",");
        }
        return StringUtil.isEmpty(sb.toString()) ? null : sb.toString().replaceAll(",+$", "");
    }

    /**
     * 通过项目查询项目下的部门信息
     *
     * @param list
     * @return
     */
    private Map<Long, String> getAllDeptInfoMap(List<ProjectVo> list) {
        Set<Long> deptIds = new HashSet<>();
        list.forEach(x -> {
            if (x.getApplyDepart() != null) {
                deptIds.add(x.getApplyDepart());
            }
        });
        List<SysDepartmentModel> models = this.sysDepartmentService.selectByIds(new ArrayList(deptIds));
        return models.stream().collect(Collectors.toMap(SysDepartmentModel::getDEPID, SysDepartmentModel::getDEPNAME));
    }

    private String translateListToStr(List<Long> list, Map<Long, SysUserVo> map) {
        if (ListUtil.isNullOrEmpty(list)) {
            return "";
        }
        List<String> names = new ArrayList<>();
        list.forEach(x -> {
            SysUserVo tmpModel = map.get(x);
            if(tmpModel != null){
                names.add(tmpModel.getRealName());
            }
        });
        return names.isEmpty()?"":String.join(",", names);
    }

    private Map<Integer, Map<Long, IProjectBusinessModel>> getAllBusinessInfoMap(List<ProjectVo> list) throws ExecutionException, InterruptedException {
        Map<Integer, Set<Long>> businessMap = new HashMap<>(3);
        Long regId = UserUtil.getUserRegId();
        list.forEach(tmp -> {
            Set<Long> tmpList = businessMap.computeIfAbsent(
                    tmp.getResource(), k -> new HashSet<>());
            Integer resourceType = tmp.getResource();
            if (!Objects.equals(resourceType, ProjectResourceEnum.INNER_PROJECT.getValue()) && !StringUtil.isEmpty(tmp.getConnectId())) {
                tmpList.addAll(Stream.of(tmp.getConnectId().split(",")).filter(StringUtil::isNotEmpty).map(Long::parseLong).collect(Collectors.toSet()));
            }else if(Objects.equals(resourceType, ProjectResourceEnum.INNER_PROJECT.getValue())){
                tmpList.add(tmp.getId());
            }
        });
        //进行合同相关查询
        Map<Integer, Map<Long, IProjectBusinessModel>> resultMap = new HashMap<>();
        Future contractInfo = threadPoolExecutor.submit((Callable<Object>) () -> {
            Set<Long> tmpList = businessMap.get(ProjectResourceEnum.MARKETING_CONTRACT.getValue());
            if (tmpList == null || tmpList.isEmpty()) {
                return new HashMap<>(0);
            }
            List<CrmContractVo> crmContractVos = this.crmContractService.selectByIds(new ArrayList<>(tmpList));
            return crmContractVos.stream().collect(Collectors.toMap(CrmContractVo::getId, crmContractVo -> crmContractVo));
        });
        //进行销售机会查询
        Future crmSalChanceInfo = threadPoolExecutor.submit((Callable<Object>) () -> {
            Set<Long> tmpList = businessMap.get(ProjectResourceEnum.SALE_CHANCE.getValue());
            if (tmpList == null || tmpList.isEmpty()) {
                return new HashMap<>(0);
            }
            List<CrmSaleChanceVo> crmSaleChanceVos = this.crmSaleChanceService.selectByIds(new ArrayList<>(tmpList));
            return crmSaleChanceVos.stream().collect(Collectors.toMap(CrmSaleChanceVo::getId, crmSaleChanceVo -> crmSaleChanceVo));
        });
        //进行销售机会查询
        final HttpServletRequest request = HttpServletRequestUtil.getRequest();
        Future orderInfo = threadPoolExecutor.submit((Callable<Object>) () -> {
            Set<Long> tmpList = businessMap.get(ProjectResourceEnum.ORDER.getValue());
            if (tmpList == null || tmpList.isEmpty()) {
                return new HashMap<>(0);
            }
            List<CrmOrderListVo> crmOrderListVos = this.crmOrderService.getOrderInfosByIdsTreadPool(new ArrayList<>(tmpList), request);
            return crmOrderListVos.stream().collect(Collectors.toMap(CrmOrderListVo::getId, crmOrderListVo -> crmOrderListVo));
        });
        //进行内部项目查询
        Future innerProject = threadPoolExecutor.submit((Callable<Object>) () -> {
            Set<Long> tmpList = businessMap.get(ProjectResourceEnum.INNER_PROJECT.getValue());
            if (tmpList == null || tmpList.isEmpty()) {
                return new HashMap<>(0);
            }
            List<ProjectInnerProjectBusinessVo> projectEstablishProjectVos = this.projectEstablishProjectService.selectByProjectIds(new ArrayList<>(tmpList), regId);
            return projectEstablishProjectVos.stream().collect(Collectors.toMap(ProjectInnerProjectBusinessVo::getId, x -> x));
        });
        resultMap.put(ProjectResourceEnum.MARKETING_CONTRACT.getValue(), (Map<Long, IProjectBusinessModel>) contractInfo.get());
        resultMap.put(ProjectResourceEnum.SALE_CHANCE.getValue(), (Map<Long, IProjectBusinessModel>) crmSalChanceInfo.get());
        resultMap.put(ProjectResourceEnum.ORDER.getValue(), (Map<Long, IProjectBusinessModel>) orderInfo.get());
        resultMap.put(ProjectResourceEnum.INNER_PROJECT.getValue(), (Map<Long, IProjectBusinessModel>) innerProject.get());
        return resultMap;
    }

    private Map<Long, SysUserVo> getAllUserInfoMap(List<ProjectVo> list) {
        Set<Long> userIds = new HashSet<>();
        list.forEach(tmp -> {
            if (tmp.getLeader() != null) {
                userIds.add(tmp.getLeader());
            }
            if (tmp.getApplyer() != null) {
                userIds.add(tmp.getApplyer());
            }
            if (!ListUtil.isNullOrEmpty(tmp.getPartners())) {
                userIds.addAll(tmp.getPartners());
            }
        });
        return this.sysUserService.selectUserInfoAndDeptInfoByIds(new ArrayList<>(userIds))
                .stream().collect(Collectors.toMap(SysUserVo::getUserId, sysUserVo -> sysUserVo));
    }

    /**
     * aop数据自动校验， 进行数据新增
     *
     * @param projectModel
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ProjectModel insertModel(ProjectModel projectModel) throws Exception {
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        projectModel.setInitStatus();
        synchronized (this) {
            projectModel = projectModel.fillInsertBaseInfo(sysUserModel, projectCodeRegService
                    .getProjectCodeByRegId(new ProjectCodeQueryPojo(projectModel, sysUserModel)));
            List<ProjectUserModel> list = ProjectUserModel.createList(projectModel, ActionEnum.INSERT_ACTION);
            Long leaderId = projectModel.getLeader();
            ProjectUserModel leader = list.stream().filter(x -> Objects.equals(x.getUserId(), leaderId)).findFirst().get();
            if (this.projectMapper.insertSelective(projectModel) >= 0 && this.projectUserService.insertList(list, projectModel)) {
                Future<Boolean> teamFuture = initProjectTeam(sysUserModel, projectModel, list);
                Future<Boolean> roleFuture = initProjectRole(sysUserModel, projectModel, leader);
                if (teamFuture.get() && roleFuture.get()) {
                    return projectModel;
                }
            }
            throw new SystemParamCheckException("项目创建失败");
        }
    }


    /**
     * 初始化项目角色
     *
     * @param sysUserModel
     * @param projectModel
     * @return
     */
    private Future<Boolean> initProjectRole(SysUserModel sysUserModel, ProjectModel projectModel, ProjectUserModel leader) {
        return threadPoolExecutor.submit(() -> {
            ProjectRoleModel projectRoleModel = new ProjectRoleModel(ProjectDefaultRoleEnum.TYPE_PROJECT_ADMIN, sysUserModel, projectModel, ActionEnum.INSERT_ACTION);
            if (this.projectRoleService.insertSelective(projectRoleModel)
                && this.projectRoleUserService.insertSelective(new ProjectRoleUserModel(leader, projectRoleModel.getId(), sysUserModel))) {
                return true;
            }
            throw new SystemParamCheckException("项目角色初始化创建失败");
        });
    }


    /**
     * 初始化项目团队
     *
     * @param sysUserModel
     * @param projectModel
     * @param list
     * @return
     */
    private Future<Boolean> initProjectTeam(SysUserModel sysUserModel, ProjectModel projectModel, List<ProjectUserModel> list) {
        Long leaderId = projectModel.getLeader();
        final ProjectModel finalModel = projectModel;
        return threadPoolExecutor.submit(() -> {
            Long rootId = this.projectTeamService.insertProjectRootTeam(sysUserModel, finalModel);
            Long unGroupQueueId = this.projectTeamService.insertInitTeamsAndReturnUnGroupQueue(finalModel, sysUserModel, rootId);
            List<ProjectTeamUserModel> projectTeamUserModels = new ArrayList<>();
            list.forEach(tmp -> {
                if (Objects.equals(leaderId, tmp.getUserId())) {
                    projectTeamUserModels.add(new ProjectTeamUserModel(tmp, rootId, sysUserModel));
                } else {
                    projectTeamUserModels.add(new ProjectTeamUserModel(tmp, unGroupQueueId, sysUserModel));
                }
            });
            return this.projectTeamUserService.insertList(projectTeamUserModels);
        });
    }



    public ProjectModel updateModel(ProjectModel projectModel) {
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        projectModel.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
        if (this.projectMapper.updateByIdSelective(projectModel) >= 0) {
            return projectModel;
        }
        throw new SystemParamCheckException("项目创建失败");
    }

    public ProjectModel deleteModel(ProjectModel projectModel) {
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        if (projectModel == null || projectModel.getId() == null) {
            throw new SystemParamCheckException("项目删除时，未传入项目id，无法进行删除");
        }
        projectModel.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
        projectModel.setDelStatus(DeleteStatusEnum.DELETE.getStatus());
        if (this.projectMapper.updateByIdSelective(projectModel) >= 0) {
            return projectModel;
        }
        throw new SystemParamCheckException("项目删除失败");
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectAttentionPojo payAttentionModel(ProjectAttentionPojo model) {
        if (model == null || model.getId() == null || model.getAttention() == null) {
            throw new SystemParamCheckException("项目关注失败，参数校验报错").appendAlaramMsg(JSON.toJSONString(model));
        }
        ProjectModel projectModel = this.projectMapper.selectById(model.getId());
        if (Objects.isNull(projectModel)) {
            throw new SystemParamCheckException("项目数据已经不存在，无法进行操作").appendAlaramMsg(JSON.toJSONString(model));
        }
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        ProjectConcernModel projectConcernModel = this.projectConcernService.selectByProjectIdAndUserId(model.getId(), sysUserModel.getUserId());
        if (projectConcernModel == null) {
            if (!model.getAttention()) {
                throw new SystemParamCheckException("关注数据不存在，无法取消关注");
            }
            projectConcernModel = new ProjectConcernModel(model, sysUserModel);
            this.projectConcernService.insert(projectConcernModel);
            return model;
        }
        if (model.getAttention()) {
            throw new SystemParamCheckException("关注数据已存在，无法再次关注");
        }
        projectConcernModel.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
        projectConcernModel.setDelStatus(DeleteStatusEnum.DELETE.getStatus());
        this.projectConcernService.updateByIdSelective(projectConcernModel);
        return model;
    }

    public ProjectModel selectById(Long id) {
        if (id == null) {
            throw new SystemParamCheckException("传入的父节点id无效，无法进行查询");
        }
        return this.projectMapper.selectById(id);
    }

    public ProjectModel selectByRoleId(Long roleId) {
        if (roleId == null) {
            throw new SystemParamCheckException("角色id传入异常，无法进行查询");
        }
        return this.projectMapper.selectByRoleId(roleId);
    }

    /**
     * 查询项目详情
     * @param projectModel (id为必填项)
     * @return
     * @throws Exception
     */
    public ProjectVo selectOne(ProjectModel projectModel, Boolean establishFlag) throws Exception {
        if (projectModel == null || projectModel.getId() == null) {
            throw new SystemParamCheckException("项目id传入异常，无法进行查询");
        }
        ProjectVo projectVo = this.projectMapper.selectOne(projectModel.getId(), establishFlag);
        if (projectVo == null) {
            throw new SystemParamCheckException("项目信息不存在，请刷新后重试");
        }
        if(Objects.isNull(projectVo.getVerifyStatus())
                || ProjectApplyVerifyStatusEnum.getCanSubmitStatus().contains(projectVo.getVerifyStatus())){
            projectVo.setSubmitShow(EnableStatusEnum.ENABLE.getStatus());
        }
        return this.fileProjectInfo(Stream.of(projectVo).collect(Collectors.toList())).get(0);
    }

    public List<SysUserVo> selectCurrentProjectUsers() {
        Long regId = UserUtil.getUserRegId();
        return this.sysUserService.selectByRegIds(Stream.of(regId)
                .collect(Collectors.toList())).stream().map(x ->
                new SysUserVo(x.getUserId(), x.getRealName(), x.getDeptId(), x.getDeptName())).collect(Collectors.toList());
    }

    public List<TeamPersonSelectVo> selectCurrentProjectDept() {
        Long regId = UserUtil.getUserRegId();
        return this.sysDepartmentService.selectDeptTreeByRegId(regId);
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectModel updateProjectContent(ProjectModel model) {
        if (model == null || model.getId() == null || StringUtil.isEmpty(model.getContent())) {
            throw new SystemParamCheckException("传入的参数异常，无法进行项目内容更新");
        }
        SysUserModel userModel = this.sysUserService.getCurrentUsr();
        model.setUserInfo(userModel, ActionEnum.UPDATE_ACTION);
        if (this.projectMapper.updateByIdSelective(model) >= 0) {
            return model;
        }
        throw new SystemParamCheckException("数据更新异常，请检查当前项目信息是否存在");
    }

    public BasePageInfo<ProjectVo> listByUserId(BasePageInfo<ProjectPojo> pageInfo) throws ExecutionException, InterruptedException {
        //查询用户关注项目
        List<Long> attentionIds = this.projectConcernService.selectByModel(new ProjectConcernModel(UserUtil.getUserId()))
                .stream().map(ProjectConcernModel::getProjectId).collect(Collectors.toList());
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize(), true);
        List<ProjectVo> list = fileProjectInfo(this.projectMapper.listByUserId(pageInfo));
        translateProjectAttentionByAttentionIds(attentionIds, list);
        return new BasePageInfo<>(list);
    }

    public ProjectModel selectModelByStepId(Long stepId) {
        if (stepId == null) {
            throw new SystemParamCheckException("阶段id传入异常，无法进行项目信息查询");
        }
        return this.projectMapper.selectModelByStepId(stepId);
    }

    @Override
    public Map<? extends Long, ? extends String> getBusinessNameMap(List<Long> ids) {
        return this.selectByIds(ids);
    }

    public Map<Long, String> selectByIds(List<Long> ids) {
        if (ListUtil.isNullOrEmpty(ids)) {
            return new HashMap<>();
        }
        return this.projectMapper.selectByIds(ids).stream()
                .collect(Collectors.toMap(ProjectModel::getId, ProjectModel::getName));
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectModel submitToVerify(ProjectModel projectModel) {
        if (projectModel == null || projectModel.getId() == null) {
            throw new SystemParamCheckException("传入的项目id异常，无法进行提交审核");
        }
        ProjectModel tmpModel = this.projectMapper.selectById(projectModel.getId());
        if (!Objects.isNull(tmpModel.getVerifyStatus()) && !ProjectApplyVerifyStatusEnum.getCanSubmitStatus().contains(tmpModel.getVerifyStatus())) {
            throw new SystemParamCheckException("当前审批状态无法再次提交审批");
        }
        projectModel.setVerifyStatus(ProjectApplyVerifyStatusEnum.TYPE_VERIFYING.getValue());
        if (this.projectBusinessCreateApplyImplService.createApplyInfo(tmpModel)
                && this.projectMapper.updateByIdSelective(projectModel) >= 0) {
            return projectModel;
        }
        throw new SystemParamCheckException("项目提交审核异常，无法进行提交");
    }

    public Long getCurrentFlowNeedChooseFlowList(Long businessId, Long flowId) {
        return projectApplyBusinessService.getCurrentFlowNeedChooseFlowList(businessId, flowId, this);
    }


    @Transactional(rollbackFor = Exception.class)
    public boolean updateSelectiveById(ProjectModel projectModel) {
        if(projectModel == null || projectModel.getId() == null){
            throw new SystemParamCheckException("传入的项目参数异常，无法进行更新");
        }
        return this.projectMapper.updateByIdSelective(projectModel) >= 0;
    }

    @Override
    public Object selectModelByIdAndConditionModel(Long businessId, Map<Integer, String> conditionMap) {
        return this.projectMapper.selectModelByIdAndConditionModel(businessId, conditionMap);
    }


    @Transactional(rollbackFor = Exception.class)
    public boolean updateEstablishStatus(Long id, Integer establishment) {
        if(id == null || establishment == null){
            throw new SystemParamCheckException("参数传入异常,理想状态更新失败");
        }
        return this.projectMapper.updateEstablishStatus(id, establishment) >= 0;
    }

    public boolean updateDelStatusByProjectId(Long id, Integer delStatus) {
        if(id == null || delStatus == null){
            throw new SystemParamCheckException("项目删除标识传参异常，无法进行更新");
        }
        return this.projectMapper.updateDelStatusByProjectId(id, delStatus) >= 0;
    }

    public boolean updateSelectiveByIdOnEstablish(ProjectModel projectModel) {
        if(projectModel == null || projectModel.getId() == null){
            throw new SystemParamCheckException("传入的项目参数异常，无法进行更新");
        }
        return this.projectMapper.updateSelectiveByIdOnEstablish(projectModel) >= 0;
    }

    public ProjectStatisticsVo selectProjectCondition(BasePageInfo<ProjectPojo> pageInfo) {
        if(Objects.equals(ProjectQueryTypeEnum.TYPE_MANAGE_USER_PROJECT.getValue(), pageInfo.getModel().getQueryType())){
            List<Long> leaders = selectLeaderIdsByLeftSelectTypeAndId(pageInfo.getModel());
            if(leaders.isEmpty()){
                return ProjectStatisticsVo.initModel();
            }
            pageInfo.getModel().setLeaderIds(leaders);
        }
        List<ProjectVo> projectVos = this.projectMapper.selectByFilterAndOrderParams(pageInfo);
        return statisticsProjectModelsToStatisticsVo(projectVos);
    }

    public ProjectStatisticsVo statisticsProjectModelsToStatisticsVo(List<ProjectVo> projectVos) {
        Date now = new Date();
        ProjectStatisticsVo model = ProjectStatisticsVo.initModel();
        model.setTotalProject(new BigDecimal(projectVos.size()));
        projectVos.forEach(x -> {
            Date compareTime = Objects.isNull(x.getRealEndTime())?now:x.getRealEndTime();
            if(!Objects.isNull(x.getPlanEndTime()) && compareTime.compareTo(x.getPlanEndTime()) > 0){
                model.setDelayProject(model.getDelayProject().add(BigDecimal.ONE));
            }else{
                model.setNormalProject(model.getNormalProject().add(BigDecimal.ONE));
            }
        });
        return model;
    }

    public ProjectPriorityVo queryProjectPriority(ProjectModel projectModel) {
        if(projectModel == null || projectModel.getId() == null){
            throw new SystemParamCheckException("项目id传入异常，无法进行查询");
        }
        ProjectPriorityVo model = new ProjectPriorityVo();
        //确认该用户是否与该项目有直接关系
        List<Long> userIds = this.projectUserService.selectUserIdsByProjectId(projectModel.getId());
        Map<String, Integer> projectPriority = null;
        if(userIds.contains(UserUtil.getUserId())){
            projectPriority = projectRoleAuthorityDetailService.selectUserPriorityByProjectId(projectModel, UserUtil.getUserId());
        }else{
            //todo
            projectPriority = projectRoleAuthorityDetailService.selectUserPriorityByShowPriority();
        }
        //确认该用户是否与该项目已经关联
        projectModel = this.projectMapper.selectById(projectModel.getId());
        model.setPriorityMap(projectPriority);
        if(Objects.equals(projectModel.getCreateId(), UserUtil.getUserId())
                && (Objects.isNull(projectModel.getVerifyStatus()) || Objects.equals(projectModel.getVerifyStatus(), ProjectApplyVerifyStatusEnum.TYPE_UNCOMMIT.getValue()))){
            model.setCanChangable(EnableStatusEnum.ENABLE.getStatus());
        }else{
            model.setCanChangable(EnableStatusEnum.DISABLE.getStatus());
        }
        return model;
    }

    /*
     * 通过项目id获取团队树状结构
     */
    public  List<ProjectTreeModelVo> selectProjectTreeById(Long id){
    	if(id != null) {
    		return projectMapper.selectProjectTreeById(id);
    	}else {
    		throw new SystemParamCheckException("参数传入异常，无法进行查询");
    	}
    }


    public Map<String, Object> selectAreaAndIndustry() {
        Map<String, Object> map = new HashMap<>(16);
        List<CrmDictionaryIndustryModel> crmDictionaryIndustryModels = this.crmDictionaryIndustryService.selectUsefulIndustry(UserUtil.getUserRegId());
        List<CrmDictionaryRegionModel> crmDictionaryRegionModels = this.crmDictionaryRegionService.selectUsefulRegion(UserUtil.getUserRegId());
        List<SysDictionaryItemModel> list = sysDictionaryItemService.selectByShortNameAndRegId(ProjectFlowListService.CURRENCY_CODE, UserUtil.getUserRegId());
        List<Map<String, Object>> currencyMap = list.stream().map(x -> {
            Map<String, Object> tmpMap = new HashMap<>(2);
            tmpMap.put("id", x.getITEMID());
            tmpMap.put("name", x.getDICVALUE());
            return tmpMap;
        }).collect(Collectors.toList());
        map.put("region", CrmDictionaryRegionVo.createListByCrmDictionaryRegionModel(crmDictionaryRegionModels));
        map.put("industry", CrmDictionaryIndustryVo.createListByCrmDictionaryIndustryModel(crmDictionaryIndustryModels));
        map.put("currency", currencyMap);
        return map;
    }

    public UserManageInfoVo queryManageUserInfo() {
        Long jobId = this.sysJobService.selectJobIdByUserId(UserUtil.getUserId());
        if(jobId == null){
            return null;
        }
        List<SysJobVo> sysJobVos = this.sysJobService.selectTreeListByJobId(jobId);
        List<Long> jobIds = sysJobVos.stream().filter(x -> !Objects.equals(jobId, x.getID())).map(SysJobModel::getID).collect(Collectors.toList());
        //通过jobId,查询对应的用户信息
        List<UserIdAndJobIdModel> list = sysJobService.selectByRegIdAndJobIds(UserUtil.getUserRegId(), jobIds);
        List<Long> userIds = list.stream().map(UserIdAndJobIdModel::getUserId).distinct().collect(Collectors.toList());
        Map<Long, SysUserModel> userMap = this.sysUserService.selectBaseInfoByIds(userIds).stream().collect(Collectors.toMap(SysUserModel::getUserId, x->x));
        Map<Long, List<SysUserModel>> map = new HashMap<>(list.size());
        list.forEach(x -> {
            List<SysUserModel> targetList = map.computeIfAbsent(x.getJobId(), key -> new ArrayList<>());
            SysUserModel tmpModel = userMap.get(x.getUserId());
            if(tmpModel != null){
                targetList.add(tmpModel);
            }
        });
        Map<Long, List<UserManageInfoVo>> jobAndUserMap = new HashMap<>(map.size());
        map.forEach((k, v) -> {
            List<UserManageInfoVo> tmpList = new ArrayList<>(v.size());
            v.forEach(tmp -> tmpList.add(new UserManageInfoVo(tmp, k)));
            jobAndUserMap.put(k, tmpList);
        });
        Map<Long, UserManageInfoVo> jobMap = sysJobVos.stream().collect(Collectors.toMap(SysJobModel::getID, UserManageInfoVo::new));
        jobAndUserMap.forEach((k, v) -> {
            UserManageInfoVo tmpModel = jobMap.get(k);
            if(tmpModel == null){
                return;
            }
            tmpModel.getChildren().addAll(v);
        });
        jobMap.forEach((k, v) -> {
            if(v.getParentId() == null || jobMap.get(v.getParentId()) == null){
                return;
            }
            jobMap.get(v.getParentId()).getChildren().add(v);
        });
        return jobMap.get(jobId);
    }

    public BasePageInfo<ProjectVo> queryCurrentSelectChargeList(BasePageInfo<ProjectPojo> pageInfo) throws ExecutionException, InterruptedException {
        if(pageInfo == null || pageInfo.getModel() == null){
            throw new SystemParamCheckException("传入的参数异常，无法进行查询");
        }
        List<Long> leaders = selectLeaderIdsByLeftSelectTypeAndId(pageInfo.getModel());
        if(leaders.isEmpty()){
            return new BasePageInfo<>(new ArrayList<>());
        }
        pageInfo.getModel().setLeaderIds(leaders);
        return this.listByParam(pageInfo);
    }

    /**
     * 查询当前选择结构，下属的所有管辖人员
     * @param queryModel
     * @return
     */
    public List<Long> selectLeaderIdsByLeftSelectTypeAndId(ProjectPojo queryModel) {
        List<Long> leaders = new ArrayList<>();
        if(Objects.equals(queryModel.getSelectType(), ProjectTeamTagEnum.TYPE_USER.getValue())){
            leaders.add(queryModel.getSelectId());
        }else if(Objects.equals(queryModel.getSelectType(), ProjectTeamTagEnum.TYPE_TEAM.getValue())){
            List<SysJobVo> sysJobVos = this.sysJobService.selectTreeListByJobId(queryModel.getSelectId());
            List<Long> jobIds = sysJobVos.stream().filter(x -> !Objects.equals(queryModel.getSelectId(), x.getID())).map(SysJobModel::getID).collect(Collectors.toList());
            //通过jobId,查询对应的用户信息
            List<UserIdAndJobIdModel> list = sysJobService.selectByRegIdAndJobIds(UserUtil.getUserRegId(), jobIds);
            leaders = list.stream().map(UserIdAndJobIdModel::getUserId).distinct().collect(Collectors.toList());
        }
        return leaders;
    }

    public BasePageInfo<ProjectVo> selectProjectByViewInfo(BasePageInfo<ProjectPojo> pageInfo) throws ExecutionException, InterruptedException {
        List<Long> attentionIds = this.projectConcernService.selectByModel(new ProjectConcernModel(UserUtil.getUserId()))
                .stream().map(ProjectConcernModel::getProjectId).collect(Collectors.toList());
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize(), true);
        List<ProjectVo> list = fileProjectInfo(this.projectMapper.listByViewInfo(pageInfo));
        translateProjectAttentionByAttentionIds(attentionIds, list);
        return new BasePageInfo<>(list);
    }

    public ProjectApplyVo selectVerifyStatus(ProjectModel model, List<Integer> applyTypes) {
        if(model == null || model.getId() == null){
            throw new SystemParamCheckException("传入的项目id异常无法进行查询");
        }
        return this.projectApplyService.selectByBusinessIdAndApplyTypes(model.getId(), applyTypes);
    }
}