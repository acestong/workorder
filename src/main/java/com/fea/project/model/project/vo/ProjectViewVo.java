package com.fea.project.model.project.vo;

import com.fea.project.model.project.ProjectViewModel;
import lombok.Data;

import java.util.List;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/11/1 9:31
 **/
@Data
public class ProjectViewVo extends ProjectViewModel {

    List<ProjectViewSelfConfigVo> projectViewSelfConfigVos;

}
