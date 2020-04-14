package com.fea.project.service.businessflow.flowtype;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.SpringContextHelper;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.enums.apply.ProjectApplyVerifyStatusEnum;
import com.fea.project.enums.base.EnableStatusEnum;
import com.fea.project.enums.flow.base.ProjectCopyAdviseTypeEnum;
import com.fea.project.model.apply.ProjectApplyModel;
import com.fea.project.model.apply.pojo.ProjectApplyFlowInfoPojo;
import com.fea.project.model.apply.pojo.ProjectApplyPojo;
import com.fea.project.model.businessflow.ProjectBusinessFlowModel;
import com.fea.project.model.businessflow.pojo.ProjectBusinessFlowPojo;
import com.fea.project.model.config.ProjectConfigModel;
import com.fea.project.model.flow.ProjectFlowModel;
import com.fea.project.model.flow.pojo.FlowApplyStatusModel;
import com.fea.project.service.apply.ProjectApplyCodeService;
import com.fea.project.service.apply.ProjectApplyFlowInfoService;
import com.fea.project.service.apply.ProjectApplyService;
import com.fea.project.service.businessflow.ProjectBusinessFlowService;
import com.fea.project.service.config.ProjectConfigService;
import com.fea.project.service.flow.ProjectFlowService;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/11/25 9:40
 * 流程申请服务接口
 **/
public abstract class AbstractFlowApply<T> {

    @Autowired
    private ProjectConfigService projectConfigService;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private ProjectApplyCodeService projectApplyCodeService;
    @Autowired
    private ProjectApplyFlowInfoService projectApplyFlowInfoService;
    @Autowired
    private ProjectFlowService projectFlowService;
    @Autowired
    private ProjectApplyService projectApplyService;

    public boolean createApplyInfo(T model) {
        if (!Objects.equals(this.checkFlowParamIsAvailable(model), Boolean.TRUE)) {
            return Boolean.FALSE;
        }
        //查询项目设置的流程
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        FlowApplyStatusModel flowApplyStatusModel = this.getFlowApplyStatus(model);
        ProjectBusinessFlowModel projectBusinessFlowModel = null;
        if (Objects.equals(EnableStatusEnum.ENABLE.getStatus(), flowApplyStatusModel.getStatus())) {
            if (Objects.isNull(flowApplyStatusModel.getFlowId())) {
                throw new SystemParamCheckException("流程定义异常，启用状态下未选择流程信息");
            }
            Long flowListId = this.getCurrentFlowNeedChooseFlowList(getModelPrimaryId(model), flowApplyStatusModel.getFlowId());
            if (Objects.isNull(flowListId)) {
                throw new SystemParamCheckException("流程判定异常，没有判定出要走的流程");
            }
            projectBusinessFlowModel = SpringContextHelper.getBean(ProjectBusinessFlowService.class).copyFlowToBusiness(new ProjectBusinessFlowPojo(flowApplyStatusModel.getFlowId(), flowListId));
        } else {
            updateBusinessInfoWhenFlowFinish(getModelPrimaryId(model));
            return Boolean.TRUE;
        }
        //创建申请信息
        ProjectApplyPojo applyModel = this.createProjectApplyModel(model, projectBusinessFlowModel, sysUserModel);
        if (SpringContextHelper.getBean(ProjectApplyService.class).insertProjectApplyInfo(applyModel)) {
            //参数进行判定进行参数判定
            this.updateBusinessStatusByApplyModel(applyModel);
            ProjectFlowModel projectFlowModel = this.projectFlowService.selectById(flowApplyStatusModel.getFlowId());
            if (projectFlowModel != null && ProjectCopyAdviseTypeEnum.getBeforeVerifyNeedAdviseStatus().contains(projectFlowModel.getCopySetType())) {
                //TODO
                //根据选择的抄送类型人员进行抄送选择


            }
            return Boolean.TRUE;
        }
        throw new SystemParamCheckException("申请提交异常，请刷新后重试");
    }

    protected void updateBusinessStatusByApplyModel(ProjectApplyPojo applyModel){
        List<ProjectApplyFlowInfoPojo> projectApplyFlowInfoModels = applyModel.getProjectApplyFlowInfoModels();
        if(projectApplyFlowInfoModels.isEmpty()){
            return;
        }
        for (int i = 0; i < projectApplyFlowInfoModels.size(); i++) {
            if(!ProjectApplyVerifyStatusEnum.TYPE_HAS_VERIFY.getValue().equals(projectApplyFlowInfoModels.get(i).getVerifyStatus())){
                return;
            }
        }
        if(this.projectApplyService.updateVerifyStatusById(applyModel.getId(), ProjectApplyVerifyStatusEnum.TYPE_HAS_VERIFY.getValue())
            && this.updateBusinessInfoWhenFlowFinish(applyModel.getBusinessId())){
            return;
        }
        throw new SystemParamCheckException("参数更新异常");
    }


