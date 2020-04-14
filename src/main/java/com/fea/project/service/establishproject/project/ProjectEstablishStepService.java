package com.fea.project.service.establishproject.project;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.establishproject.project.ProjectEstablishStepMapper;
import com.fea.project.enums.apply.ProjectApplyVerifyStatusEnum;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.enums.base.EnableStatusEnum;
import com.fea.project.model.establishproject.project.ProjectEstablishProjectModel;
import com.fea.project.model.establishproject.project.ProjectEstablishStepModel;
import com.fea.project.model.establishproject.pojo.ProjectEstablishStepPojo;
import com.fea.project.model.establishproject.vo.ProjectEstablishStepVo;
import com.fea.project.model.flow.ProjectFlowModel;
import com.fea.project.model.project.ProjectModel;
import com.fea.project.service.appendix.ProjectAppendixService;
import com.fea.project.service.apply.ProjectApplyBusinessService;
import com.fea.project.service.apply.io.IProjectApplyBusiness;
import com.fea.project.service.apply.io.IProjectFlowListChoose;
import com.fea.project.service.businessflow.flowtype.ProjectBusinessEstablishApplyImplService;
import com.fea.project.service.establishproject.project.ProjectEstablishProjectService;
import com.fea.project.service.flow.ProjectFlowService;
import com.fea.project.service.project.ProjectService;
import com.fea.project.util.ListUtil;
import com.fea.project.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2019/12/30.
 */
@Service
public class ProjectEstablishStepService implements IProjectApplyBusiness, IProjectFlowListChoose {

    @Autowired
    private ProjectEstablishStepMapper projectEstablishStepMapper;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private ProjectFlowService projectFlowService;

    @Autowired
    private ProjectBusinessEstablishApplyImplService projectBusinessEstablishApplyImplService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProjectApplyBusinessService projectApplyBusinessService;

    @Autowired
    private ProjectAppendixService projectAppendixService;

