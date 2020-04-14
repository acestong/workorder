package com.fea.project.service.project.draft;


import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.project.draft.DraftProjectMapper;
import com.fea.project.enums.apply.ProjectApplyVerifyStatusEnum;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.enums.flow.base.ProjectFlowTypeEnum;
import com.fea.project.model.apply.ProjectApplyModel;
import com.fea.project.model.flow.ProjectFlowModel;
import com.fea.project.model.flow.vo.ProjectFlowListConditionVo;
import com.fea.project.model.flow.vo.ProjectFlowListVo;
import com.fea.project.model.flow.vo.ProjectFlowVo;
import com.fea.project.model.project.ProjectDeliverClaimModel;
import com.fea.project.model.project.ProjectModel;
import com.fea.project.model.project.ProjectStepModel;
import com.fea.project.model.project.ProjectStepVerifyModel;
import com.fea.project.model.project.draft.DraftDeliverClaimModel;
import com.fea.project.model.project.draft.DraftProjectModel;
import com.fea.project.model.project.draft.DraftStepModel;
import com.fea.project.model.project.draft.DraftStepVerifyModel;
import com.fea.project.model.project.draft.vo.DraftProjectVo;
import com.fea.project.model.project.vo.ProjectDeliverClaimVo;
import com.fea.project.model.project.vo.ProjectStepVo;
import com.fea.project.model.project.vo.ProjectVo;
import com.fea.project.service.apply.ProjectApplyService;
import com.fea.project.service.businessflow.flowtype.ProjectBusinessChangeApplyImplService;
import com.fea.project.service.flow.ProjectFlowService;
import com.fea.project.service.project.*;
import com.fea.project.util.ListUtil;
import com.fea.project.util.UserUtil;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2019/12/10.
 * 项目信息表 Service
 */
@Service
public class DraftProjectService {

    @Autowired
    private DraftProjectMapper draftProjectMapper;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProjectDeliverClaimService projectDeliverClaimService;

    @Autowired
    private ProjectStepService projectStepService;

    @Autowired
    private DraftDeliverClaimService draftDeliverClaimService;

    @Autowired
    private DraftStepService draftStepService;

    @Autowired
    private DraftStepVerifyService draftStepVerifyService;

    @Autowired
    private ProjectStepVerifyService projectStepVerifyService;

    @Autowired
    private ProjectBusinessChangeApplyImplService projectBusinessChangeApplyImplService;

    @Autowired
    private ProjectApplyService projectApplyService;

    @Autowired
    private ProjectFlowService projectFlowService;

    @Autowired
    private ThreadPoolExecutor threadPoolExecutor;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private ProjectVersionService projectVersionService;


    @Transactional(rollbackFor = Exception.class)
    public DraftProjectModel createDraftProject(ProjectModel model) throws Exception {
        if(model == null || model.getId() == null){
            throw new SystemParamCheckException("传入的项目id异常，无法进行查询");
        }
        ProjectVo projectVo = this.projectService.selectOne(model, false);
        DraftProjectModel draftProjectModel = createOrUpdateDraftProjectModel(projectVo, null);
        if(this.projectVersionService.createDraftVersion(model.getId(), draftProjectModel.getId(), projectVo.getVersionCode())){
            return draftProjectModel;
        }
        throw new SystemParamCheckException("草稿版本信息更新失败");
    }