    protected FlowApplyStatusModel getFlowApplyStatus(T model){
        List<ProjectConfigModel> list = projectConfigService.selectByModel(new ProjectConfigModel(getProjectId(model), getFlowTypeId()));
        System.out.println("list = " + list);
        if (list.size() != 1) {
            throw new SystemParamCheckException("项目创建流程设置异常");
        }
        Integer status = list.get(0).getState();
        Long flowId = StringUtil.isEmpty(list.get(0).getRemark()) ? null : Long.parseLong(list.get(0).getRemark());
        return new FlowApplyStatusModel(status, flowId);
    }


    protected abstract Long getProjectId(T model);


    protected ProjectApplyPojo createProjectApplyModel(T model, ProjectBusinessFlowModel projectBusinessFlowModel, SysUserModel sysUserModel) {
        ProjectApplyPojo projectApplyPojo = new ProjectApplyPojo(projectBusinessFlowModel.getId(), sysUserModel);
        this.setProjectApplyConnectBusinessInfo(projectApplyPojo, model);
        projectApplyPojo.setApplyCode(projectApplyCodeService.createRegFlowTypeCode(getFlowTypeId()));
        Long parentId = null;
        List<ProjectApplyFlowInfoPojo> projectApplyFlowInfoPojos = this.getProjectApplyFlowInfo(model, projectBusinessFlowModel, sysUserModel, parentId);
        projectApplyPojo.setProjectApplyFlowInfoModels(projectApplyFlowInfoPojos);
        return projectApplyPojo;
    }

    protected List<ProjectApplyFlowInfoPojo> getProjectApplyFlowInfo(T model, ProjectBusinessFlowModel projectBusinessFlowModel, SysUserModel sysUserModel, Long parentId) {
        return getProjectApplyFlowInfo(getApplyer(model), projectBusinessFlowModel, sysUserModel, parentId);
    }

    public List<ProjectApplyFlowInfoPojo> getProjectApplyFlowInfo(Long applyerId, ProjectBusinessFlowModel projectBusinessFlowModel, SysUserModel sysUserModel, Long parentId) {
        List<ProjectApplyFlowInfoPojo> projectApplyFlowInfoPojos = new ArrayList<>();
        ProjectApplyFlowInfoPojo projectApplyFlowInfoPojo = null;
        do {
            projectApplyFlowInfoPojo = projectApplyFlowInfoService.createProjectApplyInfo(applyerId, projectBusinessFlowModel, sysUserModel, parentId);
            if (projectApplyFlowInfoPojo == null) {
                break;
            }
            projectApplyFlowInfoPojos.add(projectApplyFlowInfoPojo);
            parentId = projectApplyFlowInfoPojo.getProjectBusinessFlowVerifyId();
        } while (Objects.equals(projectApplyFlowInfoPojo.getVerifyStatus(), ProjectApplyVerifyStatusEnum.TYPE_HAS_VERIFY.getValue())
                || Objects.equals(projectApplyFlowInfoPojo.getVerifyStatus(), ProjectApplyVerifyStatusEnum.TYPE_APPLY.getValue()));
        return projectApplyFlowInfoPojos;
    }

    protected boolean updateApplyStatus(Long businessId){
        return this.projectApplyService.updateVerifyStatusByBusinessIdAndVerifyStatus(ProjectApplyVerifyStatusEnum.TYPE_HAS_VERIFY.getValue(), businessId, ProjectApplyVerifyStatusEnum.TYPE_VERIFYING.getValue());
    }


    /**
     * 检查流程参数是否可用
     */
    protected abstract boolean checkFlowParamIsAvailable(T model);


    /**
     * 获取流程类型信息
     * ProjectBaseConfigEnum 中的类型对应
     *
     * @return
     */
    protected abstract Integer getFlowTypeId();

    /**
     * 根据当前的业务id以及流程流程列表id，获取对应的流程信息
     *
     * @param businessId
     * @param flowId
     * @return
     */
    protected abstract Long getCurrentFlowNeedChooseFlowList(Long businessId, Long flowId);


    /**
     * 获取当前相关业务的model主键
     *
     * @param model
     * @return
     */
    protected abstract Long getModelPrimaryId(T model);

    /**
     * 获取当前业务的申请人
     *
     * @param model
     * @return
     */
    protected abstract Long getApplyer(T model);

    /**
     * 设置项目申请关联的业务数据
     *
     * @param projectApplyPojo
     * @param model
     */
    protected abstract void setProjectApplyConnectBusinessInfo(ProjectApplyPojo projectApplyPojo, T model);

    @Transactional(rollbackFor = Exception.class)
    public abstract boolean updateBusinessInfoWhenFlowFinish(Long businessId);

    @Transactional(rollbackFor = Exception.class)
    public abstract boolean revertBusinessInfo(Long businessId);

    @Transactional(rollbackFor = Exception.class)
    public abstract boolean refuseBusinessInfo(Long businessId);

}