    @Autowired
    private ProjectEstablishProjectService projectEstablishProjectService;

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectEstablishStepMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectEstablishStepMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectEstablishStepModel model) {
        return model != null && this.projectEstablishStepMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectEstablishStepModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectEstablishStepModel> list : ListUtil.getSubList(models, 100)) {
                this.projectEstablishStepMapper.insertList(list);
            }
        } else {
            return this.projectEstablishStepMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectEstablishStepModel model) {
        return model != null && this.projectEstablishStepMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectEstablishStepModel selectById(Long id) {
        return id == null ? null : this.projectEstablishStepMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectEstablishStepVo> selectByModel(ProjectEstablishStepModel model) {
        return model == null ? new ArrayList<>(0) : this.projectEstablishStepMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectEstablishStepModel model) {
        return !(model == null || model.getId() == null) && this.projectEstablishStepMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectEstablishStepModel model) {
        return !(model == null || model.getId() == null) && this.projectEstablishStepMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectEstablishStepModel model) {
        return !(model == null || model.getId() == null) && this.projectEstablishStepMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectEstablishStepModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectEstablishStepMapper.insert(model) == 1;
        }
        return this.projectEstablishStepMapper.updateById(model) == 1;
    }

    public List<ProjectEstablishStepVo> listByParam(ProjectModel model) {
        if(model == null || model.getId() == null){
            throw new SystemParamCheckException("传入的项目id异常，无法进行查询");
        }
        List<ProjectEstablishStepVo> list = this.projectEstablishStepMapper.selectByModel(new ProjectEstablishStepModel(model.getId()));
        Set<Long> leadIds = new HashSet<>();
        Set<Long> flowIds = new HashSet<>();
        list.forEach(x -> {
            if(x.getLeader() != null){
                leadIds.add(x.getLeader());
            }
            if(Objects.equals(x.getFlowState(), EnableStatusEnum.ENABLE.getStatus()) && x.getFlowId() != null){
                flowIds.add(x.getFlowId());
            }
            x.setSumitBtnShow(EnableStatusEnum.DISABLE.getStatus());
        });
        Map<Long, String> leaderMap = this.sysUserService.selectByIds(new ArrayList<>(leadIds)).stream().collect(Collectors.toMap(SysUserModel::getUserId, SysUserModel::getRealName));
        Map<Long, String> flowMap = this.projectFlowService.selectByIds(new ArrayList<>(flowIds))
                .stream().collect(Collectors.toMap(ProjectFlowModel::getId, ProjectFlowModel::getName));
        Map<Integer, String> verifyStatusMap = ProjectApplyVerifyStatusEnum.getMap();
        final String canSubmitFlag = "canSubmitFlag";
        final String verifyingFlag = "verifyingFlag";
        Map<String, Boolean> map = new HashMap<String, Boolean>(){{
            put(canSubmitFlag, true);
            put(verifyingFlag, false);
        }};
        list.forEach(x -> {
            x.setLeadName(leaderMap.get(x.getLeader()));
            if(Objects.equals(x.getFlowState(), EnableStatusEnum.ENABLE.getStatus())){
                x.setFlowName(flowMap.get(x.getFlowId()));
            }
            x.setVerifyStatusName(verifyStatusMap.get(x.getVerifyStatus()));
            if(Objects.equals(x.getVerifyStatus(), ProjectApplyVerifyStatusEnum.TYPE_VERIFYING.getValue())){
                map.put(verifyingFlag, true);
            }
            if(!map.get(verifyingFlag) && map.get(canSubmitFlag)
                    && (Objects.isNull(x.getVerifyStatus()) || ProjectApplyVerifyStatusEnum.getCanSubmitStatus().contains(x.getVerifyStatus()))
                    && Objects.equals(x.getLeader(), UserUtil.getUserId())
            ){
                x.setSumitBtnShow(EnableStatusEnum.ENABLE.getStatus());
                map.put("canSubmitFlag", false);
            }
        });
        return list;
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectEstablishStepPojo updateModel(ProjectEstablishStepPojo model) {
        checkStepStatusAvaliable(model.getId());
        SysUserModel userModel = this.sysUserService.getCurrentUsr();
        model.setUserInfo(userModel, ActionEnum.UPDATE_ACTION);
        if(this.projectEstablishStepMapper.updateByIdSelective(model) >= 0
            && this.projectAppendixService.updateByBusinessIdAndIds(model.getId(), model.getAppendixs())){
            return model;
        }
        throw new SystemParamCheckException("参数更新失败");
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectEstablishStepModel submitToVerify(ProjectEstablishStepModel model) {
        if(model == null || model.getId() == null){
            throw new SystemParamCheckException("传入参数异常，无法提交审核");
        }
        Long userId = UserUtil.getUserId();
        //校验流程是否该是当前流程审核
        ProjectEstablishStepModel tmpModel = this.projectEstablishStepMapper.selectById(model.getId());
        if(!Objects.equals(userId, tmpModel.getLeader())){
            throw new SystemParamCheckException("当前用户无法进行提交审核");
        }
        List<ProjectEstablishStepModel> list = this.projectEstablishStepMapper.selectBeforeById(model.getId());
        if(!list.isEmpty()){
            List<ProjectEstablishStepModel> filterStep = list.stream().filter(x -> !Objects.equals(x.getVerifyStatus(), ProjectApplyVerifyStatusEnum.TYPE_HAS_VERIFY.getValue()))
                    .collect(Collectors.toList());
            if(!filterStep.isEmpty()){
                throw new SystemParamCheckException("之前流程未完成，无法进行当前流程确认");
            }
        }
        SysUserModel userModel = sysUserService.getCurrentUsr();
        model.setUserInfo(userModel, ActionEnum.UPDATE_ACTION);
        model.setVerifyStatus(ProjectApplyVerifyStatusEnum.TYPE_VERIFYING.getValue());
        ProjectModel queryModel = this.projectService.selectById(tmpModel.getProjectId());
        if(!Objects.equals(queryModel.getVerifyStatus(), ProjectApplyVerifyStatusEnum.TYPE_VERIFYING.getValue())){
            queryModel.setUserInfo(userModel, ActionEnum.UPDATE_ACTION);
            queryModel.setVerifyStatus(ProjectApplyVerifyStatusEnum.TYPE_VERIFYING.getValue());
        }
        ProjectEstablishProjectModel projectEstablishProjectModel = this.projectEstablishProjectService.selectByProjectId(tmpModel.getProjectId());
        projectEstablishProjectModel.setEstablishStep(tmpModel.getId());
        projectEstablishProjectModel.setUserInfo(userModel, ActionEnum.UPDATE_ACTION);
        if(this.projectEstablishStepMapper.updateByIdSelective(model) >= 0
            && this.projectService.updateSelectiveById(queryModel)
            && this.projectEstablishProjectService.updateByIdSelective(projectEstablishProjectModel)){
            if(this.projectBusinessEstablishApplyImplService.createApplyInfo(tmpModel)){
                return model;
            }
        }
        throw new SystemParamCheckException("项目立项阶段提交审核异常");
    }

    @Override
    public Map<? extends Long,? extends String> getBusinessNameMap(List<Long> ids) {
        if(Objects.isNull(ids)){
            throw new SystemParamCheckException("传入的业务id异常，无法进行查询");
        }
        if (ids.isEmpty()) {
            return new HashMap<>(0);
        }
        return this.projectEstablishStepMapper.selectByIds(ids).stream()
                .collect(Collectors.toMap(ProjectEstablishStepModel::getId, ProjectEstablishStepModel::getName));
    }

    public List<ProjectEstablishStepModel> selectByIds(List<Long> ids) {
        if(Objects.isNull(ids)){
            throw new SystemParamCheckException("传入的业务id异常，无法进行查询");
        }
        if (ids.isEmpty()) {
            return Collections.emptyList();
        }
        return this.projectEstablishStepMapper.selectByIds(ids);
    }

    public List<ProjectEstablishStepVo> selectByProjectId(Long projectId) {
        if(projectId == null){
            return Collections.emptyList();
        }
        return this.projectEstablishStepMapper.selectByModel(new ProjectEstablishStepModel(projectId));
    }

    public List<ProjectEstablishStepModel> selectLeftNeedUpdate(Long id) {
        if(id == null){
            throw new SystemParamCheckException("传入的阶段id异常，无法进行查询");
        }
        return this.projectEstablishStepMapper.selectLeftNeedUpdate(id);
    }

    public Long getCurrentFlowNeedChooseFlowList(Long businessId, Long flowId) {
        return projectApplyBusinessService.getCurrentFlowNeedChooseFlowList(businessId, flowId, this);
    }


    @Override
    public Object selectModelByIdAndConditionModel(Long businessId, Map<Integer, String> conditionMap) {
        return this.projectEstablishStepMapper.selectModelByIdAndConditionModel(businessId, conditionMap);
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectEstablishStepPojo insertModel(ProjectEstablishStepPojo model) {
        SysUserModel userModel = this.sysUserService.getCurrentUsr();
        model.setUserInfo(userModel, ActionEnum.INSERT_ACTION);
        if(this.projectEstablishStepMapper.insertSelective(model) >= 0
            && this.projectAppendixService.updateByBusinessIdAndIds(model.getId(), model.getAppendixs())){
            return model;
        }
        throw new SystemParamCheckException("项目立项阶段新增异常");
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectEstablishStepModel deleteModel(ProjectEstablishStepModel model) {
        if(model == null || model.getId() == null){
            throw new SystemParamCheckException("立项阶段参数异常，无法进行删除");
        }
        checkStepStatusAvaliable(model.getId());
        SysUserModel userModel = this.sysUserService.getCurrentUsr();
        model.setUserInfo(userModel, ActionEnum.UPDATE_ACTION);
        model.setDelStatus(DeleteStatusEnum.DELETE.getStatus());
        if(this.projectEstablishStepMapper.updateByIdSelective(model) >= 0
            && this.projectAppendixService.updateByBusinessIdAndIds(model.getId(), new ArrayList<>())){
            return model;
        }
        throw new SystemParamCheckException("立项阶段无法删除");
    }

    private void checkStepStatusAvaliable(Long id) {
        ProjectEstablishStepModel checkModel = new ProjectEstablishStepModel();
        checkModel.setId(id);
        List<ProjectEstablishStepVo> tmpModels = this.projectEstablishStepMapper.selectByModel(checkModel);
        if(tmpModels.isEmpty()){
            throw new SystemParamCheckException("该立项阶段已经被删除，请刷新后重试");
        }
        if(!Objects.isNull(tmpModels.get(0).getVerifyStatus())){
            throw new SystemParamCheckException("当前审核状态下无法进行操作");
        }
    }
}