    /**
     * 创建或是更新项目草稿信息
     * @param projectVo 项目信息
     * @param draftId 草稿id，如果存在表示更新草稿信息，如果不存在，表示新增草稿
     * @return
     */
    private DraftProjectModel createOrUpdateDraftProjectModel(ProjectVo projectVo, Long draftId) {
        projectVo.setVerifyStatus(null);
        List<ProjectDeliverClaimVo> projectDeliverClaimVos = this.projectDeliverClaimService.listByProjectId(new ProjectDeliverClaimModel(projectVo.getId()));
        List<ProjectStepVo> projectStepModels = this.projectStepService.listByProjectId(new ProjectStepModel(projectVo.getId()));
        List<ProjectStepVerifyModel> projectStepVerifyModels = this.projectStepVerifyService.selectByStepIds(
                projectStepModels.stream().map(ProjectStepVo::getId).distinct().collect(Collectors.toList()));
        /**
         * 项目基本信息复制
         * 项目阶段进行复制
         * 项目阶段审核信息进行复制
         * 项目交付物信息复制
         * （项目联系人直接添加，不进行保存）
         */
        DraftProjectModel draftProjectModel = new DraftProjectModel(projectVo, UserUtil.getUserId());
        List<DraftDeliverClaimModel> draftDeliverClaimModels = projectDeliverClaimVos.stream().map(DraftDeliverClaimModel::new).collect(Collectors.toList());
        List<DraftStepModel> draftStepModels = projectStepModels.stream().map(DraftStepModel::new).collect(Collectors.toList());
        List<DraftStepVerifyModel> draftStepVerifyModels = projectStepVerifyModels.stream().map(DraftStepVerifyModel::new).collect(Collectors.toList());
        if(this.insertOrUpdateSelectiveByDraftId(draftProjectModel, draftId)
            && this.draftDeliverClaimService.insertListSelective(draftDeliverClaimModels, draftProjectModel.getId())
            && this.draftStepService.insertListSelective(draftStepModels, draftProjectModel.getId())
            && this.draftStepVerifyService.insertListSelective(draftStepVerifyModels, draftProjectModel.getId())){
            return new DraftProjectModel(draftProjectModel.getId());
        }
        throw new SystemParamCheckException("草稿信息生成失败");
    }

    private boolean insertOrUpdateSelectiveByDraftId(DraftProjectModel draftProjectModel, Long draftId) {
        draftProjectModel.setId(draftId == null?draftProjectModel.getId():draftId);
        if(draftId == null && this.draftProjectMapper.insert(draftProjectModel) >= 0){
            return Boolean.TRUE;
        }else if(draftId != null && this.draftProjectMapper.updateById(draftProjectModel) >= 0){
            return Boolean.TRUE;
        }
        throw new SystemParamCheckException("草稿项目信息生成失败");
    }

    public DraftProjectVo selectOne(DraftProjectModel model) throws ExecutionException, InterruptedException {
        if(model == null || model.getId() == null){
            throw new SystemParamCheckException("传入的草稿id异常，无法进行查询");
        }
        DraftProjectVo draftProjectVo = this.draftProjectMapper.selectById(model.getId());
        ProjectVo projectVo = draftProjectVo.createProjectModel();
        projectVo = projectService.fileProjectInfo(Stream.of(projectVo).collect(Collectors.toList())).get(0);
        draftProjectVo.setExtentionInfo(projectVo);
        return draftProjectVo;
    }

    public DraftProjectModel submitChangeToVerify(DraftProjectModel draftProjectModel) {
        if(draftProjectModel == null || draftProjectModel.getId() == null){
            throw new SystemParamCheckException("传入的参数id异常，无法进行变更审核");
        }
        DraftProjectModel tmpModel = this.draftProjectMapper.selectById(draftProjectModel.getId());
        ProjectModel projectModel = this.projectService.selectById(tmpModel.getOriginalId());
        /**
         * 项目版本检查
         * 1.检查版本是否一致
         * 2.检查是否已经存在有变更审核提交
         * 版本不一致，无法进行变更提交，需要先进性版本更新
         * 已经存在进行中的变更审核提交，无法提交
         */
        if(!Objects.equals(tmpModel.getVersion(), projectModel.getVersion())){
            throw new SystemParamCheckException("草稿与正式版本，版本存在差异，请同步草稿版本后，重新编辑提交");
        }
        //查询当前项目下，项目变更类型的数据是否存在数据
        List<ProjectApplyModel> list = this.projectApplyService.selectRunningFlowByProjectIdAndApplyType(
                tmpModel.getOriginalId(), ProjectFlowTypeEnum.PROJECT_CHANGE_VERIFY.getValue());
        if(!list.isEmpty()){
            throw new SystemParamCheckException("存在正在审核的项目变更提交，请等待审核完成");
        }
        tmpModel.setVerifyStatus(ProjectApplyVerifyStatusEnum.TYPE_VERIFYING.getValue());
        if (this.projectBusinessChangeApplyImplService.createApplyInfo(tmpModel)
                && this.draftProjectMapper.updateByIdSelective(tmpModel) >= 0) {
            return tmpModel;
        }
        throw new SystemParamCheckException("项目变更提交审核异常，无法进行提交");
    }

