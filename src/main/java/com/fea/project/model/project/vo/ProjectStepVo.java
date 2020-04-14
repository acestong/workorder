package com.fea.project.model.project.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.model.project.ProjectStepModel;
import com.fea.project.model.project.ProjectStepVerifyModel;
import com.fea.project.model.project.draft.vo.DraftStepVo;
import com.fea.project.util.ListUtil;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/9/30 14:08
 **/
@AllArgsConstructor
@Data
public class ProjectStepVo extends ProjectStepModel {

    private String leadName;
    private String deptName;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long stepVerifyId;
    private Integer stepVerifyStatus;
    private String stepVerifyStatusName;

    private List<ProjectStepVerifyModel> projectStepVerifyModels;

    public ProjectStepVo() {
    }

    public ProjectStepVo(DraftStepVo model) {
        this.id = model.getOriginalId();
        this.projectId = model.getProjectId();
        this.name = model.getName();
        this.index = model.getIndex();
        this.startTime = model.getStartTime();
        this.endTime = model.getEndTime();
        this.duration = model.getDuration();
        this.leader = model.getLeader();
        this.content = model.getContent();
        this.deliverClaim = model.getDeliverClaim();
        this.delStatus = model.getDelStatus();
        this.createId = model.getCreateId();
        this.createBy = model.getCreateBy();
        this.createTime = model.getCreateTime();
        this.updateId = model.getUpdateId();
        this.updateBy = model.getUpdateBy();
        this.updateTime = model.getUpdateTime();
        this.projectStepVerifyModels = ListUtil.isNullOrEmpty(model.getDraftStepVerifyModels())?null:
                model.getDraftStepVerifyModels().stream().map(x -> new ProjectStepVerifyModel(x, model.getOriginalId())).collect(Collectors.toList());
    }
}
