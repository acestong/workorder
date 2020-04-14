package com.fea.project.model.flow.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.model.flow.ProjectFlowModel;
import lombok.Data;

import java.util.List;

/**
 * Created by Administrator on 2019/10/10.
 */
@Data
public class ProjectFlowVo extends ProjectFlowModel {

    private String flowTypeName;

    private String statusName;

    private ProjectFlowListVo defaultFlowModel;

    private String projectName;

    private List<ProjectFlowListVo> projectFlowListModels;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long flowListId;

    private String projectTypeName;

    public ProjectFlowVo() {
    }

}