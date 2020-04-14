package com.fea.project.service.apply.action;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.enums.apply.ProjectApplyVerifyStatusEnum;
import com.fea.project.enums.flow.base.ProjectFlowTypeEnum;
import com.fea.project.enums.flow.base.ProjectSignTypeEnum;
import com.fea.project.model.apply.ProjectApplyFlowInfoModel;
import com.fea.project.model.apply.ProjectApplyFlowVerifyModel;
import com.fea.project.model.apply.ProjectApplyModel;
import com.fea.project.model.apply.pojo.ProjectApplyFlowInfoPojo;
import com.fea.project.model.apply.pojo.ProjectApplyFlowVerifyPojo;
import com.fea.project.model.apply.vo.ProjectApplyFlowInfoVo;
import com.fea.project.model.businessflow.ProjectBusinessFlowModel;
import com.fea.project.model.businessflow.ProjectBusinessFlowVerifyerModel;
import com.fea.project.service.apply.ProjectApplyFlowInfoService;
import com.fea.project.service.apply.ProjectApplyFlowVerifyService;
import com.fea.project.service.apply.ProjectApplyService;
import com.fea.project.service.businessflow.ProjectBusinessFlowService;
import com.fea.project.service.businessflow.ProjectBusinessFlowVerifyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/12/2 14:39
 **/
@Service
public class ActionAgreeService {

    @Autowired
    private ProjectApplyFlowVerifyService projectApplyFlowVerifyService;

    @Autowired
    private ProjectApplyFlowInfoService projectApplyFlowInfoService;

    @Autowired
    private ProjectBusinessFlowVerifyerService projectBusinessFlowVerifyerService;

    @Autowired
    private ProjectApplyService projectApplyService;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private ProjectBusinessFlowService projectBusinessFlowService;


    /**
     * 同意操作，确认当前数据是会签还是获签
     * 如果是获签，直接更新
     * 如果是会签，确认别的签约情况，如果其他都完了，进行状态更新
     *
     * @param model
     * @param projectApplyFlowInfoVo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean updateInfoByStatus(ProjectApplyFlowVerifyPojo model, ProjectApplyFlowInfoVo projectApplyFlowInfoVo) {
        model.setVerifyStatus(ProjectApplyVerifyStatusEnum.TYPE_HAS_VERIFY.getValue());
        model.setVerifyResult(ProjectApplyVerifyStatusEnum.TYPE_HAS_VERIFY.getMsg());
        if (this.projectApplyFlowVerifyService.insertOrUpdateSelective(model)) {
            if (!Objects.equals(projectApplyFlowInfoVo.getVerifyType(), ProjectSignTypeEnum.TYPE_SINGLE_SIGN.getValue())) {
                List<ProjectApplyFlowVerifyModel> unVerifyModels = this.projectApplyFlowVerifyService.selectUnVerifyModelsByApplyFlowId(projectApplyFlowInfoVo.getId());
                if (!unVerifyModels.isEmpty()) {
                    return Boolean.TRUE;
                }
            }
            if (updateProjectApplyFLowInfoByVerifyModel(model, projectApplyFlowInfoVo)) {
                //取下一步流程数据
                ProjectApplyModel projectApplyModel = this.projectApplyService.selectById(projectApplyFlowInfoVo.getApplyId());
                ProjectBusinessFlowVerifyerModel tmpModel = projectBusinessFlowVerifyerService.selectNextVerifyById(projectApplyFlowInfoVo.getBusinessFlowVerifyId());
                //如果下一步数据不存在，进行流程绑定业务数据收尾工作
                ProjectFlowTypeEnum projectFlowTypeEnum = ProjectFlowTypeEnum.getTargetMap(projectApplyModel == null ? null : projectApplyModel.getApplyType());
                if (tmpModel == null) {
                    //新增流程结束状态更新
                    this.projectApplyService.updateVerifyStatusById(projectApplyFlowInfoVo.getApplyId(), ProjectApplyVerifyStatusEnum.TYPE_HAS_VERIFY.getValue());
                    return projectFlowTypeEnum.updateBusinessInfoWhenFlowFinish(projectApplyModel.getBusinessId());
                }
                //下一步数据存在，插入到数据库中
                SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
                ProjectBusinessFlowModel projectBusinessFlowModel = this.projectBusinessFlowService.selectById(projectApplyModel.getBusinessFlowId());
                List<ProjectApplyFlowInfoPojo> projectApplyFlowInfoPojos = projectFlowTypeEnum.getProjectApplyFlowInfo(projectApplyModel.getApplyerId(), projectBusinessFlowModel, sysUserModel, tmpModel.getParentId());
                if (this.projectApplyService.insertProjectApplyInfo(projectApplyFlowInfoPojos, projectApplyModel.getId())) {
                    /*
                        校验完成度，如果完成进行完成更新
                        如果未完成直接返回
                     */
                    ProjectApplyFlowInfoModel projectApplyFlowInfoModel = this.projectApplyFlowInfoService.selectNotVerifyModelsByApplyId(projectApplyFlowInfoVo.getApplyId());
                    if (projectApplyFlowInfoModel == null) {
                        return projectFlowTypeEnum.updateBusinessInfoWhenFlowFinish(projectApplyModel.getBusinessId());
                    }
                    return Boolean.TRUE;
                }
                throw new SystemParamCheckException("申请流程数据下一步数据异常");
            }
        }
        throw new SystemParamCheckException("审核状态更新异常");
    }

    private boolean updateProjectApplyFLowInfoByVerifyModel(ProjectApplyFlowVerifyPojo model, ProjectApplyFlowInfoVo projectApplyFlowInfoVo) {
        projectApplyFlowInfoVo.setActionTime(model.getActionTime());
        projectApplyFlowInfoVo.setStopTime(model.getStopTime());
        projectApplyFlowInfoVo.setVerifyStatus(model.getVerifyStatus());
        projectApplyFlowInfoVo.setActionType(model.getActionType());
        projectApplyFlowInfoVo.setVerifyResult(model.getVerifyResult());
        projectApplyFlowInfoVo.setDescribe(model.getDescribe());
        if (this.projectApplyFlowInfoService.updateByIdSelective(projectApplyFlowInfoVo)) {
            return Boolean.TRUE;
        }
        throw new SystemParamCheckException("审核状态更新异常");
    }
}
