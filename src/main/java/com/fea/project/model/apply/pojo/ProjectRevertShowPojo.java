package com.fea.project.model.apply.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.enums.apply.ProjectApplyVerifyStatusEnum;
import com.fea.project.enums.flow.base.ProjectSignTypeEnum;
import com.fea.project.model.apply.ProjectApplyFlowInfoModel;
import com.fea.project.model.apply.ProjectApplyFlowVerifyModel;
import com.fea.project.model.apply.vo.ProjectApplyFlowInfoVo;
import lombok.Data;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/12/9 10:15
 **/
@Data
public class ProjectRevertShowPojo {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private String name;
    private String signTypeName;
    private String verifyerNames;

    public ProjectRevertShowPojo() {
    }

    public ProjectRevertShowPojo(Long id, String name, String signTypeName, String verifyerNames) {
        this.id = id;
        this.name = name;
        this.signTypeName = signTypeName;
        this.verifyerNames = verifyerNames;
    }

    public ProjectRevertShowPojo(ProjectApplyFlowInfoModel model, String verifyerNames) {
        this.id = model.getBusinessFlowVerifyId();
        this.name = ProjectApplyVerifyStatusEnum.getVerifyTypeName(model.getVerifyStatus());
        this.signTypeName = ProjectSignTypeEnum.getVerifyTypeNames().get(model.getVerifyType());
        this.verifyerNames = verifyerNames;
    }

    public ProjectRevertShowPojo(ProjectApplyFlowInfoVo model, Map<Long, String> userNames) {
        this.id = model.getBusinessFlowVerifyId();
        this.name = ProjectApplyVerifyStatusEnum.getVerifyTypeName(model.getVerifyStatus());
        this.signTypeName = ProjectSignTypeEnum.getVerifyTypeNames().get(model.getVerifyType());
        this.verifyerNames =  model.getProjectApplyFlowVerifyModels().stream().filter(x -> !Objects.isNull(x.getActionTime()))
                .map(ProjectApplyFlowVerifyModel::getVerifyerId).distinct().map(userNames::get).collect(Collectors.joining(","));
    }
}
