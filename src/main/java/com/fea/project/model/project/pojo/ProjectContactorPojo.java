package com.fea.project.model.project.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.model.project.ProjectContactorModel;
import lombok.Data;

import java.util.List;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/25 10:26
 * 项目联系人对象
 **/
@Data
public class ProjectContactorPojo extends ProjectContactorModel {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private List<Long> contactorIds;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private List<Long> ids;
}
