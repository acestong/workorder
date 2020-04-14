package com.fea.project.model.baseconfig.vo;

import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.model.baseconfig.ProjectCodeModel;
import com.fea.project.util.ListUtil;
import lombok.Data;

import java.util.List;

/**
 * Created by Administrator on 2019/09/27.
 */
@Data
public class ProjectCodeVo extends ProjectCodeModel {

    private List<ProjectCodeShortNameVo> projectCodeShortNameModels;

    public ProjectCodeModel createNewModel(Long regId) {
        ProjectCodeModel model = new ProjectCodeModel();
        model.setChildNumber(this.getChildNumber());
        model.setCreatePeriod(this.getCreatePeriod());
        model.setDataStr(this.getDataStr());
        model.setParentNumber(this.getParentNumber());
        model.setRegId(regId);
        return model;
    }

    public String getShortName(Long projectType) {
        if (projectType == null) {
            throw new SystemParamCheckException("传入的项目类型无效");
        }
        List<ProjectCodeShortNameVo> projectCodeShortNameVos = this.getProjectCodeShortNameModels();
        if (ListUtil.isNullOrEmpty(projectCodeShortNameVos)) {
            throw new SystemParamCheckException("项目类型编码未进行编码设置");
        }
        for (ProjectCodeShortNameVo projectCodeShortNameVo : projectCodeShortNameVos) {
            if (projectType.equals(projectCodeShortNameVo.getDicProjectType())) {
                return projectCodeShortNameVo.getShortCode();
            }
        }
        throw new SystemParamCheckException("项目类型编码未进行编码设置");
    }
}