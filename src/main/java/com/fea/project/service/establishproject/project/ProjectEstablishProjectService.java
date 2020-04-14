package com.fea.project.service.establishproject.project;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.fea.project.api.other.model.base.SysDictionaryItemModel;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.model.base.vo.SysUserVo;
import com.fea.project.api.other.service.base.SysDictionaryItemService;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.LoginStateIllegalException;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.establishproject.project.ProjectEstablishProjectMapper;
import com.fea.project.enums.apply.ProjectApplyVerifyStatusEnum;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.enums.base.DictionaryTypeEnum;
import com.fea.project.enums.base.EnableStatusEnum;
import com.fea.project.enums.project.*;
import com.fea.project.enums.team.ProjectDefaultRoleEnum;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.apply.vo.ProjectApplyVo;
import com.fea.project.model.base.ProjectDictionaryModel;
import com.fea.project.model.base.vo.ProjectDictionaryItemSelectVo;
import com.fea.project.model.establishproject.pojo.ProjectAndEstablishProjectPojo;
import com.fea.project.model.establishproject.pojo.ProjectEstablishProjectPojo;
import com.fea.project.model.establishproject.project.ProjectEstablishProjectModel;
import com.fea.project.model.establishproject.project.ProjectEstablishProjectStartModel;
import com.fea.project.model.establishproject.project.ProjectEstablishStepModel;
import com.fea.project.model.establishproject.role.ProjectEstablishRoleModel;
import com.fea.project.model.establishproject.role.ProjectEstablishRoleUserModel;
import com.fea.project.model.establishproject.team.ProjectEstablishTeamUserModel;
import com.fea.project.model.establishproject.user.ProjectEstablishUserModel;
import com.fea.project.model.establishproject.vo.ProjectEstablishProjectVo;
import com.fea.project.model.establishproject.vo.ProjectEstablishStepVo;
import com.fea.project.model.establishproject.vo.ProjectEstablishVo;
import com.fea.project.model.establishproject.vo.ProjectInnerProjectBusinessVo;
import com.fea.project.model.project.ProjectConcernModel;
import com.fea.project.model.project.ProjectModel;
import com.fea.project.model.project.pojo.ProjectAttentionPojo;
import com.fea.project.model.project.vo.ProjectVo;
import com.fea.project.model.team.vo.TeamPersonSelectVo;
import com.fea.project.service.base.ProjectDictionaryItemService;
import com.fea.project.service.establishproject.role.ProjectEstablishRoleService;
import com.fea.project.service.establishproject.role.ProjectEstablishRoleUserService;
import com.fea.project.service.establishproject.team.ProjectEstablishTeamService;
import com.fea.project.service.establishproject.team.ProjectEstablishTeamUserService;
import com.fea.project.service.establishproject.user.ProjectEstablishUserService;
import com.fea.project.service.project.ProjectConcernService;
import com.fea.project.service.project.ProjectService;
import com.fea.project.service.project.ProjectVersionService;
import com.fea.project.service.user.ProjectUserService;
import com.fea.project.util.JsonUtil;
import com.fea.project.util.ListUtil;
import com.fea.project.util.UserUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2019/12/23.
 */
@Service
public class ProjectEstablishProjectService {

    @Autowired
    private ProjectEstablishProjectMapper projectEstablishProjectMapper;

    @Autowired
    private ProjectDictionaryItemService projectDictionaryItemService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private ProjectConcernService projectConcernService;

    @Autowired
    private ProjectEstablishUserService projectEstablishUserService;

    @Autowired
    private ThreadPoolExecutor threadPoolExecutor;

    @Autowired
    private ProjectEstablishRoleService projectEstablishRoleService;

    @Autowired
    private ProjectEstablishRoleUserService projectEstablishRoleUserService;

    @Autowired
    private ProjectEstablishTeamService projectEstablishTeamService;

    @Autowired
    private ProjectEstablishTeamUserService projectEstablishTeamUserService;

    @Autowired
    private SysDictionaryItemService sysDictionaryItemService;


    @Autowired
    private ProjectEstablishStepService projectEstablishStepService;

