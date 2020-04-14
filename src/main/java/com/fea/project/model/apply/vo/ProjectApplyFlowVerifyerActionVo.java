package com.fea.project.model.apply.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.model.apply.ProjectApplyFlowInfoModel;
import com.fea.project.util.DateUtil;
import com.fea.project.util.ListUtil;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/11/30 15:00
 * 项目申请流程审核人操作
 **/
@Data
public class ProjectApplyFlowVerifyerActionVo {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private Integer personType;
    private String personTypeName;
    private Integer verifyType;
    private String verifyTypeName;
    private Integer verifyStatus;
    private String verifyStatusName;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long verifyerId;
    private String verifyerName;
    private String verifyResult;
    private Date actionTime;
    private String stopTime;
    private String describe;
    private Integer actionType;
    private String actionTypeName;
    private List<ProjectApplyFlowVerifyerActionVo> children;

    public ProjectApplyFlowVerifyerActionVo() {
    }

    public ProjectApplyFlowVerifyerActionVo(ProjectApplyFlowInfoVo projectApplyFlowInfoVo, ProjectApplyFlowVerifyVo projectApplyFlowVerifyVo, Date now) {
        this.id = projectApplyFlowInfoVo.getId();
        this.personType = projectApplyFlowInfoVo.getPersonType();
        this.verifyType = projectApplyFlowInfoVo.getVerifyType();
        this.verifyStatus = projectApplyFlowInfoVo.getVerifyStatus();
        this.stopTime = Objects.isNull(projectApplyFlowVerifyVo.getActionTime())
                ? DateUtil.getStopTime(projectApplyFlowInfoVo.getCreateTime(), now) : projectApplyFlowVerifyVo.getStopTime();
        this.verifyerId = projectApplyFlowVerifyVo.getVerifyerId();
        this.verifyResult = projectApplyFlowVerifyVo.getVerifyResult();
        this.actionTime = projectApplyFlowInfoVo.getActionTime();
        this.describe = projectApplyFlowVerifyVo.getDescribe();
        this.actionType = projectApplyFlowVerifyVo.getActionType();
        this.children = new ArrayList<>();
    }

    public ProjectApplyFlowVerifyerActionVo(ProjectApplyFlowVerifyVo projectApplyFlowVerifyVo, Date now, boolean isFinish) {
        this.id = projectApplyFlowVerifyVo.getId();
        this.verifyStatus = projectApplyFlowVerifyVo.getVerifyStatus();
        this.verifyerId = projectApplyFlowVerifyVo.getVerifyerId();
        this.verifyResult = projectApplyFlowVerifyVo.getVerifyResult();
        this.actionTime = projectApplyFlowVerifyVo.getActionTime();
        this.stopTime = Objects.isNull(projectApplyFlowVerifyVo.getActionTime()) && !isFinish
                ? DateUtil.getStopTime(projectApplyFlowVerifyVo.getCreateTime(), now) : projectApplyFlowVerifyVo.getStopTime();
        this.describe = projectApplyFlowVerifyVo.getDescribe();
        this.actionType = projectApplyFlowVerifyVo.getActionType();
        this.children = new ArrayList<>();
    }

    public ProjectApplyFlowVerifyerActionVo(ProjectApplyFlowInfoModel projectApplyFlowInfoVo, Date now) {
        this.id = projectApplyFlowInfoVo.getId();
        this.personType = projectApplyFlowInfoVo.getPersonType();
        this.verifyType = projectApplyFlowInfoVo.getVerifyType();
        this.verifyStatus = projectApplyFlowInfoVo.getVerifyStatus();
        this.stopTime = Objects.isNull(projectApplyFlowInfoVo.getActionTime())
                ? DateUtil.getStopTime(projectApplyFlowInfoVo.getCreateTime(), now) : projectApplyFlowInfoVo.getStopTime();
        this.actionTime = projectApplyFlowInfoVo.getActionTime();
        this.actionType = projectApplyFlowInfoVo.getActionType();
        this.describe = projectApplyFlowInfoVo.getDescribe();
        this.verifyResult = projectApplyFlowInfoVo.getVerifyResult();
        this.children = new ArrayList<>();
    }


    public static List<ProjectApplyFlowVerifyerActionVo> createList(ProjectApplyFlowInfoVo projectApplyFlowInfoVo, Date now) {
        if (projectApplyFlowInfoVo == null || ListUtil.isNullOrEmpty(projectApplyFlowInfoVo.getProjectApplyFlowVerifyModels())) {
            throw new SystemParamCheckException("审核人信息异常，无法进行查询");
        }
        List<ProjectApplyFlowVerifyerActionVo> list = new ArrayList<>();
        List<ProjectApplyFlowVerifyVo> projectApplyFlowVerifyModels = projectApplyFlowInfoVo.getProjectApplyFlowVerifyModels();
        if (projectApplyFlowVerifyModels.size() == 1) {
            list.add(new ProjectApplyFlowVerifyerActionVo(projectApplyFlowInfoVo, projectApplyFlowVerifyModels.get(0), now));
            return list;
        }
        ProjectApplyFlowVerifyerActionVo tmpModel = new ProjectApplyFlowVerifyerActionVo(projectApplyFlowInfoVo, now);
        boolean isFinish = !Objects.isNull(projectApplyFlowInfoVo.getActionTime());
        projectApplyFlowVerifyModels.forEach(x -> list.add(new ProjectApplyFlowVerifyerActionVo(x, now, isFinish)));
        tmpModel.setChildren(list);
        return Stream.of(tmpModel).collect(Collectors.toList());
    }
}