    public DraftProjectModel selectById(Long id) {
        if(id == null){
            throw new SystemParamCheckException("传入的id异常，无法进行查询");
        }
        return this.draftProjectMapper.selectById(id);
    }

    public Long getCurrentFlowNeedChooseFlowList(Long businessId, Long flowId) {
        if (businessId == null || flowId == null) {
            throw new SystemParamCheckException("参数传入异常，无法进行流程数据筛选");
        }
        ProjectFlowVo projectFlowVo = projectFlowService.selectOne(new ProjectFlowModel(flowId));
        List<ProjectFlowListVo> projectFlowListModels = projectFlowVo.getProjectFlowListModels();
        Long flowListId = null;
        //通过业务id以及对应的无法求出的类型，直接对类型进行查询
        Map<Integer, Object> otherDBConnectInfo = null;
        try {
            otherDBConnectInfo = this.selectDBConnectInfo(businessId, projectFlowVo.getFlowType());
        } catch (Exception e) {
            throw new SystemParamCheckException(e);
        }
        for (ProjectFlowListVo tmp : projectFlowListModels) {
            if (this.selectModelByIdAndConditionModel(businessId, tmp, projectFlowVo.getFlowType(), otherDBConnectInfo) != null) {
                flowListId = tmp.getId();
                break;
            }
        }
        if (flowListId != null) {
            return flowListId;
        }
        return projectFlowVo.getDefaultFlowModel().getId();

    }