    @Autowired
    private ProjectUserService projectUserService;

    @Autowired
    private ProjectVersionService projectVersionService;




    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectEstablishProjectModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectEstablishProjectModel> list : ListUtil.getSubList(models, 100)) {
                this.projectEstablishProjectMapper.insertList(list);
            }
        } else {
            return this.projectEstablishProjectMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectEstablishProjectModel model) {
        return model != null && this.projectEstablishProjectMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectEstablishProjectModel selectById(Long id) {
        return id == null ? null : this.projectEstablishProjectMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectEstablishProjectModel> selectByModel(ProjectEstablishProjectModel model) {
        return model == null ? new ArrayList<>(0) : this.projectEstablishProjectMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectEstablishProjectModel model) {
        return !(model == null || model.getId() == null) && this.projectEstablishProjectMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectEstablishProjectModel model) {
        return !(model == null || model.getId() == null) && this.projectEstablishProjectMapper.updateById(model) == 1;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectEstablishProjectModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectEstablishProjectMapper.insert(model) == 1;
        }
        return this.projectEstablishProjectMapper.updateById(model) == 1;
    }

    public Map<String, Object> selectCreateOrUpdateBaseInfo() {
        Map<String, Object> map = this.projectDictionaryItemService.selectProjectInitParamWhenNullCreate();
        map.put("project_from", ProjectResourceEnum.getApplyProjectResource());
        map.put("project_action_status", ProjectActionStatusEnum.getProjectActionStatus());
        return map;
    }

    public Object selectAssociatedBusiness(ProjectEstablishProjectPojo model) {
        if(model == null || model.getResource() == null){
            throw new SystemParamCheckException("项目来源参数传入异常，无法进行查询");
        }
        ProjectModel projectModel = new ProjectModel();
        projectModel.setResource(model.getResource());
        return this.projectService.selectAssociatedBusiness(projectModel);
    }

    public Object selectUsersByRegId() {
        return this.projectService.selectUsersByRegId();
    }

    public ProjectEstablishProjectPojo deleteModel(ProjectEstablishProjectPojo model) {
        if(model == null || model.getId() == null){
            throw new SystemParamCheckException("传入项目id异常，无法进行删除");
        }
        SysUserModel sysUserModel = sysUserService.getCurrentUsr();
        ProjectEstablishProjectModel changeBeforeModel = projectEstablishProjectMapper.selectByProjectId(model.getId());
        ProjectEstablishProjectModel actionModel = new ProjectEstablishProjectModel(changeBeforeModel.getId());
        actionModel.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
        actionModel.setDelStatus(DeleteStatusEnum.DELETE.getStatus());
        if(this.projectEstablishProjectMapper.updateByIdSelective(actionModel) >= 0){
            return model;
        }
        throw new SystemParamCheckException("立项信息删除失败，无法进行删除");
    }

    public ProjectEstablishProjectPojo insertModel(ProjectEstablishProjectPojo model) throws Exception {
        SysUserModel sysUserModel = sysUserService.getCurrentUsr();
        model.setUserInfo(sysUserModel, ActionEnum.INSERT_ACTION);
        ProjectAndEstablishProjectPojo tmpModel = new ProjectAndEstablishProjectPojo(model, sysUserModel);
        ProjectModel projectModel = tmpModel.getProjectModel();
        ProjectEstablishProjectModel projectEstablishProjectModel = tmpModel.getProjectEstablishProjectModel();
        if(this.projectService.insertModel(projectModel) != null
            && this.projectService.updateDelStatusByProjectId(projectModel.getId(), (DeleteStatusEnum.DELETE.getStatus()))){
            projectEstablishProjectModel.setProjectId(projectModel.getId());
            model.setId(projectModel.getId());
            List<ProjectEstablishUserModel> list = ProjectEstablishUserModel.createList(model, ActionEnum.INSERT_ACTION);
            ProjectEstablishUserModel establishLeader = list.stream().filter(x -> Objects.equals(x.getUserId(), model.getEstablishLeader())).findFirst().get();
            if(this.projectEstablishProjectMapper.insertSelective(projectEstablishProjectModel) > 0
                    && this.projectEstablishUserService.insertList(list)
                    && projectService.updateEstablishStatus(projectModel.getId(), ProjectEstablishmentEnum.TYPE_ESTABLISHMENT.getValue())
            ){
                ProjectEstablishProjectVo projectEstablishProjectVo = this.translateToVo(projectEstablishProjectModel);
                Future<Boolean> teamFuture = initEstablishProjectTeam(sysUserModel, projectEstablishProjectVo, list);
                Future<Boolean> roleFuture = initEstablishProjectRole(sysUserModel, projectEstablishProjectVo, establishLeader);
                if (teamFuture.get() && roleFuture.get()) {
                    return model;
                }
            }
        }
        throw new SystemParamCheckException("立项信息新增失败");
    }

    /**
     * 初始化项目角色
     *
     * @param sysUserModel
     * @param projectEstablishProjectVo
     * @return
     */
    private Future<Boolean> initEstablishProjectRole(SysUserModel sysUserModel, ProjectEstablishProjectVo projectEstablishProjectVo, ProjectEstablishUserModel establishLeader) {
        return threadPoolExecutor.submit(() -> {
            ProjectEstablishRoleModel projectEstablishRoleModel = new ProjectEstablishRoleModel(ProjectDefaultRoleEnum.TYPE_PROJECT_ADMIN, sysUserModel, projectEstablishProjectVo, ActionEnum.INSERT_ACTION);
            if (this.projectEstablishRoleService.insertSelective(projectEstablishRoleModel)
                && this.projectEstablishRoleUserService.insertSelective(new ProjectEstablishRoleUserModel(establishLeader, projectEstablishRoleModel.getId(), sysUserModel))) {
                return true;
            }
            throw new SystemParamCheckException("项目角色初始化创建失败");
        });
    }


    /**
     * 初始化项目团队
     *
     * @param sysUserModel
     * @param projectEstablishProjectVo
     * @param list
     * @return
     */
    private Future<Boolean> initEstablishProjectTeam(SysUserModel sysUserModel, ProjectEstablishProjectVo projectEstablishProjectVo, List<ProjectEstablishUserModel> list) {
        Long establishApplyer = projectEstablishProjectVo.getApplyer();
        final ProjectEstablishProjectVo finalModel = projectEstablishProjectVo;
        return threadPoolExecutor.submit(() -> {
            ProjectModel projectModel = this.projectService.selectById(finalModel.getProjectId());
            Long rootId = this.projectEstablishTeamService.insertProjectRootTeam(sysUserModel, finalModel, projectModel.getName());
            Long unGroupQueueId = this.projectEstablishTeamService.insertInitTeamsAndReturnUnGroupQueue(finalModel, sysUserModel, rootId);
            List<ProjectEstablishTeamUserModel> projectEstablishTeamUserModels = new ArrayList<>();
            list.forEach(tmp -> {
                if (Objects.equals(establishApplyer, tmp.getUserId())) {
                    projectEstablishTeamUserModels.add(new ProjectEstablishTeamUserModel(tmp, rootId, sysUserModel));
                } else {
                    projectEstablishTeamUserModels.add(new ProjectEstablishTeamUserModel(tmp, unGroupQueueId, sysUserModel));
                }
            });
            return this.projectEstablishTeamUserService.insertList(projectEstablishTeamUserModels);
        });
    }


    public ProjectEstablishProjectPojo updateModel(ProjectEstablishProjectPojo model) {
        SysUserModel sysUserModel = sysUserService.getCurrentUsr();
        //通过项目信息查询出立项信息
        model.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
        ProjectAndEstablishProjectPojo tmpModel = new ProjectAndEstablishProjectPojo(model, sysUserModel);
        ProjectModel projectModel = tmpModel.getProjectModel();
        ProjectEstablishProjectModel changeBeforeModel = projectEstablishProjectMapper.selectByProjectId(model.getId());
        if(changeBeforeModel == null){
            throw new SystemParamCheckException("立项信息已经被删除，请刷新后重试");
        }
        ProjectEstablishProjectModel projectEstablishProjectModel = tmpModel.getProjectEstablishProjectModel();
        projectEstablishProjectModel.setId(changeBeforeModel.getId());
        if(this.projectService.updateSelectiveByIdOnEstablish(projectModel)
            && this.projectEstablishProjectMapper.updateByIdSelective(projectEstablishProjectModel) >= 0){
            return model;
        }
        throw new SystemParamCheckException("立项信息更新失败");
    }

    public ProjectEstablishProjectPojo updateProjectContent(ProjectEstablishProjectPojo model) {
        if(model == null || model.getId() == null){
            throw new SystemParamCheckException("项目id传入异常，无法进行查询");
        }
        if(this.projectEstablishProjectMapper.updateContentByProjectId(model) >=0){
            return model;
        }
        throw new SystemParamCheckException("项目立项说明更新失败");
    }

    public List<TeamPersonSelectVo> selectCurrentProjectDept() {
        return this.projectService.selectCurrentProjectDept();
    }

    public List<SysUserVo> selectCurrentProjectUsers() {
        return this.projectService.selectCurrentProjectUsers();
    }

    public ProjectAttentionPojo payAttentionModel(ProjectAttentionPojo model) {
        if (model == null || model.getId() == null || model.getAttention() == null) {
            throw new SystemParamCheckException("项目关注失败，参数校验报错").appendAlaramMsg(JSON.toJSONString(model));
        }
        ProjectEstablishProjectModel projectEstablishProjectModel = this.projectEstablishProjectMapper.selectByProjectId(model.getId());
        if(Objects.isNull(projectEstablishProjectModel)){
            throw new SystemParamCheckException("当前项目已经不存在，无法进行操作");
        }
        return this.projectService.payAttentionModel(model);
    }

    public ProjectEstablishVo selectOne(ProjectModel projectModel) throws Exception {
        if (projectModel == null || projectModel.getId() == null) {
            throw new SystemParamCheckException("项目id传入异常，无法进行查询");
        }
        ProjectEstablishProjectModel projectEstablishProjectModel = this.projectEstablishProjectMapper.selectByProjectId(projectModel.getId());
        ProjectVo projectVo = this.projectService.selectOne(projectModel, true);
        if (Objects.isNull(projectVo) || Objects.isNull(projectEstablishProjectModel)) {
            throw new SystemParamCheckException("项目信息不存在，请刷新后重试");
        }
        projectVo = this.projectService.fileProjectInfo(Stream.of(projectVo).collect(Collectors.toList())).get(0);
        ProjectEstablishProjectVo projectEstablishProjectVo = this.translateToVo(projectEstablishProjectModel);
        ProjectEstablishVo projectEstablishVo = JsonUtil.translateFatherToChild(projectVo, new TypeReference<ProjectEstablishVo>(){});
        projectEstablishVo.setProjectBusinessModels(projectVo.getProjectBusinessModels());
        projectEstablishVo.setAppendInfo(projectEstablishProjectVo);
        if(projectEstablishVo.getEstablishStep() != null){
            ProjectEstablishStepModel projectEstablishStepModel = this.projectEstablishStepService.selectById(projectEstablishVo.getEstablishStep());
            projectEstablishVo.setEstablishStepName(projectEstablishStepModel.getName());
            Map<Integer, String> map = ProjectApplyVerifyStatusEnum.getMap();
            projectEstablishVo.setEstablishStepVerifyStatusName(map.get(projectEstablishStepModel.getVerifyStatus()));
        }
        if(Objects.isNull(projectEstablishVo.getVerifyStatus())
                || ProjectApplyVerifyStatusEnum.getCanSubmitStatus().contains(projectEstablishVo.getVerifyStatus())){
            projectEstablishVo.setSubmitShow(EnableStatusEnum.ENABLE.getStatus());
        }
        return projectEstablishVo;
    }

    private ProjectEstablishProjectVo translateToVo(ProjectEstablishProjectModel projectEstablishProjectModel) {
        ProjectEstablishProjectVo projectEstablishProjectVo = JsonUtil.translateFatherToChild(projectEstablishProjectModel, new TypeReference<ProjectEstablishProjectVo>(){});
        List<Long> userIds = new ArrayList<>();
        userIds.add(projectEstablishProjectVo.getApplyer());
        userIds.add(projectEstablishProjectVo.getEstablishLeader());
        //通过当前项目id查询对应的立项人员
        if(!ListUtil.isNullOrEmpty(projectEstablishProjectVo.getEstablishPartners())){
            userIds.addAll(projectEstablishProjectVo.getEstablishPartners());
        }
        Map<Long, String> userMap = this.sysUserService.selectByIds(userIds).stream().collect(Collectors.toMap(SysUserModel::getUserId, SysUserModel::getRealName));
        projectEstablishProjectVo.setApplyerName(userMap.get(projectEstablishProjectVo.getApplyer()));
        projectEstablishProjectVo.setEstablishLeaderName(userMap.get(projectEstablishProjectVo.getEstablishLeader()));
        List<String> userNames = new ArrayList<>();
        if(!ListUtil.isNullOrEmpty(projectEstablishProjectVo.getEstablishPartners())){
            projectEstablishProjectVo.getEstablishPartners().forEach(x -> {
                userNames.add(userMap.get(x));
            });
        }
        projectEstablishProjectVo.setEstablishPartnersNames(String.join(",", userNames));
        return projectEstablishProjectVo;
    }

    public BasePageInfo<ProjectEstablishVo> listByParam(BasePageInfo<ProjectEstablishProjectPojo> basePageInfo) throws ExecutionException, InterruptedException {
        List<ProjectEstablishVo> list = this.checkParamAndSelectBaseProjectEstablishModels(basePageInfo);
        projectService.fileProjectInfo(new ArrayList<>(list));
        this.fileProjectEstablishInfo(list);
        //查询用户关注项目
        List<Long> attentionIds = this.projectConcernService.selectByModel(new ProjectConcernModel(UserUtil.getUserId()))
                .stream().map(ProjectConcernModel::getProjectId).collect(Collectors.toList());
        list.forEach(x -> {
            if (attentionIds.contains(x.getId())) {
                x.setAttention(Boolean.TRUE);
                return;
            }
            x.setAttention(Boolean.FALSE);
            if((Objects.equals(x.getCreateId(), UserUtil.getUserId()) || Objects.equals(x.getEstablishLeader(), UserUtil.getUserId()))
                && !Objects.equals(x.getStartStatus(), ProjectEstablishStartStatusEnum.TYPE_START.getValue())){
                x.setStartBtnShow(EnableStatusEnum.ENABLE.getStatus());
            }
        });
        return new BasePageInfo<>(list);
    }

    /**
     * 检查基础参数，并查询基本的单表数据
     * @param basePageInfo
     * @return
     */
    public List<ProjectEstablishVo> checkParamAndSelectBaseProjectEstablishModels(BasePageInfo<ProjectEstablishProjectPojo> basePageInfo) {
        if(basePageInfo == null){
            throw new SystemParamCheckException("参数传入异常，请刷新后重试");
        }
        if(basePageInfo.getModel() == null){
            ProjectEstablishProjectPojo model = new ProjectEstablishProjectPojo();
            basePageInfo.setModel(model);
        }
        basePageInfo.getModel().setRegId(UserUtil.getUserRegId());
        PageHelper.startPage(basePageInfo.getPageNum(), basePageInfo.getPageSize(), true);
        return this.projectEstablishProjectMapper.selectByFilterAndOrderParams(basePageInfo);
    }

    private void fileProjectEstablishInfo(List<ProjectEstablishVo> list) {
        if(list.isEmpty()){
            return;
        }
        Set<Long> userIds = new HashSet<>();
        list.forEach(x -> {
            userIds.add(x.getApplyer());
            if(!ListUtil.isNullOrEmpty(x.getEstablishPartners())){
                userIds.addAll(x.getEstablishPartners());
            }
        });
        Map<Long, String> userMap = sysUserService.selectByIds(new ArrayList<>(userIds)).stream()
                .collect(Collectors.toMap(SysUserModel::getUserId, SysUserModel::getRealName));
        list.forEach(x -> {
            x.setApplyerName(userMap.get(x.getApplyer()));
            x.setEstablishLeaderName(userMap.get(x.getEstablishLeader()));
            if(!ListUtil.isNullOrEmpty(x.getEstablishPartners())){
                List<String> names = new ArrayList<>();
                x.getEstablishPartners().forEach(y -> names.add(userMap.get(y)));
                x.setEstablishPartnersNames(String.join(",", names));
            }
        });
    }

    public List<ProjectInnerProjectBusinessVo> selectByProjectIds(List<Long> projectIds, Long regId) {
        if(projectIds == null){
            throw new SystemParamCheckException("传入的项目id异常，无法进行查询");
        }
        if(projectIds.isEmpty()){
            return Collections.emptyList();
        }
        List<ProjectInnerProjectBusinessVo> projectEstablishVos = this.projectEstablishProjectMapper.selectInnerProjectBussinessByProjectIds(projectIds);
        Map<Long, String> resourceDetail = this.projectDictionaryItemService.listByShortNameAndRegIdWhenNullCreate(new ProjectDictionaryModel(DictionaryTypeEnum.PROJECT_RESOURCE_DETAIL.getValue(),regId))
                .stream().collect(Collectors.toMap(ProjectDictionaryItemSelectVo::getId, ProjectDictionaryItemSelectVo::getName));
        Map<Long, String> productTypesMap = this.sysDictionaryItemService.selectByShortNameAndRegId("productClassify", regId)
                .stream().collect(Collectors.toMap(SysDictionaryItemModel::getITEMID, SysDictionaryItemModel::getDICVALUE));
        projectEstablishVos.forEach(x -> {
            x.setBusinessName(resourceDetail.get(StringUtil.isEmpty(x.getConnectId())?null:Long.parseLong(x.getConnectId())));
            x.setProductTypeName(productTypesMap.get(x.getProductType()));
        });
        return projectEstablishVos;
    }

    public Object selectProductTypes() {
        return this.sysDictionaryItemService.selectByShortNameAndRegId("productClassify", UserUtil.getUserRegId())
                .stream().map(x -> new HashMap<String, Object>(2){{
                    put("id", x.getITEMID() + "");
                    put("name", x.getDICVALUE());
                }}).collect(Collectors.toList());
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectEstablishProjectModel submitToVerify(ProjectEstablishProjectModel model) {
        if(model == null || model.getProjectId() == null){
            throw new SystemParamCheckException("传入的立项id异常，无法进行查询");
        }
        ProjectEstablishProjectModel tmpModel = this.projectEstablishProjectMapper.selectByProjectId(model.getProjectId());
        //查询审核阶段
        List<ProjectEstablishStepVo> projectEstablishStepVos = this.projectEstablishStepService.selectByProjectId(tmpModel.getProjectId());
        if(projectEstablishStepVos.isEmpty()){
            throw new SystemParamCheckException("请添加项目阶段审核数据");
        }
        //流程状态校验
        SysUserModel userModel = this.sysUserService.getCurrentUsr();
        ProjectModel projectModel = this.projectService.selectById(tmpModel.getProjectId());
        if(!Objects.isNull(projectModel.getVerifyStatus()) &&
                !ProjectApplyVerifyStatusEnum.getCanSubmitStatus().contains(projectModel.getVerifyStatus())){
            throw new SystemParamCheckException("当前流程状态无法再次提交");
        }
        projectModel.setVerifyStatus(ProjectApplyVerifyStatusEnum.TYPE_VERIFYING.getValue());
        projectModel.setUserInfo(userModel, ActionEnum.UPDATE_ACTION);
        model.setId(tmpModel.getId());
        model.setEstablishStep(projectEstablishStepVos.get(0).getId());
        model.setUserInfo(userModel, ActionEnum.UPDATE_ACTION);
        if(this.projectEstablishProjectMapper.updateByIdSelective(model) >= 0
            && this.projectService.updateSelectiveByIdOnEstablish(projectModel)){
            return model;
        }
        throw new SystemParamCheckException("提交审核异常，无法进行提交");
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectEstablishProjectStartModel startEstablishProject(ProjectEstablishProjectStartModel model) {
        if(model == null || model.getId() == null || model.getLeader() == null){
            throw new SystemParamCheckException("传入参数异常，无法进行启动");
        }
        ProjectModel projectModel = this.projectService.selectById(model.getId());
        if(!Objects.equals(projectModel.getVerifyStatus(), ProjectApplyVerifyStatusEnum.TYPE_HAS_VERIFY.getValue())){
            throw new SystemParamCheckException("当前项目审核未完成，无法进行启动");
        }
        ProjectEstablishProjectModel projectEstablishProjectModel = this.projectEstablishProjectMapper.selectByProjectId(model.getId());
        if(projectEstablishProjectModel == null){
            throw new SystemParamCheckException("该项目不是立项项目，无法进行启动");
        }
        if(Objects.equals(DeleteStatusEnum.NOT_DELETE.getStatus(), projectModel.getDelStatus())){
            throw new SystemParamCheckException("当前已经启动，无法重复启动");
        }
        if(!Objects.equals(model.getLeader(), projectModel.getLeader())){
            //移除老的项目经理，添加新的项目经理
            this.projectUserService.changeLeader(projectModel.getId(), projectModel.getLeader(), model.getLeader());
        }
        SysUserModel userModel = this.sysUserService.getCurrentUsr();
        projectEstablishProjectModel.setStartModel(userModel);
        projectModel.setStartModel(model, userModel);
        Long version = this.projectVersionService.createNewProjectVersionModel(
                projectModel.getId(), ProjectVersionSelectTypeEnum.TYPE_REAL.getValue(), projectModel.getId());
        projectModel.setVersion(version);
        if(this.projectService.updateSelectiveByIdOnEstablish(projectModel)
            && this.projectEstablishProjectMapper.updateByIdSelective(projectEstablishProjectModel) >= 0){
            return model;
        }
        throw new SystemParamCheckException("项目启动报错，无法进行启动");
    }

    public ProjectEstablishProjectModel selectByProjectId(Long projectId) {
        if(projectId == null){
            throw new SystemParamCheckException("传入的项目id异常，无法进行查询");
        }
        return this.projectEstablishProjectMapper.selectByProjectId(projectId);
    }

    public List<ProjectEstablishProjectModel> selectByCreateId(Long userId) {
        if(userId == null){
            throw new LoginStateIllegalException("用户信息异常，请刷新后重试");
        }
        return this.projectEstablishProjectMapper.selectByCreateId(userId);
    }

    public List<ProjectEstablishProjectModel> selectByAttention(Long userId) {
        if(userId == null){
            throw new LoginStateIllegalException("用户信息异常，请刷新后重试");
        }
        return this.projectEstablishProjectMapper.selectByAttention(userId);
    }

    public List<ProjectEstablishProjectModel> selectByEstablishLeader(Long userId) {
        if(userId == null){
            throw new LoginStateIllegalException("用户信息异常，请刷新后重试");
        }
        return this.projectEstablishProjectMapper.selectByEstablishLeader(userId);
    }

    public List<ProjectEstablishProjectModel> selectByJoiner(Long userId) {
        if(userId == null){
            throw new LoginStateIllegalException("用户信息异常，请刷新后重试");
        }
        return this.projectEstablishProjectMapper.selectByJoiner(userId);
    }

    public List<ProjectEstablishProjectModel> selectByEstablishLeaders(List<Long> leaderIds) {
        if(ListUtil.isNullOrEmpty(leaderIds)){
            return Collections.emptyList();
        }
        return this.projectEstablishProjectMapper.selectByEstablishLeaders(leaderIds);
    }

    public ProjectApplyVo selectVerifyStatus(ProjectModel model, List<Integer> projectFlowTypes) {
        return this.projectService.selectVerifyStatus(model, projectFlowTypes);
    }
}