package com.fea.project.model.baseconfig.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.model.baseconfig.ProjectCodeShortNameModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/9/27 15:01
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class ProjectCodeShortNameVo extends ProjectCodeShortNameModel {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long parentCodeId;

    private String dicProjectTypeName;

    private Integer state;

    private String stateName;

    private Integer tag;
    private List<ProjectCodeShortNameVo> children;
}
