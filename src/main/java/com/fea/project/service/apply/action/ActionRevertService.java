package com.fea.project.service.apply.action;

import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.enums.apply.ProjectApplyVerifyStatusEnum;
import com.fea.project.enums.flow.base.ProjectFlowTypeEnum;
import com.fea.project.model.apply.ProjectApplyModel;
import com.fea.project.model.apply.pojo.ProjectApplyFlowVerifyPojo;
import com.fea.project.model.apply.vo.ProjectApplyFlowInfoVo;
import com.fea.project.service.apply.ProjectApplyFlowInfoService;
import com.fea.project.service.apply.ProjectApplyFlowVerifyService;
import com.fea.project.service.apply.ProjectApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/12/2 14:39
 **/
@Service
public class ActionRevertService {

    @Autowired
    private ProjectApplyFlowVerifyService projectApplyFlowVerifyService;

    @Autowired
    private ProjectApplyFlowInfoService projectApplyFlowInfoService;

    @Autowired
    private ProjectApplyService projectApplyService;

    /**
     * 添加当前撤回人的信息，将当前流程信息变为撤回状态
     *
     * @param model
     * @param projectApplyFlowInfoVo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean updateInfoByStatus(ProjectApplyFlowVerifyPojo model, ProjectApplyFlowInfoVo projectApplyFlowInfoVo) {
        model.setVerifyStatus(ProjectApplyVerifyStatusEnum.TYPE_HAS_REVERT.getValue());
        model.setVerifyResult(ProjectApplyVerifyStatusEnum.TYPE_HAS_REVERT.getMsg());
        //更新主数据，移除底下审核人信息，添加撤销人信息
        if (this.projectApplyFlowVerifyService.insertOrUpdateSelective(model)) {
            projectApplyFlowInfoVo.setVerifyStatus(model.getVerifyStatus());
            projectApplyFlowInfoVo.setStopTime(model.getStopTime());
            projectApplyFlowInfoVo.setActionTime(model.getActionTime());
            projectApplyFlowInfoVo.setActionType(model.getActionType());
            projectApplyFlowInfoVo.setVerifyResult(model.getVerifyResult());
            projectApplyFlowInfoVo.setDescribe(model.getDescribe());
            if (this.projectApplyFlowInfoService.updateByIdSelective(projectApplyFlowInfoVo)) {
                ProjectApplyModel projectApplyModel = this.projectApplyService.selectById(projectApplyFlowInfoVo.getApplyId());
                this.projectApplyService.updateVerifyStatusById(projectApplyFlowInfoVo.getApplyId(), ProjectApplyVerifyStatusEnum.TYPE_HAS_REVERT.getValue());
                //如果下一步数据不存在，进行流程绑定业务数据收尾工作
                ProjectFlowTypeEnum projectFlowTypeEnum = ProjectFlowTypeEnum.getTargetMap(projectApplyModel == null ? null : projectApplyModel.getApplyType());
                return projectFlowTypeEnum.revertBusinessInfo(projectApplyModel.getBusinessId());
            }
        }
        throw new SystemParamCheckException("审核状态更新异常");
    }
}
