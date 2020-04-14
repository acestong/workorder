package com.fea.project.model.apply.vo;

import com.fea.project.model.apply.ProjectApplyFlowInfoModel;
import lombok.Data;

import java.util.List;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/11/29 17:31
 **/
@Data
public class ProjectApplyFlowInfoVo extends ProjectApplyFlowInfoModel {

    private List<ProjectApplyFlowVerifyVo> projectApplyFlowVerifyModels;
}
