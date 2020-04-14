package com.fea.project.service.apply.action;

import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.enums.apply.ProjectApplyVerifyStatusEnum;
import com.fea.project.enums.flow.base.ProjectFlowTypeEnum;
import com.fea.project.enums.flow.base.ProjectSignTypeEnum;
import com.fea.project.model.apply.ProjectApplyFlowVerifyModel;
import com.fea.project.model.apply.ProjectApplyModel;
import com.fea.project.model.apply.pojo.ProjectApplyFlowVerifyPojo;
import com.fea.project.model.apply.vo.ProjectApplyFlowInfoVo;
import com.fea.project.service.apply.ProjectApplyFlowInfoService;
import com.fea.project.service.apply.ProjectApplyFlowVerifyService;
import com.fea.project.service.apply.ProjectApplyService;
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
public class ActionRefuseService {

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

    @Transactional(rollbackFor = Exception.class)
    public boolean updateInfoByStatus(ProjectApplyFlowVerifyPojo model, ProjectApplyFlowInfoVo projectApplyFlowInfoVo) {
        model.setVerifyStatus(ProjectApplyVerifyStatusEnum.TYPE_HAS_REFUSE.getValue());
        model.setVerifyResult(ProjectApplyVerifyStatusEnum.TYPE_HAS_REFUSE.getMsg());
        if (this.projectApplyFlowVerifyService.insertOrUpdateSelective(model)) {
            if (!Objects.equals(projectApplyFlowInfoVo.getVerifyType(), ProjectSignTypeEnum.TYPE_SINGLE_SIGN.getValue())) {
                List<ProjectApplyFlowVerifyModel> unVerifyModels = this.projectApplyFlowVerifyService.selectUnVerifyModelsByApplyFlowId(projectApplyFlowInfoVo.getId());
                if (!unVerifyModels.isEmpty()) {
                    return Boolean.TRUE;
                }
            }
            if (updateProjectApplyFLowInfoByVerifyModel(model, projectApplyFlowInfoVo)) {
                this.projectApplyService.updateVerifyStatusById(projectApplyFlowInfoVo.getApplyId(), ProjectApplyVerifyStatusEnum.TYPE_HAS_REFUSE.getValue());
                ProjectApplyModel projectApplyModel = this.projectApplyService.selectById(projectApplyFlowInfoVo.getApplyId());
                //如果下一步数据不存在，进行流程绑定业务数据收尾工作
                ProjectFlowTypeEnum projectFlowTypeEnum = ProjectFlowTypeEnum.getTargetMap(projectApplyModel == null ? null : projectApplyModel.getApplyType());
                return projectFlowTypeEnum.refuseBusinessInfo(projectApplyModel.getBusinessId());
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