    /**
     * 通过业务id查询出关联的所有业务数据
     *
     * @param businessId
     * @return
     */
    private Map<Integer, Object> selectDBConnectInfo(Long businessId, Integer flowType) throws Exception {
        ProjectFlowTypeEnum targetEnum = ProjectFlowTypeEnum.getTargetMap(flowType);
        List<Integer> list = targetEnum.getOtherDBCheckTypeList();
        Map<Integer, Object> map = new HashMap<>();
        if (ListUtil.isNullOrEmpty(list)) {
            return map;
        }
        Future[] futures = new Future[list.size()];
        for (int i = 0; i < list.size(); i++) {
            final int tmp = i;
            futures[i] = threadPoolExecutor.submit(() -> targetEnum.getConnectInfoByBusinessId(list.get(tmp), businessId));
        }
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), futures[i].get());
        }
        return map;
    }

    /**
     * @param businessId         业务id
     * @param tmp                项目流程信息
     * @param flowType           流程类型
     * @param otherDBConnectInfo 关联的其他数据库数据
     * @return
     */
    private DraftProjectModel selectModelByIdAndConditionModel(Long businessId, ProjectFlowListVo tmp, Integer flowType, Map<Integer, Object> otherDBConnectInfo) {
        //获取参数，并将参数组装成map，与businessId拼成查询sql，进行查询
        List<ProjectFlowListConditionVo> list = tmp.getProjectFlowListConditionModels();
        if (ListUtil.isNullOrEmpty(list)) {
            throw new SystemParamCheckException("项目创建流程绑定的流程信息存在条件定义异常，请进行确认");
        }
        Map<Integer, String> conditionMap = new HashMap<>();
        ProjectFlowTypeEnum targetEnum = ProjectFlowTypeEnum.getTargetMap(flowType);
        List<Integer> types = targetEnum.getOtherDBCheckTypeList();
        Map<Integer, ProjectFlowListConditionVo> anotherDBCheck = new HashMap<>();
        list.forEach(x -> {
            if (types.contains(x.getFieldType())) {
                anotherDBCheck.put(x.getFieldType(), x);
                return;
            }
            conditionMap.put(x.getFieldType(), x.getConditionStr());
        });
        //对跨表类型进行取值判断
        if (this.checkOtherDBTypeList(anotherDBCheck, otherDBConnectInfo, targetEnum)) {
            return this.draftProjectMapper.selectModelByIdAndConditionModel(businessId, conditionMap);
        }
        return null;
    }

    private boolean checkOtherDBTypeList(Map<Integer, ProjectFlowListConditionVo> anotherDBCheck, Map<Integer, Object> otherDBConnectInfo, ProjectFlowTypeEnum targetEnum) {
        ProjectFlowListConditionVo projectFlowListConditionVo = null;
        for (Map.Entry<Integer, ProjectFlowListConditionVo> tmp : anotherDBCheck.entrySet()) {
            projectFlowListConditionVo = tmp.getValue();
            Object businessInfo = otherDBConnectInfo.get(tmp.getKey());
            if (businessInfo == null || !targetEnum.isSatisfied(tmp.getKey(), projectFlowListConditionVo, businessInfo)) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    public DraftProjectModel deleteModel(DraftProjectModel model) {
        if(model == null || model.getId() == null){
            throw new SystemParamCheckException("传入的草稿id异常，无法进行删除");
        }
        model = this.draftProjectMapper.selectById(model.getId());
        if(Objects.equals(model.getVerifyStatus(), ProjectApplyVerifyStatusEnum.TYPE_VERIFYING.getValue())){
            throw new SystemParamCheckException("草稿正在审核中，无法进行删除");
        }
        SysUserModel userModel = this.sysUserService.getCurrentUsr();
        model.setDelStatus(DeleteStatusEnum.DELETE.getStatus());
        model.setUserInfo(userModel, ActionEnum.UPDATE_ACTION);
        if(this.draftProjectMapper.updateByIdSelective(model) >= 0){
            return new DraftProjectModel(model.getId());
        }
        throw new SystemParamCheckException("草稿信息删除失败");
    }

    public DraftProjectModel refreshModel(DraftProjectModel model) throws Exception {
        if(model == null || model.getId() == null){
            throw new SystemParamCheckException("传入的草稿id异常，无法进行删除");
        }
        model = this.draftProjectMapper.selectById(model.getId());
        if(Objects.equals(model.getDelStatus(), DeleteStatusEnum.DELETE.getStatus())){
            throw new SystemParamCheckException("草稿已经删除，无法进行覆盖，请重新生成");
        }
        if(Objects.equals(model.getVerifyStatus(), ProjectApplyVerifyStatusEnum.TYPE_VERIFYING.getValue())){
            throw new SystemParamCheckException("草稿正在审核中，无法进行覆盖操作");
        }
        ProjectVo projectVo = this.projectService.selectOne(new ProjectModel(model.getOriginalId()), false);
        if(Objects.equals(model.getVersion(), projectVo.getVersion())){
           throw new SystemParamCheckException("项目版本与草稿版本相同，无需覆盖，如果想进行覆盖，还请根据当前版本重新创建草稿");
        }
        //删除表中数据
        if(this.draftDeliverClaimService.updateDelStatusByDraftId(model.getId(), DeleteStatusEnum.DELETE.getStatus())
                && this.draftStepService.updateDelStatusByDraftId(model.getId(), DeleteStatusEnum.DELETE.getStatus())){
            return createOrUpdateDraftProjectModel(projectVo, model.getId());
        }
        throw new SystemParamCheckException("草稿更新失败，请刷新后重试");
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean updateSelectiveById(DraftProjectModel draftProjectModel) {
        if(draftProjectModel == null){
            throw new SystemParamCheckException("传入的草稿信息异常，无法进行更新");
        }
        return this.draftProjectMapper.updateByIdSelective(draftProjectModel) >= 0;
    }

    public DraftProjectModel updateModel(DraftProjectModel model) {
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        model.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
        if (this.draftProjectMapper.updateByIdSelective(model) >= 0) {
            return model;
        }
        throw new SystemParamCheckException("项目创建失败");
    }

    public DraftProjectModel updateProjectContent(DraftProjectModel model) {
        if (model == null || model.getId() == null || StringUtil.isEmpty(model.getContent())) {
            throw new SystemParamCheckException("传入的参数异常，无法进行项目内容更新");
        }
        SysUserModel userModel = this.sysUserService.getCurrentUsr();
        model.setUserInfo(userModel, ActionEnum.UPDATE_ACTION);
        if (this.draftProjectMapper.updateByIdSelective(model) >= 0) {
            return model;
        }
        throw new SystemParamCheckException("数据更新异常，请检查当前项目信息是否存在");
    }
}