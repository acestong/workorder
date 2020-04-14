package com.fea.project.model.project.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.model.project.ProjectExternalContactorModel;
import lombok.Data;

import java.util.List;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/25 11:08
 **/
@Data
public class ProjectExternalContactorPojo extends ProjectExternalContactorModel {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private List<Long> ids;
}
