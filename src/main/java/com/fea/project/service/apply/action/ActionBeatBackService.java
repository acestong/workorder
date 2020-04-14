package com.fea.project.service.apply.action;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.enums.apply.ProjectApplyVerifyStatusEnum;
import com.fea.project.enums.flow.base.ProjectFlowTypeEnum;
import com.fea.project.model.apply.ProjectApplyFlowInfoModel;
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

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/12/2 14:39
 **/
@Service
public class ActionBeatBackService {

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


    @Transactional(rollbackFor = Exception.class)
    public boolean updateInfoByStatus(ProjectApplyFlowVerifyPojo model, ProjectApplyFlowInfoVo projectApplyFlowInfoVo) {
        if (model.getBeatBackBusinessFlowVerifyId() == null) {
            throw new SystemParamCheckException("驳回节点传入异常，无法进行驳回");
        }
        model.setVerifyStatus(ProjectApplyVerifyStatusEnum.TYPE_HAS_REPULSE.getValue());
        model.setVerifyResult(ProjectApplyVerifyStatusEnum.TYPE_HAS_REPULSE.getMsg());
        projectApplyFlowInfoVo.setActionTime(model.getActionTime());
        projectApplyFlowInfoVo.setStopTime(model.getStopTime());
        projectApplyFlowInfoVo.setVerifyStatus(model.getVerifyStatus());
        if (this.projectApplyFlowVerifyService.updateByIdSelective(model) && this.projectApplyFlowInfoService.updateByIdSelective(projectApplyFlowInfoVo)) {
            //选取驳回节点的要审核的节点信息
            ProjectApplyModel projectApplyModel = this.projectApplyService.selectById(projectApplyFlowInfoVo.getApplyId());
            SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
            ProjectFlowTypeEnum projectFlowTypeEnum = ProjectFlowTypeEnum.getTargetMap(projectApplyModel == null ? null : projectApplyModel.getApplyType());
            ProjectBusinessFlowModel projectBusinessFlowModel = this.projectBusinessFlowService.selectById(projectApplyModel.getBusinessFlowId());
            ProjectBusinessFlowVerifyerModel projectBusinessFlowVerifyerModel = this.projectBusinessFlowVerifyerService.selectById(model.getBeatBackBusinessFlowVerifyId());
            if(projectBusinessFlowVerifyerModel == null){
                throw new SystemParamCheckException("驳回节点信息不存在");
            }
            List<ProjectApplyFlowInfoPojo> projectApplyFlowInfoPojos = projectFlowTypeEnum.getProjectApplyFlowInfo(projectApplyModel.getApplyerId(), projectBusinessFlowModel, sysUserModel, projectBusinessFlowVerifyerModel.getParentId());
            if (this.projectApplyService.insertProjectApplyInfo(projectApplyFlowInfoPojos, projectApplyModel.getId())) {
                /*
                    校验完成度，如果完成进行完成更新
                    如果未完成直接返回
                 */
                ProjectApplyFlowInfoModel projectApplyFlowInfoModel = this.projectApplyFlowInfoService.selectNotVerifyModelsByApplyId(projectApplyFlowInfoVo.getApplyId());
                if (projectApplyFlowInfoModel == null) {
                    this.projectApplyService.updateVerifyStatusById(projectApplyFlowInfoVo.getApplyId(), ProjectApplyVerifyStatusEnum.TYPE_HAS_VERIFY.getValue());
                    return projectFlowTypeEnum.updateBusinessInfoWhenFlowFinish(projectApplyModel.getBusinessId());
                }
                return Boolean.TRUE;
            }
        }
        throw new SystemParamCheckException("驳回流程异常，数据无法进行更新");
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
