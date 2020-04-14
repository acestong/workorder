package com.fea.project.model.apply.pojo;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.enums.apply.ProjectApplyVerifyStatusEnum;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.model.apply.ProjectApplyModel;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019/11/18.
 */
@Data
public class ProjectApplyPojo extends ProjectApplyModel {

    private Long businessFlowVerifyId;

    private List<ProjectApplyFlowInfoPojo> projectApplyFlowInfoModels;


    private Date startTime;
    private Date endTime;

    private List<Long> ids;

    private Long verifyerId;

    public ProjectApplyPojo() {
    }

    public ProjectApplyPojo(Long businessFlowId, SysUserModel sysUserModel) {
        this.applyTime = new Date();
        this.verifyStatus = ProjectApplyVerifyStatusEnum.TYPE_VERIFYING.getValue();
        this.businessFlowId = businessFlowId;
        super.setUserInfo(sysUserModel, ActionEnum.INSERT_ACTION);
    }

    public ProjectApplyModel createProjectApply() {
        ProjectApplyModel model = new ProjectApplyModel();
        model.setApplyCode(this.applyCode);
        model.setName(this.name);
        model.setBusinessId(this.businessId);
        model.setBusinessCode(this.businessCode);
        model.setApplyerId(this.applyerId);
        model.setApplyDepart(this.applyDepart);
        model.setApplyTime(this.applyTime);
        model.setVerifyStatus(this.verifyStatus);
        model.setCreateId(this.createId);
        model.setCreateBy(this.createBy);
        model.setCreateTime(this.createTime);
        model.setUpdateId(this.updateId);
        model.setUpdateBy(this.updateBy);
        model.setUpdateTime(this.updateTime);
        model.setDelStatus(this.delStatus);
        model.setApplyType(this.applyType);
        model.setProjectId(this.projectId);
        model.setStopTime(this.stopTime);
        model.setBusinessFlowId(this.businessFlowId);
        return model;
    }
}