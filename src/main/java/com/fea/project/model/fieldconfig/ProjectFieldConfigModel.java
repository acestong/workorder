package com.fea.project.model.fieldconfig;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.api.other.model.base.SysUserModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2020/01/19.
 */
@Data
public class ProjectFieldConfigModel {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    private String name;

    public ProjectFieldConfigModel(ProjectFieldConfigEnterpriseModel x) {
        this.id = x.getId();
        this.name = x.getName();
    }
}