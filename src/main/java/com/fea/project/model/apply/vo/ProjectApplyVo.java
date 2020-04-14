package com.fea.project.model.apply.vo;

import com.fea.project.model.apply.ProjectApplyModel;
import lombok.Data;

import java.util.List;

/**
 * Created by Administrator on 2019/11/18.
 */
@Data
public class ProjectApplyVo extends ProjectApplyModel {

    private String projectName;

    private String verifyStatusName;

    private String applyerName;

    private String applyDepartName;

    private String businessName;

    private Boolean isRevert;

    private Boolean isVerify;

    private String applyTypeName;

    private List<ProjectApplyFlowVerifyerActionVo> projectApplyFlowVerifyerActionModels;

}