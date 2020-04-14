package com.fea.project.model.flow.pojo;

import com.fea.project.configure.annotations.base.TableNameAnno;
import com.fea.project.model.flow.ProjectFlowModel;
import lombok.Data;

import java.util.List;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/11/12 17:52
 **/
@Data
@TableNameAnno("t_project_flow")
public class ProjectFlowPojo extends ProjectFlowModel {

    private ProjectFlowListPojo defaultFlowModel;
    private List<Long> projectFlowListIds;
    private Boolean selectConfig;
}
