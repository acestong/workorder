package com.fea.project.model.project.vo;

import com.fea.project.model.project.ProjectViewSelfConfigModel;
import lombok.Data;

import java.util.List;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/11/1 9:34
 **/
@Data
public class ProjectViewSelfConfigVo extends ProjectViewSelfConfigModel {

    private String fieldTypeName;
    private String filterTypeName;
    private List<String> valueList;

}
